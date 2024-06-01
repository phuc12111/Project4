/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Favouritead;
import com.models.Favourites;
import com.models.FavouritesMember;
import java.util.List;

/**
 *
 * @author asus
 */
public interface FavouritesDAO {

    public void createFavourites(Favourites favourites);

    public List<Favourites> selectFavourites(String phone);

    public void deleteFavourites(String phone, int productID);

    public List<FavouritesMember> get();

    public void delete(int favouriteID);

    public void update(Favourites favourite);

    public List<FavouritesMember> search(String productName);

    public Favourites getbyid(String id);

    public List<Favouritead> getTopFavourites();
}
