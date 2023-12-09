package project.projetmmebaovola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projetmmebaovola.Model.Etudiant;
import project.projetmmebaovola.Model.Salle;
import project.projetmmebaovola.Repository.EtudiantRepository;
import project.projetmmebaovola.Repository.SalleRepository;

import java.util.List;

@Configuration
public class Main {
    private final EtudiantRepository etudiantRepository;
    private final SalleRepository salleRepository;

    public Main(EtudiantRepository etudiantRepository, SalleRepository salleRepository) {
        this.etudiantRepository = etudiantRepository;
        this.salleRepository = salleRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner (){
        return args -> {
            Salle salle = new Salle("salle 1",23);
            salleRepository.save(salle);
            Etudiant etudiant= new Etudiant("Box","Jeddy",salle);
            Etudiant etudiant2= new Etudiant("Box2","Jeddy2",salle);
            etudiantRepository.saveAll(List.of(etudiant2,etudiant));
            List<Etudiant> test=etudiantRepository.makazemisyB("B");
            test.forEach(System.out::println);
        };


    }
}
