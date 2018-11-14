package com.android.ensak.tourismeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PageRechercheActivity extends AppCompatActivity {
    String[] tableNomVille;
    ArrayAdapter<String> adapter;
    ListView listeViewRechercheVille;

    String[] tabVille;
    String chaineDefault = "rabat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_recherche);
        tableNomVille= getResources().getStringArray(R.array.villes);
        listeViewRechercheVille=(ListView) findViewById(R.id.listeViewRechercheVille);
        EditText editText=findViewById(R.id.barreRecherchePageRecherche);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                remplirListe(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public ArrayList<String> chercherVille(String s){
        ArrayList<String> listVales=new ArrayList<String>();
        for (String v: tableNomVille
             ) {
           if( v.startsWith(s) ){
               listVales.add(v);
           }
        }
        return listVales;
    }


    public void remplirListe(String s){
        if(!s.equals("")) {
            ArrayList<String> affiche = chercherVille(s);
            tabVille = affiche.toArray(new String[affiche.size()]);

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tabVille);
            listeViewRechercheVille.setAdapter(adapter);
        }else {
            listeViewRechercheVille.setAdapter(null);
        }
    }
}
