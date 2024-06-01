/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author admin
 */
public class SupplierDAOImpl implements SupplierDAO {
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public List<Supplier> findAll() {
        String sql = "select * from suppliers ORDER BY supplierID DESC";
        List<Supplier> listSupplier = new ArrayList<>();
        List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
        
        for(Map row:rows){
            Supplier sup = new Supplier();
            sup.setSupplierID((Integer) row.get("supplierID"));
            sup.setSupplierName((String) row.get("supplierName"));
            sup.setEmail((String) row.get("email"));
            sup.setPhone((String) row.get("phone"));
            sup.setDescription((String) row.get("description"));
            sup.setPicture((String) row.get("picture"));
            listSupplier.add(sup);
        }
        return listSupplier;
    }

    @Override
    public void add(Supplier supplier) {    
        String sql = "INSERT INTO suppliers VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,supplier.getSupplierName(),supplier.getEmail(),supplier.getPhone(),supplier.getDescription(),supplier.getPicture());
    }

    @Override
    public void update(Supplier supplier) {
        String sql = "UPDATE suppliers SET supplierName = ?, email = ?, phone = ?, description = ?, picture = ? WHERE supplierID = ?";
        jdbcTemplate.update(sql, supplier.getSupplierName(), supplier.getEmail(), supplier.getPhone(), supplier.getDescription(), supplier.getPicture(), supplier.getSupplierID());
    }

    @Override
    public Supplier get(int id) {
        String sql = "SELECT * FROM suppliers WHERE supplierID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Supplier.class));
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM suppliers WHERE supplierID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Supplier> find(String keyword) {
        String sql = "SELECT * FROM suppliers WHERE supplierName LIKE ? ORDER BY supplierID DESC";
        keyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new Object[]{keyword}, BeanPropertyRowMapper.newInstance(Supplier.class));
    }
    
}
