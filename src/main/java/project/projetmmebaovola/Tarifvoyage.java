package project.projetmmebaovola;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import project.projetmmebaovola.Model.entity.Voyage;
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
@Table(name = "tarifvoyage")
public class Tarifvoyage {
    @Id
    @Column(name = "id_voyage")
    private Integer idVoyage;

    @Column(name = "prixactivite")
    private Double prixactivite;

    public Integer getIdVoyage() {
        return idVoyage;
    }


    public Double getPrixactivite() {
        return prixactivite;
    }

    public void setIdVoyage(Integer idVoyage) {
        this.idVoyage = idVoyage;
    }

    public void setPrixactivite(Double prixactivite) {
        this.prixactivite = prixactivite;
    }

    protected Tarifvoyage() {
    }

    public static List<HashMap<String,Object>> getVoyage_Tarif(double debut, double fin, VoyageRepository voyageRepository, TarifvoyageRepository tarifvoyageRepository, VoyageActiviteRepository voyageActiviteRepository){
        List<Tarifvoyage> tarifvoyages= tarifvoyageRepository.getTarifVoyagesbetween(debut,fin);
        List<HashMap<String ,Object>> response= new ArrayList<>();
        for (int i = 0; i < tarifvoyages.size(); i++) {
            HashMap<String,Object> hashMap=new HashMap<>();
            Optional<Voyage> optionalVoyage= voyageRepository.findById(tarifvoyages.get(i).getIdVoyage());
            if(optionalVoyage.isPresent()){
                Voyage voyage=optionalVoyage.get();
                voyage.setListeActivite(voyageActiviteRepository.findVoyageActiviteByVoyage(voyage));
                hashMap.put("voyage",optionalVoyage.get());
                hashMap.put("tarif",tarifvoyages.get(i).getPrixactivite());
            }

            response.add(hashMap);

        }
        return response;
    }
}