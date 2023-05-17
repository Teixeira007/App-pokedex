package com.home.pokedex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.home.pokedex.data.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    List<Pokemon> pokemons;

    public PokemonAdapter() {
        this.pokemons = new ArrayList<>();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.bind(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return (pokemons != null && pokemons.size() > 0) ? pokemons.size() : 0;
    }

    static class PokemonViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagePokemon;
        private TextView namePokemon;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePokemon = itemView.findViewById(R.id.image_pokemon);
            namePokemon = itemView.findViewById(R.id.name_pokemon);
        }

        public void bind(Pokemon pokemon){
            namePokemon.setText(pokemon.getName());
            List<String> urlSplit = Arrays.asList(pokemon.getUrl().split("/"));
            int id = Integer.parseInt(urlSplit.get(6));
            pokemon.setId(id);
//            System.out.println("teste");
//            System.out.println("nome: "+pokemon.getName()+" id: "+pokemon.getId());
            Picasso.get()
                    .load("https://unpkg.com/pokeapi-sprites@2.0.2/sprites/pokemon/other/dream-world/1.svg")
                    .into(imagePokemon);

        }
    }

    public void setList(List<Pokemon> pokemons){
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }




}
