package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.projetmmebaovola.Model.entity.voyage.Voyage;

import java.util.List;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage,Integer> {

//    @Query("select s.activite from VoyageActivite s where s.voyage=:voyage")
//    public List<Activite> getList

    List<Voyage> getVoyageByEtat(int etat);


}
