package com.epf.Persistance;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapRowMapper implements RowMapper<Map> { // convertit une ligne de la base de données en un objet Map
    @Override
    public Map mapRow(ResultSet rs, int rowNum) throws SQLException { 
        return new Map(
                rs.getInt("id_map"),
                rs.getString("chemin_image"),
                rs.getInt("ligne"),
                rs.getInt("colonne")
        );
    }
}
