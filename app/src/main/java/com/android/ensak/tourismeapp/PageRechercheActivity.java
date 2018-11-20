package com.android.ensak.tourismeapp;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

public class PageRechercheActivity extends AppCompatActivity implements ListeVillesFragment.OnFragmentInteractionListenerListeVilles{


    FragmentManager fragmentManager;
    ListeVillesFragment listeVillesFragment;
    listeSuggestionsFragment listeSuggestionsFragment;
    Context context;
    FragmentActivity myContext;
    String[] tableNomVille ;
    String[] tableRechercheSurTourismeApp;
    EditText editText;
    String [] table;
    String typePageRecherche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_recherche);
        editText=findViewById(R.id.barreRecherchePageRecherche);
        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();
        typePageRecherche=bundle.getString("typePageRecherche");
        myContext= this;
        listeVillesFragment =new ListeVillesFragment();
        listeSuggestionsFragment =new listeSuggestionsFragment();
        listeVillesFragment.initContext(myContext);
        fragmentManager=getSupportFragmentManager();
        tableNomVille = getResources().getStringArray(R.array.villes);
        tableRechercheSurTourismeApp=getResources().getStringArray(R.array.recherche_sur_Tourisme_App);
        getSupportFragmentManager().beginTransaction().add(R.id.content_fragment_page_recherche,listeVillesFragment,"fragment2")
                .add(R.id.content_fragment_page_recherche, listeSuggestionsFragment,"fragment1")
                .show(listeSuggestionsFragment)
                .hide(listeVillesFragment).commit();

        switch (typePageRecherche){
            case "ville":
                editText.setHint("Recherchez sur Tourisme APP");
                listeSuggestionsFragment.typeSuggestion("ville");
                table=tableRechercheSurTourismeApp;
                break;
            case "Page Principale":
                listeSuggestionsFragment.typeSuggestion("Page Principale");
                table=tableNomVille;
                break;

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if(s.toString().equals("")){
                    getSupportFragmentManager().beginTransaction().show(listeSuggestionsFragment).hide(listeVillesFragment).commit();
                }else {
                    getSupportFragmentManager().beginTransaction().show(listeVillesFragment).hide(listeSuggestionsFragment).commit();
                    listeVillesFragment.remplirListe(s.toString(), table);

                }
                        /*
                     getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_page_recherche,listeVillesFragment).commit();
                     getSupportFragmentManager().beginTransaction().show(listeVillesFragment).commit();
                     listeVillesFragment.remplirListe(s.toString(),tableNomVille);
                     */
            }
            @Override
            public void afterTextChanged(Editable s){}
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (typePageRecherche){
            case "ville":
                LinearLayout linearLayout=(LinearLayout) view;
                TextView textVie=(TextView) linearLayout.findViewById(R.id.barreRecherche2);
                Toast.makeText(myContext, String.valueOf(position)+" "+textVie.getText(), Toast.LENGTH_LONG).show();
                break;
            case "Page Principale":

                LinearLayout linearLayout2=(LinearLayout) view;
                TextView textVie2=(TextView) linearLayout2.findViewById(R.id.barreRecherche2);
                Toast.makeText(myContext, String.valueOf(position)+" "+textVie2.getText(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,VilleActivity.class);
                intent.putExtra("nomVille",textVie2.getText());
                startActivity(intent);
                break;

        }

    }
}
