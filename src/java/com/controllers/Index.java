package com.controllers;



import com.models.Cart;
import com.servlets.ProductDAO;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class Index {
    
    @Autowired
    private ProductDAO productDAO;
    
    
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String showShipper(ModelMap model) {
        List<com.models.Product> listPro = productDAO.findAll();
        model.addAttribute("listPro", listPro);
        return "index";
    }
    
}
