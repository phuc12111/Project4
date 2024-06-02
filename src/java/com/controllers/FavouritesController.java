package com.controllers;

import com.models.Categories;
import com.models.Favouritead;
import com.models.Favourites;
import com.models.FavouritesMember;
import com.models.Login;
import com.models.Product;
import com.servlets.CartDAO;
import com.servlets.CategoryDAO;
import com.servlets.FavouritesDAO;
import com.servlets.LoginDAO;
import com.servlets.ProductDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "add/{productID}/{phone}", method = RequestMethod.GET)
    public String addFavourite(ModelMap mm, HttpSession session,
            @PathVariable("productID") int productID,
            @PathVariable("phone") String phone) {

        Login user = loginDAO.findByUser(phone);
        Product product = cartDAO.findById(productID);
        List<com.models.Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);
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

    @RequestMapping(value = "viewfavourites/{phone}", method = RequestMethod.GET)
    public String viewFavourites(ModelMap mm, HttpSession session, @PathVariable("phone") String phone) {
        try {
            Login user = loginDAO.findByUser(phone);
            if (user == null) {
                mm.addAttribute("message", "Qui khach chua dang nhap");
                return "favourites"; // Redirect to the favourites page with a message
            } else {
                List<Favourites> favouritesList = favouritesDAO.selectFavourites(phone);
                mm.addAttribute("favouritesList", favouritesList);
                session.setAttribute("login", user);
                List<com.models.Categories> cate = categoryDAO.findAll();
                mm.addAttribute("cate", cate);
                return "favourites";
            }
        } catch (EmptyResultDataAccessException e) {
            mm.addAttribute("message", "User not found or no favourites found.");
            return "favourites"; // Redirect to the favourites page with an error message
        }
    }

    @RequestMapping(value = "delete/{phone}/{productID}", method = RequestMethod.GET)
    public String deleteFavourite(ModelMap mm, @PathVariable("phone") String phone, @PathVariable("productID") int productID) {

        Login user = loginDAO.findByUser(phone);

        if (user == null) {
            mm.addAttribute("message", "User not found. Please log in.");
            return "favourites";
        }

        favouritesDAO.deleteFavourites(phone, productID);

        // After deletion, retrieve the updated list of favourites
        List<Favourites> favouritesList = favouritesDAO.selectFavourites(phone);
        mm.addAttribute("favouritesList", favouritesList);
        mm.addAttribute("successfully", "Favourite item deleted successfully!");

        return "favourites";
    }

    @RequestMapping(value = "viewfa", method = RequestMethod.GET)
    public String viewfa(ModelMap mm, HttpSession session) {

        List<FavouritesMember> listfa = favouritesDAO.get();
        mm.addAttribute("listfa", listfa);

        List<Favouritead> faadmin = favouritesDAO.getTopFavourites();
        mm.addAttribute("faadmin", faadmin);

        return "favouritesad";

    }

    @RequestMapping(value = "editFavouriteForm", method = RequestMethod.GET)
    public String showEditFavouriteForm(@RequestParam("favouriteID") String id, ModelMap mm) {
        Favourites favourite = favouritesDAO.getbyid(id);
        mm.addAttribute("favourite", favourite);
        return "edit_favourites";
    }

    @RequestMapping(value = "updateFavourite", method = RequestMethod.POST)
    public String updateFavourite(@ModelAttribute("favourite") Favourites favourite, ModelMap mm) {
        favouritesDAO.update(favourite);
        List<FavouritesMember> listfa = favouritesDAO.get();
        mm.addAttribute("listfa", listfa);
        return "favouritesad";
    }

    @RequestMapping(value = "deleteFavourite/{favouriteID}", method = RequestMethod.GET)
    public String deleteFavourite(@PathVariable("favouriteID") int favouriteID, ModelMap mm) {
        favouritesDAO.delete(favouriteID);
        List<FavouritesMember> listfa = favouritesDAO.get();
        mm.addAttribute("listfa", listfa);
        return "favouritesad";
    }

    @RequestMapping(value = "searchFavourites", method = RequestMethod.GET)
    public String searchFavourites(@RequestParam("productName") String productName, ModelMap mm) {
        List<FavouritesMember> listfa = favouritesDAO.search(productName);
        mm.addAttribute("listfa", listfa);
        return "favouritesad";
    }

    @ModelAttribute("favourite")
    public Favourites setFavouriteForm() {
        return new Favourites();
    }

    @RequestMapping(value = "addcate/{productID}/{phone}/{categoryID}", method = RequestMethod.GET)
    public String addFavouritecate(ModelMap mm, HttpSession session,
            @PathVariable("productID") int productID,
            @PathVariable("categoryID") int categoryID,
            @PathVariable("phone") String phone) {

        // Fetch user by phone
        Login user = loginDAO.findByUser(phone);
        if (user == null) {
            mm.addAttribute("message", "User not found!");
            return "error"; // Return an error view or appropriate response
        }

        // Fetch product by ID
        Product product = cartDAO.findById(productID);
        if (product == null) {
            mm.addAttribute("message", "Product not found!");
            return "error"; // Return an error view or appropriate response
        }

        // Create and set values for Favourites object
        Favourites favourites = new Favourites();
        favourites.setProductName(product.getProductName());
        favourites.setPrice(product.getPrice());
        favourites.setPicture(product.getPicture());
        favourites.setPhone(user.getPhone());
        favourites.setProductID(productID);

        // Save the favourite
        favouritesDAO.createFavourites(favourites);

        // Add attributes to model
        List<Product> listPro = productDAO.findAll();
        mm.addAttribute("listPro", listPro);
        mm.addAttribute("message", "Favourite added successfully!");

        List<Product> pro = categoryDAO.findAllpro(categoryID);
        mm.addAttribute("pro", pro);

        List<Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);

        Categories catedal = categoryDAO.findById(categoryID);
        mm.addAttribute("catedal", catedal);

        return "detailCategory";
    }

}
