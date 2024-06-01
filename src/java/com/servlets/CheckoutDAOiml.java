/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.Orders;
import com.models.PurchasingInvoices;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author asus
 */
public class CheckoutDAOiml implements CheckoutDAO{
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
        @Override
public int createOrder(Orders order) {
    String sql = "INSERT INTO Orders (orderDate, deliveryDate, shipAddress , total, status, paymentID, deliveryID, phone) VALUES (?, ?,? , ?, ?, ?,?,?)";
    jdbcTemplate.update(sql, order.getOrderID(), order.getDeliveryDate(), order.getShipAddress(), order.getTotal(), order.getStatus(), order.getPaymentID(), order.getDeliveryID(), order.getPhone());
    return getLastInsertedOrderId();
}


private int getLastInsertedOrderId() {
    String getLastInsertedIdQuery = "SELECT TOP 1 OrderID FROM Orders ORDER BY OrderID DESC";
    return jdbcTemplate.queryForObject(getLastInsertedIdQuery, Integer.class);
}

@Override
public void createOrderDetails(List<PurchasingInvoices> purchasingInvoiceslist, int orderId) {
    String sql = "INSERT INTO purchasingInvoices (orderID, productID, price, quantity) VALUES (?, ?, ?, ?)";
    for (PurchasingInvoices purchasingInvoices : purchasingInvoiceslist) {
        jdbcTemplate.update(sql, orderId, purchasingInvoices.getProductID(), purchasingInvoices.getPrice(), purchasingInvoices.getQuantity());
    }
}
}
