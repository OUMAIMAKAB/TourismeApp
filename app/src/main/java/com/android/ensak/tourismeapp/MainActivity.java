package com.android.ensak.tourismeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BareRechercheFragment.OnFragmentInteractionListener{
String page="ville";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    PageRechercheFragment pageRechercheFragment= (PageRechercheFragment) fragment.findFragmentById(R.id.fragmentContainer);
    }


    @Override
    public void onClick(String mode)
    {
        Toast.makeText(this,mode,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,PageRechercheActivity.class);
        intent.putExtra("cle1",mode);
        startActivity(intent);
}

}
