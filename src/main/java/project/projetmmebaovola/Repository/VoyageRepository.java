package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.projetmmebaovola.Model.entity.Voyage;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage,Integer> {
}
