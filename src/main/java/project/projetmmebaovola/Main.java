package project.projetmmebaovola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projetmmebaovola.Model.entity.Activite;
import project.projetmmebaovola.Model.entity.Bouquets;
import project.projetmmebaovola.Model.entity.CateorieActivite;
import project.projetmmebaovola.Model.entity.TypeLieu;
import project.projetmmebaovola.Repository.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Main {



    @Bean
    CommandLineRunner commandLineRunner (ActiviteRepository activiteRepository,
                                         BouquetsRepository bouquetsRepository,
                                         TypeLieuRepository typeLieuRepository,
                                         RechercheRepository rechercheRepository,
                                         CateorieActiviteRepository cateorieActiviteRepository){
        return args -> {
            activiteRepository.findAll().forEach(System.out::println);

            List<Bouquets> bouquets= new ArrayList<>();
            bouquets.add(new Bouquets(100,"gold","un bouquet gold"));
            bouquets.add(new Bouquets(200,"premium","un bouquet premium"));
            bouquets.add(new Bouquets(300,"lite","un bouquet lite"));

            bouquetsRepository.saveAll(bouquets);
            List<Activite> activites=new ArrayList<>();
            activites.add(new Activite(100,"tir a l'arc", "tir à l'arc ",3, "heures"));
            activites.add(new Activite(200,"quad", "quad",3, "heures"));
            activites.add(new Activite(300,"visite guidés", "visite guidés ",3, "heures"));
            activiteRepository.saveAll(activites);

            List<TypeLieu> typeLieus= new ArrayList<>();
            typeLieus.add(new TypeLieu(1,"local"));
            typeLieus.add(new TypeLieu(2,"International"));
            typeLieus.add(new TypeLieu(3,"national"));
            typeLieuRepository.saveAll(typeLieus);
            System.out.println("priiii");
            rechercheRepository.searchvoyage("tir").forEach(System.out::println);

            List<CateorieActivite> cateorieActiviteList=new ArrayList<>();
            cateorieActiviteList.add(new CateorieActivite(1,"extérieurs"));
            cateorieActiviteList.add(new CateorieActivite(2,"Aquatique"));
            cateorieActiviteList.add(new CateorieActivite(3,"Jeux"));
            cateorieActiviteList.add(new CateorieActivite(4,"Gastronomie"));
            cateorieActiviteRepository.saveAll(cateorieActiviteList);
        };


    }
}
