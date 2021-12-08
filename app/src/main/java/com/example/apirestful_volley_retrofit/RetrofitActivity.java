package com.example.apirestful_volley_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.apirestful_volley_retrofit.interfaces.Json_PlaceHolder_Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    TextView txtResultado;
    List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        dataList = new ArrayList<>();

        txtResultado = findViewById(R.id.txtResultado_r);

    }

    public void resultadoRetrofit()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gorest.co.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Json_PlaceHolder_Api DataService = retrofit.create(Json_PlaceHolder_Api.class);
        Call<AllJson> call = DataService.getData();

        call.enqueue(new Callback<AllJson>() {
            @Override
            public void onResponse(Call<AllJson> call, Response<AllJson> response) {
                AllJson allJson = response.body();
                dataList = new ArrayList<>(Arrays.asList(allJson.getDataArray()));
                for(Data p: dataList){
                    String resultado = "";
                    resultado+="ID: " + p.getId() + "\n";
                    resultado+="NAME : " + p.getName() + "\n";
                    resultado+="E-MAIL : " + p.getEmail() + "\n";
                    resultado+="GENDER : " + p.getGender() + "\n";
                    resultado+="STATUS : " + p.getStatus() + "\n" + "\n";
                    txtResultado.append(resultado);
                }
            }

            @Override
            public void onFailure(Call<AllJson> call, Throwable t) {

            }
        });
/*
        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                List<Data> dataList = response.body();
                for(Data p: dataList){
                    String resultado = "";
                    resultado+="ID: " + p.getId() + "\n";
                    resultado+="NAME : " + p.getName() + "\n";
                    resultado+="E-MAIL : " + p.getEmail() + "\n";
                    resultado+="GENDER : " + p.getGender() + "\n";
                    resultado+="STATUS : " + p.getStatus() + "\n" + "\n";
                    txtResultado.append(resultado);
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });*/


    }
}