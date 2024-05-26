package com.servlets;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.models.OrderdetailView;

public class ViewOrderDAOiml implements ViewOrderDAO {

   private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public List<OrderdetailView> getAllOrderInfo(String phone) {
        String sql = "SELECT " + " PIs.picture," + "    O.orderID,  " + "    O.orderDate,  " + "    O.deliveryDate,  "
                + "    O.shipAddress,  " + "    O.status,  " + "    P.paymentName,  " + "    D.deliveryName,  "
                + "    PIS.productName,  " + "    PIS.productID,  " + "    PIS.price,  " + "    PID.quantity ,  "
                + "    M.phone   " + "FROM   " + "    orders O  " + "JOIN   "
                + "    payments P ON O.paymentID = P.paymentID  " + "JOIN   "
                + "    deliveries D ON O.deliveryID = D.deliveryID  " + "JOIN   "
                + "    members M ON O.phone = M.phone  " + "JOIN   "
                + "    purchasingInvoices PID ON O.orderID = PID.orderID  " + "JOIN   "
                + "    products PIS ON PID.productID = PIS.productID  " + "  " + "WHERE   "
                + "    M.phone =  ?";

        return jdbcTemplate.query(sql, new Object[] { phone }, new RowMapper<OrderdetailView>() {
            @Override
            public OrderdetailView mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderdetailView orderInfo = new OrderdetailView();
                orderInfo.setOrderID(rs.getInt("orderID"));
                orderInfo.setOrderDate(rs.getTimestamp("orderDate"));
                orderInfo.setDeliveryDate(rs.getTimestamp("deliveryDate"));
                orderInfo.setShipAddress(rs.getString("shipAddress"));
                orderInfo.setStatus(rs.getString("status"));
                orderInfo.setPaymentName(rs.getString("paymentName"));
                orderInfo.setDeliveryName(rs.getString("deliveryName"));
                orderInfo.setProductName(rs.getString("productName"));
                orderInfo.setProductID(rs.getInt("productID"));
                orderInfo.setPrice(rs.getDouble("price"));
                orderInfo.setQuantity(rs.getInt("quantity"));
                orderInfo.setPhone(rs.getString("phone"));
                orderInfo.setPicture(rs.getString("picture"));
                return orderInfo;
            }
        });
    }
}
