import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.epf.Persistance.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Arrays;
import java.util.List;
import org.mockito.MockitoAnnotations;

public class testDAOPlantes {

    private DAO_Plantes planteDAO;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.planteDAO = new DAO_Plantes(jdbcTemplate); // Passage de JdbcTemplate
    }

    @Test
    public void testGetPlanteById() {
        Plante expectedPlante = new Plante(1, "Tournesol", 0, 50, 100, 0.0, 25.0, "img_tournesol.png", "produit_soleil");

        when(jdbcTemplate.queryForObject(
                eq("SELECT * FROM Plante WHERE id_plante = ?"),
                any(Object[].class),
                any(PlanteRowMapper.class)
        )).thenReturn(expectedPlante);

        Plante result = planteDAO.getPlanteById(1);

        assertNotNull(result);
        assertEquals(expectedPlante.getId_plante(), result.getId_plante());
        assertEquals(expectedPlante.getNom(), result.getNom());
        assertEquals(expectedPlante.getEffet(), result.getEffet());
    }

    @Test
    public void testGetAllPlantes() {
        List<Plante> expectedPlantes = Arrays.asList(
                new Plante(1, "Tournesol", 0, 50, 100, 0.0, 25.0, "img_tournesol.png", "produit_soleil"),
                new Plante(2, "Pisto-pois", 20, 100, 100, 1.0, 0.0, "img_pistopois.png", "attaque")
        );

        when(jdbcTemplate.query(eq("SELECT * FROM Plante"), any(PlanteRowMapper.class)))
                .thenReturn(expectedPlantes);

        List<Plante> result = planteDAO.getAllPlantes();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Tournesol", result.get(0).getNom());
        assertEquals("Pisto-pois", result.get(1).getNom());

        verify(jdbcTemplate, times(1)).query(eq("SELECT * FROM Plante"), any(PlanteRowMapper.class));
    }

    @Test
    void testAddPlante() {
        Plante plante = new Plante(0, "Mur", 0, 75, 300, 0.0, 0.0, "img_mur.png", "protection");

        when(jdbcTemplate.update(anyString(),
                anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyDouble(), anyString(), anyString()))
                .thenReturn(1);

        planteDAO.addPlante(plante);

        verify(jdbcTemplate, times(1)).update(anyString(),
                eq(plante.getNom()), eq(plante.getPoint_de_vie()), eq(plante.getAttaque_par_seconde()),
                eq(plante.getDegat_attaque()), eq(plante.getCout()), eq(plante.getSoleil_par_seconde()),
                eq(plante.getEffet()), eq(plante.getChemin_image()));
    }

    @Test
    void testUpdatePlante() {
        Plante plante = new Plante(3, "Pisto-gelé", 15, 125, 100, 1.0, 0.0, "img_gelé.png", "ralenti");

        when(jdbcTemplate.update(anyString(),
                anyString(), anyInt(), anyDouble(), anyInt(), anyDouble(), anyDouble(), anyString(), anyString(), anyInt()))
                .thenReturn(1);

        planteDAO.updatePlante(plante);

        verify(jdbcTemplate, times(1)).update(anyString(),
                eq(plante.getNom()), eq(plante.getPoint_de_vie()), eq(plante.getAttaque_par_seconde()),
                eq(plante.getDegat_attaque()), eq(plante.getCout()), eq(plante.getSoleil_par_seconde()),
                eq(plante.getEffet()), eq(plante.getChemin_image()), eq(plante.getId_plante()));
    }

    @Test
    void testDeletePlante() {
        when(jdbcTemplate.update(eq("DELETE FROM Plante WHERE id_plante = ?"), anyInt()))
                .thenReturn(1);

        planteDAO.deletePlante(1);

        verify(jdbcTemplate, times(1)).update(eq("DELETE FROM Plante WHERE id_plante = ?"), eq(1));
    }
}
