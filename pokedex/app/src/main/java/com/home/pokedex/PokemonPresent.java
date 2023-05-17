package com.home.pokedex;

import com.home.pokedex.data.dto.DtoPokemon;
import com.home.pokedex.data.model.Pokemon;
import com.home.pokedex.data.network.ApiPokemon;
import com.home.pokedex.data.network.response.PokemonResponse;
import com.home.pokedex.data.network.response.PokemonResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonPresent implements PokemonContract.Present{

    private PokemonContract.View view;

    public PokemonPresent(PokemonContract.View view) {
        this.view = view;
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
    public void destoryView() {
        this.view = null;
    }
}
