package project.projetmmebaovola.Model;

import jakarta.persistence.*;
import project.projetmmebaovola.Repository.EtudiantRepository;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom ;
    private String prenom;

    @ManyToOne
    @JoinColumn(name="idSalle")
    private Salle salle;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Etudiant(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant() {
    }

//    functions
    public void saveEtudiant(EtudiantRepository etudiantRepository){
        etudiantRepository.save(this);

    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", salle=" + salle +
                '}';
    }

    public Etudiant(Long id, String nom, String prenom, Salle salle) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.salle = salle;
    }

    public Etudiant(String nom, String prenom, Salle salle) {
        this.nom = nom;
        this.prenom = prenom;
        this.salle = salle;
    }

}
