package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.projetmmebaovola.Model.view.Recherche;

import java.util.List;

@Repository
public interface RechercheRepository extends JpaRepository<Recherche,Integer> {
    @Query(value = "select * from recherche where typedure like '%' || :ref || '%' or nom_activite like '%' || :ref || '%' or nom_bouquet like '%' || :ref || '%'",nativeQuery = true)
    List<Recherche> searchvoyage(@Param("ref") String search);
}
