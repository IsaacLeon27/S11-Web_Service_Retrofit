package com.iwalnexus.tsn.webserviceretrofit.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.iwalnexus.tsn.webserviceretrofit.R;
import com.iwalnexus.tsn.webserviceretrofit.entidades.Futbol;
import com.iwalnexus.tsn.webserviceretrofit.entidades.Match;

import java.util.List;


public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> lista;

    private int layout;
    private Context context;
    private OnItemClickListener listener;

    // Pasamos el activity en vez del context, ya que nos hará falta para poder inflar en context menu
    public MatchesAdapter(List<Match> lista, int layout, Context context, OnItemClickListener listener) {

        this.lista = lista;
        this.layout = layout;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(lista.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    // Implementamos las interfaces OnCreateContextMenuListener y OnMenuItemClickListener
    // para hacer uso del context menu en RecyclerView, y sobreescribimos los métodos
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView c;
        public TextView home;
        public TextView away;
        public TextView date;


        public ViewHolder(View itemView) {
            super(itemView);
            c = itemView.findViewById(R.id.nliga);
            home = itemView.findViewById(R.id.nh);
            away = itemView.findViewById(R.id.na);
            date = itemView.findViewById(R.id.date);
        }

        public void bind(final Match obj, final OnItemClickListener listener) {


            this.c.setText(obj.getCompetition().getName());
            this.home.setText(obj.getHomeTeam().getName());
            this.away.setText(obj.getAwayTeam().getName());
            this.date.setText(obj.getUtcDate().toString());



            }


    }

    public interface OnItemClickListener {
        void onItemClick(Futbol obj, int position);
    }


}
