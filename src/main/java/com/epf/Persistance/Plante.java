package com.epf.Persistance;

public class Plante {

    private int id_plante;
    private String nom;
    private int degat_attaque;
    private int cout;
    private int point_de_vie;
    private double attaque_par_seconde;
    private double soleil_par_seconde;
    private String chemin_image;
    private String effet;


    // Constructuer avec tous les attributs de plante

    public Plante(int id_plante, String nom, int degat_attaque, int cout, int point_de_vie, double attaque_par_seconde, double soleil_par_seconde, String chemin_image, String effet) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.soleil_par_seconde = soleil_par_seconde;
        this.chemin_image = chemin_image;
        this.effet = effet;
    }


    // Getters et setters de plante

    public int getId_plante() {
        return id_plante;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public void setAttaque_par_seconde(int attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public double getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public void setSoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public String getEffet() {
        return effet;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }


    // Fin des getters et setters

    // Meilleur affichage
    @Override
    public String toString() {
        return "Plante{" +
                "idPlante=" + id_plante +
                ", nom='" + nom + '\'' +
                ", pointDeVie=" + point_de_vie +
                ", attaqueParSeconde=" + attaque_par_seconde +
                ", degatAttaque=" + degat_attaque +
                ", cout=" + cout +
                ", soleilParSeconde=" + soleil_par_seconde +
                ", effet=" + effet +  
                ", cheminImage='" + chemin_image + '\'' +
                '}';
    }
}
