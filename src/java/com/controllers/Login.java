/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.servlets.LoginDAO;
import com.servlets.ProductDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class Login {

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String showcart() {
        return "account";
    }
@PostMapping("/alogin")
public String login(@ModelAttribute("phone") String phone, @ModelAttribute("password") String password, ModelMap model, HttpSession session) {
    com.models.Login login = loginDAO.login(phone, password);
    if (login != null) {
        session.setAttribute("login", login);
        com.models.Login loggedInUser = loginDAO.findByUser(phone);  
        if (loggedInUser != null){
            List<com.models.Product> listPro = productDAO.findAll();
            model.addAttribute("listPro", listPro);
            model.addAttribute("login", loggedInUser);  
            return "index";
        }
    } else {
        model.addAttribute("error", "Invalid username or password");
        return "account";
    }
    return "account";  
}

}
