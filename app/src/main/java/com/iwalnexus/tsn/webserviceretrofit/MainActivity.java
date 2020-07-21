package com.iwalnexus.tsn.webserviceretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.iwalnexus.tsn.webserviceretrofit.adaptadores.MatchesAdapter;
import com.iwalnexus.tsn.webserviceretrofit.entidades.Futbol;
import com.iwalnexus.tsn.webserviceretrofit.entidades.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   private FutbolApi futbolApi;
   private Call<Futbol> futbolCall;

   private RecyclerView rv;
   private RecyclerView.LayoutManager manager;
   private MatchesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        futbolApi = API.api().create(FutbolApi.class);

        futbolCall = futbolApi.getMatches();

        preapreUI();

        futbolCall.enqueue(new Callback<Futbol>() {
            @Override
            public void onResponse(Call<Futbol> call, Response<Futbol> response) {
                Futbol fut = response.body();

                List<Match> lista = fut.getMatches();

                adapter = new MatchesAdapter(lista, R.layout.match_item, MainActivity.this, new MatchesAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Futbol obj, int position) {

                    }
                });

                rv.setLayoutManager(manager);
                rv.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Futbol> call, Throwable t) {

            }
        });

    }

    private void preapreUI() {
        rv = findViewById(R.id.rv);

        manager = new LinearLayoutManager(this);
    }
}
