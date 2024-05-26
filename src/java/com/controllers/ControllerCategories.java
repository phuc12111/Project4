package com.controllers;

import com.models.Categories;
import com.models.Product;
import com.servlets.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "category")
public class ControllerCategories {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "detail/{categoryID}", method = RequestMethod.GET)
    public String viewCategoryDetail(ModelMap mm, HttpSession session, @PathVariable("categoryID") int categoryID) {
        List<Product> pro = categoryDAO.findAllpro(categoryID);
        mm.addAttribute("pro", pro);
        List<com.models.Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);
        return "listing-grid_1_full";
    }
}
