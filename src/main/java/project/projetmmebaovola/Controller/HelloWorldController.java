package project.projetmmebaovola.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import project.projetmmebaovola.Model.Etudiant;
import project.projetmmebaovola.Repository.EtudiantRepository;

import java.util.Optional;

@Controller
public class HelloWorldController {
    @Autowired
    private EtudiantRepository etudiantRepository;

//    public HelloWorldController(EtudiantRepository etudiantRepository) {
//        this.etudiantRepository = etudiantRepository;
//    }

    @GetMapping({"/","/hello","/test"})
    public String hello(@RequestParam(value = "name", defaultValue = "World", required = true) String name,  Model model, HttpSession session) {
        model.addAttribute("message", name);
        return "hello";
    }

    @GetMapping("/etudiants")
    public String listerEtudiant(Model model, HttpSession session){
        Optional<Etudiant> etudiant=etudiantRepository.findById(7L);
        Etudiant etudiant1=null;
        if(etudiant.isPresent()){
            etudiant1=etudiant.get();
            model.addAttribute("singleEtudiant", etudiant1);
        }
        else{
            model.addAttribute("error","etudiant non existant");
            model.addAttribute("singleEtudiant", new Etudiant());
        }
       model.addAttribute("etudiant", etudiantRepository.findAll());
       return "ListEtudiant";
    }

    @GetMapping("/formEtudiant")
    public String getForm(){
        return "formEtudiant";
    }

    // rediriger vers un controller sans utiliser un model
    @PostMapping("/etudiantpost")
    // atao an'ty redirect view ty ny type de retour an'le fonction
    public RedirectView newEtudiant(@ModelAttribute Etudiant etudiant){
        // eto no manao creation an'le hoe aiza no rediriger-na le fonction
        // @ty zao izy rediriger-ko ao @le controller misy @GetMapping("/etudiant")
        final RedirectView redirectView = new RedirectView("/etudiant", true);
        // eto ah manao an'ze traitement ilaiko
        etudiantRepository.save(etudiant);
        return redirectView;
    }




}
