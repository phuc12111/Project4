package com.servlets;

import com.models.Admins;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminDAOiml implements AdminDAO {
    private JdbcTemplate jdbcTemplate;

    public AdminDAOiml() {
    }

    public AdminDAOiml(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Admins admin) {
        String sql = "INSERT INTO admins (adminID, adminName, email, password, phone, gender, address, avatar, createdAt, roleID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, admin.getAdminID(), admin.getAdminName(), admin.getEmail(), admin.getPassword(), admin.getPhone(), admin.getGender(), admin.getAddress(), admin.getAvatar(), admin.getCreatedAt(), admin.getRoleID());
    }

    @Override
    public void change(Admins admin) {
        String sql = "UPDATE admins SET adminName = ?, email = ?, password = ?, phone = ?, gender = ?, address = ?, avatar = ?, createdAt = ?, roleID = ? WHERE adminID = ?";
        jdbcTemplate.update(sql, admin.getAdminName(), admin.getEmail(), admin.getPassword(), admin.getPhone(), admin.getGender(), admin.getAddress(), admin.getAvatar(), admin.getCreatedAt(), admin.getRoleID(), admin.getAdminID());
    }

    @Override
    public Admins get(String id) {
        String sql = "SELECT * FROM admins WHERE adminID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Admins.class));
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM admins WHERE adminID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Admins> findAll() {
        String sql = "SELECT * FROM admins";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Admins.class));
    }

    @Override
    public List<Admins> find(String keyword) {
        String sql = "SELECT * FROM admins WHERE adminName LIKE ?";
        keyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{keyword}, BeanPropertyRowMapper.newInstance(Admins.class));
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    @Override
    public void update(Admins admin) {
    String sql = "UPDATE admins SET adminName = ?, email = ?, password = ?, phone = ?, gender = ?, address = ?, avatar = ?, roleID = ? WHERE adminID = ?";
    jdbcTemplate.update(sql, admin.getAdminName(), admin.getEmail(), admin.getPassword(), admin.getPhone(), admin.getGender(), admin.getAddress(), admin.getAvatar(), admin.getRoleID(), admin.getAdminID());
}

}