package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.projetmmebaovola.Model.entity.Activite;
import project.projetmmebaovola.Model.entity.Bouquet_activite;
import project.projetmmebaovola.Model.entity.Bouquets;

import java.util.List;

public interface BouquetActiviteRepository extends JpaRepository<Bouquet_activite,Integer> {


    List<Bouquet_activite> getBouquet_activitesByBouquetsAndEtat(Bouquets bouquets,int etat);

}
