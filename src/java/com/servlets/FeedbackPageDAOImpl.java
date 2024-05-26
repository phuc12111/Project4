/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.FeedbackPage;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author admin
 */
public class FeedbackPageDAOImpl implements FeedbackPageDAO {

    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<FeedbackPage> findAll() {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<FeedbackPage> find(String keyword) {
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addFeedbackPage(FeedbackPage feedbackPage) {
        String sql = "insert into feedbackPages (phone,createdAt,content) values (?,?,?)";
        jdbcTemplate.update(sql, feedbackPage.getPhone(), feedbackPage.getCreatedAt(), feedbackPage.getContent());
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
}
