package com.epf.Persistance;

import java.util.List;

public interface DAO_Map_Interface { // Les méthodes à faire pour les classes qui implémentent cette interface (contrat)

    void addMap(Map map);//create (ici add pour ajouter/créer une map)

    Map getMapById(int id);//get

    List<Map> getAllMaps();

    void updateMap(Map map);//update

    void deleteMap(int id);//delete

    List<Zombie> getZombiesByMapId(int mapId);//get zombie (par rapport à l'id de la map)

}
