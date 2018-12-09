package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.BareRechercheFragment;

public class VilleActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener{

    BareRechercheFragment fragment;
    Drawable drawable;
    TextView textView;
    String nomVille;
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
        nomVille= bundle.getString("nomVille");
        textView.setText(nomVille);
        RelativeLayout relativeLayout=findViewById(R.id.container_image_view_ville);
       // Drawable drawable = context.getResources().getDrawable(listesVillesPopulairesTendances.get(position).getImageVille());
         switch(nomVille.toLowerCase()){
             case "rabat":
                 drawable=getResources().getDrawable(R.drawable.rabat);
                 break;
             case "meknes":
                 drawable=getResources().getDrawable(R.drawable.meknes);
                 break;
             case "agadir":
                 drawable=getResources().getDrawable(R.drawable.agadir);
                 break;
             case "azilal":
                 drawable=getResources().getDrawable(R.drawable.azilal);
                 break;
             case "casablanca" :
                 drawable=getResources().getDrawable(R.drawable.casablanca);
                 break;
             case "chefchawn":
                 drawable=getResources().getDrawable(R.drawable.chefchawn);
                 break;
             case "dakhla":
                 drawable=getResources().getDrawable(R.drawable.dakhla);
                 break;
             case "el_jadida":
                 drawable=getResources().getDrawable(R.drawable.el_jadida);
                 break;
             case "essaourira":
                 drawable=getResources().getDrawable(R.drawable.essaouira);
                 break;
             case "fes":
                 drawable=getResources().getDrawable(R.drawable.fes);
                 break;
             case "ifran":
                 drawable=getResources().getDrawable(R.drawable.ifran);
                 break;
             case "marakech":
                 drawable=getResources().getDrawable(R.drawable.marrakech);
                 break;

             case "ouarzazate":
                 getResources().getDrawable(R.drawable.ouarzazate);
                 break;
             case "saidia":
                 getResources().getDrawable(R.drawable.saidia);
                 break;
             case "tanger":
                 getResources().getDrawable(R.drawable.tanger);
                 break;
             case "tetouan":
                 getResources().getDrawable(R.drawable.tetouan);
                 break;
         }
        relativeLayout.setBackground(drawable);
    }

    @Override
    public void onClick(String mode) {

        Toast.makeText(this,mode,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,PageRechercheActivity.class);
        intent.putExtra("typePageRecherche",mode);
        intent.putExtra("nomVille",nomVille.toLowerCase());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragment.setTextBarreRecherche(" Que recherches-tu sur "+ nomVille +" ?");
    }
}
