package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Hopital;
import com.nostra13.universalimageloader.core.ImageLoader;

public class HopitalActivity extends AppCompatActivity {

    TextView titleElement;
    TextView descriptionElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hopital);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Hopital hopital= (Hopital) bundle.getSerializable("hopital");

        titleElement=findViewById(R.id.activity_hopital_name);
        titleElement.setText(hopital.getName());
    }
}
