/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Favourites;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FavouritesDAOiml implements FavouritesDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void createFavourites(Favourites favourites) {
        String sql = "INSERT INTO favourites (productName, price, picture, phone, productID) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, favourites.getProductName(), favourites.getPrice(), favourites.getPicture(), favourites.getPhone(), favourites.getProductID());
    }

    @Override
    public List<Favourites> selectFavourites(String phone) {
        String sql = "SELECT * FROM favourites WHERE phone = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(Favourites.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>(); // Return an empty list if no results found
        }
    }
}
