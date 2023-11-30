package com.sfsl.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Producto")
public class ProductModel implements Serializable{
    @Id
    @Column(name = "Id",unique = true, nullable = false)
    private String id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Brand", nullable = false)
    private String brand;
    @Column(name = "Description", nullable = false)
    private String description;
    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Date_Expiration", nullable = false)
    private String dateExpiration;


    public ProductModel() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }


}
