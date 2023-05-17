package com.home.pokedex.data.dto;

import com.home.pokedex.data.model.Pokemon;
import com.home.pokedex.data.network.response.PokemonResponse;

import java.util.ArrayList;
import java.util.List;

public class DtoPokemon {

    public static List<Pokemon> converterPokemonResponseForPokemon(List<PokemonResponse> response){
        List<Pokemon> pokemons = new ArrayList<>();
        for(PokemonResponse pokemonResponse: response){
            final Pokemon pokemon = new Pokemon(pokemonResponse.getName(), pokemonResponse.getUrl());
            pokemons.add(pokemon);
        }

        return pokemons;
    }


}
