package project.projetmmebaovola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projetmmebaovola.Model.entity.activite.Activite;
import project.projetmmebaovola.Model.entity.activite.CateorieActivite;
import project.projetmmebaovola.Model.entity.bouquet.Bouquets;
import project.projetmmebaovola.Model.entity.personnel.Fonctions;
import project.projetmmebaovola.Model.entity.personnel.TypeMainOeuvre;
import project.projetmmebaovola.Model.entity.voyage.*;
import project.projetmmebaovola.Repository.TypeMainOeuvreRepository;
import project.projetmmebaovola.Repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class Main {



    @Bean
    CommandLineRunner commandLineRunner (ActiviteRepository activiteRepository,
                                         BouquetsRepository bouquetsRepository,
                                         TypeLieuRepository typeLieuRepository,
                                         RechercheRepository rechercheRepository,
                                         CateorieActiviteRepository cateorieActiviteRepository,
                                         MouvementStockActiviteRepository mouvementStockActiviteRepository,
                                         TypeMainOeuvreRepository typeMainOeuvreRepository,
                                         VoyageRepository voyageRepository,
                                         MainDOeuvreRepository mainDOeuvreRepository,
                                         VDepensesVoyageRepository vDepensesVoyageRepository,
                                         FonctionsRepository fonctionsRepository){
        return args -> {
            activiteRepository.findAll().forEach(System.out::println);

            List<Bouquets> bouquets= new ArrayList<>();
            bouquets.add(new Bouquets(1,"gold","un bouquet gold"));
            bouquets.add(new Bouquets(2,"premium","un bouquet premium"));
            bouquets.add(new Bouquets(3,"lite","un bouquet lite"));

            bouquetsRepository.saveAll(bouquets);
            List<Activite> activites=new ArrayList<>();
            activites.add(new Activite(1,"tir a l'arc", "tir à l'arc ",3, "heures",3000));
            activites.add(new Activite(2,"quad", "quad",3, "heures",4000));
            activites.add(new Activite(3,"visite guidés", "visite guidés ",3, "heures",3000));
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

            List<TypeMainOeuvre> typeMainOeuvreList=new ArrayList<>();
            typeMainOeuvreList.add(new TypeMainOeuvre(1,"chauffeur",500,8));
            typeMainOeuvreList.add(new TypeMainOeuvre(2,"guide",600,6));
            typeMainOeuvreList.add(new TypeMainOeuvre(3,"cuisinière",300,7));
            typeMainOeuvreList.add(new TypeMainOeuvre(4,"accompagnateur",800,10));
            typeMainOeuvreRepository.saveAll(typeMainOeuvreList);

            Optional<Voyage> v=voyageRepository.findById(1);
            if(v.isPresent()) {
                List<MainDOeuvre> mainDOeuvreList = new ArrayList<>();
//                mainDOeuvreList.add(new MainDOeuvre(1,v.get(),typeMainOeuvreList.get(0)));
//                mainDOeuvreList.add(new MainDOeuvre(2,v.get(),typeMainOeuvreList.get(1)));
//                mainDOeuvreList.add(new MainDOeuvre(3,v.get(),typeMainOeuvreList.get(2)));
//                mainDOeuvreList.add(new MainDOeuvre(4,v.get(),typeMainOeuvreList.get(3)));
//                mainDOeuvreRepository.saveAll(mainDOeuvreList);
//                mainDOeuvreRepository.getMainDOeuvreByVoyage(v.get()).forEach(System.out::println);

                vDepensesVoyageRepository.getBeneficesVoyageEntreDeuxFourchetteDePrix(100,1000000).forEach(System.out::println);

                activiteRepository.getActiveActivite().forEach(System.out::println);

            }
            System.out.println("=====");
            List<Fonctions> fonctions=new ArrayList<>();
            fonctions.add(new Fonctions(1,"agent simple",0,2,1));
            fonctions.add(new Fonctions(2,"senior",3,6,2));
            fonctions.add(new Fonctions(3,"expert",7,100,3));
            fonctionsRepository.saveAll(fonctions);

            System.out.println(fonctionsRepository.getFonctionByAnneeTravail(3).get());;

//            mouvementStockActiviteRepository.getResteStock().forEach(System.out::println);

        };



    }
}
