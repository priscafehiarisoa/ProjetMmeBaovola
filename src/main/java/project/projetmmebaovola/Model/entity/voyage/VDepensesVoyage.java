package project.projetmmebaovola.Model.entity.voyage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;
import project.projetmmebaovola.Repository.VoyageActiviteRepository;
import project.projetmmebaovola.Repository.VoyageRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "v_depenses_voyage")
public class VDepensesVoyage {
    @Id
    @Column(name = "voyage_id")
    private Integer voyageId;

    @Column(name = "salairepersonnel")
    private Double salairepersonnel;

    @Column(name = "prixactivite")
    private Double prixactivite;

    @Column(name = "joursvoyage")
    private Integer joursvoyage;

    @Column(name = "prix_unitaire_voyage")
    private Double prixUnitaireVoyage;

    public Integer getVoyageId() {
        return voyageId;
    }

    public Double getSalairepersonnel() {
        return salairepersonnel;
    }

    public Double getPrixactivite() {
        return prixactivite;
    }

    public Integer getJoursvoyage() {
        return joursvoyage;
    }

    public Double getPrixUnitaireVoyage() {
        return prixUnitaireVoyage;
    }

    protected VDepensesVoyage() {
    }

    public VDepensesVoyage(Integer voyageId, Double salairepersonnel, Double prixactivite, Integer joursvoyage, Double prixUnitaireVoyage) {
        this.voyageId = voyageId;
        this.salairepersonnel = salairepersonnel;
        this.prixactivite = prixactivite;
        this.joursvoyage = joursvoyage;
        this.prixUnitaireVoyage = prixUnitaireVoyage;
    }
    public HashMap<String , Object> getObjectFromDepenses(VoyageRepository voyageRepository, VoyageActiviteRepository voyageActiviteRepository){
        Optional<Voyage> voyageOptional=voyageRepository.findById(this.getVoyageId());
        HashMap<String,Object> hashMap=new HashMap<>();
        Voyage voyage=new Voyage();
        if(voyageOptional.isPresent()){
            voyage=voyageOptional.get();
            voyage.setListeActivite(voyageActiviteRepository.findVoyageActiviteByVoyage(voyage));
        }
        hashMap.put("voyage",voyage);
        hashMap.put("benefices",getPrixUnitaireVoyage()-(getSalairepersonnel()+getPrixactivite()));
        hashMap.put("salairePersonnel",getSalairepersonnel());
        hashMap.put("prixActivite",getPrixactivite());
        hashMap.put("prixUnitaireVoyage",getPrixUnitaireVoyage());
        return hashMap;
    }

    public static List<HashMap<String,Object>> getBeneficesParFourchette(double prix1, double prix2, VDepensesVoyageRepository vDepensesVoyageRepository, VoyageRepository voyageRepository, VoyageActiviteRepository voyageActiviteRepository){
        List<VDepensesVoyage> depensesVoyages=vDepensesVoyageRepository.getBeneficesVoyageEntreDeuxFourchetteDePrix(prix1,prix2);
        List<HashMap<String,Object>> hashMaps=new ArrayList<>();
        for (int i = 0; i < depensesVoyages.size(); i++) {
            hashMaps.add(depensesVoyages.get(i).getObjectFromDepenses(voyageRepository,voyageActiviteRepository));
        }
        return hashMaps;
    }
}