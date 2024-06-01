/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Albums;
import com.models.Favourites;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AlbumsDAOImpl implements AlbumsDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void addAlbum(Albums album) {
        String sql = "INSERT INTO albums (albumName , phone) VALUES (?, ? )";
        jdbcTemplate.update(sql, album.getAlbumName(), album.getPhone());
    }

    @Override
    public void updateAlbum(Albums album) {
        String sql = "UPDATE albums SET albumName = ?, description = ?, createdAt = ?, picture = ?, phone = ? WHERE albumID = ?";
        jdbcTemplate.update(sql, album.getAlbumName(), album.getDescription(), album.getCreatedAt(), album.getPicture(), album.getPhone(), album.getAlbumID());
    }

    @Override
    public Albums findAlbumById(int albumID) {
        String sql = "SELECT * FROM albums WHERE albumID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{albumID}, new BeanPropertyRowMapper<>(Albums.class));
    }

    @Override
    public void deleteAlbum(int albumID) {
        String deleteAlbumDetailsSql = "DELETE FROM albumDetails WHERE albumID = ?";
        jdbcTemplate.update(deleteAlbumDetailsSql, albumID);

        // Xóa album
        String deleteAlbumSql = "DELETE FROM albums WHERE albumID = ?";
        jdbcTemplate.update(deleteAlbumSql, albumID);
    }

    @Override
    public List<Albums> selectAlbums(String phone) {
        String sql = "select * from albums where phone =?";
        try {
            return jdbcTemplate.query(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(Albums.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>(); // Return an empty list if no results found
        }
    }

    @Override
    public List<Albums> findAllAlbums() {
        String sql = "SELECT * FROM albums";
        List<Albums> albumsList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            Albums album = new Albums();
            album.setAlbumID((int) row.get("albumID"));
            album.setAlbumName((String) row.get("albumName"));
            album.setDescription((String) row.get("description"));
            album.setCreatedAt((Timestamp) row.get("createdAt"));
            album.setPicture((String) row.get("picture"));
            album.setPhone((String) row.get("phone"));
            albumsList.add(album);
        }
        return albumsList;
    }

}
