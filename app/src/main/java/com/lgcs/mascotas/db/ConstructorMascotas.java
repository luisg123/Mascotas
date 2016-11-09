package com.lgcs.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.lgcs.mascotas.Mascota;
import com.lgcs.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Tecnologías on 25/10/2016.
 */

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Bird 1", R.drawable.bird_48,5));
        mascotas.add(new Mascota("Bird 2", R.drawable.bird_50,6));
        mascotas.add(new Mascota("Bird 3", R.drawable.bull_52,7));
        mascotas.add(new Mascota("Cat 1", R.drawable.cat_48,16));
        mascotas.add(new Mascota("Cat 2", R.drawable.cat_filled_50,5));
        mascotas.add(new Mascota("Chicken 1", R.drawable.chicken_52,5));
        mascotas.add(new Mascota("Bull 1", R.drawable.bull_52,6));
        mascotas.add(new Mascota("Cow 1", R.drawable.cow_filled_50,8));
        mascotas.add(new Mascota("Dog 1", R.drawable.dog_filled_50,1));
        mascotas.add(new Mascota("Duck 1", R.drawable.duck_52,2));
        mascotas.add(new Mascota("Horse 1", R.drawable.horse_filled_50,3));
        mascotas.add(new Mascota("Pig 1", R.drawable.pig_52,2));
        mascotas.add(new Mascota("Rabbit 1", R.drawable.rabbit_52,3));
        mascotas.add(new Mascota("Rabbit Run 1", R.drawable.running_rabbit_filled_50,3));
        mascotas.add(new Mascota("Turtle 1", R.drawable.turtle_52,4));*/

        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Bird 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.bird_48);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Cat 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.cat_48);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Cow 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.cow_filled_50);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Pig 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.pig_52);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,"Rabbit 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.running_rabbit_filled_50);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES,LIKE);
        db.insertarLikeMascota(contentValues);
        db.close();
    }

    public int obtenerLikesMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }
}
