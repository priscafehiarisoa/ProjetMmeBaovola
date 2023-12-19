package project.projetmmebaovola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.projetmmebaovola.Repository.ActiviteRepository;

import java.util.List;

@Configuration
public class Main {



    @Bean
    CommandLineRunner commandLineRunner (ActiviteRepository activiteRepository){
        return args -> {
            activiteRepository.findAll().forEach(System.out::println);
        };


    }
}
