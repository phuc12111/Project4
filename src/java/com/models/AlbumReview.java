/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class AlbumReview {
    private int albumReviewID;
    private String content;
    private String createdAt;
    private int numberStars;
    private String phone;
    private int albumID;

    public AlbumReview() {
    }

    public AlbumReview(int albumReviewID, String content, String createdAt, int numberStars, String phone, int albumID) {
        this.albumReviewID = albumReviewID;
        this.content = content;
        this.createdAt = createdAt;
        this.numberStars = numberStars;
        this.phone = phone;
        this.albumID = albumID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public int getAlbumReviewID() {
        return albumReviewID;
    }

    public void setAlbumReviewID(int albumReviewID) {
        this.albumReviewID = albumReviewID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getNumberStars() {
        return numberStars;
    }

    public void setNumberStars(int numberStars) {
        this.numberStars = numberStars;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
