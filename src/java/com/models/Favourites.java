/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author asus
 */
public class Favourites {
    private int favouriteID;
    private String productName;
    private double price;
    private String picture;
    private  String phone;
    private int productID;

    public Favourites() {
    }

    public Favourites(int favouriteID, String productName, double price, String picture, String phone, int productID) {
        this.favouriteID = favouriteID;
        this.productName = productName;
        this.price = price;
        this.picture = picture;
        this.phone = phone;
        this.productID = productID;
    }

    public int getFavouriteID() {
        return favouriteID;
    }

    public void setFavouriteID(int favouriteID) {
        this.favouriteID = favouriteID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    
    
}
