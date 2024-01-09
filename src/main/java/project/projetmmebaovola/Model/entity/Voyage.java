package project.projetmmebaovola.Model.entity;

import jakarta.persistence.*;
import project.projetmmebaovola.Repository.BouquetsRepository;
import project.projetmmebaovola.Repository.TypeLieuRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private LocalDate dateDebutvoyage;
    private LocalDate dateFinVoyage;

    private String typedure;


    @ManyToOne
    private Bouquets bouquets;
    @ManyToOne
    @JoinColumn(name = "idTypeLieu")
    private TypeLieu typeLieu;

    private String lieu ;

    @Transient
    private List<VoyageActivite> listeActivite;

    public List<VoyageActivite> getListeActivite() {
        return listeActivite;
    }

    public void setListeActivite(List<VoyageActivite> listeActivite) {
        this.listeActivite = listeActivite;
    }

    public LocalDate getDateDebutvoyage() {
        return dateDebutvoyage;
    }

    public void setDateDebutvoyage(LocalDate dateDebutvoyage) {
        this.dateDebutvoyage = dateDebutvoyage;
    }

    public LocalDate getDateFinVoyage() {
        return dateFinVoyage;
    }

    public void setDateFinVoyage(LocalDate dateFinVoyage) {
        this.dateFinVoyage = dateFinVoyage;
    }

    public Bouquets getBouquets() {
        return bouquets;
    }

    public void setBouquets(Bouquets bouquets) {
        this.bouquets = bouquets;
    }

    public TypeLieu getTypeLieu() {
        return typeLieu;
    }

    public void setTypeLieu(TypeLieu typeLieu) {
        this.typeLieu = typeLieu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTypedure() {
        return typedure;
    }

    public void setTypedure(String typedure) {
        this.typedure = typedure;
    }

    public Voyage(String lieu, Integer id, LocalDate dateDebutvoyage, LocalDate dateFinVoyage, Bouquets bouquets, TypeLieu typeLieu,String typedure) {
        setId(id);
        setDateDebutvoyage(dateDebutvoyage);
        setDateFinVoyage(dateFinVoyage);
        setBouquets((bouquets));
        setTypeLieu(typeLieu);
        setLieu(lieu);
        setTypedure(typedure);
    }

    public Voyage(String lieu,LocalDate dateDebutvoyage, LocalDate dateFinVoyage, Bouquets bouquets, TypeLieu typeLieu,String typedure) {
        setDateDebutvoyage(dateDebutvoyage);
        setDateFinVoyage(dateFinVoyage);
        setBouquets(bouquets);
        setTypeLieu(typeLieu);
        setLieu(lieu);
        setTypedure(typedure);
    }

    public Voyage(LocalDate dateDebutvoyage, LocalDate dateFinVoyage, Integer idbouquets, int typeLieu, String lieu, BouquetsRepository bouquetsRepository, TypeLieuRepository typeLieuRepository,String typedure) throws Exception {
        setDateDebutvoyage(dateDebutvoyage);
        setTypedure(typedure);

            Optional<Bouquets> bouquets1= bouquetsRepository.findById(idbouquets);
            if(bouquets1.isPresent()){
                setBouquets(bouquets1.get());
            }else{
                throw new Exception("bouquets "+ idbouquets+" introuvable");
            }

        setBouquets(bouquets);
        setDateFinVoyage(dateFinVoyage);
        Optional<TypeLieu> typeLieu1= typeLieuRepository.findById(typeLieu);

        if(typeLieu1.isPresent()){
            setTypeLieu(typeLieu1.get());
        }
        else{
            throw new Exception("typeLieu introuvable ");
        }
        setLieu(lieu);
    }

    public Voyage() {
    }
}
