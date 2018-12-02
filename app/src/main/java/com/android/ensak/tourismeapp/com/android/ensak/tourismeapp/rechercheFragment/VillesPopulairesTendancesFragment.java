package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse.VillesPopulairesTendances;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.villesPopulairesTendancesAdapter;

import java.util.ArrayList;

public class VillesPopulairesTendancesFragment extends Fragment {

    ListView listeView;
    ArrayList<VillesPopulairesTendances> villesPopulairesTendances;
    ArrayList<VillesPopulairesTendances> patrimoineUnesco;
    Context context;
    private FragmentVillesPopulairesTendancesInterface mListener;
    String choix;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_liste_villes_populaires_tendances,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listeView= (ListView) getView().findViewById(R.id.liste_view_villes_populaires_tendances);
        listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onItemClick(parent,view,position,id);
            }
        });
        villesPopulairesTendances=new ArrayList<VillesPopulairesTendances>();
        patrimoineUnesco=new ArrayList<VillesPopulairesTendances>();

        if(choix.equals("villes_populaires")) {
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.agadir,"Agadir"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.azilal,"Azilal"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.casablanca,"Casablanca"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.chefchawn,"chefchawn"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.dakhla,"dakhla"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.el_jadida,"el_jadida"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.essaouira,"Essaourira"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.fes,"fes"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.ifran,"ifran"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.marrakech,"marrakech"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.meknes,"meknes"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.ouarzazate,"ouarzazate"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.rabat,"rabat"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.saidia,"saidia"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.tanger,"tanger"));
            villesPopulairesTendances.add(new VillesPopulairesTendances(R.drawable.tetouan,"tetouan"));
            villesPopulairesTendancesAdapter adapter = new villesPopulairesTendancesAdapter(getContext(), R.layout.layout_villes_populaires_tendances_adapter, villesPopulairesTendances);
            listeView.setAdapter(adapter);
        }
        if(choix.equals("tendances")){
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.el_jadida2, "El_JADIDA"));
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.essaouira2,"ESSAOUIRA"));
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.fes2,"FES"));
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.marrakech2, "MARRAKECH"));
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.meknes2,"MEKNES"));
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.rabat2,"RABAT"));
            patrimoineUnesco.add(new VillesPopulairesTendances(R.drawable.tetouan2,"TETOUAN"));
            villesPopulairesTendancesAdapter adapter = new villesPopulairesTendancesAdapter(getContext(), R.layout.layout_villes_populaires_tendances_adapter, patrimoineUnesco);
            listeView.setAdapter(adapter);
        }

    }

    public void changerAdapterList(villesPopulairesTendancesAdapter adapter){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentVillesPopulairesTendancesInterface) {
            mListener = (FragmentVillesPopulairesTendancesInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }


    public void initContext(Context context) {
        this.context=context;
    }

    public void choixSuggestion(String choix) {
        this.choix=choix;

    }

    public interface FragmentVillesPopulairesTendancesInterface extends  AdapterView.OnItemClickListener{

    }
}
