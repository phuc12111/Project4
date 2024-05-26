/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Cart;
import com.models.ListAlbum;
import com.models.Product;
import com.servlets.CartDAO;
import com.servlets.LoginDAO;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "list")
public class ListAlbumController {

    @Autowired
    private CartDAO cartDAO;
    
    @Autowired
    private LoginDAO loginDAO;

    @RequestMapping(value = "addAlbum/{productID}", method = RequestMethod.GET)
    public String addToCart(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {
        HashMap<Integer, ListAlbum> cartItems = (HashMap<Integer, ListAlbum>) session.getAttribute("myAlbumItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = cartDAO.findById(productID);

        ListAlbum item = cartItems.get(productID);
        if (item == null) {
            item = new ListAlbum();
            item.setProduct(product);
            cartItems.put(productID, item);
        }
        updateSessionAttributes(session, cartItems);
        return "redirect:/index.htm";
    }

    private void updateSessionAttributes(HttpSession session, HashMap<Integer, ListAlbum> cartItems) {
        session.setAttribute("myAlbumItems", cartItems);
    }
    
    @RequestMapping(value = "showAlbum", method = RequestMethod.GET)
    public String showAlbum(ModelMap model, HttpSession session){
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);
            model.addAttribute("login", login);
            return "albums";
        } else {
            return "albums";
        }
    }
}
