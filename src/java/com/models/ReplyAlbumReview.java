/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

/**
 *
 * @author admin
 */
public class ReplyAlbumReview {
    private AlbumReview albumReview;
    private String phone;
    private String content;
    private String createAt;

    public ReplyAlbumReview() {
    }

    public ReplyAlbumReview(AlbumReview albumReview, String phone, String content, String createAt) {
        this.albumReview = albumReview;
        this.phone = phone;
        this.content = content;
        this.createAt = createAt;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public AlbumReview getAlbumReview() {
        return albumReview;
    }

    public void setAlbumReview(AlbumReview albumReview) {
        this.albumReview = albumReview;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
