package project.projetmmebaovola.initializer;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
//        // Votre script SQL ici
//        String sql = "create or replace view tarifVoyage as\n" +
//                "    select voyage_activite.id_voyage,sum(a.tarif*voyage_activite.quantite) as prixActivite\n" +
//                "    from voyage_activite join public.activite a on a.id = voyage_activite.id_activite\n" +
//                "group by voyage_activite.id_voyage";
//
//        jdbcTemplate.execute(sql);
//
//        String sql2 = "create view recherche as\n" +
//                "select\n" +
//                "    voyage.id,\n" +
//                "    voyage.date_debutvoyage,\n" +
//                "    voyage.date_fin_voyage,\n" +
//                "    voyage.typedure,\n" +
//                "    bouquets.nom_bouquet,\n" +
//                "    a.nom_activite,\n" +
//                "        quantite\n" +
//                "--     *\n" +
//                "from voyage join bouquets on bouquets.id=voyage.bouquets_id\n" +
//                "    join public.voyage_activite va on voyage.id = va.id_voyage\n" +
//                "    join public.activite a on a.id = va.id_activite";
//
//        jdbcTemplate.execute(sql2);

    }
}