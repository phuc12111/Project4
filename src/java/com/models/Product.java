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
public class Product {
    private int productID;
    private String productName;
    private String description;
    private String picture;
    private double price;
    private double sale;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private double totalStars;
    private int totalFeedback;
    private int totalOrder;
    private String audioFile;

    public Product(int productID, String productName, String description, String picture, double price, double sale, Timestamp createdAt, Timestamp updatedAt, double totalStars, int totalFeedback, int totalOrder, String audioFile) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.picture = picture;
        this.price = price;
        this.sale = sale;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalStars = totalStars;
        this.totalFeedback = totalFeedback;
        this.totalOrder = totalOrder;
        this.audioFile = audioFile;
    }

    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public double getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(double totalStars) {
        this.totalStars = totalStars;
    }

    public int getTotalFeedback() {
        return totalFeedback;
    }

    public void setTotalFeedback(int totalFeedback) {
        this.totalFeedback = totalFeedback;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }
    
    
    
}
