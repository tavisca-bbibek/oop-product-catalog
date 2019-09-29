package com.tbbc.assignment;

public class FreshFruit extends Product {
    private double weight;

    public FreshFruit(long id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    @Override
    public double taxComponent() {
        return 0.0d;
    }

    @Override
    public String additionalInfo() {
        return "the " + this.getName() + " is " + weight + " grams";
    }


    @Override
    public String toString() {
        return this.getId() +
                " | " + this.getName() +
                ": $" + this.getPrice() +
                " [ " + this.additionalInfo() + " ]";
    }
}
