package com.iwalnexus.tsn.webserviceretrofit;

import com.iwalnexus.tsn.webserviceretrofit.entidades.Futbol;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface FutbolApi {

    //@Headers("X-Auth-Token: ccfca4000abd48c580bf6fb46ba6448a")
    @GET("teams/86/matches?status=SCHEDULED")
    Call<Futbol> getMatches();
}
