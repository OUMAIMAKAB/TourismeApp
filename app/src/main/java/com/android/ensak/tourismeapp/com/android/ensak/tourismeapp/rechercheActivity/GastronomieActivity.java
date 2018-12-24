package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Gastronomie;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GastronomieActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleElement;
    TextView descriptionElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastronomie);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Gastronomie gastronomie= (Gastronomie) bundle.getSerializable("gastronomie");
        imageView=findViewById(R.id.activity_gastronomie_image_view);
        titleElement=findViewById(R.id.activity_gastronomie_name);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+"/Capture1.PNG",  imageView);
        titleElement.setText(gastronomie.getNom());
    }
}
