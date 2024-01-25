package project.projetmmebaovola;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "prix_main_d_oeuvres")
public class PrixMainDOeuvre {
    @Id
    @Column(name = "voyage_id")
    private Integer voyageId;

    @Column(name = "salairepersonnel")
    private Double salairepersonnel;

    @Column(name = "prixactivite")
    private Double prixactivite;

    public Integer getVoyageId() {
        return voyageId;
    }

    public Double getSalairepersonnel() {
        return salairepersonnel;
    }

    public Double getPrixactivite() {
        return prixactivite;
    }

    protected PrixMainDOeuvre() {
    }
}