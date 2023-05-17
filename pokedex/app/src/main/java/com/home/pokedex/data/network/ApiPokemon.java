package com.home.pokedex.data.network;

import com.home.pokedex.data.network.response.PokemonResponse;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiPokemon {

    private static PokemonService INSTANCE;

    public static PokemonService getINSTANCE(){
        if(INSTANCE == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co/api/v2/")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(PokemonService.class);
        }

        return INSTANCE;
    }
}
