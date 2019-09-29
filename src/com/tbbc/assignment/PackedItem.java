package com.tbbc.assignment;

public class PackedItem extends Product {

    private int quantity;
    private String unitName = "unit";
    private String bunchName = "package";

    public PackedItem(long id, String name, double price, int quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    @Override
    public double taxComponent() {
        return getPrice() / 10;
    }

    public String additionalInfo() {
        return quantity + " " + unitName + "(s) of " + this.getName() + " in the " + bunchName;
    }

    void setUnitName(String unit) {
        this.unitName = unit;
    }

    void setBunchName(String bunch) {
        this.bunchName = bunch;
    }

    @Override
    public String toString() {
        return this.getId() +
                " | " + this.getName() +
                ": $" + this.getPrice() +
                " [ " + this.additionalInfo() + " ]";
    }
}
