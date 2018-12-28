package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Pharmacie;

public class PharmacieActivity extends AppCompatActivity {
    TextView titleElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacie);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        String nomPharmacie=bundle.getString("nomPharmacie");
        Pharmacie pharmacie=getPharmacie(nomPharmacie);
        //Pharmacie pharmacie= (Pharmacie) bundle.getSerializable("pharmacie");

        titleElement=findViewById(R.id.activity_pharmacie_name);
        titleElement.setText(pharmacie.getName());
    }

    private Pharmacie getPharmacie(String nomPharmacie) {
        Pharmacie pharmacie=new Pharmacie();
        for (Pharmacie pharmacie2 : GlobalClass.listVillePharmacies
                ) {
            if(pharmacie2.getName().equals(nomPharmacie)){
                pharmacie=pharmacie2;
                break;
            }
        }
        return pharmacie;
    }
}
