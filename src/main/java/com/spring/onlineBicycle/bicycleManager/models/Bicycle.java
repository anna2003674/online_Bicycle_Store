package com.spring.onlineBicycle.bicycleManager.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "bicycle")
@AllArgsConstructor
public class Bicycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "modell")
    private String modell;       //модель

    @Column(name = "year")
    private int year;       //год создания

    @Column(name = "bottomBracket")
    private String bottomBracket;       // каретка

    @Column(name = "brand")
    private String brand;       //бренд

    @Column(name = "chain")
    private String chain;       //цепь

    @Column(name = "saddle")
    private String saddle;      //седло

    @Column(name = "pedals")
    private String pedals;      //педали

    @Column(name = "frontHub")
    private String frontHub;        //передняя втулка

    @Column(name = "type")
    private String type;        //тип

    @Column(name = "price")
    private double price;      // цена

    @Column(name = "weight")
    private double weight;      //вес

    @Column(name = "wheelDiameter")
    private double wheelDiameter;       //диаметр колес

    @Column(name = "frameMaterial")
    private String frameMaterial;       //материал рамы

    @Column(name = "brakeType")
    private String brakeType;   //тип тормозов

    @Column(name = "numberSpeeds")
    private int numberSpeeds;       //количество скоростей

    @Column(name = "depreciation")
    private String depreciation;        //амортизация


    @Column(name = "quantityInStock")
    private int quantityInStock;        //количество на складе


    @Column(name = "description")
    private String description;    // описание велосипеда


    public Bicycle() {
    }

    public Bicycle(String modell, int year, String bottomBracket, String brand, String chain,
                   String saddle, String pedals, String frontHub, String type, double price,
                   double weight, double wheelDiameter, String frameMaterial, String brakeType,
                   int numberSpeeds, String depreciation, int quantityInStock, String description) {
        this.modell = modell;
        this.year = year;
        this.bottomBracket = bottomBracket;
        this.brand = brand;
        this.chain = chain;
        this.saddle = saddle;
        this.pedals = pedals;
        this.frontHub = frontHub;
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.wheelDiameter = wheelDiameter;
        this.frameMaterial = frameMaterial;
        this.brakeType = brakeType;
        this.numberSpeeds = numberSpeeds;
        this.depreciation = depreciation;
        this.quantityInStock = quantityInStock;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBottomBracket() {
        return bottomBracket;
    }

    public void setBottomBracket(String bottomBracket) {
        this.bottomBracket = bottomBracket;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getSaddle() {
        return saddle;
    }

    public void setSaddle(String saddle) {
        this.saddle = saddle;
    }

    public String getPedals() {
        return pedals;
    }

    public void setPedals(String pedals) {
        this.pedals = pedals;
    }

    public String getFrontHub() {
        return frontHub;
    }

    public void setFrontHub(String frontHub) {
        this.frontHub = frontHub;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWheelDiameter() {
        return wheelDiameter;
    }

    public void setWheelDiameter(double wheelDiameter) {
        this.wheelDiameter = wheelDiameter;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    public String getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(String brakeType) {
        this.brakeType = brakeType;
    }

    public int getNumberSpeeds() {
        return numberSpeeds;
    }

    public void setNumberSpeeds(int numberSpeeds) {
        this.numberSpeeds = numberSpeeds;
    }

    public String getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(String depreciation) {
        this.depreciation = depreciation;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}





