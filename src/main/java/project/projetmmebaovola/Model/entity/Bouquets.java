package project.projetmmebaovola.Model.entity;

import jakarta.persistence.*;
import project.projetmmebaovola.Repository.ActiviteRepository;
import project.projetmmebaovola.Repository.BouquetActiviteRepository;
import project.projetmmebaovola.Repository.BouquetsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * etat des bouquets
 * 0 normale
 * -10 supprimé
 * */

@Entity
public class Bouquets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomBouquet;

    private String descriptionBouquet;

    @Transient
    private List<Bouquet_activite> listeBouquetActivite;

    private int etat=0;

    public Bouquets() {

    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public List<Bouquet_activite> getListeBouquetActivite() {
        return listeBouquetActivite;
    }

    public void setListeBouquetActivite(List<Bouquet_activite> listeBouquetActivite) {
        this.listeBouquetActivite = listeBouquetActivite;
    }

    public String getDescriptionBouquet() {
        return descriptionBouquet;
    }

    public void setDescriptionBouquet(String descriptionBouquet) {
        this.descriptionBouquet = descriptionBouquet;
    }

    public String getNomBouquet() {
        return nomBouquet;
    }

    public void setNomBouquet(String nomBouquet) {
        this.nomBouquet = nomBouquet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bouquets(Integer id, String nomBouquet) {
        setId(id);
        setNomBouquet(nomBouquet);
    }

    public Bouquets(Integer id, String nomBouquet, String descriptionBouquet) {
        setId(id);
        setNomBouquet(nomBouquet);
        setDescriptionBouquet(descriptionBouquet);
    }

    public Bouquets(String nomBouquet, String descriptionBouquet) {
        setNomBouquet(nomBouquet);
        setDescriptionBouquet(descriptionBouquet);
    }

    public List<Bouquet_activite> createActiviteForBouquet(List<Integer> idActivites, ActiviteRepository activiteRepository) throws Exception {
        List<Bouquet_activite> bouquetActivites=new ArrayList<>();
        for (int i = 0; i < idActivites.size(); i++) {
            Optional<Activite> activite= activiteRepository.findById(idActivites.get(i));
            Bouquet_activite bouquetActivite=null;
            if(activite.isPresent()) {
                bouquetActivite = new Bouquet_activite(this, activite.get());
            }
            else{
                throw new Exception("l'activite "+idActivites.get(i)+" n'existe pas ");
            }
            bouquetActivites.add(bouquetActivite);
        }
        return bouquetActivites;
    }

    public void saveBouquet(List<Integer> bouquetActiviteList, BouquetsRepository bouquetsRepository, BouquetActiviteRepository bouquetActiviteRepository,ActiviteRepository activiteRepository) throws Exception {
        bouquetsRepository.save(this);
        List<Bouquet_activite> bouquetActivites=this.createActiviteForBouquet(bouquetActiviteList,activiteRepository);
        bouquetActiviteRepository.saveAll(bouquetActivites);
    }

    public void setListBouquetActivite(BouquetActiviteRepository bouquetActiviteRepository){
        listeBouquetActivite=bouquetActiviteRepository.getBouquet_activitesByBouquetsAndEtat(this,0);
    }

    public List<Bouquet_activite> getListBouquetActivite(){
        return listeBouquetActivite;
    }

}
