-- create view recherche (id, date_debutvoyage, date_fin_voyage, nom_bouquet, typedure, nom_activite, quantite) as
-- SELECT voyage.id,
--        voyage.date_debutvoyage,
--        voyage.date_fin_voyage,
--        b.nom_bouquet,
--        voyage.typedure,
--        a.nom_activite,
--        voyage_activite.quantite
-- FROM voyage
--          JOIN voyage_activite ON voyage.id = voyage_activite.id
--          JOIN activite a ON a.id = voyage_activite.id_activite
--          JOIN voyage_bouquets ON voyage.id = voyage_bouquets.voyage_id
--          JOIN bouquets b ON b.id = voyage_bouquets.bouquets_id;
--


create view recherche as
select
    voyage.id,
    voyage.date_debutvoyage,
    voyage.date_fin_voyage,
    voyage.typedure,
    bouquets.nom_bouquet,
    a.nom_activite,
        quantite
--     *
from voyage join bouquets on bouquets.id=voyage.bouquets_id
    join public.voyage_activite va on voyage.id = va.id_voyage
    join public.activite a on a.id = va.id_activite


-- vue ca;cul tarif
create or replace view tarifVoyage as
    select voyage_activite.id_voyage,sum(a.tarif*voyage_activite.quantite) as prixActivite
    from voyage_activite join public.activite a on a.id = voyage_activite.id_activite
group by voyage_activite.id_voyage


-- calcul prix main d'oeuvres
-- create view prix_main_d_oeuvres as
--     select sum(nombre_main_oeuvre*taux_journalier) sommeTauxJournalier, sum(nombre_main_oeuvre*taux_horaire) sommeTauxHoraire ,
--        voyage_id,tarifVoyage.prixActivite from maindoeuvre join public.type_main_oeuvre tmo on tmo.id = maindoeuvre.type_main_oeuvre_id
--            join tarifVoyage on tarifVoyage.id_voyage=maindoeuvre.voyage_id
--            join public.voyage v on v.id = maindoeuvre.voyage_id
-- group by voyage_id, tarifVoyage.prixActivite

-- review prix main d'oeuvre
create view  prix_main_d_oeuvres as select sum(coalesce((tmo.heure_de_travail*get_salaire_by_date_embauche(p.id))*nombre_de_jours_de_travail,0) )as salairePersonnel,maindoeuvre.voyage_id,tarifVoyage.prixActivite from maindoeuvre
    right join public.personnel p on p.id = maindoeuvre.personnel_id
    join public.type_main_oeuvre tmo on tmo.id = p.id_type_main_oeuvre
    join tarifVoyage on tarifVoyage.id_voyage=maindoeuvre.voyage_id

group by maindoeuvre.voyage_id, tarifVoyage.prixActivite

-- calcul des depenses du voyage
create view v_depenses_voyage as
    select salairePersonnel,voyage_id,prixActivite,(date_fin_voyage-date_debutvoyage)as joursVoyage, v.prix_unitaire_voyage
    from  prix_main_d_oeuvres join public.voyage v on v.id = prix_main_d_oeuvres.voyage_id


select prix_unitaire_voyage-(salairePersonnel+prixActivite),voyage_id,prix_unitaire_voyage,salairePersonnel+prixActivite from v_depenses_voyage
create view v_quantite_all_activite as select type_mouvement,activite_id,quantite_mouvement from mouvement_stock_activite
union all
select 1,id,0 from activite

-- requette pour obtenir le reste des stocks

create view v_restestockactivite as select activite_id as id_activite,sum(quantite_mouvement*v_quantite_all_activite.type_mouvement) as restestock from v_quantite_all_activite
group by activite_id

select * from v_restestockactivite

--  fonction getSalaire
CREATE OR REPLACE FUNCTION get_salaire_by_date_embauche(personnel_id INT)
    RETURNS DOUBLE PRECISION
AS $$
DECLARE
    personne_date_embauche DATE;
    fonction_id INT;
    realSalaireHoraie DOUBLE PRECISION;
    personne_salaire_nin DOUBLE PRECISION;
BEGIN
    -- Récupérer la date d'embauche du personnel
    SELECT date_embauche INTO personne_date_embauche FROM Personnel WHERE id = personnel_id;
    SELECT tmo.taux_horaire INTO personne_salaire_nin FROM Personnel JOIN public.type_main_oeuvre tmo ON tmo.id = Personnel.id_type_main_oeuvre WHERE Personnel.id = personnel_id;

    -- Trouver la fonction correspondante
    SELECT id INTO fonction_id
    FROM Fonctions
    WHERE extract(year FROM current_date) - extract(year FROM personne_date_embauche) BETWEEN debut_intervalle_annee AND fin_intervalle_annee;

    -- Calculer le salaire horaire réel
    realSalaireHoraie := personne_salaire_nin * (SELECT multiplicateur FROM Fonctions WHERE id = fonction_id);

    -- Retourner le salaire horaire réel
    RETURN realSalaireHoraie;
END;
$$ LANGUAGE plpgsql;

select get_salaire_by_date_embauche(1)