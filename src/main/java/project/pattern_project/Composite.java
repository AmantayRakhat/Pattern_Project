package project.pattern_project;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

// Structural Design Pattern: Composite Pattern
interface Product {
    String getName();

    double getPrice();
}
class ConcreteProduct implements Product {
    private int id;
    private String name;
    private double price;

    public ConcreteProduct(int id, String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
interface CompositeProduct extends Product {
    List<Product> getProducts();
}

class ConcreteComposite implements CompositeProduct {
    private int id;
    private String name ;
    private List<Product> products = new ArrayList<>();

    public ConcreteComposite(int id, String name) {
        this.id=id;
        this.name=name;
        this.products = DBConnection.getProductsForComposite(id);
    }
    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}