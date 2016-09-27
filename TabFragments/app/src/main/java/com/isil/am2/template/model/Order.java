package com.isil.am2.template.model;

import java.io.Serializable;

/**
 * Created by eduardo on 26/09/16.
 */
public class Order implements Serializable {

    private int id;
    private String name;

    public Order(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
