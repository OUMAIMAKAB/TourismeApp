package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListElementsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.ListeElmentsFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.VillesPopulairesTendancesFragment;
import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.Element;

import java.util.ArrayList;
import java.util.List;

public class ContainerActivity extends AppCompatActivity implements VillesPopulairesTendancesFragment.FragmentVillesPopulairesTendancesInterface {
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        Intent intent=getIntent();
        Bundle bundle =intent.getExtras();
        String choix =bundle.getString("choix");
        if(choix.equals("villes_populaires")|| choix.equals("tendances")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            VillesPopulairesTendancesFragment villesPopulairesTendancesFragment = new VillesPopulairesTendancesFragment();
            villesPopulairesTendancesFragment.choixSuggestion(choix);
            villesPopulairesTendancesFragment.initContext(this);
            context = this;
            fragmentManager.beginTransaction().add(R.id.layout_container, villesPopulairesTendancesFragment).commit();
            Toast.makeText(this, "final", Toast.LENGTH_LONG).show();
        }
        if(choix.equals("Monuments")){
         FragmentManager fragmentManager=getSupportFragmentManager();
         ArrayList<Element> elements=new ArrayList<Element>();
         elements.add(new Element("Tour Hassan ",R.drawable.tour_hassan_rabat));
         elements.add(new Element("Mausolee Mohammed 5",R.drawable.mausolee_mohammed_5_rabat));
         elements.add(new Element("Kasbah des Oudayas",R.drawable.kasbah_des_oudayas_rabat));
         elements.add(new Element("Chellah",R.drawable.chellah_rabat));
         ListElementsAdapter listElementsAdapter=new ListElementsAdapter(this,R.layout.layout_list_elements_adapter,elements);
         ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listElementsAdapter);
         fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
         //listeElmentsFragment.changeContentListView(listElementsAdapter);
          // ListView listView=(ListView) listeElmentsFragment.getView().findViewById(R.id.liste_view_elements);
          //listView.setAdapter(listElementsAdapter);
         }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        TextView textView=relativeLayout.findViewById(R.id.textViewVillesPopulairesTendances);
        ImageView imageView=relativeLayout.findViewById(R.id.imageButtonGo);
      //  if(imageView.isClickable())
        //    Toast.makeText(getApplicationContext(),"you clicked the image view",Toast.LENGTH_LONG).show();
        //if(textView.isClickable())
          //  Toast.makeText(getApplicationContext(),"you clicked the text view",Toast.LENGTH_LONG).show();


    }
}
