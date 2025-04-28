package com.epf.Service;

import com.epf.Persistance.Map;
import java.util.List;

public interface Serv_Interface_Map { // liste des méthodes à faire dans nos classes qui implémenteront cette interface (format du contrat)

    Map getMapById(int id);

    List<Map> getAllMaps();

    void addMap(Map map);
    void updateMap(Map map);
    void deleteMap(int id);
}
