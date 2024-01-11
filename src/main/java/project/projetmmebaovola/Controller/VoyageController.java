package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import project.projetmmebaovola.Model.entity.*;
import project.projetmmebaovola.Recherche;
import project.projetmmebaovola.Repository.CateorieActiviteRepository;
import project.projetmmebaovola.Model.util.Utils;
import project.projetmmebaovola.Repository.*;
import project.projetmmebaovola.Tarifvoyage;
import project.projetmmebaovola.TarifvoyageRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class VoyageController {

    private final VoyageRepository voyageRepository;
    private final BouquetsRepository bouquetsRepository;
    private final TypeLieuRepository typeLieuRepository;
    private final ActiviteRepository activiteRepository;
    private final BouquetActiviteRepository bouquetActiviteRepository;
    private final CateorieActiviteRepository cateorieActiviteRepository;
    private final VoyageActiviteRepository voyageActiviteRepository;
    private final RechercheRepository rechercheRepository;
    private final TarifvoyageRepository tarifvoyageRepository;

    public VoyageController(VoyageRepository voyageRepository,
                            BouquetsRepository bouquetsRepository,
                            TypeLieuRepository typeLieuRepository,
                            ActiviteRepository activiteRepository,
                            BouquetActiviteRepository bouquetActiviteRepository,
                            CateorieActiviteRepository cateorieActiviteRepository,
                            VoyageActiviteRepository voyageActiviteRepository,
                            RechercheRepository rechercheRepository,
                            TarifvoyageRepository tarifvoyageRepository) {
        this.voyageRepository = voyageRepository;
        this.bouquetsRepository = bouquetsRepository;
        this.typeLieuRepository = typeLieuRepository;
        this.activiteRepository = activiteRepository;
        this.bouquetActiviteRepository = bouquetActiviteRepository;
        this.cateorieActiviteRepository = cateorieActiviteRepository;
        this.voyageActiviteRepository = voyageActiviteRepository;
        this.rechercheRepository = rechercheRepository;
        this.tarifvoyageRepository = tarifvoyageRepository;
    }

    // voyage
    @GetMapping("/formVoyage")
    public String getFormVoyage(Model model){
        model.addAttribute("bouquet", bouquetsRepository.findAll());
        model.addAttribute("typeLieu", typeLieuRepository.findAll());
        model.addAttribute("activite", activiteRepository.findAll());

        return "voyage/formVoyage";
    }
    @GetMapping({"/","/listVoyage"})
    public String getListVoyage(Model model){
        List<Voyage> voyage=voyageRepository.findAll();
        for (int i = 0; i < voyage.size(); i++) {
            voyage.get(i).setListeActivite(voyageActiviteRepository.findVoyageActiviteByVoyage(voyage.get(i)));
        }
        model.addAttribute("voyage", voyage);
        return "voyage/listeVoyage";
    }
    @PostMapping("/newVoyage")
    public RedirectView saveVoyage(@RequestParam HashMap<String,Object> voyage, @RequestParam("bouquets") Integer idBouquet,
                                   @RequestParam(value = "activites", required = false) List<String> activites,
                                   @RequestParam(value = "Quantite_activites", required = false) List<String> quantiteActivites) throws Exception {
        final RedirectView redirectView = new RedirectView("/formVoyage", true);
        LocalDate datedebut= Utils.convertToLocalDate((String) voyage.get("dateDebutvoyage"));
        LocalDate datefin=Utils.convertToLocalDate(String.valueOf(voyage.get("dateFinVoyage")));
        String typeDure=String.valueOf(voyage.get("typedure"));


        // traiter les activités
        List<Integer> activitesCochees = new ArrayList<>();
        List<Double> quantitesCochees = new ArrayList<>();

        // Parcourir les activités et récupérer les quantités correspondantes
        for (int i = 0; i < activites.size(); i++) {
            String activiteId = activites.get(i);
            String quantite = quantiteActivites.get(i);

            // Vérifier si la case à cocher correspondante est cochée
            if (!activiteId.isEmpty() && !quantite.isEmpty()) {
                activitesCochees.add(Integer.valueOf(activiteId));
                quantitesCochees.add(Double.parseDouble(quantite));
                System.out.println();
            }
        }



        int typelieu= Integer.valueOf(String.valueOf(voyage.get("type"))) ;
        String lieu= String.valueOf(voyage.get("lieu")) ;
        Voyage voyage1= new Voyage(datedebut,datefin,idBouquet,typelieu,lieu,bouquetsRepository,typeLieuRepository,typeDure);
        voyageRepository.save(voyage1);

        List<VoyageActivite> voyageActivites=new ArrayList<>();
        for (int i = 0; i < activitesCochees.size(); i++) {
            Optional<Activite> activite= activiteRepository.findById(activitesCochees.get(i));
            if(activite.isEmpty()){
                throw new Exception("tsy hita le activite ");
            }
            else{
                voyageActivites.add(new VoyageActivite(activite.get(),quantitesCochees.get(i),voyage1));
            }
        }
        voyageActivites.forEach(System.out::println);
        voyageActiviteRepository.saveAll(voyageActivites);
        return redirectView;
    }

//    controller bouquet
    @GetMapping("/listBouquet")
    public String getListBouquet (Model model ){
        List<Bouquets> bouquets=bouquetsRepository.getBouquetsByEtat(0);
//        for (int i = 0; i < bouquets.size(); i++) {
//            bouquets.get(i).setListBouquetActivite(bouquetActiviteRepository);
//        }
        model.addAttribute("bouquet", bouquets );
        return "bouquets/listeBouquet";
    }

    @PostMapping("/newBouquet")
    public RedirectView saveBouquet (@ModelAttribute Bouquets bouquets
//            , @RequestParam("activites") List<Integer> idActivites
    ) throws Exception {
        List<Integer> idActivites=new ArrayList<>();
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
        model.addAttribute("activite",activiteRepository.findAll());

        return "activite/listeActivite";
    }

    @PostMapping("/addNewActivite")
    public RedirectView addNewActivite(@ModelAttribute Activite activite, @RequestParam("categories") List<Integer> categories,Model model)  {
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

    @PostMapping("/searchvoyage")
    public String getSerach(@RequestParam("recherche") String recherche,Model model){
        List<Recherche> voyages= rechercheRepository.searchvoyage(recherche);

        model.addAttribute("voyage",voyages);
        return "voyage/recherche";
    }

    @PostMapping("/VoyageTarif")
    public String getVoyageTarif(@RequestParam("debut") double debut, @RequestParam("fin") double fin,Model model){
        List<HashMap<String,Object>> listVoyage= Tarifvoyage.getVoyage_Tarif(debut,fin,voyageRepository,tarifvoyageRepository,voyageActiviteRepository);
        model.addAttribute("tarifVoyage",listVoyage);
        return "activite/formTarif";
    }
    @GetMapping("/getTarif")
    public String getTarifPage(){
        return "activite/formTarif";
    }
}
