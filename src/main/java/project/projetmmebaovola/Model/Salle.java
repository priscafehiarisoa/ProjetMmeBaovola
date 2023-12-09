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

    private String nomsalle;
    private int nombreChaises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomsalle() {
        return nomsalle;
    }

    public void setNomsalle(String nomsalle) {
        this.nomsalle = nomsalle;
    }

    public int getNombreChaises() {
        return nombreChaises;
    }

    public void setNombreChaises(int nombreChaises) {
        this.nombreChaises = nombreChaises;
    }

    public Salle(Long id, int nombreChaises) {
        this.id = id;
        this.nombreChaises = nombreChaises;
    }

    public Salle(Long id, String nomsalle, int nombreChaises) {
        this.id = id;
        this.nomsalle = nomsalle;
        this.nombreChaises = nombreChaises;
    }

    public Salle(String nomsalle, int nombreChaises) {
        this.nomsalle = nomsalle;
        this.nombreChaises = nombreChaises;
    }

    public Salle() {
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nomsalle='" + nomsalle + '\'' +
                ", nombreChaises=" + nombreChaises +
                '}';
    }
}
