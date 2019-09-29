package com.tbbc.assignment;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static ProductCatalogue bbCatalogue = new ProductCatalogue();
    static {
        bbCatalogue.addFreshFruits(getFreshFruits());
        bbCatalogue.addPackedItems(getPacketItems());
    }

    public static void main(String[] args) {

        List<Product> allProducts = bbCatalogue.getAllProducts();
        List<PackedItem> packedItems = bbCatalogue.getPackedItems();
        List<FreshFruit> freshFruits = bbCatalogue.getFreshFruits();

        System.out.println("===========[ Welcome to bb the shop ]==========");
        System.out.println("Fresh Fruits: ");
        freshFruits.forEach(System.out::println);

        System.out.println("Packed Items: ");
        packedItems.forEach(System.out::println);

        System.out.println("To select items enter the item ids separated by a ',' (comma)");
        System.out.println("Example: '1, 2, 3, 4, 4, 5'");

        System.out.println("Items: ");
        String input = new Scanner(System.in).nextLine();

        List<Long> itemIds = Collections.emptyList();
        try {
            itemIds = parseOrder(input);
        } catch (NumberFormatException e) {
            System.err.println("Error: invalid order format");
        }

        boolean allOrderItemsAreAvailable = allProducts.stream()
                .map(Product::getId)
                .collect(Collectors.toList()).containsAll(itemIds);

        if (!allOrderItemsAreAvailable) {
            System.out.println("Error: one or more invalid item(s) selected");
            return;
        }

        Order order = new Order();
        itemIds.stream()
        .map(bbCatalogue::getItem)
        .forEach(p -> p.ifPresent(order::addProduct));

        System.out.println("=======[ Order items ]=======");
        System.out.print(order.toString());
        System.out.println("Total Items: " + order.itemCount());
        System.out.println("Total Amount: " + order.total());
        System.out.println("Tax Component: " + order.taxComponent());
    }

    private static List<Long> parseOrder(String input) {
        String[] ids = input.split(", *");
        return Arrays.stream(ids)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private static List<FreshFruit> getFreshFruits() {
        return Arrays.asList(
                new FreshFruit(1, "Apple", 20.0d, 50.0d),
                new FreshFruit(2, "Orange", 10.0d, 70.0d),
                new FreshFruit(3, "Pineapple", 30.0d, 70.0d),
                new FreshFruit(4, "Pear", 100.0d, 10.0d),
                new FreshFruit(5, "Peach", 25.0d, 24.0d)
        );
    }

    private static List<PackedItem> getPacketItems() {
        List<PackedItem> packedItems = new ArrayList<>();

        PackedItem kitkat = new PackedItem(6, "KitKat", 31.0d, 4);
        kitkat.setUnitName("bar");
        kitkat.setBunchName("bag");
        packedItems.add(kitkat);

        PackedItem oreo = new PackedItem(7, "Oreo", 9.0d, 7);
        oreo.setUnitName("slice");
        oreo.setBunchName("rod");
        packedItems.add(oreo);

        PackedItem coke = new PackedItem(8, "Coke", 13.0d, 2);
        coke.setUnitName("bottle");
        packedItems.add(coke);

        PackedItem advance = new PackedItem(9, "Advance", 40.0d, 5);
        advance.setUnitName("bar");
        advance.setUnitName("packet");
        packedItems.add(advance);

        PackedItem bean = new PackedItem(10, "Flashlight", 200.0d, 9);
        bean.setBunchName("bundle");
        packedItems.add(bean);

        return packedItems;
    }
}
