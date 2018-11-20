package com.android.ensak.tourismeapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class listeSuggestionsFragment extends Fragment {

    ListView listeView;
    ArrayList<String> nameSuggestions=new ArrayList<>() ;
    String typeSuggestion;
    TextView textView;
    public listeSuggestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_liste_suggestions,container,false);
    }


    public void typeSuggestion(String typeSuggestion) {
        this.typeSuggestion=typeSuggestion;
        if(typeSuggestion.equals("ville")){
            nameSuggestions.add("choix1");
            nameSuggestions.add("choix2");
            nameSuggestions.add("choix3");
            nameSuggestions.add("choix4");
            nameSuggestions.add("choix5");
        }else if(typeSuggestion.equals("Page Principale")){
            nameSuggestions.add("Villes Populaires");
            nameSuggestions.add("Tendances");
            nameSuggestions.add("b1");
            nameSuggestions.add("b2");
            nameSuggestions.add("b3");
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listeView = (ListView) getView().findViewById(R.id.listSuggestionsVille);

        textView = (TextView) getView().findViewById(R.id.add_more_suggestions);
        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,nameSuggestions);
        listeView.setAdapter(arrayAdapter);
        textView.setText("add more Suggestions");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.INVISIBLE);
                if(typeSuggestion.equals("ville")){
                    nameSuggestions.add("1 more suggestions Ville");
                    nameSuggestions.add("2 more suggestions Ville");
                }else if(typeSuggestion.equals("Page Principale")){
                    nameSuggestions.add("1 more suggestions Page Principale");
                    nameSuggestions.add("2 more suggestions Page Principale");
                }

                arrayAdapter.notifyDataSetChanged();
            }
        });

        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   LinearLayout linearLayou=(LinearLayout) view;
                TextView textVi=(TextView) view;
                Toast.makeText(getContext(), String.valueOf(position)+""+textVi.getText(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
