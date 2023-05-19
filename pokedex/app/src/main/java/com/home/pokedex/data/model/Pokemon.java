package com.home.pokedex.data.model;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private Integer id;
    private String name;
    private String url;

    private int height;

    private int weight;



    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Pokemon(String name, String url, int height, int weight) {
        this.name = name;
        this.url = url;
        this.height = height;
        this.weight = weight;
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

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
