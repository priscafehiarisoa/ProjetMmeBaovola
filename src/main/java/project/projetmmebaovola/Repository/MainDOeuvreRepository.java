package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.voyage.MainDOeuvre;
import project.projetmmebaovola.Model.entity.voyage.Voyage;

import java.util.List;

public interface MainDOeuvreRepository extends JpaRepository<MainDOeuvre, Integer> {
    List<MainDOeuvre> getMainDOeuvreByVoyage(Voyage voyage);
}