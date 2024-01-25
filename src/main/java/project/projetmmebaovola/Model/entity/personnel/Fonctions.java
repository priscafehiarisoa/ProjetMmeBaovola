package project.projetmmebaovola.Model.entity.personnel;

import jakarta.persistence.*;

@Entity
public class Fonctions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomFonction;
    private int debutIntervalleAnnee;
    private int finIntervalleAnnee;
    private int multiplicateur;

    public int getMultiplicateur() {
        return multiplicateur;
    }

    public void setMultiplicateur(int multiplicateur) {
        this.multiplicateur = multiplicateur;
    }

    public int getDebutIntervalleAnnee() {
        return debutIntervalleAnnee;
    }

    public void setDebutIntervalleAnnee(int debutIntervalleAnnee) {
        this.debutIntervalleAnnee = debutIntervalleAnnee;
    }

    public int getFinIntervalleAnnee() {
        return finIntervalleAnnee;
    }

    public void setFinIntervalleAnnee(int finIntervalleAnnee) {
        this.finIntervalleAnnee = finIntervalleAnnee;
    }

    public String getNomFonction() {
        return nomFonction;
    }

    public void setNomFonction(String nomFonction) {
        this.nomFonction = nomFonction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fonctions{" +
                "id=" + id +
                ", nomFonction='" + nomFonction + '\'' +
                ", debutIntervalleAnnee=" + debutIntervalleAnnee +
                ", finIntervalleAnnee=" + finIntervalleAnnee +
                '}';
    }

    public Fonctions(Integer id, String nomFonction, int debutIntervalleAnnee, int finIntervalleAnnee,int multiplicateur) {
        this.id = id;
        this.nomFonction = nomFonction;
        this.debutIntervalleAnnee = debutIntervalleAnnee;
        this.finIntervalleAnnee = finIntervalleAnnee;
        setMultiplicateur(multiplicateur);
    }
    public Fonctions( String nomFonction, int debutIntervalleAnnee, int finIntervalleAnnee,int multiplicateur) {
        this.nomFonction = nomFonction;
        this.debutIntervalleAnnee = debutIntervalleAnnee;
        this.finIntervalleAnnee = finIntervalleAnnee;
        setMultiplicateur(multiplicateur);


    }

    public Fonctions() {
    }
}
