package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.simpleClasse;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.android.ensak.tourismeapp.R;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheAdapter.ListElementsAdapter;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.ListeElmentsFragment;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.rechercheFragment.VillesPopulairesTendancesFragment;

public class ResultChoixFragmentSuggestion {

    private String nomVille;
    private Context context;
    private String choix;
    private static ResultChoixFragmentSuggestion resultChoixFragmentSuggestion;
    private FragmentManager fragmentManager;

    private ResultChoixFragmentSuggestion(Context context, String choix,String nomVille) {
        this.nomVille = nomVille;
        this.context = context;
        this.choix = choix;
    }

    private ResultChoixFragmentSuggestion(Context context) {
        this.context = context;
    }

    public static ResultChoixFragmentSuggestion getResultChoixFragmentSuggestion(Context context){
        if(resultChoixFragmentSuggestion==null){
            resultChoixFragmentSuggestion=new ResultChoixFragmentSuggestion(context);
        }
        return resultChoixFragmentSuggestion;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void getFragmentSuggestion(){

        switch(choix){
            case "villes_populaires" : case "tendances" :
                fragmentVillesPopulairesOuPatrimoineUnesco();
                break;
            case "Monuments":
                monumentVille(nomVille);
                break;
            case "Hopitaux":
                break;
            case "Gastronomie":

                break;
            case "Artisanat":

                break;
            case "Restaurants":

                break;

        }

    }

    private void fragmentVillesPopulairesOuPatrimoineUnesco() {
        VillesPopulairesTendancesFragment villesPopulairesTendancesFragment = new VillesPopulairesTendancesFragment();
        villesPopulairesTendancesFragment.choixSuggestion(choix);
        villesPopulairesTendancesFragment.initContext(context);
        fragmentManager.beginTransaction().replace(R.id.layout_container, villesPopulairesTendancesFragment).commit();
    }

    private void monumentVille(String nomVille) {

        switch(nomVille){
            case "rabat" :
                ListElementsAdapter listElementsAdapter=new ListElementsAdapter(context,R.layout.layout_list_elements_adapter,AppUtility.getAppUtility(context).getMonumentsRabat());
                ListeElmentsFragment listeElmentsFragment=new ListeElmentsFragment(listElementsAdapter);
                fragmentManager.beginTransaction().add(R.id.layout_container,listeElmentsFragment).commit();
                break;

        }
    }


}
