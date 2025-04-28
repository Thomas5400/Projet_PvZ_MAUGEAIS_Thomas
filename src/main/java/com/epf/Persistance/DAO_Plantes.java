package com.epf.Persistance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DAO_Plantes implements DAO_Interface_Plantes{

    private JdbcTemplate jdbcTemplate;

    // Constructeur pour initialiser JdbcTemplate
    public DAO_Plantes(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implémentation de la méthode pour obtenir une plante par son ID
    @Override
    public Plante getPlanteById(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PlanteRowMapper());
    }

    // Implémentation pour obtenir toutes les plantes
    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    // Implementation pour ajouter une plante
    @Override
    public void addPlante(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image());
    }

    // Implémentation pour mettre à jour une plante
    @Override
    public void updatePlante(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image(), plante.getId_plante());
    }

    // Implémentation pour supprimer une plante
    @Override
    public void deletePlante(int id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }

}
