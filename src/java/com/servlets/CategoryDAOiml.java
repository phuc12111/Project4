/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Categories;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

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
     
}
