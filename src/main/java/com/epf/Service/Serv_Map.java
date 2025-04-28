package com.epf.Service;

import com.epf.Persistance.DAO_Map_Interface;
import com.epf.Persistance.Map;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Serv_Map implements Serv_Interface_Map { // On implemente l'interface Serv_Interface_Map qui définit les classes à implementer
// donc on utilisera les classe de DAO_Map_Interface pour implementer les méthodes de l'interface Serv_Interface_Map

    private final DAO_Map_Interface daoMap;

    public Serv_Map(DAO_Map_Interface daoMap) {
        this.daoMap = daoMap;
    }

    @Override
    public Map getMapById(int id) {
        return daoMap.getMapById(id); // On fait ici appel aux méthodes de notre classe DAO, vu qu'elles implémentent les classes de l'interface DAO_Map_Interface
    }

    @Override
    public List<Map> getAllMaps() {
        return daoMap.getAllMaps();
    }

    @Override
    public void addMap(Map map) {
        daoMap.addMap(map);
    }

    @Override
    public void updateMap(Map map) {
        daoMap.updateMap(map);
    }

    @Override
    public void deleteMap(int id) {
        daoMap.deleteMap(id);
    }
}
