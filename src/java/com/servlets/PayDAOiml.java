/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Payment;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class PayDAOiml implements PayDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public List<Payment> getAllPayments() {
        String sql = "SELECT * FROM payments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Payment.class));
    }

    @Override
    public Payment getPaymentByID(int paymentID) {
        String sql = "SELECT * FROM payments WHERE paymentID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{paymentID}, new BeanPropertyRowMapper<>(Payment.class));
    }

    @Override
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO payments (paymentName, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, payment.getPaymentName(), payment.getDescription());
    }

    @Override
    public void updatePayment(Payment payment) {
        String sql = "UPDATE payments SET paymentName = ?, description = ? WHERE paymentID = ?";
        jdbcTemplate.update(sql, payment.getPaymentName(), payment.getDescription(), payment.getPaymentID());
    }

    @Override
    public void deletePayment(int paymentID) {
        String sql = "DELETE FROM payments WHERE paymentID = ?";
        jdbcTemplate.update(sql, paymentID);
    }

    @Override
    public List<Payment> searchPaymentsByPaymentName(String paymentName) {
        String searchSql = "SELECT * FROM payments WHERE paymentName LIKE ?";
        String likePattern = "%" + paymentName + "%";
        return jdbcTemplate.query(searchSql, new Object[]{likePattern}, new BeanPropertyRowMapper<>(Payment.class));
    }

}
