package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.bouquet.Bouquets;

import java.util.List;

public interface BouquetsRepository extends JpaRepository<Bouquets,Integer> {
    List<Bouquets> getBouquetsByEtat(int etat);
}
