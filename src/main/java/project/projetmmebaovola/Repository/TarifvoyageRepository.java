package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.projetmmebaovola.Model.view.Tarifvoyage;

import java.util.List;

public interface TarifvoyageRepository extends JpaRepository<Tarifvoyage, Integer> {

    @Query("select tarif from Tarifvoyage tarif where tarif.prixactivite>=:debut and tarif.prixactivite<=:fin")
    List<Tarifvoyage> getTarifVoyagesbetween(@Param("debut") double debut, @Param("fin") double fin );
}