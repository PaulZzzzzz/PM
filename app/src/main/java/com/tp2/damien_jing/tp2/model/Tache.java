package com.tp2.damien_jing.tp2.model;

/**
 * Created by Admin on 2018/1/29.
 */

public class Tache {
    private String nom;
    private int duree;
    private String description;
    public Categorie categorie;

    public Tache(String n,String cat,String dur,String des){
        this.nom = n;
        this.description = des;
        Categorie c = Categorie.findCategorie(cat);
        this.duree = Integer.valueOf(dur);
        this.categorie = c;

        //this.categorie = cat;
    }

    public Tache(String n,Categorie cat,int dur,String des){
        this.nom = n;
        this.description = des;
        this.duree = dur;
        this.categorie = cat;
    }

    public Tache(String n){
        this.nom = n;
    }

    public String getNom(){
        return this.nom;
    }

    public String getDuree(){
        return String.valueOf(this.duree);
    }

    public Categorie getCategorie(){
        return this.categorie;
    }

    public String getDescription(){
        return this.description;
    }


}
