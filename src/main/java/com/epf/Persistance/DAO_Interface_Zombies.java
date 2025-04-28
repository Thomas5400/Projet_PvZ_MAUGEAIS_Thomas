package com.epf.Persistance;

import java.util.List;

public interface DAO_Interface_Zombies { //Similaire à map, on donne les méthodes que doivent créer les classes implémentant cette interface
    void addZombie(Zombie zombie);

    Zombie getZombieById(int id);

    List<Zombie> getAllZombies();

    void updateZombie(Zombie zombie);

    void deleteZombie(int id);

    List<Zombie> getZombiesByMapId(int mapId);
}
