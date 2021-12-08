package com.example.apirestful_volley_retrofit.interfaces;

import com.example.apirestful_volley_retrofit.AllJson;
import com.example.apirestful_volley_retrofit.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Json_PlaceHolder_Api {

    @GET("public/v1/users")

    Call<AllJson> getData();
}
