/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.ReplyAlbumReview;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ReplyAlbumReviewDAO {
    
    public List<ReplyAlbumReview> findAll();
    public void add(ReplyAlbumReview albumReview);
    public void update(ReplyAlbumReview albumReview);
    public ReplyAlbumReview get(int id);
    public void delete(int id);
}
