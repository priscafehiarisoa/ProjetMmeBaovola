package project.projetmmebaovola.Model.entity.voyage;

import ch.qos.logback.core.model.INamedModel;
import jakarta.persistence.*;
import project.projetmmebaovola.Model.entity.client.Client;
import project.projetmmebaovola.Model.entity.voyage.Voyage;

import java.time.LocalDate;

@Entity

public class ReservationVoyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  Integer nombreRervation;
    private LocalDate dateReservation;
    @ManyToOne
    @JoinColumn(name = "idVoyage")
    private  Voyage voyage;
    @ManyToOne
    @JoinColumn(name="idClient")
    private Client client;
   private int etat;

    public ReservationVoyage() {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getEtat() {
        return etat;
    }
 public void setEtat(int etat){this.etat=etat;}
    public Integer getId(){return id;}
    public void setId(int id){this.id=id;}
    public LocalDate getDateReservation(){return dateReservation;}
    public void setDateReservation(LocalDate dateReservation){this.dateReservation=dateReservation;}
    public Integer getNombreRervation(){
        return nombreRervation;
    }
    public void setNombreRervation(int nombreRervation) throws  Exception{
        if(nombreRervation<=0){
            throw  new Exception("reservation non validée");
        }
        this.nombreRervation=nombreRervation;
    }
    public Voyage getVoyage(){return voyage;}
    public void setVoyage(Voyage voyage){this.voyage=voyage;}

    public ReservationVoyage(Integer id, Integer nombreRervation, LocalDate dateReservation, Voyage voyage, Client client, int etat) {
        this.id = id;
        this.nombreRervation = nombreRervation;
        this.dateReservation = dateReservation;
        this.voyage = voyage;
        this.client = client;
        this.etat = etat;
    }

    public ReservationVoyage(Integer nombreRervation, Voyage voyage, Client client) throws Exception {
        setNombreRervation(nombreRervation);
        this.voyage = voyage;
        this.client = client;
    }

}
