/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author asus
 */
public class Deliveries {
    private int deliveryID;
    private String deliveryName;
    private double price;
    private String shipperName;

    public Deliveries(int deliveryID, String deliveryName, double price, String shipperName) {
        this.deliveryID = deliveryID;
        this.deliveryName = deliveryName;
        this.price = price;
        this.shipperName = shipperName;
    }

    public Deliveries() {
    }



    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }
    
    
}
