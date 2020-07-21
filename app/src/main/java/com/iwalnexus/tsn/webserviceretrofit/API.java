package com.iwalnexus.tsn.webserviceretrofit;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    public static final String BASE_URL = "https://api.football-data.org/v2/";

    private static Retrofit retrofit = null;

    public static Retrofit api(){

        if(retrofit == null){

            Interceptor i = new Interceptor("ccfca4000abd48c580bf6fb46ba6448a");

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .addInterceptor(i)
                    .build();

           retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .client(okHttpClient)
                   .build();

        }

        return retrofit;

    }
}
