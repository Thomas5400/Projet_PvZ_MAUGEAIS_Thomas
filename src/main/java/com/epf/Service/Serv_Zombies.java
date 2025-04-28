package com.epf.Service;

import com.epf.Persistance.Zombie;
import com.epf.Persistance.DAO_Interface_Zombies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serv_Zombies implements Serv_Interface_Zombies {// On implemente l'interface Serv_Interface_Zombies

    private final DAO_Interface_Zombies daoZombies;

    @Autowired
    public Serv_Zombies(DAO_Interface_Zombies daoZombies) { 
        this.daoZombies = daoZombies;
    }

    @Override
    public Zombie getZombieById(int id) { // On réutilise les méthodes de DAO_Interface_Zombies pour toutes les méthodes que l'on doit implémenter 
        return daoZombies.getZombieById(id);
    }

    @Override
    public List<Zombie> getAllZombies() {
        return daoZombies.getAllZombies();
    }

    @Override
    public void addZombie(Zombie zombie) {
        daoZombies.addZombie(zombie);
    }

    @Override
    public void updateZombie(Zombie zombie) {
        daoZombies.updateZombie(zombie);
    }

    @Override
    public void deleteZombie(int id) {
        daoZombies.deleteZombie(id);
    }
}
