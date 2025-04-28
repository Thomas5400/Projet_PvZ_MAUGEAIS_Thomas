package com.epf.Persistance;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ZombieRowMapper implements RowMapper<Zombie> { // convertit une ligne de la base de données en un objet Zombie

    @Override
    public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Zombie(
                rs.getInt("id_zombie"),
                rs.getInt("point_de_vie"),
                rs.getString("nom"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
        );
    }

}
