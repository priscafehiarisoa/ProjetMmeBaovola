package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.projetmmebaovola.Model.entity.voyage.VDepensesVoyageRepository;
import project.projetmmebaovola.Model.entity.voyage.VDepensesVoyage;
import project.projetmmebaovola.Repository.VoyageActiviteRepository;
import project.projetmmebaovola.Repository.VoyageRepository;

@Controller
public class BeneficesController {
    private final VoyageActiviteRepository voyageActiviteRepository;
    private final VoyageRepository voyageRepository;
    private final VDepensesVoyageRepository vDepensesVoyageRepository;

    public BeneficesController(VoyageActiviteRepository voyageActiviteRepository, VoyageRepository voyageRepository, VDepensesVoyageRepository vDepensesVoyageRepository) {
        this.voyageActiviteRepository = voyageActiviteRepository;
        this.voyageRepository = voyageRepository;
        this.vDepensesVoyageRepository=vDepensesVoyageRepository;

    }

    @PostMapping("/getListBenefices")
    public String getListBenefices(@RequestParam("prix1")double prix1, @RequestParam("prix2") double prix2, Model model){
        if(prix1<0 ){
            model.addAttribute("erreur", "le prix numero 1 est negatif : "+prix1);
        } else if (prix2<0) {
            model.addAttribute("erreur", "le prix numero 2 est negatif : "+prix2);
        }
        else {
            model.addAttribute("range_text","benefices entre "+prix1+" et "+prix2);
            model.addAttribute("benefices", VDepensesVoyage.getBeneficesParFourchette(prix1, prix2, vDepensesVoyageRepository, voyageRepository, voyageActiviteRepository));
        }
        return "benefices/rechercheRangeBenefice";
    }
    @GetMapping("/getBenefice")
    public String getBeneficePage(){
        return "benefices/rechercheRangeBenefice";
    }

}
