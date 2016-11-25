package com.lgcs.mascotas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lgcs.mascotas.db.ConstructorMascotas;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Tecnologías on 18/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador (ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    public MascotaAdaptador(ArrayList<Mascota> contactos, Activity activity) {
        this.mascotas = contactos;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        //holder.imgFoto.setImageResource(mascota.geturlFoto());
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.bull_52)
                .into(holder.imgFoto);
        holder.tvNombre.setText(mascota.getNombreCompleto());
        holder.tvLike.setText(String.valueOf(mascota.getMegusta()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,CincoMascotas.class);
                intent.putExtra("url",mascota.getUrlFoto());
                intent.putExtra("like", mascota.getMegusta());
                activity.startActivity(intent);
            }
        });

        /*holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                holder.tvLike.setText(constructorMascotas.obtenerLikesMascota(mascota) + " Likes");
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvLike;
        private ImageView btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgPic);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvName);
            tvLike      = (TextView) itemView.findViewById(R.id.tvLike);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
