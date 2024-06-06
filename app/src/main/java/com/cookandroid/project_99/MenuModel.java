package com.cookandroid.project_99;

public class MenuModel {
    private int id;
    private String name;
    private int price;
    private String type;

    @Override
    public String toString() {
        return " " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", type = '" + type + '\'' +
                ' ';
    }

    public MenuModel(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
