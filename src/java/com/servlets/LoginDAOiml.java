/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Admins;
import com.models.AdminsMap;
import com.models.Login;
import com.models.LoginMap;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
            return null;
        }
    }

    @Override
    public Admins loginadmin(String adminID, String password) {
        String sql = "SELECT * FROM admins WHERE adminID = ? AND password = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{adminID, password}, new AdminsMap());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Login findByUser(String phone) {
        String sql = "SELECT * FROM members WHERE phone = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{phone}, new BeanPropertyRowMapper<>(Login.class));
    }


    @Override
    public Admins findByAdmin(String adminID) {
        String sql = "SELECT * FROM admins WHERE adminID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{adminID}, new BeanPropertyRowMapper<>(Admins.class));
    }

    @Override
    public Login findPhone(String phone) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM members WHERE phone = ?", new Object[]{phone}, new BeanPropertyRowMapper<>(Login.class));
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if no user is found
        }
    }

}
