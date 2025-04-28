package com.epf.Service;

import com.epf.Persistance.Zombie;
import java.util.List;

public interface Serv_Interface_Zombies { // liste des méthodes à faire dans nos classes qui implémenteront cette interface (format du contrat)

    Zombie getZombieById(int id);

    List<Zombie> getAllZombies();

    void addZombie(Zombie zombie);

    void updateZombie(Zombie zombie);

    void deleteZombie(int id);
}
