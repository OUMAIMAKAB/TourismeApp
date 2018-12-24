package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.mainActivity.MainActivity;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ArtisanatActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleElement;
    TextView descriptionElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artisanat);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        Artisanat artisanat= (Artisanat) bundle.getSerializable("artisanat");
        imageView=findViewById(R.id.activity_artisanat_image_view);
        titleElement=findViewById(R.id.activity_artisanat_name);
        ImageLoader.getInstance().init(MainActivity.config); // Do it on Application start
        // Then later, when you want to display image
        ImageLoader.getInstance().displayImage(GlobalClass.urlServerImages+"/Capture1.PNG",  imageView);
        titleElement.setText(artisanat.getNom());

    }
}
