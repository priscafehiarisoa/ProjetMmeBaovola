package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.projetmmebaovola.Model.view.VRestestockactivite;

import java.util.List;

public interface VRestestockactiviteRepository extends JpaRepository<VRestestockactivite, Integer> {
    VRestestockactivite getVRestestockactiviteByIdActivite(int idActivite);
}