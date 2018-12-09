package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.BareRechercheFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PageRechercheActivity;
import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.VilleActivity;

public class MainActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener {

    BareRechercheFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (BareRechercheFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment.setMode("Page Principale");
    }


    @Override
    public void onClick(String mode)
    {

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
