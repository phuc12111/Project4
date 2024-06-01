/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Deliveries;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeliveriesDAOiml implements DeliveriesDAO{
      
     private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    @Override
    public List<Deliveries> findAll() {
        String sql = "SELECT * FROM deliveries";
        List<Deliveries> de = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            Deliveries obj = new Deliveries();
            obj.setDeliveryID((int) row.get("deliveryID"));
            obj.setDeliveryName((String) row.get("deliveryName"));
            obj.setPrice((Double) row.get("price"));
            obj.setShipperName((String) row.get("shipperName"));

            
            de.add(obj);
        }
        return de;
    }
    
    @Override
    public Deliveries findByShipperName(String shipperName){
        String sql = "SELECT * FROM deliveries where shipperName = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{shipperName}, new BeanPropertyRowMapper<>(Deliveries.class));
    }
    
    
     @Override
    public void addDelivery(Deliveries delivery) {
        String sql = "INSERT INTO deliveries (deliveryName, price, shipperName) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, delivery.getDeliveryName(), delivery.getPrice(), delivery.getShipperName());
    }

    @Override
    public void updateDelivery(Deliveries delivery) {
        String sql = "UPDATE deliveries SET deliveryName = ?, price = ?,shipperName =? WHERE deliveryID = ?";
        jdbcTemplate.update(sql, delivery.getDeliveryName(), delivery.getPrice(),delivery.getShipperName() , delivery.getDeliveryID());
    }

    @Override
    public void deleteDelivery(int deliveryID) {
        String sql = "DELETE FROM deliveries WHERE deliveryID = ?";
        jdbcTemplate.update(sql, deliveryID);
    }

    @Override
    public List<Deliveries> searchDeliveriesByDeliveryName(String shipperName) {
    String searchSql = "SELECT * FROM deliveries WHERE shipperName LIKE ?";
    String likePattern = "%" + shipperName + "%";
    return jdbcTemplate.query(searchSql, new Object[]{likePattern}, new BeanPropertyRowMapper<>(Deliveries.class));
}


    @Override
    public Deliveries findById(int deliveryID) {
    String sql = "SELECT * FROM deliveries WHERE deliveryID = ?";
    return jdbcTemplate.queryForObject(sql, new Object[]{deliveryID}, new BeanPropertyRowMapper<>(Deliveries.class));
}

    
}
