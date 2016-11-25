package com.lgcs.mascotas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.lgcs.mascotas.R.layout.cardview_petfil;

/**
 * Created by Tecnologías on 02/08/2016.
 */
public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaPerfilAdaptador (ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    public MascotaPerfilAdaptador(ArrayList<Mascota> contactos, Activity activity) {
        this.mascotas = contactos;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(cardview_petfil,parent,false);


        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        //holder.imgFoto.setImageResource(mascota.getUrlFoto());

        holder.tvLike.setText(mascota.getMegusta());


        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.bull_52)
                .into(holder.imgFoto);
        holder.tvLike.setText(mascota.getNombreCompleto());
        holder.tvLike.setText(String.valueOf(mascota.getMegusta()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgPic);
            tvLike      = (TextView) itemView.findViewById(R.id.tvLike);
        }
    }
}
