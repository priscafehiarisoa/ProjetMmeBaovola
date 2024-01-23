package project.projetmmebaovola.Model.entity.voyage;

import jakarta.persistence.*;

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
    private String nomClient;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombreRervation(Integer nombreRervation) {
        this.nombreRervation = nombreRervation;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public ReservationVoyage(Integer id, Integer nombreRervation, Voyage voyage) throws Exception {
        setId(id);
        setNombreRervation(nombreRervation);
        setDateReservation(LocalDate.now());
        setVoyage(voyage);
    }

    public ReservationVoyage(Integer nombreRervation,  Voyage voyage) throws Exception {
        setNombreRervation(nombreRervation);
        setDateReservation(LocalDate.now());
        setVoyage(voyage);
    }

    public ReservationVoyage() {
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

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
}
