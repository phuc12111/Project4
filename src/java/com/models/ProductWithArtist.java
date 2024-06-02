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
public class ProductWithArtist {
     private int productID;

    public ProductWithArtist() {
    }
    private String productName;
    private String productDescription;
    private String productPicture;
    private float price;
    private float sale;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private float totalStars;
    private int totalFeedback;
    private int totalOrder;
    private int categoryID;
    private int supplierID;
    private int producerID;
    private int artistID;
    private String audioFile;

    private String artistName;
    private String artistEmail;
    private String artistPhone;
    private String artistDescription;
    private String artistPicture;

    public ProductWithArtist(int productID, String productName, String productDescription, String productPicture, float price, float sale, Timestamp createdAt, Timestamp updatedAt, float totalStars, int totalFeedback, int totalOrder, int categoryID, int supplierID, int producerID, int artistID, String audioFile, String artistName, String artistEmail, String artistPhone, String artistDescription, String artistPicture) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPicture = productPicture;
        this.price = price;
        this.sale = sale;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalStars = totalStars;
        this.totalFeedback = totalFeedback;
        this.totalOrder = totalOrder;
        this.categoryID = categoryID;
        this.supplierID = supplierID;
        this.producerID = producerID;
        this.artistID = artistID;
        this.audioFile = audioFile;
        this.artistName = artistName;
        this.artistEmail = artistEmail;
        this.artistPhone = artistPhone;
        this.artistDescription = artistDescription;
        this.artistPicture = artistPicture;
    }

    // Getters and Setters for all fields

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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
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

    public float getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(float totalStars) {
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistEmail() {
        return artistEmail;
    }

    public void setArtistEmail(String artistEmail) {
        this.artistEmail = artistEmail;
    }

    public String getArtistPhone() {
        return artistPhone;
    }

    public void setArtistPhone(String artistPhone) {
        this.artistPhone = artistPhone;
    }

    public String getArtistDescription() {
        return artistDescription;
    }

    public void setArtistDescription(String artistDescription) {
        this.artistDescription = artistDescription;
    }

    public String getArtistPicture() {
        return artistPicture;
    }

    public void setArtistPicture(String artistPicture) {
        this.artistPicture = artistPicture;
    }
}
