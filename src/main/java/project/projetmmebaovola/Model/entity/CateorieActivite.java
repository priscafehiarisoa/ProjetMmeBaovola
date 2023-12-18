package project.projetmmebaovola.Model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CateorieActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomCAtegorie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCAtegorie() {
        return nomCAtegorie;
    }

    public void setNomCAtegorie(String nomCAtegorie) {
        this.nomCAtegorie = nomCAtegorie;
    }

    public CateorieActivite(Integer id, String nomCAtegorie) {
        setId(id);
        setNomCAtegorie(nomCAtegorie);
    }

    public CateorieActivite(String nomCAtegorie) {
        setNomCAtegorie(nomCAtegorie);
    }

    public CateorieActivite() {
    }
}
