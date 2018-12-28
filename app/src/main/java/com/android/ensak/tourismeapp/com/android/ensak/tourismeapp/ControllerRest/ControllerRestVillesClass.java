package com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.ControllerRest;

import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Monument;
import com.android.ensak.tourismeapp.com.android.ensak.tourismeapp.modelsRest.Ville;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.Response;

public class ControllerRestVillesClass {
    TourismeAppService tourismeAppService;
    public static List<Ville> villes =new ArrayList<Ville>();
    private static ControllerRestVillesClass controllerRestVillesClass;
    private ControllerRestVillesClass(){
        tourismeAppService = new RestAdapter.Builder()
                .setEndpoint(TourismeAppService.ENDPOINT)
                .setLog(new AndroidLog("retrofit"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TourismeAppService.class);
    }
    public static ControllerRestVillesClass getInstanceControllerRestClass(){
        if(controllerRestVillesClass==null){
            controllerRestVillesClass=new ControllerRestVillesClass();
        }
        return controllerRestVillesClass;
    }


    public void listVillesAsync() {

        tourismeAppService.listVilleAsync(new Callback<List<Ville>>() {
            @Override
            public void success(List<Ville> villes, Response response) {
                listVilles(villes);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    public void listVilleTouristiquesAsync(){
        tourismeAppService.listVilleTouristiquesAsync(new Callback<List<Ville>>() {
            @Override
            public void success(List<Ville> villes, Response response) {
                listVillesTouristiques(villes);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
    public void listVilleInUnescoAsync(){
        tourismeAppService.listVilleInUnescoAsync(new Callback<List<Ville>>() {
            @Override
            public void success(List<Ville> villes, Response response) {
                listVillesInUnesco(villes);

            }
            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void listVillesTouristiques(List<Ville> villes) {
        GlobalClass.listVillesTourisques=villes;
    }

    private void listVillesInUnesco(List<Ville> villes){
        GlobalClass.listVillesInUnesco=villes;
    }

    private void listVilles(List<Ville> villes) {
        GlobalClass.listVilles=villes;
     //  ControllerRestVillesClass.villes=villes;
    }



}
