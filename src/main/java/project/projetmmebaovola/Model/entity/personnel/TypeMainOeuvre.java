package project.projetmmebaovola.Model.entity.personnel;

import jakarta.persistence.*;

@Entity
public class TypeMainOeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nomMainD_oeuvre;
    private double tauxHoraire;
    private double tauxJournalier;

    public double getTauxJournalier() {
        return tauxJournalier;
    }

    public void setTauxJournalier(double tauxJournalier) {
        this.tauxJournalier = tauxJournalier;
    }

    private int heureDeTravail;
    public String getNomMainD_oeuvre() {
        return nomMainD_oeuvre;
    }

    public void setNomMainD_oeuvre(String nomMainD_oeuvre) {
        this.nomMainD_oeuvre = nomMainD_oeuvre;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) throws Exception {
        if(tauxHoraire<0){
            throw new Exception("taux horaire negatif");
        }
        this.tauxHoraire = tauxHoraire;
    }



    public void setHeureDeTravail(int heureDeTravail) throws Exception {
        if(heureDeTravail<0){
            throw new Exception("heur de travail negative");

        }
        this.heureDeTravail = heureDeTravail;
    }
    public int getHeureDeTravail(){return  heureDeTravail;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeMainOeuvre(Integer id, String nomMainD_oeuvre, double tauxHoraire, int heureTravail) throws Exception {
        setId(id);
        setNomMainD_oeuvre(nomMainD_oeuvre);
        setTauxHoraire(tauxHoraire);
        setHeureDeTravail(heureTravail);

    }
    public TypeMainOeuvre( String nomMainD_oeuvre, double tauxHoraire, double tauxJournalier) throws Exception {
        setNomMainD_oeuvre(nomMainD_oeuvre);
        setTauxHoraire(tauxHoraire);

    }

    public TypeMainOeuvre() {
    }

    @Override
    public String toString() {
        return "TypeMainOeuvre{" +
                "id=" + id +
                ", nomMainD_oeuvre='" + nomMainD_oeuvre + '\'' +
                ", tauxHoraire=" + tauxHoraire +

                '}';
    }
}
