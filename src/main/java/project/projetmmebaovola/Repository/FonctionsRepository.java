package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.projetmmebaovola.Model.entity.personnel.Fonctions;

import java.util.Optional;

public interface FonctionsRepository extends JpaRepository<Fonctions, Integer> {
    @Query("select f from Fonctions f where :annee between f.debutIntervalleAnnee and f.finIntervalleAnnee")
    Optional<Fonctions> getFonctionByAnneeTravail(@Param("annee") int anneeTravail);
}