package project.projetmmebaovola.Model.entity;

import jakarta.persistence.*;

@Entity
public class VoyageActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idActivite")
    private Activite activite;

    @ManyToOne
    @JoinColumn(name = "idVoyage")
    private Voyage voyage;

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    private double quantite;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VoyageActivite(Integer id, Activite activite, double quantite, Voyage voyage) {
        this.id = id;
        this.activite = activite;
        this.quantite = quantite;
        setVoyage(voyage);
    }

    public VoyageActivite(Activite activite, double quantite , Voyage voyage) {
        this.activite = activite;
        this.quantite = quantite;
        setVoyage(voyage);
    }

    public VoyageActivite() {
    }

    @Override
    public String toString() {
        return "VoyageActivite{" +
                "id=" + id +
                ", activite=" + activite +
                ", voyage=" + voyage +
                ", quantite=" + quantite +
                '}';
    }
}
