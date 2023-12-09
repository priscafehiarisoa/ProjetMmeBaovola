package project.projetmmebaovola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projetmmebaovola.Model.Etudiant;
import project.projetmmebaovola.Repository.EtudiantRepository;

import java.util.List;

@Configuration
public class Main {
    private final EtudiantRepository etudiantRepository;

    public Main(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner (){
        return args -> {
            Etudiant etudiant= new Etudiant("Box","Jeddy");
            Etudiant etudiant2= new Etudiant("Box2","Jeddy2");
//            etudiantRepository.saveAll(List.of(etudiant2,etudiant));

            List<Etudiant> test=etudiantRepository.makazemisyB("B");
            test.forEach(System.out::println);
        };


    }
}
