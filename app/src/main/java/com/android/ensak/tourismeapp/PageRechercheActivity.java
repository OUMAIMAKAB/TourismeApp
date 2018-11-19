package com.android.ensak.tourismeapp;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class PageRechercheActivity extends AppCompatActivity implements ListeVillesFragment.OnFragmentInteractionListenerListeVilles{


    FragmentManager fragmentManager;
    ListeVillesFragment listeVillesFragment;
    listeSuggestionsFragment listeSuggestionsFragment;
    Context context;
    FragmentActivity myContext;
    String[] tableNomVille ;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_recherche);
        editText=findViewById(R.id.barreRecherchePageRecherche);
        myContext= this;
        listeVillesFragment =new ListeVillesFragment();
        listeSuggestionsFragment =new listeSuggestionsFragment();
        listeVillesFragment.initContext(myContext);
        fragmentManager=getSupportFragmentManager();
        tableNomVille = getResources().getStringArray(R.array.villes);
        getSupportFragmentManager().beginTransaction().add(R.id.content_fragment_page_recherche,listeVillesFragment,"fragment2")
                .add(R.id.content_fragment_page_recherche, listeSuggestionsFragment,"fragment1")
                 .show(listeSuggestionsFragment)
                 .hide(listeVillesFragment).commit();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                        if(s.toString().equals("")){
                            getSupportFragmentManager().beginTransaction().show(listeSuggestionsFragment).hide(listeVillesFragment).commit();
                        }else {
                            getSupportFragmentManager().beginTransaction().show(listeVillesFragment).hide(listeSuggestionsFragment).commit();
                            listeVillesFragment.remplirListe(s.toString(), tableNomVille);
                        }
                        /*
                     getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_page_recherche,listeVillesFragment).commit();
                     getSupportFragmentManager().beginTransaction().show(listeVillesFragment).commit();
                     listeVillesFragment.remplirListe(s.toString(),tableNomVille);
                     */
            }
            @Override
            public void afterTextChanged(Editable s){}
        });
                   }



    @Override
    public void onClick(String mode) {

    }
}
