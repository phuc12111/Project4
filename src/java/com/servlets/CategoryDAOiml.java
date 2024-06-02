/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Categories;
import com.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author asus
 */
public class CategoryDAOiml implements CategoryDAO{

     private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
     @Override
    public List<Categories> findAll() {
        String sql = "select * from categories";
        List<Categories> cate = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            Categories obj = new Categories();
            obj.setCategoryID((int) row.get("categoryID"));
            obj.setCategoryName((String) row.get("categoryName"));
            obj.setDescription((String) row.get("description"));

            cate.add(obj);
        }
        return cate;
    }
    
    @Override
     public Categories findById(int categoryID) {
        String sql = "select * from categories where categoryID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{categoryID}, new RowMapper<Categories>() {
            @Override
            public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
                Categories category = new Categories();
                category.setCategoryID(rs.getInt("categoryID"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setDescription(rs.getString("description"));
                return category;
            }
        });
    }
    
    
     @Override
public List<Product> findAllpro(int categoryID) {
    String sql = "SELECT * FROM products WHERE categoryID = ?;";
    List<Product> pro = new ArrayList<>();
    List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, categoryID);

    for (Map<String, Object> row : rows) {
        Product obj = new Product();
        obj.setProductID((int) row.get("ProductID"));
        obj.setProductName((String) row.get("ProductName"));
        obj.setDescription((String) row.get("Description"));
        obj.setPicture((String) row.get("Picture"));
        obj.setPrice((Double) row.get("Price"));
        obj.setSale((Double) row.get("Sale"));
        obj.setCreatedAt((Timestamp) row.get("CreatedAt"));
        obj.setUpdatedAt((Timestamp) row.get("UpdatedAt"));
        obj.setTotalStars((Double) row.get("TotalStars"));
        obj.setTotalFeedback((int) row.get("TotalFeedback"));
        obj.setTotalOrder((int) row.get("TotalOrder"));
        obj.setAudioFile((String) row.get("AudioFile"));
        pro.add(obj);
    }
    return pro;
}

}
