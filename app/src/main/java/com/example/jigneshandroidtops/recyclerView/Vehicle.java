package com.example.jigneshandroidtops.recyclerView;

public class Vehicle {

    String name;
    int average;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Vehicle(String name, int average) {
        this.name = name;
        this.average = average;
    }
}
