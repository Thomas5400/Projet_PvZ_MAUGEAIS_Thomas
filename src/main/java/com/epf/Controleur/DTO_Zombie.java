package com.epf.Controleur;

public class DTO_Zombie {
    private int id_zombie;
    private int point_de_vie;
    private String nom;
    private double vitesse_de_deplacement;
    private double attaque_par_seconde;
    private int degat_attaque;
    private String chemin_image;
    private int id_map;

    public DTO_Zombie() {}

    public DTO_Zombie(int id_zombie, int point_de_vie, String nom, double vitesse_de_deplacement,
                      double attaque_par_seconde, int degat_attaque, String chemin_image, int id_map) {
        this.id_zombie = id_zombie;
        this.point_de_vie = point_de_vie;
        this.nom = nom;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.chemin_image = chemin_image;
        this.id_map = id_map;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getVitesse_de_deplacement() {
        return vitesse_de_deplacement;
    }

    public void setVitesse_de_deplacement(double vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public void setAttaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }
}

