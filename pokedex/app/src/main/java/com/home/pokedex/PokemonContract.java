package com.home.pokedex;

import com.home.pokedex.data.model.Pokemon;
import com.home.pokedex.data.network.response.PokemonResults;

import java.util.List;

public interface PokemonContract {

    interface View{

        void showPokemons(List<Pokemon> pokemons);

        void showMessageError();


    }

    interface Present{
        void getListPokemons();


        void destoryView();
    }
}
