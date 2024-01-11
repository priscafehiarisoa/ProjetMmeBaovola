package project.projetmmebaovola.Model.entity;

import jakarta.persistence.*;
import project.projetmmebaovola.Repository.ActiviteRepository;
import project.projetmmebaovola.Repository.CateorieActiviteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Definition des états
 * etat=0 => veux dire que l'activite est disponible pour les voyages
 * etat = -10 => veux dire que l'activite a été supprimé du bouquet
 * */
@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomActivite;
    private String description;
    private int duree;
    private String typedure;
    private int etat=0;
    @ManyToMany
    private List<CateorieActivite> listeCategorieActivite;
    private double tarif;
    public int getEtat() {
        return etat;
    }
  public double getTarif(){
        return tarif;
  }

  public void setTarif(double tarif) throws Exception{
        if(tarif<0){
            throw new Exception("montant ivalide");
        }
        this.tarif=tarif;
  }
    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descrition) {
        this.description = descrition;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getTypedure() {
        return typedure;
    }

    public void setTypedure(String typedure) {
        this.typedure = typedure;
    }

    public List<CateorieActivite> getListeCategorieActivite() {
        return listeCategorieActivite;
    }

    public void setListeCategorieActivite(List<CateorieActivite> listeCategorieActivite) {
        this.listeCategorieActivite = listeCategorieActivite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Activite(Integer id, String nomActivite, String descrition, int duree, String typedure,double tarif) throws Exception {
        setId(id);
        setDescription(descrition);
        setNomActivite(nomActivite);
        setDuree(duree);
        setTypedure(typedure);
        setTarif(tarif);
    }

    public Activite(String nomActivite, String descrition, int duree, String typedure,double tarif) throws Exception {
        setDescription(descrition);
        setNomActivite(nomActivite);
        setDuree(duree);
        setTypedure(typedure);
        setTarif(tarif);
    }

    public Activite() {
    }

    public void  saveActivite(ActiviteRepository activiteRepository, CateorieActiviteRepository cateorieActiviteRepository, List<Integer> idCategories) throws Exception {
        List<CateorieActivite> cateorieActivites=new ArrayList<>();
        for (int i = 0; i < idCategories.size(); i++) {
            Optional<CateorieActivite> cat=cateorieActiviteRepository.findById(idCategories.get(i));
            if(cat.isPresent()){
                cateorieActivites.add(cat.get());
            }else {
                throw new Exception("categorie introuvable");
            }
        }
        setListeCategorieActivite(cateorieActivites);
        activiteRepository.save(this);
        System.out.println("here you go man ");
    }
}
