package com.home.pokedex.data.model;

public class Pokemon {

    private Integer id;
    private String name;
    private String url;



    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }


    public void setId(Integer id) {
        this.id = id;
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
