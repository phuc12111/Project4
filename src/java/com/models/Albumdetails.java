/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author asus
 */
public class Albumdetails {
    private int albumID;
    private int productID;
  private String description;
    private String productName;

    public Albumdetails(int albumID, int productID, String description, String productName, double price, String audioFile) {
        this.albumID = albumID;
        this.productID = productID;
        this.description = description;
        this.productName = productName;
        this.price = price;
        this.audioFile = audioFile;
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

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }
    private double price;
    private String audioFile;
    public Albumdetails() {
        
    }

    
    
    

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
}
