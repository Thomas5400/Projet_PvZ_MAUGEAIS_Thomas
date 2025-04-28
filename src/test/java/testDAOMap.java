import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.epf.Persistance.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;


public class testDAOMap {
    private DAO_Map mapDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private MapRowMapper mapRowMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mapDAO = new DAO_Map(jdbcTemplate, mapRowMapper); // Passage des dépendances
    }


    @Test
    public void testGetMapById() {
        Map expectedMap = new Map(1, "chemin_vers_image", 5, 6);

        when(jdbcTemplate.queryForObject(
                eq("SELECT * FROM Map WHERE id_map = ?"),
                any(Object[].class),
                any(MapRowMapper.class)
        )).thenReturn(expectedMap);

        Map result = mapDAO.getMapById(1);

        assertNotNull(result);
        assertEquals(expectedMap.getId_map(), result.getId_map());
        assertEquals(expectedMap.getChemin_image(), result.getChemin_image());
        assertEquals(expectedMap.getLigne(), result.getLigne());
        assertEquals(expectedMap.getColonne(), result.getColonne());
    }

    @Test
    public void testGetZombiesByMap() {
        List<Zombie> expectedZombies = Arrays.asList(
                new Zombie(1, 100, "Zombie1", 10, 5, 5, "zombie_image", 1),
                new Zombie(2,150 , "Zombie2", 12, 6, 6, "zombie_image", 1)
        );

        when(jdbcTemplate.query(eq("SELECT * FROM Zombie WHERE id_map = ?"),
                any(Object[].class), any(ZombieRowMapper.class)))
                .thenReturn(expectedZombies);

        List<Zombie> result = mapDAO.getZombiesByMapId(1);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(expectedZombies.get(0).getId_zombie(), result.get(0).getId_zombie());
        assertEquals(expectedZombies.get(1).getId_zombie(), result.get(1).getId_zombie());
    }

    @Test
    void testCreate() { //méthode add pour moi
        Map map_create = new Map(1, "chemin_vers_image", 5, 6);
        when(jdbcTemplate.update(anyString(), anyInt(), anyInt(),anyString())).thenReturn(1);
        mapDAO.addMap(map_create);
        verify(jdbcTemplate, times(1)).update(anyString(), anyInt(), anyInt(),anyString());
    }

    @Test
    void testDelete() {

        when(jdbcTemplate.update(eq("DELETE FROM Map WHERE id_map = ?"), anyInt())).thenReturn(1);

        mapDAO.deleteMap(1);

        verify(jdbcTemplate, times(1)).update(eq("DELETE FROM Map WHERE id_map = ?"), eq(1));
    }

    @Test
    void testGetAllMaps() {
        List<Map> expectedMaps = Arrays.asList(
                new Map(1, "chemin_vers_image1", 5, 6),
                new Map(2, "chemin_vers_image2", 7, 8)
        );

        when(jdbcTemplate.query(eq("SELECT * FROM Map"), any(MapRowMapper.class)))
                .thenReturn(expectedMaps);

        List<Map> result = mapDAO.getAllMaps();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(expectedMaps.get(0).getId_map(), result.get(0).getId_map());
        assertEquals(expectedMaps.get(1).getId_map(), result.get(1).getId_map());

        verify(jdbcTemplate, times(1)).query(eq("SELECT * FROM Map"), any(MapRowMapper.class));
    }

}
