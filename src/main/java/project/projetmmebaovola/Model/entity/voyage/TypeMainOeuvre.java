package project.projetmmebaovola.Model.entity.voyage;

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

    public double getTauxJournalier() {
        return tauxJournalier;
    }

    public void setTauxJournalier(double tauxJournalier) throws Exception {
        if(tauxJournalier<0){
            throw new Exception("taux journalier negatif");

        }
        this.tauxJournalier = tauxJournalier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeMainOeuvre(Integer id, String nomMainD_oeuvre, double tauxHoraire, double tauxJournalier) throws Exception {
        setId(id);
        setNomMainD_oeuvre(nomMainD_oeuvre);
        setTauxHoraire(tauxHoraire);
        setTauxJournalier(tauxJournalier);
    }
    public TypeMainOeuvre( String nomMainD_oeuvre, double tauxHoraire, double tauxJournalier) throws Exception {
        setNomMainD_oeuvre(nomMainD_oeuvre);
        setTauxHoraire(tauxHoraire);
        setTauxJournalier(tauxJournalier);
    }

    public TypeMainOeuvre() {
    }

    @Override
    public String toString() {
        return "TypeMainOeuvre{" +
                "id=" + id +
                ", nomMainD_oeuvre='" + nomMainD_oeuvre + '\'' +
                ", tauxHoraire=" + tauxHoraire +
                ", tauxJournalier=" + tauxJournalier +
                '}';
    }
}
