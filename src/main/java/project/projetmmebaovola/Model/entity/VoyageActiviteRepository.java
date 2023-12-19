package project.projetmmebaovola.Model.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoyageActiviteRepository extends JpaRepository<VoyageActivite, Integer> {
    List<VoyageActivite> findVoyageActiviteByVoyage(Voyage voyage);
}