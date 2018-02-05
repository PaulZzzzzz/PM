package com.tp2.damien_jing.tp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.tp2.damien_jing.tp2.model.Categorie;

public class Detail_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        Intent intent = this.getIntent();
        TextView nom =(TextView)findViewById(R.id.nom);
        TextView duree = (TextView)findViewById(R.id.duree);
        ImageView image = (ImageView)findViewById(R.id.image);
        TextView des = (TextView)findViewById(R.id.descriprion);
        String message_nom = intent.getStringExtra(MainActivity.NOM_ACTIVITE);
        nom.setText(message_nom);
        String message_duree = intent.getStringExtra(MainActivity.DUREE_ACTIVIE);
        duree.setText(message_duree);
        String message_des = intent.getStringExtra(MainActivity.DESC_ACTIVITE);
        des.setText(message_des);
        String message_cat = intent.getStringExtra(MainActivity.CATEGORIE_ACTIVITE);
        Categorie c = Categorie.findCategorie(message_cat);
        image.setImageResource(c.getResId());

    }
}
