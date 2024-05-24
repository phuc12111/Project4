/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author asus
 */
public class CartDAOiml implements CartDAO{
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    
    @Override
    public Product findById(int productID) {
        String sql = "SELECT * FROM products WHERE productID  = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productID}, new BeanPropertyRowMapper<>(Product.class));
    }
}
