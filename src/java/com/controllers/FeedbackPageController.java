/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.FeedbackPage;
import com.servlets.FeedbackPageDAO;
import com.servlets.LoginDAO;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/feedbackPage")
public class FeedbackPageController {
    
    @Autowired
    private LoginDAO loginDAO;
    
    @Autowired
    private FeedbackPageDAO feedbackPageDAO;
    
    @RequestMapping(value = "/addFeedbackPage", method = RequestMethod.POST)
    public String addFeedbackPage(ModelMap model, @RequestParam("phone") String phone, @RequestParam("contentFeedbackPage") String content){
        
//        com.models.Login user = loginDAO.findByUser(phone);
        
        FeedbackPage feedbackPage = new FeedbackPage();
        feedbackPage.setPhone(phone);
        feedbackPage.setContent(content);
        feedbackPage.setCreatedAt(new Timestamp(new Date().getTime()));
        feedbackPageDAO.addFeedbackPage(feedbackPage);
        model.addAttribute("messageFBP", "Your feedback added successfully!");
        return "index";
    }
    
}
