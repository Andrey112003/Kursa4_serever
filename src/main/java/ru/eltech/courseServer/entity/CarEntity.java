package ru.eltech.courseServer.entity;

import jakarta.persistence.*;

@Entity(name="car")
@Table(name="car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="brand")
    private String brand;

    @Column(name="year")
    private int year;

    @Column(name="price")
    private int price;

    public CarEntity(int id, String brand, int year, int price) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public CarEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
