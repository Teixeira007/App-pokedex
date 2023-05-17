package com.home.pokedex.data.network.response;

public class PokemonResponse {
    private Integer id;
    private String name;
    private String url;

    public PokemonResponse(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }
}
