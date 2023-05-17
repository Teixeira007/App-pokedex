package com.home.pokedex.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class PokemonResults {

    @Json(name = "results")
    private final List<PokemonResponse> pokemonResponse;

    public PokemonResults(List<PokemonResponse> pokemonResponse) {
        this.pokemonResponse = pokemonResponse;
    }

    public List<PokemonResponse> getPokemonResponse() {
        return pokemonResponse;
    }
}
