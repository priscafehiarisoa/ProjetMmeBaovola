package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import project.projetmmebaovola.Model.entity.personnel.Fonctions;
import project.projetmmebaovola.Model.entity.personnel.Personnel;
import project.projetmmebaovola.Model.entity.personnel.TypeMainOeuvre;
import project.projetmmebaovola.Repository.FonctionsRepository;
import project.projetmmebaovola.Repository.PersonnelRepository;
import project.projetmmebaovola.Repository.TypeMainOeuvreRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class PersonnelController {
    private final FonctionsRepository fonctionsRepository;
    private final PersonnelRepository personnelRepository;
    private final TypeMainOeuvreRepository typeMainOeuvreRepository;

    public PersonnelController(FonctionsRepository fonctionsRepository, PersonnelRepository personnelRepository, TypeMainOeuvreRepository typeMainOeuvreRepository) {
        this.fonctionsRepository = fonctionsRepository;
        this.personnelRepository = personnelRepository;
        this.typeMainOeuvreRepository = typeMainOeuvreRepository;
    }

    @GetMapping("/listePersonnel")
    public String listePersonnel(Model model){
        List<Personnel> personnels=personnelRepository.findAll();
        for (int i = 0; i < personnels.size(); i++) {
            personnels.get(i).setFonction(fonctionsRepository);
        }
        model.addAttribute("personnel",personnels);
        return "personnel/listePersonnel";
    }
    @GetMapping("updateFormPersonnel/{id}")
    public String updateForm (Model model,@PathVariable("id") int id){
        Optional<Personnel> personnel=personnelRepository.findById(id);
        if(personnel.isPresent()){
            model.addAttribute("modifPersonnle",personnel.get());
        }
        model.addAttribute("TypeMainOeuvre",typeMainOeuvreRepository.findAll());

        return "personnel/modifierPersonnel";
    }
    @PostMapping("/updatePersonnel")
    public Object updatePersonnel(Model model, @RequestParam("id") int id, @RequestParam("Nom") String nom, @RequestParam("dateEmbauche") LocalDate dateEmbauche, @RequestParam("typeMainOeuvre") int idMO) {
        Personnel personnel = new Personnel();
        personnel.setId(id);
        personnel.setNomPersonnel(nom);
        personnel.setDateEmbauche(dateEmbauche);
        Optional<TypeMainOeuvre> typeMainOeuvre = typeMainOeuvreRepository.findById(idMO);
        if (typeMainOeuvre.isPresent()) {
            personnel.setTypeMainOeuvre(typeMainOeuvre.get());
            personnelRepository.save(personnel);
        }
        String returniing ="listePersonnel";
        return new RedirectView(returniing, true);
    }

    @GetMapping("updateFormFonction/{id}")
    public String updateFormFonction (Model model,@PathVariable("id") int id){
        Optional<Fonctions> personnel=fonctionsRepository.findById(id);
        if(personnel.isPresent()){
            model.addAttribute("modifFonction",personnel.get());
        }

        return "personnel/AjoutFonction";
    }
    @PostMapping("/updateFonction")
    public Object updateFonction(Model model,@RequestParam("id") int id,@RequestParam("Nom") String nom,@RequestParam("debutIntervalle") int debut,@RequestParam("finIntervalle") int fin,@RequestParam("multiplicateur") int idMO) {
        Fonctions personnel = new Fonctions();
        personnel.setId(id);
        personnel.setNomFonction(nom);
        personnel.setDebutIntervalleAnnee(debut);
        personnel.setFinIntervalleAnnee(fin);
        personnel.setMultiplicateur(idMO);
        fonctionsRepository.save(personnel);
        String returniing ="listFonction";
        return new RedirectView(returniing, true);
    }
    @GetMapping("listFonction")
    public String listFonction(Model model){
        model.addAttribute("fonctions",fonctionsRepository.findAll());
        return "personnel/listeFonction";
    }
}
