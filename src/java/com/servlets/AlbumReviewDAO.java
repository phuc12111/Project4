/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.AlbumReview;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AlbumReviewDAO {
    public List<AlbumReview> findAll();
    public void add(AlbumReview albumReview);
    public void update(AlbumReview albumReview);
    public AlbumReview get(int id);
    public void delete(int id);
}
