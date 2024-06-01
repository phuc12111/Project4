/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author asus
 */
public class AdminsMap implements RowMapper<Admins>{
    @Override
    public Admins mapRow(ResultSet rs, int rowNum) throws SQLException {
        String adminID = rs.getString("adminID");
        String password = rs.getString("password");
        return new Admins(adminID, password);
    }

}