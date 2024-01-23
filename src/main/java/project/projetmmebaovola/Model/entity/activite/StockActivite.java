package project.projetmmebaovola.Model.entity.activite;

import jakarta.persistence.*;
import project.projetmmebaovola.Model.entity.activite.Activite;

import java.time.LocalDateTime;

@Entity
public class StockActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double nombreStock;
  private  LocalDateTime entreeStock;
    @ManyToOne
    @JoinColumn(name = "idActivite")
    private Activite activite;

    public Double getNombreStock() {
        return nombreStock;
    }
    public void  setNombreStock(double nombreStock) throws Exception{
        if(nombreStock<=0){
            throw new Exception("valeur invalide");
        }
        this.nombreStock=nombreStock;
    }
    public Integer getId(){
        return id;
    }
    public void setId(int id){this.id=id;}
    public Activite getActivite(){return  activite;}
   public void setActivite(Activite activite){this.activite=activite;}
    public LocalDateTime getDateEntreeStock(){return entreeStock;}
    public void setDateEntreeStock(LocalDateTime entreeStock){
        this.entreeStock=entreeStock;
    }

    public StockActivite(Integer id, Double nombreStock,  Activite activite) throws Exception {
        setId(id);
        setNombreStock(nombreStock);
        setDateEntreeStock(LocalDateTime.now());
        setActivite(activite);
    }

    public StockActivite(Double nombreStock, Activite activite) throws Exception {
        setNombreStock(nombreStock);
        setDateEntreeStock(LocalDateTime.now());
        setActivite(activite);
    }

    public StockActivite() {
    }
}
