package com.controllers;

import com.models.Albums;
import com.models.Cart;
import com.models.Supplier;
import com.servlets.AlbumdetailsDAOiml;
import com.servlets.AlbumsDAO;
import com.servlets.CategoryDAO;
import com.servlets.LoginDAO;
import com.servlets.ProductDAO;
import com.servlets.SupplierDAO;
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

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private AlbumsDAO albumsDAO;

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private AlbumdetailsDAOiml albumdetailsDAOiml;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String showShipper(ModelMap model, HttpSession session) {
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);
            List<Albums> albumsList = albumsDAO.selectAlbums(phone);
            model.addAttribute("albums", albumsList);
        }
        List<com.models.Product> listPro = productDAO.findAll();
        model.addAttribute("listPro", listPro);

        List<Supplier> listSupplier = supplierDAO.findAll();
        model.addAttribute("listSupplier", listSupplier);

        List<com.models.Categories> cate = categoryDAO.findAll();
        model.addAttribute("cate", cate);
        return "index";

    }

}
