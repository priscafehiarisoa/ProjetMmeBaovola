package project.projetmmebaovola.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nombreChaises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombreChaises() {
        return nombreChaises;
    }

    public void setNombreChaises(int nombreChaises) {
        this.nombreChaises = nombreChaises;
    }
}
