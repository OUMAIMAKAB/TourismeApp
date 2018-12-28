package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest.GlobalClass;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Restaurant;

public class RestaurantActivity extends AppCompatActivity {
    TextView titleElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Intent intent =getIntent();
        Bundle bundle=intent.getExtras();
        String nomRestaurant=bundle.getString("nomRestaurant");
        Restaurant restaurant=getRestaurant(nomRestaurant);
        //Restaurant restaurant= (Restaurant) bundle.getSerializable("restaurant");

        titleElement=findViewById(R.id.activity_restaurant_name);
        titleElement.setText(restaurant.getName());
    }

    private Restaurant getRestaurant(String nomRestaurant) {
        Restaurant restaurant=new Restaurant();
        for (Restaurant restaurant2 : GlobalClass.listVilleRestaurants
                ) {
            if(restaurant2.getName().equals(nomRestaurant)){
                restaurant=restaurant2;
                break;
            }
        }
        return restaurant;
    }

}
