package com.epf.Persistance;

import java.util.List;

public interface DAO_Interface_Plantes { //Similaire à map, on donne les méthodes que doivent créer les classes implémentant cette interface

    void addPlante(Plante plante);

    Plante getPlanteById(int id);

    List<Plante> getAllPlantes();

    void updatePlante(Plante plante);

    void deletePlante(int id);
}
