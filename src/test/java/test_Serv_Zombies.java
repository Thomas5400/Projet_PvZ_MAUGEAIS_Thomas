import com.epf.Persistance.DAO_Interface_Zombies;
import com.epf.Persistance.Zombie;
import com.epf.Service.Serv_Zombies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class test_Serv_Zombies {

    @Mock
    private DAO_Interface_Zombies daoZombies;

    private Serv_Zombies servZombies;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        servZombies = new Serv_Zombies(daoZombies);
    }

    @Test
    void getZombieByIdTest() {
        Zombie zombie = new Zombie(1, 100, "Zombie rapide", 2.0, 1.5, 10, "img/zombie.png", 1);
        when(daoZombies.getZombieById(1)).thenReturn(zombie);

        Zombie result = servZombies.getZombieById(1);
        assertEquals("Zombie rapide", result.getNom());
        verify(daoZombies).getZombieById(1);
    }

    @Test
    void getAllZombiesTest() {
        List<Zombie> zombies = Arrays.asList(
                new Zombie(1, 100, "Zombie rapide", 2.0, 1.5, 10, "img/zombie.png", 1),
                new Zombie(2, 200, "Zombie lent", 1.0, 0.8, 20, "img/zombie_lent.png", 1)
        );
        when(daoZombies.getAllZombies()).thenReturn(zombies);

        List<Zombie> result = servZombies.getAllZombies();
        assertEquals(2, result.size());
        verify(daoZombies).getAllZombies();
    }

    @Test
    void addZombieTest() {
        Zombie zombie = new Zombie(3, 150, "Zombie explosif", 1.5, 2.0, 30, "img/zombie_explosif.png", 1);
        servZombies.addZombie(zombie);
        verify(daoZombies).addZombie(zombie);
    }

    @Test
    void updateZombieTest() {
        Zombie zombie = new Zombie(2, 250, "Zombie fort", 2.5, 2.0, 50, "img/zombie_fort.png", 1);
        servZombies.updateZombie(zombie);
        verify(daoZombies).updateZombie(zombie);
    }

    @Test
    void deleteZombieTest() {
        servZombies.deleteZombie(1);
        verify(daoZombies).deleteZombie(1);
    }
}
