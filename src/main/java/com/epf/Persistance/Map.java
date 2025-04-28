package com.epf.Persistance;

public class Map {

    private int id_map;
    private String chemin_image;
    private int ligne;
    private int colonne;

    // Constructeur avec les attributs de la classe map

    public Map(int id_map, String chemin_image, int ligne, int colonne) {
        this.id_map = id_map;
        this.chemin_image = chemin_image;
        this.ligne = ligne;
        this.colonne = colonne;
    }


    // Getters et setters

    public int getId_map() {
        return id_map;
    }

    public int getLigne() {
        return ligne;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public int getColonne() {
        return colonne;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

// Fin des getters et setters

    // Meilleur affichage d'un objet Map

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id_map +
                ", chemin image ='" + chemin_image + '\'' +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                '}';
    }
}
