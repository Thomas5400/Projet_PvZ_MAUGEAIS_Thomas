package com.epf.Persistance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DAO_Map implements DAO_Map_Interface {


    private JdbcTemplate jdbcTemplate;
    private final MapRowMapper mapRowMapper;

    // Constructeur pour initialiser JdbcTemplate
    public DAO_Map(JdbcTemplate jdbcTemplate, MapRowMapper mapRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapRowMapper = mapRowMapper;

    }

    // Implémentation de la méthode pour obtenir une carte par son ID
    @Override
    public Map getMapById(int id) {
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapRowMapper);
    }

    // Implémentation pour obtenir toutes les cartes
    @Override
    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    // Implémentation pour ajouter (ou créer) une map
    @Override
    public void addMap(Map map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    // Implémentation pour mettre à jour une carte
    @Override
    public void updateMap(Map map) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image(), map.getId_map());
    }

    // Implémentation pour supprimer une carte
    @Override
    public void deleteMap(int id) {
        // D'abord supprimer les zombies associés
        String deleteZombiesSQL = "DELETE FROM Zombie WHERE id_map = ?";
        jdbcTemplate.update(deleteZombiesSQL, id);
        
        // Ensuite supprimer la map
        String deleteMapSQL = "DELETE FROM Map WHERE id_map = ?";
        jdbcTemplate.update(deleteMapSQL, id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(int idMap) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{idMap}, new ZombieRowMapper());
    }

}
