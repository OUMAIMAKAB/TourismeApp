package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.ControllerRestVillesClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.Main2TestActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.BareRechercheFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.PageRechercheActivity;
import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity.VilleActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class MainActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener {

    BareRechercheFragment fragment;
    public static DisplayImageOptions defaultOptions;
    public static ImageLoaderConfiguration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = (BareRechercheFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        fragment.setMode("Page Principale");
       ControllerRestVillesClass controllerRestVillesClass=ControllerRestVillesClass.getInstanceControllerRestClass();
        controllerRestVillesClass.listVillesAsync();


         defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .build();

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
        int positionList=getIdVille(nameVille.toLowerCase());
        Intent intent = new Intent(this,VilleActivity.class);
       // intent.putExtra("nomVille",nameVille);
        intent.putExtra("positionList",positionList);
        startActivity(intent);
    }

    private int getIdVille(String s) {
        int idVille = 0;
        for (Ville ville:GlobalClass.listVilles) {
            if(ville.getName().equals(s)){
                break;
            }
            idVille++;
        }
        return idVille;
    }

}
