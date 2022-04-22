package com.example.jigneshandroidtops.recyclerView_crud;

public class Weather {

    String name;
    float temp;
    float wind_speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Weather(String name, float temp, float wind_speed) {
        this.name = name;
        this.temp = temp;
        this.wind_speed = wind_speed;
    }
}
