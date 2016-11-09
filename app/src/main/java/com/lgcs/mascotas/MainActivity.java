package com.lgcs.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar = (Toolbar) findViewById(R.id.ToolbarR);
        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();



        /*

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }*/



    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ReclyclerViewFragment());
        fragments.add(new Perfil());

        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        /*tabLayout.getTabAt(0).setIcon(R.drawable.ic_pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet);*/
    }

    public void irSegundaActividad(View v){
        Intent intent = new Intent(this,CincoMascotas.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        getMenuInflater().inflate(R.menu.menu_star,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContact:
                Intent cIntent = new Intent(this, ActivityContact.class);
                startActivity(cIntent);
                break;
            case R.id.mAbout:
                Intent aIntent = new Intent(this, ActivityAbout.class);
                startActivity(aIntent);
                break;
            case  R.id.mRefresh:
                Intent fiveIntent = new Intent(this, CincoMascotas.class);
                startActivity(fiveIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
