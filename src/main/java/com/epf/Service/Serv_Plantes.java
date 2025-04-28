package com.epf.Service;

import com.epf.Persistance.Plante;
import com.epf.Persistance.DAO_Interface_Plantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serv_Plantes implements Serv_Interface_Plantes { // On implemente l'interface Serv_Interface_Plantes

    private final DAO_Interface_Plantes daoPlantes;

    @Autowired
    public Serv_Plantes(DAO_Interface_Plantes daoPlantes) {
        this.daoPlantes = daoPlantes;
    }

    @Override                                    /// On réutilise les méthodes de Dao _Interface_Plantes pour toutes les méthodes que l'on doit implémenter
    public Plante getPlanteById(int id) {
        return daoPlantes.getPlanteById(id);
    }

    @Override
    public List<Plante> getAllPlantes() {
        return daoPlantes.getAllPlantes();
    }

    @Override
    public void addPlante(Plante plante) {
        daoPlantes.addPlante(plante);
    }

    @Override
    public void updatePlante(Plante plante) {
        daoPlantes.updatePlante(plante);
    }

    @Override
    public void deletePlante(int id) {
        daoPlantes.deletePlante(id);
    }
}
