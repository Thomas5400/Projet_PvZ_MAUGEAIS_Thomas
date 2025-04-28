import com.epf.Persistance.DAO_Interface_Plantes;
import com.epf.Persistance.Plante;
import com.epf.Service.Serv_Plantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class test_Serv_Plantes {

    @Mock
    private DAO_Interface_Plantes daoPlantes;

    private Serv_Plantes servPlantes;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        servPlantes = new Serv_Plantes(daoPlantes);
    }

    @Test
    void getPlanteByIdTest() {
        Plante plante = new Plante(1, "Tournesol", 0, 50, 100, 0, 25.0, "img/tournesol.png", "produit du soleil");
        when(daoPlantes.getPlanteById(1)).thenReturn(plante);

        Plante result = servPlantes.getPlanteById(1);
        assertEquals("Tournesol", result.getNom());
        verify(daoPlantes).getPlanteById(1);
    }

    @Test
    void getAllPlantesTest() {
        List<Plante> plantes = Arrays.asList(
                new Plante(1, "Tournesol", 0, 50, 100, 0, 25.0, "img/tournesol.png", "produit du soleil"),
                new Plante(2, "Pisto-pois", 20, 100, 100, 1.5, 0, "img/pistopo.png", "tire des pois")
        );
        when(daoPlantes.getAllPlantes()).thenReturn(plantes);

        List<Plante> result = servPlantes.getAllPlantes();
        assertEquals(2, result.size());
        verify(daoPlantes).getAllPlantes();
    }

    @Test
    void addPlanteTest() {
        Plante plante = new Plante(3, "Noix", 0, 50, 300, 0, 0, "img/noix.png", "bouclier");
        servPlantes.addPlante(plante);
        verify(daoPlantes).addPlante(plante);
    }

    @Test
    void updatePlanteTest() {
        Plante plante = new Plante(2, "Pisto-pois", 30, 100, 100, 1.5, 0, "img/pistopo.png", "tire des pois");
        servPlantes.updatePlante(plante);
        verify(daoPlantes).updatePlante(plante);
    }

    @Test
    void deletePlanteTest() {
        servPlantes.deletePlante(1);
        verify(daoPlantes).deletePlante(1);
    }
}
