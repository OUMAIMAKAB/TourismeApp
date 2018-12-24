package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
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
        Pharmacie pharmacie= (Pharmacie) bundle.getSerializable("pharmacie");

        titleElement=findViewById(R.id.activity_pharmacie_name);
        titleElement.setText(pharmacie.getName());
    }
}
