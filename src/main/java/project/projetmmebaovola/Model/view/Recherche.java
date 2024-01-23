package project.projetmmebaovola.Model.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "recherche")
public class Recherche {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_debutvoyage")
    private LocalDate dateDebutvoyage;

    @Column(name = "date_fin_voyage")
    private LocalDate dateFinVoyage;

    @Column(name = "nom_bouquet")
    private String nomBouquet;

    @Column(name = "typedure")
    private String typedure;

    @Column(name = "nom_activite")
     String nomActivite;

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDateDebutvoyage() {
        return dateDebutvoyage;
    }

    public LocalDate getDateFinVoyage() {
        return dateFinVoyage;
    }

    public String getNomBouquet() {
        return nomBouquet;
    }

    public String getTypedure() {
        return typedure;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    protected Recherche() {
    }

    @Override
    public String toString() {
        return "Recherche{" +
                "id=" + id +
                ", dateDebutvoyage=" + dateDebutvoyage +
                ", dateFinVoyage=" + dateFinVoyage +
                ", nomBouquet='" + nomBouquet + '\'' +
                ", typedure='" + typedure + '\'' +
                ", nomActivite='" + nomActivite + '\'' +
                '}';
    }
}