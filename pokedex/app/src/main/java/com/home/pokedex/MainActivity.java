package com.home.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.home.pokedex.data.model.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PokemonContract.View{

    private ImageView logo;
    private RecyclerView recyclerView;
    private PokemonAdapter adapter;
    private PokemonPresent present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        configAdapter();

        present = new PokemonPresent(this);
        present.getListPokemons();
    }


    public void configAdapter(){
        recyclerView = findViewById(R.id.my_recycler_view);
        adapter = new PokemonAdapter();

        RecyclerView.LayoutManager grideLayout = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(grideLayout);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showPokemons(List<Pokemon> pokemons) {
        adapter.setList(pokemons);
    }

    @Override
    public void showMessageError() {
        Toast.makeText(this, "Erro ao carregar api",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.destoryView();
    }
}