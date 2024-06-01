/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Albumdetails;
import com.models.Albums;
import java.util.List;

/**
 *
 * @author asus
 */
public interface AlbumdetailsDAO {
    void addAlbumDetails(Albumdetails albumdetails);
    public List<Albumdetails> selectAlbumDetails(int albumID);
}
