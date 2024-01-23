package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.activite.MouvementStockActivite;

public interface MouvementStockActiviteRepository extends JpaRepository<MouvementStockActivite, Integer> {
//    @Query("select s.activite,sum(s.quantiteMouvement*s.typeMouvement) as quantiteMouvement from MouvementStockActivite s group by s.activite")
//    List<MouvementStockActivite> getResteStock();
}