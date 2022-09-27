package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    Toolbar mi_toolbar;
    RecyclerView rv_ItemLista;
    ItemListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mi_toolbar = findViewById(R.id.mi_toolbar);
        setSupportActionBar(mi_toolbar);
        getSupportActionBar().setTitle("GAME OF THRONES");


        setupAdapter();
    }


    private void setupAdapter() {

        rv_ItemLista = findViewById(R.id.rv_itemLista);

        adapter = new ItemListaAdapter(getItemLista());

        rv_ItemLista.setAdapter(adapter);
    }

    private List<ItemLista> getItemLista() {
        return new ArrayList<ItemLista>() {{
            add(new ItemLista("Gander", "Algood", "A game of thrones"));
            add(new ItemLista("Walder","Allyrion","A clash of kings"));
        }};
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.item_cerrar){
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Contantes.SP_CREDENCIALES, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(Contantes.USUARIO, null);
            editor.putString(Contantes.PASSWORD,null);
            editor.apply();
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }return super.onOptionsItemSelected(item);
    }

}