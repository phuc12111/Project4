/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlets;

import com.models.AlbumReview;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author admin
 */
public class AlbumReviewDAOImpl implements AlbumReviewDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public List<AlbumReview> findAll() {
        String sql = "select * from albumReviews ORDER BY albumReviewID DESC";
        List<AlbumReview> listAlbumReview = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            AlbumReview ar = new AlbumReview();
            ar.setAlbumReviewID((Integer) row.get("albumReviewID"));
            ar.setContent((String) row.get("content"));
            ar.setCreatedAt((String) row.get("createAt"));
            ar.setNumberStars((Integer) row.get("numberStars"));
            ar.setPhone((String) row.get("phone"));
            ar.setAlbumID((Integer) row.get("albumID"));

            listAlbumReview.add(ar);
        }
        return listAlbumReview;
    }

    @Override
    public void add(AlbumReview albumReview) {
        String sql = "INSERT INTO albumReviews VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, albumReview.getContent(), albumReview.getCreatedAt(), albumReview.getNumberStars(), albumReview.getPhone(), albumReview.getAlbumID());
    }

    @Override
    public void update(AlbumReview albumReview) {
        String sql = "UPDATE albumReviews SET content = ?, createdAt = ?, numberStars = ?, phone = ?, albumID = ? WHERE albumReviewID = ?";
        jdbcTemplate.update(sql, albumReview.getContent(), albumReview.getCreatedAt(), albumReview.getNumberStars(), albumReview.getPhone(), albumReview.getAlbumID(), albumReview.getAlbumReviewID());
    }

    @Override
    public AlbumReview get(int id) {
        String sql = "SELECT * FROM albumReviews WHERE albumReviewID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(AlbumReview.class));
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM albumReviews WHERE albumReviewID = ?";
        jdbcTemplate.update(sql, id);
    }

}
