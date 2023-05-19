package com.home.pokedex;

import androidx.annotation.NonNull;

import com.home.pokedex.data.dto.DtoPokemon;
import com.home.pokedex.data.model.Pokemon;
import com.home.pokedex.data.network.ApiPokemon;
import com.home.pokedex.data.network.response.PokemonResponse;
import com.home.pokedex.data.network.response.PokemonResults;
import com.home.pokedex.data.network.response.PokemonStatsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonPresent implements PokemonContract.Present{

    private PokemonContract.View view;
    private PokemonContract.ViewDetails viewDetails;

    public PokemonPresent(PokemonContract.View view, PokemonContract.ViewDetails viewDetails) {
        this.view = view;
        this.viewDetails = viewDetails;
    }

    @Override
    public void getListPokemons() {
        ApiPokemon.getINSTANCE().getListPokemons()
                .enqueue(new Callback<PokemonResults>() {
                    @Override
                    public void onResponse(Call<PokemonResults> call, Response<PokemonResults> response) {
                        List<Pokemon> pokemons = DtoPokemon.converterPokemonResponseForPokemon(response.body().getPokemonResponse());
                        view.showPokemons(pokemons);
                    }

                    @Override
                    public void onFailure(Call<PokemonResults> call, Throwable t) {
                        view.showMessageError();
                    }
                });
    }

    @Override
    public void getPokemon(Integer id) {
        ApiPokemon.getINSTANCE().getPokemon(id)
                .enqueue(new Callback<PokemonStatsResponse>() {
                    @Override
                    public void onResponse(Call<PokemonStatsResponse> call, @NonNull Response<PokemonStatsResponse> response) {
                        PokemonStatsResponse pokemonStatsResponse = response.body();
                        Pokemon pokemon = DtoPokemon.converterPokemonResponseStatsForPokemon(pokemonStatsResponse);

//                        view.showDetailsPokemon(pokemon);
                    }

                    @Override
                    public void onFailure(Call<PokemonStatsResponse> call, Throwable t) {
                        view.showMessageError();
                    }
                });
    }


    @Override
    public void destoryView() {
        this.view = null;
    }
}
