package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.Voyage;
import project.projetmmebaovola.Model.entity.VoyageActivite;

import java.util.List;

public interface VoyageActiviteRepository extends JpaRepository<VoyageActivite, Integer> {
    List<VoyageActivite> findVoyageActiviteByVoyage(Voyage voyage);
}