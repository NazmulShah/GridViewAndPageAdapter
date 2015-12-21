package com.example.user.arraylist;

import java.io.Serializable;

/**
 * Created by User on 12/18/2015.
 */
public class Item implements Serializable {

    private  String name;
    private  String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description =description;
    }
}
