package project.projetmmebaovola.Model.entity.personnel;

import jakarta.persistence.*;
import project.projetmmebaovola.Model.util.Utils;
import project.projetmmebaovola.Repository.FonctionsRepository;

import java.time.LocalDate;
import java.util.Optional;

@Entity
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String NomPersonnel;
   private LocalDate dateEmbauche;

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    @ManyToOne
    @JoinColumn(name = "idTypeMainOeuvre")
    private TypeMainOeuvre typeMainOeuvre;
   @Transient
   private Fonctions fonction;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId(){return id;}

    public void setNomPersonnel(String nomPersonnel) {
        NomPersonnel = nomPersonnel;
    }
    public String getNomPersonnel(){return   NomPersonnel;}
    public void setDateEmbauche(LocalDate dateEmbauche){
        this.dateEmbauche=dateEmbauche;
    }

    public void setTypeMainOeuvre(TypeMainOeuvre typeMainOeuvre) {
        this.typeMainOeuvre = typeMainOeuvre;
    }
    public TypeMainOeuvre getTypeMainOeuvre(){return typeMainOeuvre;}

    public void setFonction(Fonctions fonction) {
        this.fonction = fonction;
    }
    public void setFonction(FonctionsRepository fonctionsRepository) {
        int anneeTravail= Utils.differenceInYears(getDateEmbauche(),LocalDate.now());
        Optional<Fonctions> optionalFonctions=fonctionsRepository.getFonctionByAnneeTravail(anneeTravail);
        if(optionalFonctions.isPresent()){
            setFonction(optionalFonctions.get());
        }
    }

    public double getSalaire(){
        return this.getFonction().getMultiplicateur()*this.getTypeMainOeuvre().getTauxHoraire();
    }

    public double getHeureTravail(){
        return this.getFonction().getMultiplicateur()*this.getTypeMainOeuvre().getHeureDeTravail();
    }
    public Fonctions getFonction(){return fonction;}



    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", NomPersonnel='" + NomPersonnel + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", typeMainOeuvre=" + typeMainOeuvre +
                ", fonction='" + fonction + '\'' +
                '}';
    }

    public Personnel(Integer id, String nomPersonnel, LocalDate dateEmbauche, TypeMainOeuvre typeMainOeuvre, FonctionsRepository fonction) {
        this.id = id;
        NomPersonnel = nomPersonnel;
        this.dateEmbauche = dateEmbauche;
        this.typeMainOeuvre = typeMainOeuvre;
        setFonction(fonction);
    }
    public Personnel( String nomPersonnel, LocalDate dateEmbauche, TypeMainOeuvre typeMainOeuvre, FonctionsRepository fonction) {
        NomPersonnel = nomPersonnel;
        this.dateEmbauche = dateEmbauche;
        this.typeMainOeuvre = typeMainOeuvre;
        setFonction(fonction);
    }

    public Personnel() {
    }
}
