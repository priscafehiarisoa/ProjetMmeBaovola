package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.projetmmebaovola.Model.entity.activite.Activite;

import java.util.List;

public interface ActiviteRepository extends JpaRepository<Activite,Integer> {

    @Query(value = "select coalesce(resteStock,0) as reste from v_resteStockActivite right outer join activite on id_activite=activite.id where id=:idActivite",nativeQuery = true)
    double getResteStock(@Param("idActivite") int idActivite);

    @Query(value = "select * from activite where activite.nom_activite like '%'|| :ref || '%' ",nativeQuery = true)
    List<Activite> getRechercheActivite(@Param("ref") String recherche);
    @Query("select a from Activite a where a.etat=0")
    List<Activite> getActiveActivite();

    @Query("select a from Activite a where a.etat=-10")
    List<Activite> getDeletedActivite();
}
