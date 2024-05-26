/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.FeedbackPage;
import java.util.List;

/**
 *
 * @author admin
 */
public interface FeedbackPageDAO {
    public List<FeedbackPage> findAll();
    public List<FeedbackPage> find(String keyword);
    public void addFeedbackPage(FeedbackPage feedbackPage);
    
}
