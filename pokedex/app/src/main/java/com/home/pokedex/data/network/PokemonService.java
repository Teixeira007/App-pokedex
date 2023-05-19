package com.home.pokedex.data.network;

import com.home.pokedex.data.network.response.PokemonResponse;
import com.home.pokedex.data.network.response.PokemonResults;
import com.home.pokedex.data.network.response.PokemonStatsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    @GET("pokemon?limit=1281")
    Call<PokemonResults> getListPokemons();

    @GET("pokemon/{id}")
    Call<PokemonStatsResponse> getPokemon(@Path("id") Integer id);
}
