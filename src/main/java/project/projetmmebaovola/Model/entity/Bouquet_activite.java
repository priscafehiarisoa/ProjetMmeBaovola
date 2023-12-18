package project.projetmmebaovola.Model.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Definition des états
 * etat=0 => veux dire que l'activite est disponible pour les voyages
 * etat = -10 => veux dire que l'activite a été supprimé du bouquet
 * */

@Entity
public class Bouquet_activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Bouquets bouquets;
    @ManyToOne
    private Activite activite;

    private int etat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bouquets getBouquets() {
        return bouquets;
    }

    public void setBouquets(Bouquets bouquets) {
        this.bouquets = bouquets;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) throws Exception {
        if(!getAllowedStatus().contains(etat)){
            throw new Exception("l'état "+etat+" n'existe pas encore");
        }
        this.etat = etat;
    }

    // statuts Authorisé

    public List<Integer> getAllowedStatus(){
        return List.of(10,0,-10);
    }

    public Bouquet_activite(Integer id, Bouquets bouquets, Activite activite, int etat) throws Exception {
        setId(id);
        setActivite(activite);
        setBouquets(bouquets);
        setEtat(etat);
    }

    public Bouquet_activite(Bouquets bouquets, Activite activite) throws Exception {
        setActivite(activite);
        setBouquets(bouquets);
        setEtat(0);
    }

    public Bouquet_activite() {
    }
}
