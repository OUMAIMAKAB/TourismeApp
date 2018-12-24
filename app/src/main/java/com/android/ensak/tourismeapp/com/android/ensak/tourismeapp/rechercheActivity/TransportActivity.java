package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Logement;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Transport;

public class TransportActivity extends AppCompatActivity {
    TextView titleElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Transport transport= (Transport) bundle.getSerializable("transport");

        titleElement=findViewById(R.id.activity_transport_name);
        titleElement.setText(transport.getType());
    }


}
