package com.tp2.damien_jing.tp2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.tp2.damien_jing.tp2.model.Categorie;
import com.tp2.damien_jing.tp2.model.Tache;
import com.tp2.damien_jing.tp2.model.TacheAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{
    public final static String NOM_ACTIVITE = "NOM_ACTIVITE";
    public final static String DUREE_ACTIVIE = "DUREE_ACTIVITE";
    public final static String DESC_ACTIVITE = "DESC_ACTIVITE";
    public final static String CATEGORIE_ACTIVITE = "CATEGORIE_ACTIVITE";
    public final static int CODE_AJOUT_ACTIVITE = 0;
    public final static int RESULT_OK = 0;
    public final static int RESULT_KO = 2;
    private List<Tache> mesDonnees;
    protected TacheAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mesDonnees = new ArrayList<Tache>();
        adapter = new TacheAdapter(this,this.mesDonnees);
        ListView l =(ListView)findViewById(R.id.maListe);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
        l.setOnItemLongClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Ajoute_Activity.class);
                startActivityForResult(intent,CODE_AJOUT_ACTIVITE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CODE_AJOUT_ACTIVITE){
            if(resultCode == MainActivity.RESULT_OK){
                String nom = data.getStringExtra(NOM_ACTIVITE);
                String duree = data.getStringExtra(DUREE_ACTIVIE);
                String categorie = data.getStringExtra(CATEGORIE_ACTIVITE);
                String description = data.getStringExtra(DESC_ACTIVITE);
                Tache t = new Tache(nom,categorie,duree,description);
                mesDonnees.add(t);
                adapter.notifyDataSetChanged();
            }

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,Detail_Activity.class);
        intent.putExtra(NOM_ACTIVITE,mesDonnees.get(i).getNom());
        intent.putExtra(DUREE_ACTIVIE,mesDonnees.get(i).getDuree());
        intent.putExtra(DESC_ACTIVITE,mesDonnees.get(i).getDescription());
        intent.putExtra(CATEGORIE_ACTIVITE,mesDonnees.get(i).getCategorie().toString());
        startActivity(intent);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        final int index = i;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.confirm)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mesDonnees.remove(index);
                        adapter.notifyDataSetChanged();


                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();


        // Create the AlertDialog object and return it
        return true;
    }
}
