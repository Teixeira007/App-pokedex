package com.home.pokedex.data.dto;

import com.home.pokedex.data.model.Pokemon;
import com.home.pokedex.data.network.response.PokemonResponse;
import com.home.pokedex.data.network.response.PokemonStatsResponse;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static Pokemon converterPokemonResponseStatsForPokemon(PokemonStatsResponse response){
        String url = response.getUrl();

        url = url.replaceAll("/encounters", "");


       Pokemon pokemon = new Pokemon(response.getName(), url, response.getHeight(), response.getWeight());


        return pokemon;
    }


}
