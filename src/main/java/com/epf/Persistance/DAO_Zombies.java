package com.epf.Persistance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DAO_Zombies implements DAO_Interface_Zombies {

    private JdbcTemplate jdbcTemplate;

    // Constructeur pour initialiser le JdbcTemplate
    public DAO_Zombies(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Implémentation de la méthode pour obtenir un zombie avec son ID
    @Override
    public Zombie getZombieById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ZombieRowMapper());
    }

    // Implémentation pour obtenir tous les zombies
    @Override
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    // Implémentation pour ajouter un zombie
    @Override
    public void addZombie(Zombie zombie) {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map());
    }

    // Implémentation pour mettre à jour un zombie
    @Override
    public void updateZombie(Zombie zombie) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map(), zombie.getId_zombie());
    }

    // Implémentation pour supprimer un zombie
    @Override
    public void deleteZombie(int id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    // Implémentation pour récuperer les zombies par ID de carte
    @Override
    public List<Zombie> getZombiesByMapId(int mapId) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new Object[]{mapId}, new ZombieRowMapper());
    }

}
