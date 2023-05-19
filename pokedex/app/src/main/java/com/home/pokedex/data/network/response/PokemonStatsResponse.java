package com.home.pokedex.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class PokemonStatsResponse {

    private String name;
    private int height;
    private int weight;

    @Json(name = "location_area_encounters")
    private String url;



    public PokemonStatsResponse(String name, int height, int weight) {
        this.height = height;
        this.weight = weight;
        this.name = name;
    }



    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


}
