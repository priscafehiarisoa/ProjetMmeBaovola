package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import project.projetmmebaovola.Model.entity.activite.Activite;
import project.projetmmebaovola.Model.entity.activite.MouvementStockActivite;
import project.projetmmebaovola.Model.entity.activite.StockActivite;
import project.projetmmebaovola.Model.entity.activite.VoyageActivite;
import project.projetmmebaovola.Model.entity.bouquet.Bouquets;
import project.projetmmebaovola.Model.entity.client.Client;
import project.projetmmebaovola.Model.entity.personnel.Fonctions;
import project.projetmmebaovola.Model.entity.personnel.Personnel;
import project.projetmmebaovola.Model.entity.personnel.TypeMainOeuvre;
import project.projetmmebaovola.Model.entity.voyage.*;
import project.projetmmebaovola.Model.util.ResteStock;
import project.projetmmebaovola.Model.view.Recherche;
import project.projetmmebaovola.Model.view.Tarifvoyage;
import project.projetmmebaovola.Model.view.VRestestockactivite;
import project.projetmmebaovola.Repository.CateorieActiviteRepository;
import project.projetmmebaovola.Model.util.Utils;
import project.projetmmebaovola.Repository.*;

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
    private final VoyageActiviteRepository voyageActiviteRepository;
    private final RechercheRepository rechercheRepository;
    private final TarifvoyageRepository tarifvoyageRepository;
    private final ReservationVoyageRepository reservationVoyageRepository;
    private final VRestestockactiviteRepository vRestestockactiviteRepository;
    private final TypeMainOeuvreRepository typeMainOeuvreRepository;
    private final MainDOeuvreRepository mainDOeuvreRepository;
    private final PersonnelRepository personnelRepository;
    private final FonctionsRepository fonctionsRepository;
    private final MouvementStockActiviteRepository mouvementStockActiviteRepository;
    private final ClientRepository clientRepository;
    private final VenteVoyageRepository venteVoyageRepository;

    public VoyageController(VoyageRepository voyageRepository,
                            BouquetsRepository bouquetsRepository,
                            TypeLieuRepository typeLieuRepository,
                            ActiviteRepository activiteRepository,
                            BouquetActiviteRepository bouquetActiviteRepository,
                            VoyageActiviteRepository voyageActiviteRepository,
                            RechercheRepository rechercheRepository,
                            TarifvoyageRepository tarifvoyageRepository,
                            ReservationVoyageRepository reservationVoyageRepository,
                            VRestestockactiviteRepository vRestestockactiviteRepository,
                            TypeMainOeuvreRepository typeMainOeuvreRepository,
                            MainDOeuvreRepository mainDOeuvreRepository,
                            PersonnelRepository personnelRepository,
                            FonctionsRepository fonctionsRepository,
                            MouvementStockActiviteRepository mouvementStockActiviteRepository,
                            ClientRepository clientRepository,
                            VenteVoyageRepository venteVoyageRepository) {
        this.voyageRepository = voyageRepository;
        this.bouquetsRepository = bouquetsRepository;
        this.typeLieuRepository = typeLieuRepository;
        this.activiteRepository = activiteRepository;
        this.bouquetActiviteRepository = bouquetActiviteRepository;
        this.voyageActiviteRepository = voyageActiviteRepository;
        this.rechercheRepository = rechercheRepository;
        this.tarifvoyageRepository = tarifvoyageRepository;
        this.reservationVoyageRepository = reservationVoyageRepository;
        this.vRestestockactiviteRepository = vRestestockactiviteRepository;
        this.typeMainOeuvreRepository = typeMainOeuvreRepository;
        this.mainDOeuvreRepository = mainDOeuvreRepository;
        this.personnelRepository = personnelRepository;
        this.fonctionsRepository = fonctionsRepository;
        this.mouvementStockActiviteRepository = mouvementStockActiviteRepository;
        this.clientRepository = clientRepository;
        this.venteVoyageRepository = venteVoyageRepository;
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
        List<Voyage> voyage=voyageRepository.getVoyageByEtat(0);
        for (int i = 0; i < voyage.size(); i++) {
            voyage.get(i).setListeActivite(voyageActiviteRepository.findVoyageActiviteByVoyage(voyage.get(i)));
        }
        model.addAttribute("voyage", voyage);
        return "voyage/listeVoyage";
    }
    @PostMapping("/newVoyage")
    public RedirectView saveVoyage(@RequestParam HashMap<String,Object> voyage,
                                   @RequestParam("prixUnitaireVoyage") double prixVoyage,
                                   @RequestParam("bouquets") Integer idBouquet,
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
        voyage1.setPrixUnitaireVoyage(prixVoyage);
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

    @GetMapping("/updateVoyage/{id}")
    public Object updateVoyage(@PathVariable("id") int idVoyage,Model model){
        Optional<Voyage> optionalVoyage= voyageRepository.findById(idVoyage);
        Voyage voyage=new Voyage();
        if(optionalVoyage.isPresent()){
            voyage=optionalVoyage.get();
            voyage.setListeActivite(voyageActiviteRepository.findVoyageActiviteByVoyage(voyage));

            model.addAttribute("modifVoyage",voyage);
        }
        model.addAttribute("bouquet", bouquetsRepository.findAll());
        model.addAttribute("typeLieu", typeLieuRepository.findAll());
        model.addAttribute("activite", activiteRepository.findAll());

        return "voyage/ModifVoyage";
    }
    @PostMapping("/updateVoyagePost")
    public Object postUpdateVoyage(@RequestParam HashMap<String,Object> voyage,
                                   @RequestParam("prixUnitaireVoyage") double prixVoyage,
                                   @RequestParam("bouquets") Integer idBouquet,
                                   @RequestParam(value = "activites", required = false) List<String> activites,
                                   @RequestParam(value = "Quantite_activites", required = false) List<String> quantiteActivites) throws Exception {
        LocalDate datedebut= Utils.convertToLocalDate((String) voyage.get("dateDebutvoyage"));
        LocalDate datefin=Utils.convertToLocalDate(String.valueOf(voyage.get("dateFinVoyage")));
        String typeDure=String.valueOf(voyage.get("typedure"));
        int idVoyage= Integer.valueOf(String.valueOf(voyage.get("id"))) ;

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
        voyage1.setId(idVoyage);
        voyage1.setPrixUnitaireVoyage(prixVoyage);
        voyageRepository.save(voyage1);

        // enregistrer la partie activite par voyage
        //1 get liste activite par voyage
        List<VoyageActivite> oldVoyageActivite=voyageActiviteRepository.findVoyageActiviteByVoyage(voyage1);

        // 2 creer une nouvelle liste pour les activites
        List<VoyageActivite> newvoyageActivites=new ArrayList<>();
        for (int i = 0; i < activitesCochees.size(); i++) {
            Optional<Activite> activite= activiteRepository.findById(activitesCochees.get(i));
            if(activite.isEmpty()){
                throw new Exception("tsy hita le activite ");
            }
            else{
                newvoyageActivites.add(new VoyageActivite(activite.get(),quantitesCochees.get(i),voyage1));
            }
        }

        // 3 verifier si existe déjà dans l'ancienne liste
        for (int i = 0; i < oldVoyageActivite.size(); i++) {
            int countnewVoyage=0;
            for (int j = 0; j < newvoyageActivites.size(); j++) {
                if(oldVoyageActivite.get(i).getActivite().getId()==newvoyageActivites.get(j).getActivite().getId()){
                    newvoyageActivites.get(j).setId(oldVoyageActivite.get(i).getId());
                    break;
                }
                countnewVoyage++;
            }
            if(countnewVoyage==newvoyageActivites.size()){
                voyageActiviteRepository.delete(oldVoyageActivite.get(i));
            }
        }
        voyageActiviteRepository.saveAll(newvoyageActivites);
        final RedirectView redirectView = new RedirectView("/listVoyage", true);
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


    // stock activite


    // reservation
    @GetMapping("/getFormReservationVoyage")
    public String getFormReservationVoyage (Model model){
        List<Voyage> list= voyageRepository.findAll();
        System.out.println(model.getAttribute("errors"));
        model.addAttribute("voyage",list);
        return "voyage/FormReservationVoyage";
    }
    @GetMapping("/getListeReservation")
    public String getListeReservation(Model model){
        List<ReservationVoyage> reservationVoyages=reservationVoyageRepository.findAll();
        model.addAttribute("reservation",reservationVoyages);
        return "voyage/listeReservation";
    }

    @GetMapping("/getPagePayerReservation/{id}")
    public String getPagePayerReservation(@PathVariable("id") int id,Model model){
        Optional<ReservationVoyage> reservationVoyage=reservationVoyageRepository.findById(id);
        if(reservationVoyage.isPresent()){
            model.addAttribute("reservation",reservationVoyage.get());
            model.addAttribute("prixApayer",reservationVoyage.get().getVoyage().getPrixUnitaireVoyage()*reservationVoyage.get().getNombreRervation());
        }
        return "voyage/PaymentReservation";
    }
    @PostMapping("/payerReservation")
    public Object payer(@RequestParam("payementReservation") double payement,@RequestParam("id") int id){
        Optional<ReservationVoyage> reservationVoyageOptional=reservationVoyageRepository.findById(id);
        if(reservationVoyageOptional.isPresent()){
            // effectuer la vente
            VenteVoyage voyage=new VenteVoyage(reservationVoyageOptional.get(),payement);
            venteVoyageRepository.save(voyage);
        }
        String returntype="/getListeReservation";
        final RedirectView redirectView = new RedirectView(returntype, true);

        return redirectView;
    }


    @PostMapping("/submitReservationClient")
    public Object submitReservationClient(Model model,
                                          @RequestParam("idVoyage") int idVoyage,
                                          @RequestParam("nombreReservation") int nombreReservation,
                                          @RequestParam("nomClient") int nomClient){
        String redirection="/getFormReservationVoyage";

        try{
            // getVoyage
            Optional<Voyage> optionalVoyage=voyageRepository.findById(idVoyage);
            List<String> errors=new ArrayList<>();
            if(optionalVoyage.isPresent()){
                Voyage voyage=optionalVoyage.get();
                voyage.setListeActivite(voyageActiviteRepository.findVoyageActiviteByVoyage(voyage));
                for (int i = 0; i < voyage.getListeActivite().size(); i++) {
                    VRestestockactivite restestockactivite=vRestestockactiviteRepository.getVRestestockactiviteByIdActivite(voyage.getListeActivite().get(i).getActivite().getId());
                    double resteStock= restestockactivite.getRestestock();
                    // condition : restestock >= nombreActivite*nombre de reservation
                    // je dois ajouter les differences
                    double nombreActiviteNecessaires=voyage.getListeActivite().get(i).getQuantite()*nombreReservation;

                    if(resteStock<nombreActiviteNecessaires){
                        errors.add("il manque "+(nombreActiviteNecessaires-resteStock)+" billets pour l'activite "+voyage.getListeActivite().get(i).getActivite().getNomActivite());
                    }
                }
                if(errors.size()>0){
                    model.addAttribute("errors",errors);
                    List<Voyage> list= voyageRepository.getVoyageByEtat(0);
                    model.addAttribute("activite",list);
                    return "voyage/FormReservationVoyage";
                }
                else{
                    // enregistrement des mouvements
                    for (int i = 0; i < voyage.getListeActivite().size(); i++) {
                        MouvementStockActivite mouvementStockActivite=new MouvementStockActivite(-1,voyage.getListeActivite().get(i).getActivite(),voyage.getListeActivite().get(i).getQuantite()*nombreReservation);
                        mouvementStockActiviteRepository.save(mouvementStockActivite);
                    }
                    // enregistrement
                    //todo mila amboarina le client ty atao optional
                    Client client=clientRepository.findById(nomClient).get();
                    ReservationVoyage reservationVoyage1= new ReservationVoyage(nombreReservation,voyage,client);

                    reservationVoyage1.setClient(client);
                    reservationVoyageRepository.save(reservationVoyage1);
                }
            }
            else{
                model.addAttribute("error","voyage introuvable");
                List<Voyage> list= voyageRepository.getVoyageByEtat(0);
                model.addAttribute("activite",list);
                return "voyage/FormReservationVoyage";
            }
        }catch (Exception e){

            model.addAttribute("error",e.getMessage());
            List<Voyage> list= voyageRepository.getVoyageByEtat(0);
            model.addAttribute("activite",list);
            return "voyage/FormReservationVoyage";
        }
        return new RedirectView(redirection, true);
    }

    @GetMapping("/getResteStock")
    public String getResteStock (Model model){
        List<VRestestockactivite> list= vRestestockactiviteRepository.findAll();
        List<ResteStock> resteStocks=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resteStocks.add(new ResteStock(list.get(i).getIdActivite(),list.get(i).getRestestock(),activiteRepository));
        }
        model.addAttribute("reste",resteStocks);
        return "activite/ListeStock";
    }

    @PostMapping("/newTypeMO")
    public String newTypeMo(@RequestParam("nomMainD_oeuvre")String nomMainD_oeuvre,@RequestParam("tauxHoraire") double tauxHoraire,@RequestParam("heureDeTravail") int heureDeTravail,Model model) throws Exception {
       TypeMainOeuvre typeMainOeuvre=new TypeMainOeuvre();
       typeMainOeuvre.setNomMainD_oeuvre(nomMainD_oeuvre);
        if(typeMainOeuvre.getTauxJournalier()<0){
            model.addAttribute("error","taux journalier negatif");
        }
        else if(typeMainOeuvre.getTauxHoraire()<0){
            model.addAttribute("error","taux horaire negatif");

        }
        else {
            try{
                typeMainOeuvre.setHeureDeTravail(heureDeTravail);
                typeMainOeuvre.setTauxHoraire(tauxHoraire);
                typeMainOeuvreRepository.save(typeMainOeuvre);

            }catch (Exception e){
                model.addAttribute("error",e.getMessage());
            }
        }
        return "benefices/nouveauTypeMO";
    }

    // nouvel employe
    @GetMapping("/formAjoutPersonnel")
    public String formAjoutPersonnel(Model model){
        model.addAttribute("TypeMainOeuvre",typeMainOeuvreRepository.findAll());
        return "personnel/ajoutPersonnel";
    }
    @PostMapping("/newPersonnel")
    public Object newPersonnel(@RequestParam("Nom") String nom,@RequestParam("dateEmbauche") LocalDate dateEmbauche,@RequestParam("typeMainOeuvre") int idMO){
        Personnel personnel=new Personnel();
        personnel.setNomPersonnel(nom);
        personnel.setDateEmbauche(dateEmbauche);
        Optional<TypeMainOeuvre> typeMainOeuvre=typeMainOeuvreRepository.findById(idMO);
        if(typeMainOeuvre.isPresent()){
            personnel.setTypeMainOeuvre(typeMainOeuvre.get());
            personnelRepository.save(personnel);
        }
        String redirection="/formAjoutPersonnel";
        return new RedirectView(redirection, true);

    }

    @GetMapping("/typeMO")
    public String typeMo(Model model){
//        model.addAttribute(typeMainOeuvreRepository.findAll());
        return "benefices/nouveauTypeMO";
    }
    @GetMapping("/formOuvrierVoyages")
    public String formOuvrierVoyage(Model model){
        model.addAttribute("voyage",voyageRepository.findAll());
        model.addAttribute("personnel",personnelRepository.findAll());
        return "benefices/formOuvrierVoyage";
    }
    @PostMapping("/newOuvrierVoyage")
    public Object newOuvrierVoyage(@RequestParam("idVoyage") int idVoyage,@RequestParam("nombreJourTravail") int nombreJourTravail,@RequestParam("idPersonnel") int idPersonnel, Model model){
        if(nombreJourTravail<0){
            model.addAttribute("error","nombre de jours de travail negatif");
            return "benefices/formOuvrierVoyage";
        }
        Optional<Voyage> optionalVoyage=voyageRepository.findById(idVoyage);
        if(optionalVoyage.isPresent()) {
                Optional<Personnel> personnelOptional=personnelRepository.findById(idPersonnel);
                if(personnelOptional.isPresent()) {
                    MainDOeuvre mainDOeuvre = new MainDOeuvre(optionalVoyage.get(),nombreJourTravail,personnelOptional.get());
                    mainDOeuvreRepository.save(mainDOeuvre);
                }

        }
         String redirection="/formOuvrierVoyages";
        return new RedirectView(redirection, true);
    }

    @GetMapping("/deleteVoyage/{id}")
    public Object deleteVoyage(@PathVariable("id") int id,Model model){
        Optional<Voyage> optionalVoyage=voyageRepository.findById(id);
        if(optionalVoyage.isPresent()){
            Voyage voyage=optionalVoyage.get();
            voyage.setEtat(-1);
            voyageRepository.save(voyage);
        }
        String link="/listVoyage";
        return new RedirectView(link, true);
    }



}
