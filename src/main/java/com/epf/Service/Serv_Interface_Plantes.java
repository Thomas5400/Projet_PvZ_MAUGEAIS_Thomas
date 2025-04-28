package com.epf.Service;

import com.epf.Persistance.Plante;
import java.util.List;

public interface Serv_Interface_Plantes { // liste des méthodes à faire dans nos classes qui implémenteront cette interface (format du contrat)

    Plante getPlanteById(int id);

    List<Plante> getAllPlantes();

    void addPlante(Plante plante);
    void updatePlante(Plante plante);
    void deletePlante(int id);
}
