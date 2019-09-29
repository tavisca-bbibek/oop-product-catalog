package com.tbbc.assignment;

public abstract class Product {
    private long id;
    private String name;
    private double price;

    Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " | " + name ;
    }

    public abstract double taxComponent();
    public abstract String additionalInfo();
}
