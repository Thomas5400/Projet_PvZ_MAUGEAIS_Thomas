import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.epf.Persistance.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

public class testDAOZombies {

    private DAO_Zombies zombieDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.zombieDAO = new DAO_Zombies(jdbcTemplate);
    }

    @Test
    public void testGetZombieById() {
        Zombie expectedZombie = new Zombie(1, 100, "Zombie1", 10.0, 5.0, 5, "chemin_image", 1);

        when(jdbcTemplate.queryForObject(
                eq("SELECT * FROM Zombie WHERE id_zombie = ?"),
                any(Object[].class),
                any(ZombieRowMapper.class)
        )).thenReturn(expectedZombie);

        Zombie result = zombieDAO.getZombieById(1);

        assertNotNull(result);
        assertEquals(expectedZombie.getId_zombie(), result.getId_zombie());
    }

    @Test
    public void testGetAllZombies() {
        List<Zombie> expectedZombies = Arrays.asList(
                new Zombie(1, 100, "Zombie1", 10.0, 5.0, 5, "chemin_image", 1),
                new Zombie(2, 120, "Zombie2", 12.0, 6.0, 6, "chemin_image", 1)
        );

        when(jdbcTemplate.query(eq("SELECT * FROM Zombie"), any(ZombieRowMapper.class)))
                .thenReturn(expectedZombies);

        List<Zombie> result = zombieDAO.getAllZombies();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddZombie() {
        Zombie newZombie = new Zombie(0, 90, "ZombieNew", 9.0, 4.0, 4, "image_path", 1);

        when(jdbcTemplate.update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyString(), anyInt()))
                .thenReturn(1);

        zombieDAO.addZombie(newZombie);

        verify(jdbcTemplate, times(1)).update(anyString(),
                eq("ZombieNew"), eq(90), eq(4.0), eq(4), eq(9.0), eq("image_path"), eq(1));
    }

    @Test
    public void testUpdateZombie() {
        Zombie zombie = new Zombie(1, 110, "ZombieUpdated", 11.0, 5.5, 6, "new_image", 2);

        when(jdbcTemplate.update(anyString(), anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyString(), anyInt(), anyInt()))
                .thenReturn(1);

        zombieDAO.updateZombie(zombie);

        verify(jdbcTemplate, times(1)).update(anyString(),
                eq("ZombieUpdated"), eq(110), eq(5.5), eq(6), eq(11.0), eq("new_image"), eq(2), eq(1));
    }

    @Test
    public void testDeleteZombie() {
        when(jdbcTemplate.update(eq("DELETE FROM Zombie WHERE id_zombie = ?"), anyInt()))
                .thenReturn(1);

        zombieDAO.deleteZombie(1);

        verify(jdbcTemplate, times(1)).update(eq("DELETE FROM Zombie WHERE id_zombie = ?"), eq(1));
    }

    @Test
    public void testGetZombiesByMapId() {
        List<Zombie> expectedZombies = Arrays.asList(
                new Zombie(1, 100, "Zombie1", 10.0, 5.0, 5, "chemin_image", 1),
                new Zombie(2, 120, "Zombie2", 12.0, 6.0, 6, "chemin_image", 1)
        );

        when(jdbcTemplate.query(eq("SELECT * FROM Zombie WHERE id_map = ?"),
                any(Object[].class), any(ZombieRowMapper.class)))
                .thenReturn(expectedZombies);

        List<Zombie> result = zombieDAO.getZombiesByMapId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
