import com.epf.Persistance.Plante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testPlante {

    @Test
    void testConstructeurPlante() {
        Plante plante = new Plante(1, "PlanteTest", 10, 1, 20, 0.5, 0.0, "chemin", "effet_base");

        assertEquals(1, plante.getId_plante(), "L'ID de la plante devrait être 1");
        assertEquals("PlanteTest", plante.getNom(), "Le nom de la plante devrait être 'PlanteTest'");
        assertEquals(10, plante.getDegat_attaque(), "Les dégâts d'attaque devraient être 10");
        assertEquals(1, plante.getCout(), "Le coût devrait être 1");
        assertEquals(20, plante.getPoint_de_vie(), "Les points de vie devraient être 20");
        assertEquals(0.5, plante.getAttaque_par_seconde(), "L'attaque par seconde devrait être 0.5");
        assertEquals(0.0, plante.getSoleil_par_seconde(), "Le soleil par seconde devrait être 0.0");
        assertEquals("chemin", plante.getChemin_image(), "Le chemin de l'image devrait être 'chemin'");
        assertEquals("effet_base", plante.getEffet(), "L'effet devrait être 'effet_base'");
    }

}

