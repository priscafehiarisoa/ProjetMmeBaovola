package project.projetmmebaovola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projetmmebaovola.Model.entity.Activite;
import project.projetmmebaovola.Model.entity.Bouquets;
import project.projetmmebaovola.Model.entity.TypeLieu;
import project.projetmmebaovola.Repository.ActiviteRepository;
import project.projetmmebaovola.Repository.BouquetsRepository;
import project.projetmmebaovola.Repository.RechercheRepository;
import project.projetmmebaovola.Repository.TypeLieuRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Main {



    @Bean
    CommandLineRunner commandLineRunner (ActiviteRepository activiteRepository,
                                         BouquetsRepository bouquetsRepository,
                                         TypeLieuRepository typeLieuRepository,
                                         RechercheRepository rechercheRepository){
        return args -> {
            activiteRepository.findAll().forEach(System.out::println);

            List<Bouquets> bouquets= new ArrayList<>();
            bouquets.add(new Bouquets(1,"gold","un bouquet gold"));
            bouquets.add(new Bouquets(2,"premium","un bouquet premium"));
            bouquets.add(new Bouquets(3,"lite","un bouquet lite"));

//            bouquetsRepository.saveAll(bouquets);
            List<Activite> activites=new ArrayList<>();
            activites.add(new Activite(1,"tir a l'arc", "tir à l'arc ",3, "heures"));
            activites.add(new Activite(2,"quad", "quad",3, "heures"));
            activites.add(new Activite(3,"visite guidés", "visite guidés ",3, "heures"));
//            activiteRepository.saveAll(activites);

            List<TypeLieu> typeLieus= new ArrayList<>();
            typeLieus.add(new TypeLieu("local"));
            typeLieus.add(new TypeLieu("International"));
            typeLieus.add(new TypeLieu("national"));
//            typeLieuRepository.saveAll(typeLieus);
            System.out.println("priiii");
            rechercheRepository.searchvoyage("tir").forEach(System.out::println);
        };


    }
}
