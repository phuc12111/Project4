/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Artists;
import com.models.Product;
import com.models.ProductWithArtist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author asus
 */
public class ArtistDAOiml implements ArtistDAO  {
     private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    
   @Override
    public void addArtist(Artists artist) {
        String sql = "INSERT INTO artists (artistName, email, phone, description, picture) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, artist.getArtistName(), artist.getEmail(), artist.getPhone(), artist.getDescription(), artist.getPicture());
    }

    @Override
    public List<Artists> getAllArtists() {
        String sql = "SELECT * FROM artists";
        return jdbcTemplate.query(sql, new RowMapper<Artists>() {
            @Override
            public Artists mapRow(ResultSet rs, int rowNum) throws SQLException {
                Artists artist = new Artists();
                artist.setArtistID(rs.getInt("artistID"));
                artist.setArtistName(rs.getString("artistName"));
                artist.setEmail(rs.getString("email"));
                artist.setPhone(rs.getString("phone"));
                artist.setDescription(rs.getString("description"));
                artist.setPicture(rs.getString("picture"));
                return artist;
            }
        });
    }

    @Override
    public Artists getArtistById(int artistID) {
        String sql = "SELECT * FROM artists WHERE artistID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{artistID}, new RowMapper<Artists>() {
            @Override
            public Artists mapRow(ResultSet rs, int rowNum) throws SQLException {
                Artists artist = new Artists();
                artist.setArtistID(rs.getInt("artistID"));
                artist.setArtistName(rs.getString("artistName"));
                artist.setEmail(rs.getString("email"));
                artist.setPhone(rs.getString("phone"));
                artist.setDescription(rs.getString("description"));
                artist.setPicture(rs.getString("picture"));
                return artist;
            }
        });
    }
    
   



    @Override
    public void updateArtist(Artists artist) {
        String sql = "UPDATE artists SET artistName = ?, email = ?, phone = ?, description = ?, picture = ? WHERE artistID = ?";
        jdbcTemplate.update(sql, artist.getArtistName(), artist.getEmail(), artist.getPhone(), artist.getDescription(), artist.getPicture(), artist.getArtistID());
    }

    @Override
    public void deleteArtist(int artistID) {
        String sql = "DELETE FROM artists WHERE artistID = ?";
        jdbcTemplate.update(sql, artistID);
    }  

    
    @Override
    public List<ProductWithArtist> getProductsByArtistId(int artistID) {
        String sql = "SELECT " +
                "p.productID, p.productName, p.description AS productDescription, p.picture AS productPicture, " +
                "p.price, p.sale, p.createdAt, p.updatedAt, p.totalStars, p.totalFeedback, p.totalOrder, " +
                "p.categoryID, p.supplierID, p.producerID, p.artistID, p.audioFile, " +
                "a.artistName, a.email AS artistEmail, a.phone AS artistPhone, " +
                "a.description AS artistDescription, a.picture AS artistPicture " +
                "FROM products p " +
                "JOIN artists a ON p.artistID = a.artistID " +
                "WHERE p.artistID = ?";

        return jdbcTemplate.query(sql, new Object[]{artistID}, new ProductWithArtistRowMapper());
    }

    private static class ProductWithArtistRowMapper implements RowMapper<ProductWithArtist> {
        @Override
        public ProductWithArtist mapRow(ResultSet rs, int rowNum) throws SQLException {
            ProductWithArtist productWithArtist = new ProductWithArtist();
            productWithArtist.setProductID(rs.getInt("productID"));
            productWithArtist.setProductName(rs.getString("productName"));
            productWithArtist.setProductDescription(rs.getString("productDescription"));
            productWithArtist.setProductPicture(rs.getString("productPicture"));
            productWithArtist.setPrice(rs.getFloat("price"));
            productWithArtist.setSale(rs.getFloat("sale"));
            productWithArtist.setCreatedAt(rs.getTimestamp("createdAt"));
            productWithArtist.setUpdatedAt(rs.getTimestamp("updatedAt"));
            productWithArtist.setTotalStars(rs.getFloat("totalStars"));
            productWithArtist.setTotalFeedback(rs.getInt("totalFeedback"));
            productWithArtist.setTotalOrder(rs.getInt("totalOrder"));
            productWithArtist.setCategoryID(rs.getInt("categoryID"));
            productWithArtist.setSupplierID(rs.getInt("supplierID"));
            productWithArtist.setProducerID(rs.getInt("producerID"));
            productWithArtist.setArtistID(rs.getInt("artistID"));
            productWithArtist.setAudioFile(rs.getString("audioFile"));

            productWithArtist.setArtistName(rs.getString("artistName"));
            productWithArtist.setArtistEmail(rs.getString("artistEmail"));
            productWithArtist.setArtistPhone(rs.getString("artistPhone"));
            productWithArtist.setArtistDescription(rs.getString("artistDescription"));
            productWithArtist.setArtistPicture(rs.getString("artistPicture"));

            return productWithArtist;
        }
    }
}
