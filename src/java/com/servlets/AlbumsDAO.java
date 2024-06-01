/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Albums;
import com.models.Favourites;
import java.util.List;

/**
 *
 * @author asus
 */
public interface AlbumsDAO {
    public Albums findAlbumById(int albumID);
    public void addAlbum(Albums album);
    public void updateAlbum(Albums album);
     public List<Albums> findAllAlbums();
     public void deleteAlbum(int albumID);
     public List<Albums> selectAlbums(String phone);
}
