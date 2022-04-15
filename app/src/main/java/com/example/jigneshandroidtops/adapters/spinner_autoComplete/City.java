package com.example.jigneshandroidtops.adapters.spinner_autoComplete;

public class City {

    String name;
    int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "name= " + name+
                "\npopulation= " + population;
    }
}
