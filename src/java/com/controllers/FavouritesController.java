package com.controllers;

import com.models.Favourites;
import com.models.Login;
import com.models.Product;
import com.servlets.CartDAO;
import com.servlets.FavouritesDAO;
import com.servlets.LoginDAO;
import com.servlets.ProductDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "favourites")
public class FavouritesController {

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private FavouritesDAO favouritesDAO;

    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private CartDAO cartDAO;

    @RequestMapping(value = "add/{productID}/{phone}", method = RequestMethod.GET)
    public String addFavourite(ModelMap mm, HttpSession session,
            @PathVariable("productID") int productID,
            @PathVariable("phone") String phone) {
        
        Login user = loginDAO.findByUser(phone);
        Product product = cartDAO.findById(productID);
        
        // Create and set values for Favourites object
        Favourites favourites = new Favourites();
        favourites.setProductName(product.getProductName());
        favourites.setPrice(product.getPrice());
        favourites.setPicture(product.getPicture());
        favourites.setPhone(user.getPhone());
        favourites.setProductID(productID);
        
        favouritesDAO.createFavourites(favourites);
        List<Product> listPro = productDAO.findAll();
        mm.addAttribute("listPro", listPro);
        mm.addAttribute("message", "Favourite added successfully!");
       
        return "index"; 
    }
    
    @RequestMapping(value = "viewfavourites{phone}", method = RequestMethod.GET)
    public String viewFavourites(ModelMap mm, HttpSession session,@PathVariable("phone") String phone) {
        Login user = loginDAO.findByUser(phone);
        if (user == null) {
            return "account"; 
        }
        
        List<Favourites> favouritesList =  favouritesDAO.selectFavourites(phone);
        mm.addAttribute("favouritesList", favouritesList);
        
        return "favourites"; 
    }
}
