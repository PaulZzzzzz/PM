package com.tp2.damien_jing.tp2.model;

import com.tp2.damien_jing.tp2.R;

/**
 * Created by Admin on 2018/1/29.
 */

public enum Categorie {
    Travail("Travail", R.drawable.travail),
    Sport("Sport",R.drawable.sport),
    Menage("Menage",R.drawable.menage),
    Lecture("Lecture",R.drawable.lecture),
    Enfants("Enfants",R.drawable.enfant),
    Courses("Courses",R.drawable.courses);

    private final String name;
    private final int ResId;

    private Categorie(String s,int i){
        name = s;
        ResId = i;
    }

    public static Categorie findCategorie(String s){
        for (Categorie c : Categorie.values()) {
            if (c.name.equalsIgnoreCase(s)) {
                return c;
            }
        }
        return null;
    }


    public String toString(){
        return this.name;
    }

    public int getResId(){
        return this.ResId;
    }


}
