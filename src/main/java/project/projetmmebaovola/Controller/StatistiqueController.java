package project.projetmmebaovola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatistiqueController {
    @GetMapping("/getStatistique")
    public String getStatistique(){
        return "statistique/statistiqueVente";
    }
}
