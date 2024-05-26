/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Albums;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AlbumsDAO {
    public List<Albums> findAll();
    public void add(Albums album);
    public void update(Albums album);
    public Albums get(int id);
    public void delete(int id);
    public List<Albums> find(String keyword);
}
