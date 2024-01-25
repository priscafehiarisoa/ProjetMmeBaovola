package project.projetmmebaovola.Model.entity.voyage;

import jakarta.persistence.*;
import project.projetmmebaovola.Model.entity.personnel.Personnel;
import project.projetmmebaovola.Model.entity.personnel.TypeMainOeuvre;

@Entity
public class MainDOeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;

    private int nombreDeJoursDeTravail;
    @ManyToOne
    @JoinColumn(name = "personnel_id")
    private Personnel personnel;

    public Personnel getPersonnel() {
        return personnel;
    }

    public int getNombreDeJoursDeTravail() {
        return nombreDeJoursDeTravail;
    }

    public void setNombreDeJoursDeTravail(int nombreDeJoursDeTravail) {
        this.nombreDeJoursDeTravail = nombreDeJoursDeTravail;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public MainDOeuvre(Integer id, Voyage voyage,  int nombreDeJoursDeTravail,Personnel personnel) {
        setId(id);
        setVoyage(voyage);
        setNombreDeJoursDeTravail(nombreDeJoursDeTravail);
        setPersonnel(personnel);
    }

    public MainDOeuvre(Voyage voyage,  int nombreDeJoursDeTravail,Personnel personnel) {
        setVoyage(voyage);
        setNombreDeJoursDeTravail(nombreDeJoursDeTravail);
        setPersonnel(personnel);
    }


    public MainDOeuvre() {
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
