/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Login;
import com.models.LoginMap;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAOiml implements LoginDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public Login login(String phone, String password) {
        String sql = "SELECT * FROM members WHERE phone = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{phone, password}, new LoginMap());
        } catch (EmptyResultDataAccessException e) {
            return null; // No matching record found
        }
    }
}

