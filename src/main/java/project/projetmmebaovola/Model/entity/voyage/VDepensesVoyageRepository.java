package project.projetmmebaovola.Model.entity.voyage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VDepensesVoyageRepository extends JpaRepository<VDepensesVoyage, Integer> {

    @Query("select s from VDepensesVoyage s where  (s.prixUnitaireVoyage-((s.sommetauxjournalier*s.joursvoyage)+s.prixactivite))>=:limite1 and (s.prixUnitaireVoyage-((s.sommetauxjournalier*s.joursvoyage)+s.prixactivite))<=:limite2")
    List<VDepensesVoyage> getBeneficesVoyageEntreDeuxFourchetteDePrix(@Param("limite1") double limite1,@Param("limite2") double limite2);
}