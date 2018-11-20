package com.android.ensak.tourismeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener{

    BareRechercheFragment fragment;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment= (BareRechercheFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment.setMode("Page Principale");
     //   button = (Button) findViewById(R.id.button_page_principale);
    }


    @Override
    public void onClick(String mode)
    {
        Toast.makeText(this,mode,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,PageRechercheActivity.class);
        intent.putExtra("typePageRecherche",mode);
        startActivity(intent);
    }

    public void button_ville_page_principal(View view) {
        String nameVille= (String) ((Button) view).getText();
        Intent intent = new Intent(this,VilleActivity.class);
        intent.putExtra("nomVille",nameVille);
        startActivity(intent);
    }
}
