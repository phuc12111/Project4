package com.servlets;

import com.models.OrderDeatail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.models.OrderdetailView;
import org.springframework.dao.EmptyResultDataAccessException;

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

        return jdbcTemplate.query(sql, new Object[]{phone}, new RowMapper<OrderdetailView>() {
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

    @Override
    public List<OrderdetailView> findAllOrder() {
        String sql = "SELECT * FROM ("
                + "    SELECT *, ROW_NUMBER() OVER (ORDER BY orderDate DESC) AS row_num "
                + "    FROM orders "
                + ") AS subquery "
                + "INNER JOIN ("
                + "    SELECT "
                + "        PIs.picture, "
                + "        O.orderID,  "
                + "        O.orderDate,  "
                + "        O.deliveryDate,  "
                + "        O.shipAddress,  "
                + "        M.memberName,"
                + "        O.status,  "
                + "        P.paymentName,  "
                + "        D.deliveryName,  "
                + "        PIS.productName,  "
                + "        PIS.productID,  "
                + "        PIS.price,  "
                + "        PID.quantity, "
                + "        M.phone "
                + "    FROM   "
                + "        orders O  "
                + "    JOIN   "
                + "        payments P ON O.paymentID = P.paymentID  "
                + "    JOIN   "
                + "        deliveries D ON O.deliveryID = D.deliveryID  "
                + "    JOIN   "
                + "        members M ON O.phone = M.phone  "
                + "    JOIN   "
                + "        purchasingInvoices PID ON O.orderID = PID.orderID  "
                + "    JOIN   "
                + "        products PIS ON PID.productID = PIS.productID  "
                + ") AS main_query ON subquery.orderID = main_query.orderID "
                + "WHERE "
                + "    subquery.row_num BETWEEN (SELECT COUNT(*) FROM orders) - 4 AND (SELECT COUNT(*) FROM orders) "
                + "ORDER BY "
                + "    subquery.orderDate DESC;";

        return jdbcTemplate.query(sql, new RowMapper<OrderdetailView>() {
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
                orderInfo.setMemberName(rs.getString("memberName"));
                return orderInfo;
            }
        });
    }

    @Override
    public List<OrderDeatail> getAllOrderDetails() {
        String sql = "SELECT "
                + "    o.orderID, "
                + "    o.orderDate, "
                + "    o.deliveryDate, "
                + "    o.shipAddress, "
                + "    o.status, "
                + "    o.paymentID, "
                + "    o.deliveryID, "
                + "    o.phone, "
                + "    p.productID, "
                + "    p.price, "
                + "    p.quantity "
                + "FROM "
                + "    orders o "
                + "JOIN "
                + "    purchasingInvoices p ON o.orderID = p.orderID";

        return jdbcTemplate.query(sql, new RowMapper<OrderDeatail>() {
            @Override
            public OrderDeatail mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderDeatail orderDetail = new OrderDeatail();
                orderDetail.setOrderID(rs.getInt("orderID"));
                orderDetail.setOrderDate(rs.getTimestamp("orderDate"));
                orderDetail.setDeliveryDate(rs.getTimestamp("deliveryDate"));
                orderDetail.setShipAddress(rs.getString("shipAddress"));
                orderDetail.setStatus(rs.getString("status"));
                orderDetail.setPaymentID(rs.getInt("paymentID"));
                orderDetail.setDeliveryID(rs.getInt("deliveryID"));
                orderDetail.setPhone(rs.getString("phone"));
                orderDetail.setProductID(rs.getInt("productID"));
                orderDetail.setPrice(rs.getDouble("price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                return orderDetail;
            }
        });
    }

    @Override
    public void updateOrder(int orderID, int productID, int quantity, String shipAddress) {
        String updateQuantitySql = "UPDATE purchasingInvoices SET quantity = ? WHERE orderID = ? AND productID = ?";
        String updateAddressSql = "UPDATE orders SET shipAddress = ? WHERE orderID = ?";
        jdbcTemplate.update(updateQuantitySql, quantity, orderID, productID);
        jdbcTemplate.update(updateAddressSql, shipAddress, orderID);
    }

    @Override
    public void deleteOrder(int orderID) {
        String deleteInvoicesSql = "DELETE FROM purchasingInvoices WHERE orderID = ?";
        String deleteOrderSql = "DELETE FROM orders WHERE orderID = ?";
        jdbcTemplate.update(deleteInvoicesSql, orderID);
        jdbcTemplate.update(deleteOrderSql, orderID);
    }

    @Override
    public List<OrderDeatail> searchOrdersByPhoneNumber(String phoneNumber) {
        String searchSql = "SELECT "
                + "o.orderID, "
                + "o.orderDate, "
                + "o.deliveryDate, "
                + "o.shipAddress, "
                + "o.status, "
                + "o.paymentID, "
                + "o.deliveryID, "
                + "o.phone, "
                + "pi.productID, "
                + "pi.price, "
                + "pi.quantity "
                + "FROM orders o "
                + "JOIN purchasingInvoices pi ON o.orderID = pi.orderID "
                + "WHERE o.phone LIKE ?";

        return jdbcTemplate.query(searchSql, new Object[]{"%" + phoneNumber + "%"}, new RowMapper<OrderDeatail>() {
            @Override
            public OrderDeatail mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderDeatail orderDetail = new OrderDeatail();
                orderDetail.setOrderID(rs.getInt("orderID"));
                orderDetail.setOrderDate(rs.getTimestamp("orderDate"));
                orderDetail.setDeliveryDate(rs.getTimestamp("deliveryDate"));
                orderDetail.setShipAddress(rs.getString("shipAddress"));
                orderDetail.setStatus(rs.getString("status"));
                orderDetail.setPaymentID(rs.getInt("paymentID"));
                orderDetail.setDeliveryID(rs.getInt("deliveryID"));
                orderDetail.setPhone(rs.getString("phone"));
                orderDetail.setProductID(rs.getInt("productID"));
                orderDetail.setPrice(rs.getDouble("price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                return orderDetail;
            }
        });
    }

    @Override
    public OrderDeatail getOrderDetail(int orderID) {
        String sql = "SELECT "
                + "o.orderID, "
                + "o.orderDate, "
                + "o.deliveryDate, "
                + "o.shipAddress, "
                + "o.status, "
                + "o.paymentID, "
                + "o.deliveryID, "
                + "o.phone, "
                + "pi.productID, "
                + "pi.price, "
                + "pi.quantity "
                + "FROM orders o "
                + "JOIN purchasingInvoices pi ON o.orderID = pi.orderID "
                + "WHERE o.orderID = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{orderID}, new RowMapper<OrderDeatail>() {
                @Override
                public OrderDeatail mapRow(ResultSet rs, int rowNum) throws SQLException {
                    OrderDeatail orderDetail = new OrderDeatail();
                orderDetail.setOrderID(rs.getInt("orderID"));
                orderDetail.setOrderDate(rs.getTimestamp("orderDate"));
                orderDetail.setDeliveryDate(rs.getTimestamp("deliveryDate"));
                orderDetail.setShipAddress(rs.getString("shipAddress"));
                orderDetail.setStatus(rs.getString("status"));
                orderDetail.setPaymentID(rs.getInt("paymentID"));
                orderDetail.setDeliveryID(rs.getInt("deliveryID"));
                orderDetail.setPhone(rs.getString("phone"));
                orderDetail.setProductID(rs.getInt("productID"));
                orderDetail.setPrice(rs.getDouble("price"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                return orderDetail;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            // Xử lý trường hợp không tìm thấy đơn hàng
            return null;
        }

    }
}
