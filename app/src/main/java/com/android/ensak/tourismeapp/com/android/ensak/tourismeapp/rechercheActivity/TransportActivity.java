package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;

public class TransportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
    }

    public void goToModeOfTransport(View view) {
        String mode_transport=(String) ((TextView) view).getText();

    }
}
