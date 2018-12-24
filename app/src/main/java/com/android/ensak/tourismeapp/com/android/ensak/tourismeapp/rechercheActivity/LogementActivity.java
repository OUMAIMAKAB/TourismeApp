package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.nostra13.universalimageloader.core.ImageLoader;

public class LogementActivity extends AppCompatActivity {
    TextView titleElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logement);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Logement logement= (Logement) bundle.getSerializable("logement");

        titleElement=findViewById(R.id.activity_logement_name);
        titleElement.setText(logement.getName());
    }
}
