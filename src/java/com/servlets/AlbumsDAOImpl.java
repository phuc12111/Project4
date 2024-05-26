/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Albums;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author admin
 */
public class AlbumsDAOImpl implements AlbumsDAO {

    private JdbcTemplate jdbcTemplate;

    public AlbumsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public AlbumsDAOImpl() {
    }
    
    @Override
    public List<Albums> findAll() {
        String sql = "select * from albums";
        List<Albums> albums = new ArrayList<>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        
        for(Map row:rows){
            Albums a = new Albums();
            a.setAlbumName((String) row.get("albumName"));
            a.setDescription((String) row.get("description"));
            a.setCreatedAt((Timestamp) row.get("createdAt"));
            a.setPhone((String) row.get("phone"));
            albums.add(a);
        }
        return albums;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Albums album) {
        String sql = "insert into albums (albumName,description,createdAt,phone) values(?,?,?,?)";
        jdbcTemplate.update(sql, album.getAlbumName(),album.getDescription(),album.getCreatedAt(),album.getPhone());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Albums album) {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Albums get(int id) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Albums> find(String keyword) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
