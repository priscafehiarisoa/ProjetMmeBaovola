package project.projetmmebaovola.Model.entity.activite;

import jakarta.persistence.*;
import project.projetmmebaovola.Repository.MouvementStockActiviteRepository;

@Entity

public class MouvementStockActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    // 1 ou -1
    private int typeMouvement;
    @ManyToOne
    @JoinColumn(name = "activite_id")
    private Activite activite;
    private double quantiteMouvement;

    public MouvementStockActivite() {

    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(int typeMouvement) throws Exception {
        if(typeMouvement!=-1 && typeMouvement!=1){
            throw new Exception("type de mouvement invalide");
        }
        this.typeMouvement = typeMouvement;
    }

    public double getQuantiteMouvement() {
        return quantiteMouvement;
    }

    public void setQuantiteMouvement(double quantiteMouvement) throws Exception {
        if(quantiteMouvement<0){
            throw new Exception("quantite invalide ");
        }
        this.quantiteMouvement = quantiteMouvement;
    }
    public void setQuantiteMouvement(double quantiteMouvement, MouvementStockActiviteRepository mouvementStockActiviteRepository) throws Exception {
        if(quantiteMouvement<0){
            throw new Exception("quantite invalide ");
        }
        this.quantiteMouvement = quantiteMouvement;
    }

    public MouvementStockActivite(Integer id, int typeMouvement, Activite activite, double quantiteMouvement) throws Exception {
        setId(id);
        setTypeMouvement(typeMouvement);
        setActivite(activite);
        setQuantiteMouvement(quantiteMouvement);
    }
    public MouvementStockActivite(int typeMouvement, Activite activite, double quantiteMouvement) throws Exception {
        setTypeMouvement(typeMouvement);
        setActivite(activite);
        setQuantiteMouvement(quantiteMouvement);
    }
    public MouvementStockActivite(int typeMouvement, Activite activite, double quantiteMouvement,MouvementStockActiviteRepository mouvementStockActiviteRepository) throws Exception {
        setTypeMouvement(typeMouvement);
        setActivite(activite);
        setQuantiteMouvement(quantiteMouvement,mouvementStockActiviteRepository);
    }

    @Override
    public String toString() {
        return "MouvementStockActivite{" +
                "id=" + id +
                ", typeMouvement=" + typeMouvement +
                ", activite=" + activite +
                ", quantiteMouvement=" + quantiteMouvement +
                '}';
    }
}
