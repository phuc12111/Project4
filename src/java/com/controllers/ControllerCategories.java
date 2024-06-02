package com.controllers;

import com.models.Albums;
import com.models.Categories;
import com.models.Product;
import com.servlets.AlbumsDAO;
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
    
     @Autowired
    private AlbumsDAO albumsDAO;

    @RequestMapping(value = "detail/{categoryID}", method = RequestMethod.GET)
    public String viewCategoryDetail(ModelMap mm, HttpSession session, @PathVariable("categoryID") int categoryID) {
        List<Product> pro = categoryDAO.findAllpro(categoryID);
        mm.addAttribute("pro", pro);
        List<com.models.Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);
        Categories catedal = categoryDAO.findById(categoryID);
        mm.addAttribute("catedal", catedal);
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
           
            List<Albums> albumsList = albumsDAO.selectAlbums(phone);
            mm.addAttribute("albums", albumsList);
        } 
        
        return "detailCategory";
    }
}
