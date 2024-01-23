package project.projetmmebaovola.Model.util;

import project.projetmmebaovola.Model.entity.activite.Activite;
import project.projetmmebaovola.Repository.ActiviteRepository;

import java.util.Optional;

public class ResteStock {
    Activite activite;
    double nbstock;

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public double getNbstock() {
        return nbstock;
    }

    public void setNbstock(double nbstock) {
        this.nbstock = nbstock;
    }

    public ResteStock(Activite activite, double nbstock) {
        this.activite = activite;
        this.nbstock = nbstock;
    }

    public ResteStock(int idActivite, double nbStock, ActiviteRepository activiteRepository) {
        Optional<Activite> activiteOptional=activiteRepository.findById(idActivite);
        if(activiteOptional.isPresent()){
            setActivite(activiteOptional.get());
        }
        setNbstock(nbStock);
    }
}
