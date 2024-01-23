package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.activite.StockActivite;

public interface StockActiviteRepository extends JpaRepository<StockActivite, Integer> {
}