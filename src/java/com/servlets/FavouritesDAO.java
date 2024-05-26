/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Favourites;
import java.util.List;

/**
 *
 * @author asus
 */
public interface FavouritesDAO {
    public void createFavourites(Favourites favourites);
    public List<Favourites> selectFavourites(String phone);
}
