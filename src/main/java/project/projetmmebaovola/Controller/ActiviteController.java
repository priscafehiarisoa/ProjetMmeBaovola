package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import project.projetmmebaovola.Model.entity.activite.*;
import project.projetmmebaovola.Repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ActiviteController {
    private final CateorieActiviteRepository cateorieActiviteRepository;
    private final ActiviteRepository activiteRepository;
    private final StockActiviteRepository stockActiviteRepository;
    private final HistoriquePrixActiviteRepository historiquePrixActiviteRepository;
    private final MouvementStockActiviteRepository mouvementStockActiviteRepository;

    public ActiviteController(CateorieActiviteRepository cateorieActiviteRepository, ActiviteRepository activiteRepository, StockActiviteRepository stockActiviteRepository,
                              HistoriquePrixActiviteRepository historiquePrixActiviteRepository,
                              MouvementStockActiviteRepository mouvementStockActiviteRepository) {
        this.cateorieActiviteRepository = cateorieActiviteRepository;
        this.activiteRepository = activiteRepository;
        this.stockActiviteRepository = stockActiviteRepository;
        this.historiquePrixActiviteRepository = historiquePrixActiviteRepository;
        this.mouvementStockActiviteRepository = mouvementStockActiviteRepository;
    }

    @GetMapping("/formActivite")
    public String loadViewFormActivite(@ModelAttribute("error") String error, Model model){
        System.out.println("Xo : "+model.getAttribute("error"));
        model.addAttribute("activite",cateorieActiviteRepository.findAll());
        return "activite/formActivite";
    }

    @GetMapping("/listActivite")
    public String loadViewListActivite(Model model){
        model.addAttribute("activite",activiteRepository.getActiveActivite());

        return "activite/listeActivite";
    }

    @GetMapping("/rechercheActivite")
    public String rechercheActivite(@RequestParam("recherche") String recherche, Model model){
        model.addAttribute("activite",activiteRepository.getRechercheActivite(recherche));

        return "activite/listeActivite";
    }
    @PostMapping("/addNewActivite")
    public RedirectView addNewActivite(@ModelAttribute Activite activite, @RequestParam("categories") List<Integer> categories, Model model)  {
        String redirection= "/listActivite";
        try{
            System.out.println("saved huhu yuhu ");
            activite.saveActivite(activiteRepository,cateorieActiviteRepository,categories);}
        catch (Exception e){
            model.addAttribute("error",e.getMessage());
            System.out.println(e.getMessage());
            redirection="/formActivite";
        }

        return new RedirectView(redirection, true);
    }

    @GetMapping("/getFormStockActivite")
    public String getFormStockActivite (Model model){
        List<Activite> list= activiteRepository.getActiveActivite();
        model.addAttribute("activite",list);
        return "activite/formStockActivite";
    }

    @PostMapping("/submitStockActivite")
    public Object submitStockActivite(@ModelAttribute StockActivite stockActivite, Model model){
        try{
            // creer un nouveau stock Activite

            StockActivite stockActivite1=new StockActivite(stockActivite.getNombreStock(),stockActivite.getActivite());
            stockActiviteRepository.save(stockActivite1);
        }
        catch (Exception e){
            model.addAttribute("error",e.getMessage());
            List<Activite> list= activiteRepository.getActiveActivite();
            model.addAttribute("activite",list);
            return "activite/formStockActivite";
        }
        String redirection="/getFormStockActivite";
        return new RedirectView(redirection, true);
    }

    @PostMapping("/submitMouvementStockActivite")
    public Object submitMouvementStockActivite(Model model,@RequestParam("nombreStock") int nombreStock,@RequestParam("activite") int idActivite) {
        try{
        Optional<Activite> optionalActivite=activiteRepository.findById(idActivite);
        if(optionalActivite.isPresent()){
            MouvementStockActivite mouvementStockActivite=new MouvementStockActivite(1,optionalActivite.get(),nombreStock);
            mouvementStockActiviteRepository.save(mouvementStockActivite);
        }
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            List<Activite> list= activiteRepository.getActiveActivite();
            model.addAttribute("activite",list);
            return "activite/formStockActivite";
        }
        String redirection="/getFormStockActivite";
        return new RedirectView(redirection, true);

    }

    @PostMapping("/updateActivite")
    public Object updateActivite(@ModelAttribute Activite activite, @RequestParam("categories") List<Integer> categories,Model model){
        // save the activite
        System.out.println(activite);
        // get Current List Of Activite
        String redirection="/listActivite";
        Optional<Activite> activiteOptional=activiteRepository.findById(activite.getId());
        if(activiteOptional.isPresent()) {
            Activite oldActivite = activiteOptional.get();
            if(activite.getTarif()!=oldActivite.getTarif()){
                HistoriquePrixActivite historiquePrixActivite= new HistoriquePrixActivite(oldActivite,oldActivite.getTarif());
                historiquePrixActiviteRepository.save(historiquePrixActivite);
            }
        List<CateorieActivite> newCategories=new ArrayList<>();
            for (int i = 0; i < categories.size(); i++) {
                Optional<CateorieActivite> cateorieActivite= cateorieActiviteRepository.findById(categories.get(i));
                if(cateorieActivite.isPresent()){
                    newCategories.add(cateorieActivite.get());
                }
            }
            activite.setListeCategorieActivite(newCategories);
            activiteRepository.save(activite);
        }
        return new RedirectView(redirection, true);

    }

    @GetMapping("/deleteActivite/{id}")
    public Object deleteActivite(@PathVariable("id") int idActivite){
        Optional<Activite> activiteOptional=activiteRepository.findById(idActivite);
        if(activiteOptional.isPresent()){
            Activite activite=activiteOptional.get();
            activite.setEtat(-10);
            activiteRepository.save(activite);
        }
        String redirection="/listActivite";
        return new RedirectView(redirection, true);
    }

    @GetMapping("/getUpdateActivitepage/{id}")
    public String getUpdateActivitepage(@PathVariable("id") int id, Model model){
        Optional<Activite> optionalActivite= activiteRepository.findById(id);
        if(optionalActivite.isEmpty()){
            model.addAttribute("error","imposible de modifier une activite qui n'existe pas ");
        }
        else{
            model.addAttribute("modifActivite",optionalActivite.get());
        }
        model.addAttribute("activite",cateorieActiviteRepository.findAll());
        return "activite/updateActivite";
    }

}
