package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import android.util.Log;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Artisanat;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Utilisateur;

import java.io.IOException;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestUtilisateurs {
    TourismeAppService tourismeAppService;
    public static List<Utilisateur> utilisateurs ;
    private static ControllerRestUtilisateurs controllerRestClass;
    private ControllerRestUtilisateurs(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestUtilisateurs getInstanceControllerRestClass(){
        if(controllerRestClass==null){
            controllerRestClass=new ControllerRestUtilisateurs();
        }
        return controllerRestClass;
    }


    public void listUtilisateursAsync() {

        tourismeAppService.listUtilisateursAsync(new Callback<List<Utilisateur>>() {
            @Override
            public void success(List<Utilisateur> utilisateurs, Response response) {
               listUtilisateurs(utilisateurs);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
   public void addUtilisateurAsync(){
        Utilisateur utilisateur=new Utilisateur();
       tourismeAppService.addUtilisateurAsync(utilisateur,new Callback<Utilisateur>() {
           @Override
           public void success(Utilisateur utilisateur, Response response) {
               newUtilisateur(utilisateur);
           }
           @Override
           public void failure(RetrofitError error) {

           }
       });
   }

    public void updateUtilisateurAsync(){
        Utilisateur utilisateur=new Utilisateur();
        tourismeAppService.updateUtilisateurAsync(18,utilisateur,new Callback<Utilisateur>() {
            @Override
            public void success(Utilisateur utilisateur, Response response) {
                updateUtilisateur(utilisateur);
            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void deleteUtilisateurAsync(){

        tourismeAppService.deleteUtilisateurAsync(18,new Callback<Utilisateur>() {
            @Override
            public void success(Utilisateur utilisateur, Response response) {

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    private void listUtilisateurs(List<Utilisateur> utilisateurs) {
          GlobalClass.listUtilisateurs=utilisateurs;
    }
   private void newUtilisateur(Utilisateur utilisateur) {
          GlobalClass.user=utilisateur;
    }
    private void updateUtilisateur(Utilisateur utilisateur){
        GlobalClass.userUpdate=utilisateur;
    }

}
