package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.personnel.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
}