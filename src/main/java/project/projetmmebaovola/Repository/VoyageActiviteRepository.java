package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.voyage.Voyage;
import project.projetmmebaovola.Model.entity.activite.VoyageActivite;

import java.util.List;

public interface VoyageActiviteRepository extends JpaRepository<VoyageActivite, Integer> {
    List<VoyageActivite> findVoyageActiviteByVoyage(Voyage voyage);
}