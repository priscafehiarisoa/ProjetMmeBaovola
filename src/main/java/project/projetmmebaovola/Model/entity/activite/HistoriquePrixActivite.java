package project.projetmmebaovola.Model.entity.activite;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class HistoriquePrixActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    LocalDateTime dateModification;
    @ManyToOne
    @JoinColumn(name = "activite_id")
    Activite activite;
    double prixActivite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }
    public void setDateModification() {
        setDateModification(LocalDateTime.now());
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public double getPrixActivite() {
        return prixActivite;
    }

    public void setPrixActivite(double prixActivite) {
        this.prixActivite = prixActivite;
    }

    public HistoriquePrixActivite(Activite activite, double prixActivite) {
        setActivite(activite);
        setPrixActivite(prixActivite);
        setDateModification();
    }
    public HistoriquePrixActivite(Integer id,Activite activite, double prixActivite) {
        setId(id);
        setActivite(activite);
        setPrixActivite(prixActivite);
        setDateModification();
    }

    public HistoriquePrixActivite() {
    }

    @Override
    public String toString() {
        return "HistoriquePrixActivite{" +
                "id=" + id +
                ", dateModification=" + dateModification +
                ", activite=" + activite +
                ", prixActivite=" + prixActivite +
                '}';
    }
}
