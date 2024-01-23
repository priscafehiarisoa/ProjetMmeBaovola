package project.projetmmebaovola.Model.entity.voyage;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
@Entity
public class TypeLieu   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String descriptionLieu;

    public TypeLieu(Integer id, String descriptionLieu) {
       setId(id);
        setDescriptionLieu(descriptionLieu);
    }

    public TypeLieu(String descriptionLieu) {
        setDescriptionLieu(descriptionLieu);
    }

    public TypeLieu() {
    }

    public String getDescriptionLieu() {
        return descriptionLieu;
    }

    public void setDescriptionLieu(String descriptionLieu) {
        this.descriptionLieu = descriptionLieu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
