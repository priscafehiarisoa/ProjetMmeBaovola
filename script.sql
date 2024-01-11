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

