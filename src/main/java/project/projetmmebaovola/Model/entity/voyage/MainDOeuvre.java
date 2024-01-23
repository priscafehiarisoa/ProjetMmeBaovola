package project.projetmmebaovola.Model.entity.voyage;

import jakarta.persistence.*;

@Entity
public class MainDOeuvre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;

    private int nombreMainOeuvre;
    @ManyToOne
    @JoinColumn(name = "type_main_oeuvre_id")
    private TypeMainOeuvre typeMainOeuvre;

    public MainDOeuvre(Integer id, Voyage voyage, int nombreMainOeuvre, TypeMainOeuvre typeMainOeuvre) {
        setId(id);
        setVoyage(voyage);
        setNombreMainOeuvre(nombreMainOeuvre);
        setTypeMainOeuvre(typeMainOeuvre);
    }

    public MainDOeuvre(Voyage voyage, int nombreMainOeuvre, TypeMainOeuvre typeMainOeuvre) {
        setVoyage(voyage);
        setNombreMainOeuvre(nombreMainOeuvre);
        setTypeMainOeuvre(typeMainOeuvre);
    }

    public TypeMainOeuvre getTypeMainOeuvre() {
        return typeMainOeuvre;
    }

    public void setTypeMainOeuvre(TypeMainOeuvre typeMainOeuvre) {
        this.typeMainOeuvre = typeMainOeuvre;
    }

    public MainDOeuvre() {
    }

    public int getNombreMainOeuvre() {
        return nombreMainOeuvre;
    }

    public void setNombreMainOeuvre(int nombreMainOeuvre) {
        this.nombreMainOeuvre = nombreMainOeuvre;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MainDOeuvre{" +
                "id=" + id +
                ", voyage=" + voyage +
                ", nombreMainOeuvre=" + nombreMainOeuvre +
                ", typeMainOeuvre=" + typeMainOeuvre +
                '}';
    }
}
