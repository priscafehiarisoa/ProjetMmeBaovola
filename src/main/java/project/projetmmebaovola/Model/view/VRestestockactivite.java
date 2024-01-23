package project.projetmmebaovola.Model.view;

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
@Table(name = "v_restestockactivite")
public class VRestestockactivite {
    @Id
    @Column(name = "id_activite")
    private Integer idActivite;

    @Column(name = "restestock")
    private Double restestock;

    public Integer getIdActivite() {
        return idActivite;
    }

    public Double getRestestock() {
        return restestock;
    }

    protected VRestestockactivite() {
    }
}