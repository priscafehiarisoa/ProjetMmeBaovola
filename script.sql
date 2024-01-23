-- create view recherche (id, date_debutvoyage, date_fin_voyage, nom_bouquet, typedure, nom_activite, quantite) as
SELECT voyage.id,
       voyage.date_debutvoyage,
       voyage.date_fin_voyage,
       b.nom_bouquet,
       voyage.typedure,
       a.nom_activite,
       voyage_activite.quantite
FROM voyage
         JOIN voyage_activite ON voyage.id = voyage_activite.id
         JOIN activite a ON a.id = voyage_activite.id_activite
         JOIN voyage_bouquets ON voyage.id = voyage_bouquets.voyage_id
         JOIN bouquets b ON b.id = voyage_bouquets.bouquets_id;



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
create view prix_main_d_oeuvres as select sum(nombre_main_oeuvre*taux_journalier) sommeTauxJournalier, sum(nombre_main_oeuvre*taux_horaire) sommeTauxHoraire ,
       voyage_id,tarifVoyage.prixActivite from maindoeuvre join public.type_main_oeuvre tmo on tmo.id = maindoeuvre.type_main_oeuvre_id
           join tarifVoyage on tarifVoyage.id_voyage=maindoeuvre.voyage_id
           join public.voyage v on v.id = maindoeuvre.voyage_id
group by voyage_id, tarifVoyage.prixActivite

select * from tarifVoyage

-- calcul des depenses du voyage
create view v_depenses_voyage as
    select sommeTauxHoraire,sommeTauxJournalier,voyage_id,prixActivite,(date_fin_voyage-date_debutvoyage)as joursVoyage, v.prix_unitaire_voyage
    from  prix_main_d_oeuvres join public.voyage v on v.id = prix_main_d_oeuvres.voyage_id

select * , (prix_unitaire_voyage-((sommetauxjournalier*joursvoyage)+prixactivite)) from v_depenses_voyage