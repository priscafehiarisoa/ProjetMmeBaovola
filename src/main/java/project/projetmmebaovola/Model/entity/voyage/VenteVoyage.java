package project.projetmmebaovola.Model.entity.voyage;

import jakarta.persistence.*;

@Entity
public class VenteVoyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name ="reservatio_id")
    private  ReservationVoyage reservation;
    private Double montantPaye;

    public VenteVoyage() {

    }

    public VenteVoyage(ReservationVoyage reservation, Double montantPaye) {
        this.reservation = reservation;
        this.montantPaye = montantPaye;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setIdreservation(ReservationVoyage idreservation) {
        this.reservation = idreservation;
    }
    public ReservationVoyage getReservation(){return reservation;}

    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Double getMontantPaye() {
        return montantPaye;
    }

    public VenteVoyage(Integer id, ReservationVoyage reservation, Double montantPaye) {
        this.id = id;
        this.reservation = reservation;
        this.montantPaye = montantPaye;
    }
}
