/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Favouritead;
import com.models.Favourites;
import com.models.FavouritesMember;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

    @Override
    public void deleteFavourites(String phone, int productID) {
        String sql = "DELETE FROM favourites WHERE phone = ? and productID = ?";
        jdbcTemplate.update(sql, phone, productID);
    }

    @Override
    public List<FavouritesMember> get() {
        String sql = "	SELECT   * FROM favourites f JOIN   members m ON f.phone = m.phone";
        try {
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FavouritesMember.class));
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>(); // Return an empty list if no results found
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list if there is any other exception
        }
    }

    @Override
    public void delete(int favouriteID) {
        String sql = "DELETE FROM favourites WHERE favouriteID = ? ";
        jdbcTemplate.update(sql, favouriteID);
    }

    @Override
    public void update(Favourites favourite) {
        String sql = "UPDATE favourites SET productName = ?, phone = ? WHERE favouriteID = ?";
        jdbcTemplate.update(sql, favourite.getProductName(), favourite.getPhone(), favourite.getFavouriteID());
    }

    @Override
    public List<FavouritesMember> search(String productName) {
        String sql = "SELECT * FROM favourites f "
                + "JOIN members m ON f.phone = m.phone "
                + "WHERE f.productName LIKE ?";
        String likePattern = "%" + productName + "%";
        return jdbcTemplate.query(sql, new Object[]{likePattern}, new BeanPropertyRowMapper<>(FavouritesMember.class));
    }

    @Override
    public Favourites getbyid(String id) {
        String sql = "	SELECT * FROM  favourites WHERE favouriteID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Favourites.class));
    }

     @Override
    public List<Favouritead> getTopFavourites() {
        String sql = "SELECT TOP 10 f.productID, p.productName, COUNT(f.favouriteID) AS favouriteCount "
                   + "FROM favourites f "
                   + "JOIN products p ON f.productID = p.productID "
                   + "GROUP BY f.productID, p.productName "
                   + "ORDER BY favouriteCount DESC";

        return jdbcTemplate.query(sql, new RowMapper<Favouritead>() {
            @Override
            public Favouritead mapRow(ResultSet rs, int rowNum) throws SQLException {
                Favouritead favouritead = new Favouritead();
                favouritead.setProductID(rs.getInt("productID"));
                favouritead.setProductName(rs.getString("productName"));
                favouritead.setFavouriteCount(rs.getInt("favouriteCount"));
                return favouritead;
            }
        });
    }

}
