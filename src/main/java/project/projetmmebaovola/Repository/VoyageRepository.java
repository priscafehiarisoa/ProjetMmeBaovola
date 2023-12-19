package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.projetmmebaovola.Model.entity.Voyage;
import project.projetmmebaovola.Recherche;

import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage,Integer> {




}
