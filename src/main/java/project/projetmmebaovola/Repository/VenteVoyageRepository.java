package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.voyage.VenteVoyage;

public interface VenteVoyageRepository extends JpaRepository<VenteVoyage, Integer> {
}