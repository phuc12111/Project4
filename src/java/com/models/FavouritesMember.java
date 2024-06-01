/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Timestamp;

/**
 *
 * @author asus
 */
public class FavouritesMember {
    private int favouriteID;
    private String productName;
    private double price;
    private String picture;
    private  String phone;
    private int productID;
    private String memberName;
    private String email;
    private String password;
    private boolean gender;
    private String address;
    private Timestamp createdAt;

    public FavouritesMember() {
    }

    public FavouritesMember(int favouriteID, String productName, double price, String picture, String phone, int productID, String memberName, String email, String password, boolean gender, String address, Timestamp createdAt) {
        this.favouriteID = favouriteID;
        this.productName = productName;
        this.price = price;
        this.picture = picture;
        this.phone = phone;
        this.productID = productID;
        this.memberName = memberName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.createdAt = createdAt;
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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
