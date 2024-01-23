package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.voyage.ReservationVoyage;

public interface ReservationVoyageRepository extends JpaRepository<ReservationVoyage, Integer> {
}