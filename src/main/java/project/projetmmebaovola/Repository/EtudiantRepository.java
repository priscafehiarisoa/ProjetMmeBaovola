package project.projetmmebaovola.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.projetmmebaovola.Model.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    public List<Etudiant> findByNom(String nom);



    @Query("select e from Etudiant e where e.nom like '%' || :param || '%'")
    public List<Etudiant> makazemisyB(@Param("param") String param);
}
