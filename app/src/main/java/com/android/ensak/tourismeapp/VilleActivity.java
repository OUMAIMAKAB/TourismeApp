package com.android.ensak.tourismeapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class VilleActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener{

    BareRechercheFragment fragment;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ville);
        fragment= (BareRechercheFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);

        fragment.setMode("ville");

        textView = (TextView) findViewById(R.id.text_view_page_ville_images);
        Intent intent =getIntent();
        Bundle bundle;
        bundle = intent.getExtras();
        String nomVille= bundle.getString("nomVille");
        textView.setText(nomVille);
    }

    @Override
    public void onClick(String mode) {

        Toast.makeText(this,mode,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,PageRechercheActivity.class);
        intent.putExtra("typePageRecherche",mode);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragment.setTextBarreRecherche(" Que recherches-tu? ");
    }
}
