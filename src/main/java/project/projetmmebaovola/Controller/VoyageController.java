package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import project.projetmmebaovola.Model.entity.Activite;
import project.projetmmebaovola.Model.entity.Bouquets;
import project.projetmmebaovola.Repository.CateorieActiviteRepository;
import project.projetmmebaovola.Model.entity.Voyage;
import project.projetmmebaovola.Model.util.Utils;
import project.projetmmebaovola.Repository.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Controller
public class VoyageController {

    private final VoyageRepository voyageRepository;
    private final BouquetsRepository bouquetsRepository;
    private final TypeLieuRepository typeLieuRepository;
    private final ActiviteRepository activiteRepository;
    private final BouquetActiviteRepository bouquetActiviteRepository;
    private final CateorieActiviteRepository cateorieActiviteRepository;

    public VoyageController(VoyageRepository voyageRepository,
                            BouquetsRepository bouquetsRepository,
                            TypeLieuRepository typeLieuRepository,
                            ActiviteRepository activiteRepository,
                            BouquetActiviteRepository bouquetActiviteRepository,
                            CateorieActiviteRepository cateorieActiviteRepository) {
        this.voyageRepository = voyageRepository;
        this.bouquetsRepository = bouquetsRepository;
        this.typeLieuRepository = typeLieuRepository;
        this.activiteRepository = activiteRepository;
        this.bouquetActiviteRepository = bouquetActiviteRepository;
        this.cateorieActiviteRepository = cateorieActiviteRepository;
    }

    // voyage
    @GetMapping("/formVoyage")
    public String getFormVoyage(Model model){
        model.addAttribute("bouquet", bouquetsRepository.findAll());
        model.addAttribute("typeLieu", typeLieuRepository.findAll());

        return "voyage/formVoyage";
    }
    @GetMapping({"/","/listVoyage"})
    public String getListVoyage(Model model){
        model.addAttribute("voyage", voyageRepository.findAll());
        return "voyage/listeVoyage";
    }
    @PostMapping("/newVoyage")
    public RedirectView saveVoyage(@RequestParam HashMap<String,Object> voyage, @RequestParam("bouquets") List<Integer> idBouquet) throws Exception {
        final RedirectView redirectView = new RedirectView("/formVoyage", true);
        LocalDate datedebut= Utils.convertToLocalDate((String) voyage.get("dateDebutvoyage"));
        LocalDate datefin=Utils.convertToLocalDate(String.valueOf(voyage.get("dateFinVoyage")));
        idBouquet.forEach(System.out::println);

        int typelieu= Integer.valueOf(String.valueOf(voyage.get("type"))) ;
        String lieu= String.valueOf(voyage.get("lieu")) ;
        Voyage voyage1= new Voyage(datedebut,datefin,idBouquet,typelieu,lieu,bouquetsRepository,typeLieuRepository);
        voyageRepository.save(voyage1);
        return redirectView;
    }

//    controller bouquet
    @GetMapping("/listBouquet")
    public String getListBouquet (Model model ){
        List<Bouquets> bouquets=bouquetsRepository.getBouquetsByEtat(0);
        for (int i = 0; i < bouquets.size(); i++) {
            bouquets.get(i).setListBouquetActivite(bouquetActiviteRepository);
        }
        model.addAttribute("bouquet", bouquets );
        return "bouquets/listeBouquet";
    }

    @PostMapping("/newBouquet")
    public RedirectView saveBouquet (@ModelAttribute Bouquets bouquets, @RequestParam("activites") List<Integer> idActivites) throws Exception {
        final RedirectView redirectView = new RedirectView("/listBouquet", true);
        bouquets.saveBouquet(idActivites,bouquetsRepository,bouquetActiviteRepository,activiteRepository);
        return redirectView;
    }
    @GetMapping("/formBouquet")
    public String formbouquet(Model model){
        model.addAttribute("activite",activiteRepository.findAll());

        return "bouquets/formBouquet";
    }

//    @GetMapping("/formAddActiviteForBouquet")
//    public String formActivite(Model model){
//        model.addAttribute("bouquet",bouquetsRepository.findAll());
//        model.addAttribute("activite",activiteRepository.findAll());
//        return "bouquets/AddActiviteForBouquet";
//    }



//    controller Activités
    @GetMapping("/formActivite")
    public String loadViewFormActivite(@ModelAttribute("error") String error, Model model){
        System.out.println("Xo : "+model.getAttribute("error"));
        model.addAttribute("activite",cateorieActiviteRepository.findAll());
        return "activite/formActivite";
    }

    @GetMapping("/listActivite")
    public String loadViewListActivite(Model model){
        return "activite/listeActivite";
    }

    @PostMapping("/addNewActivite")
    public RedirectView addNewActivite(@ModelAttribute Activite activite, @RequestParam("categories") List<Integer> categories,Model model)  {
       String redirection= "/listActivite";
        try{
        activite.saveActivite(activiteRepository,cateorieActiviteRepository,categories);}
        catch (Exception e){
            model.addAttribute("error",e.getMessage());
            System.out.println(e.getMessage());
            redirection="/formActivite";
        }

        return new RedirectView(redirection, true);
    }
}
