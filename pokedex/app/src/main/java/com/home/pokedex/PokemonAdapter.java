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

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    List<Pokemon> pokemons;
    private static ItemACLicar itemACLicar;

    public PokemonAdapter(ItemACLicar itemACLicar) {
        this.itemACLicar = itemACLicar;
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

        private Pokemon pokemon;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePokemon = itemView.findViewById(R.id.image_pokemon);
            namePokemon = itemView.findViewById(R.id.name_pokemon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(itemACLicar != null){
                        itemACLicar.itemClicado(pokemon);
                    }
                }
            });

        }

        public void bind(Pokemon pokemon){
            this.pokemon = pokemon;
            namePokemon.setText(pokemon.getName());
            List<String> urlSplit = Arrays.asList(pokemon.getUrl().split("/"));
            int id = Integer.parseInt(urlSplit.get(6));
            pokemon.setId(id);

            Picasso.get()
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokemon.getId()+".png")
                    .into(imagePokemon);

        }
    }

    public void setList(List<Pokemon> pokemons){
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }




    public interface ItemACLicar{
        void itemClicado(Pokemon pokemon);
    }




}
