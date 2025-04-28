
import com.epf.Persistance.Zombie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testZombie {

    @Test
    void testConstructeurZombie() {
        Zombie zombie = new Zombie(1,50,"zombie_test",5.5,5.5,2,"cheminimage",2);

        assertEquals(1, zombie.getId_zombie(), "L'ID du zombie devrait etre 1");
        assertEquals(50, zombie.getPoint_de_vie(), "Les PV doivent être à 50");
        assertEquals("zombie_test", zombie.getNom(), "Le nom du zombie devrait être 'zombie_test'");
        assertEquals(5.5, zombie.getVitesse_de_deplacement(), "La vitesse de déplacement devrait être de 5.5");
        assertEquals(5.5, zombie.getAttaque_par_seconde(), "l'attaque par seconde devrait être de 5.5");
        assertEquals(2, zombie.getDegat_attaque(), "Les degats de ce zombie devrait etre de 2");
        assertEquals("cheminimage", zombie.getChemin_image(), "Le chemin de l'image de ce Zombie devrait être 'cheminimage'");
        assertEquals(2, zombie.getId_map(), "l'Id de la map attribuée à ce zombie devrait être 2");
    }
}
