import com.epf.Persistance.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testMap {
    @Test
    void testConstructeurMap() {
        Map map = new Map(1, "cheminImageMap", 4, 4);

        assertEquals(1, map.getId_map());
        assertEquals("cheminImageMap", map.getChemin_image());
        assertEquals(4, map.getLigne());
        assertEquals(4, map.getColonne());

    }
}
