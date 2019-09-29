package com.tbbc.assignment;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        products.forEach(p -> {
                    result.append(p.getName() + ": $");
                    result.append(p.getPrice() + " [ ");
                    result.append(p.additionalInfo() + " ] ");
                    result.append('\n');
                });
        return result.toString();
    }

    private double cost(){
        return products.stream()
                .map(Product::getPrice)
                .reduce(0.0d, Double::sum);
    }

    public double taxComponent(){
        return products.stream()
                .map(Product::taxComponent)
                .reduce(0.0d, Double::sum);
    }

    public double total(){
        return  cost() + taxComponent();
    }

    public long itemCount(){
        return products.size();
    }
}
