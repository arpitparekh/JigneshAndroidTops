package com.example.jigneshandroidtops.okhttp;

public class Planet {

    String name;
    String des;
    String img;

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Planet(String name, String des, String img) {
        this.name = name;
        this.des = des;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
