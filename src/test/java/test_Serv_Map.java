import com.epf.Persistance.DAO_Map_Interface;
import com.epf.Persistance.Map;
import com.epf.Service.Serv_Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class test_Serv_Map {

    @Mock
    private DAO_Map_Interface daoMap;

    private Serv_Map servMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        servMap = new Serv_Map(daoMap);
    }

    @Test
    void getMapById() {
        Map map = new Map(1, "image.png", 5, 9);
        when(daoMap.getMapById(1)).thenReturn(map);

        Map result = servMap.getMapById(1);

        assertEquals(map, result);
        verify(daoMap).getMapById(1);
    }

    @Test
    void getAllMaps() {
        List<Map> maps = Arrays.asList(
                new Map(1, "img1.png", 5, 5),
                new Map(2, "img2.png", 6, 6)
        );
        when(daoMap.getAllMaps()).thenReturn(maps);

        List<Map> result = servMap.getAllMaps();

        assertEquals(maps, result);
        verify(daoMap).getAllMaps();
    }

    @Test
    void addMap() {
        Map map = new Map(3, "map3.png", 4, 4);

        servMap.addMap(map);

        verify(daoMap).addMap(map);
    }

    @Test
    void updateMap() {
        Map map = new Map(1, "updated.png", 7, 7);

        servMap.updateMap(map);

        verify(daoMap).updateMap(map);
    }

    @Test
    void deleteMap() {
        servMap.deleteMap(1);

        verify(daoMap).deleteMap(1);
    }
}
