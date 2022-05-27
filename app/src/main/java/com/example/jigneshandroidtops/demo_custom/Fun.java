package com.example.jigneshandroidtops.demo_custom;

import com.google.gson.annotations.SerializedName;

public class Fun {

    @SerializedName("name")
    String name;
    @SerializedName("city")
    String city;

    public Fun(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
