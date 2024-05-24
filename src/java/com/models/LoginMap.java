package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class LoginMap implements RowMapper<Login> {
    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
        String phone = rs.getString("phone");
        String password = rs.getString("password");
        return new Login(phone, password);
    }
}
