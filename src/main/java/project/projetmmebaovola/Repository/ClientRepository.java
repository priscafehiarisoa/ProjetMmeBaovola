package project.projetmmebaovola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.projetmmebaovola.Model.entity.client.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}