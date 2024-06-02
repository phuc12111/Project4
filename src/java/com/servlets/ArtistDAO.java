/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Artists;
import com.models.Product;
import com.models.ProductWithArtist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author asus
 */
public interface ArtistDAO {
      void addArtist(Artists artist);
    List<Artists> getAllArtists();
    Artists getArtistById(int artistID);
    void updateArtist(Artists artist);
    void deleteArtist(int artistID);
     public List<ProductWithArtist> getProductsByArtistId(int artistID);
}
