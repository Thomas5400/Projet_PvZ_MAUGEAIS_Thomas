package com.epf.Controleur;

public class DTO_Map {
    private int id_map;
    private String chemin_image;
    private int ligne;
    private int colonne;

    public DTO_Map() {}

    public DTO_Map(int id_map, String chemin_image, int ligne, int colonne) {
        this.id_map = id_map;
        this.chemin_image = chemin_image;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
}
