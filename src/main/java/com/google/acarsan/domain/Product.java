package com.google.acarsan.domain;

/**
 * Created by ferhat on 12/2/2015.
 */
public class Product {
    private final String id;
    private final String category;
    private final String name;

    public Product(String id, String category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
