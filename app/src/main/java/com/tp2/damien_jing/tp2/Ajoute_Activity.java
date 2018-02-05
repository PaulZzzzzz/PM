package com.tp2.damien_jing.tp2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tp2.damien_jing.tp2.model.Categorie;

import java.util.ArrayList;
import java.util.Arrays;

public class Ajoute_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoute_);
        final Spinner spinner = (Spinner)findViewById(R.id.categorie);
        Categorie []t = Categorie.values();
        ArrayList<Categorie> l = new ArrayList<Categorie>(Arrays.asList(t));
        ArrayAdapter<Categorie> adapter =
                new ArrayAdapter<Categorie>(getApplicationContext(),android.R.layout.simple_spinner_item,l);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        Button fab = (Button) findViewById(R.id.ajouter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nom = (EditText)findViewById(R.id.nom_ajout);
                EditText duree = (EditText)findViewById(R.id.duree_ajout);
                EditText description = (EditText)findViewById(R.id.description_ajout);
                String nom_ajout = nom.getText().toString();
                String duree_ajout = duree.getText().toString();
                String description_ajout = description.getText().toString();
                String categorie = spinner.getSelectedItem().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra(MainActivity.NOM_ACTIVITE,nom_ajout);
                returnIntent.putExtra(MainActivity.DUREE_ACTIVIE,duree_ajout);
                returnIntent.putExtra(MainActivity.CATEGORIE_ACTIVITE,categorie);
                returnIntent.putExtra(MainActivity.DESC_ACTIVITE,description_ajout);
                setResult(MainActivity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
