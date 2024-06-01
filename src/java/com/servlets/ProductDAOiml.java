package com.servlets;

import com.models.Albumdetails;
import com.models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductDAOiml implements ProductDAO {
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    
    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        List<Product> pro = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            Product obj = new Product();
            obj.setProductID((int) row.get("ProductID"));
            obj.setProductName((String) row.get("ProductName"));
            obj.setDescription((String) row.get("Description"));
            obj.setPicture((String) row.get("Picture"));

            obj.setPrice((Double) row.get("Price"));
            obj.setSale((Double) row.get("Sale"));

            obj.setCreatedAt((Timestamp) row.get("CreatedAt"));
            obj.setUpdatedAt((Timestamp) row.get("UpdatedAt"));

            obj.setTotalStars((Double) row.get("TotalStars"));

            obj.setTotalFeedback((int) row.get("TotalFeedback"));
            obj.setTotalOrder((int) row.get("TotalOrder"));
            obj.setAudioFile((String) row.get("AudioFile"));
            pro.add(obj);
        }
        return pro;
    }
    @Override
    public List<Albumdetails> getProductDetails(int albumID) {
        String sql = "SELECT ad.albumID, p.productID, p.productName, p.audioFile " +
                     "FROM products p " +
                     "JOIN albumDetails ad ON p.productID = ad.productID " +
                     "WHERE ad.albumID = ?";
        
        return jdbcTemplate.query(sql, new Object[]{albumID}, new RowMapper<Albumdetails>() {
            @Override
            public Albumdetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                Albumdetails alb = new Albumdetails();
                alb.setAlbumID(rs.getInt("albumID"));  // Lấy albumID từ kết quả truy vấn
                alb.setProductID(rs.getInt("productID"));
                alb.setProductName(rs.getString("productName"));
                alb.setAudioFile(rs.getString("audioFile"));
                return alb;
            }
        });
    }
}