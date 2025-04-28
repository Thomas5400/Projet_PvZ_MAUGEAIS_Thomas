package com.epf.Persistance;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlanteRowMapper implements RowMapper<Plante> {  // convertit une ligne de la base de données en un objet Plante
    @Override
    public Plante mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Plante(
                rs.getInt("id_plante"),
                rs.getString("nom"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getDouble("soleil_par_seconde"),
                rs.getString("chemin_image"),
                rs.getString("effet")
        );
    }
}
