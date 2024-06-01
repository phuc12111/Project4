/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Albumdetails;
import com.models.Albums;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AlbumdetailsDAOiml implements AlbumdetailsDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void addAlbumDetails(Albumdetails albumdetails) {
        String sql = "INSERT INTO albumDetails (albumID, productID) VALUES (?, ?)";
        jdbcTemplate.update(sql, albumdetails.getAlbumID(), albumdetails.getProductID());
    }

    @Override
public List<Albumdetails> selectAlbumDetails(int albumID) {
        String sql = "select * from albumDetails where albumID  = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{albumID}, new BeanPropertyRowMapper<>(Albumdetails.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>(); // Return an empty list if no results found
        }
    }
    
}
