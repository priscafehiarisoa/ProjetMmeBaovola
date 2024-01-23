package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.activite.HistoriquePrixActivite;

public interface HistoriquePrixActiviteRepository extends JpaRepository<HistoriquePrixActivite, Integer> {
}