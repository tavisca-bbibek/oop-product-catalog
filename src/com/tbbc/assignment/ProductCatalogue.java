package com.tbbc.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductCatalogue {

    private List<FreshFruit> freshFruits = new ArrayList<>();
    private List<PackedItem> packedItems = new ArrayList<>();

    public List<FreshFruit> getFreshFruits() {
        return freshFruits;
    }

    public List<PackedItem> getPackedItems() {
        return packedItems;
    }

    public void addFreshFruit(FreshFruit fruit) {
        freshFruits.add(fruit);
    }

    public void addFreshFruits(List<FreshFruit> fruits) {
        freshFruits.addAll(fruits);
    }

    public void addPackedItem(PackedItem item) {
        packedItems.add(item);
    }

    public void addPackedItems(List<PackedItem> items) {
        packedItems.addAll(items);
    }

    public List<Product> getAllProducts() {
        return Stream.concat(freshFruits.stream(), packedItems.stream())
                .collect(Collectors.toList());
    }

    public Optional<Product> getItem(Long id){
        return getAllProducts().stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
