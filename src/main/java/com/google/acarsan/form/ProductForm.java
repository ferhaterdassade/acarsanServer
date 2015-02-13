package com.google.acarsan.form;

/**
 * Created by ferhat on 13/2/2015.
 */
public class ProductForm {
    private final String category;
    private final String name;

    public ProductForm(String category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
