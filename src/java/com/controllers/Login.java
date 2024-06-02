/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Admins;
import com.models.Albums;
import com.models.OrderdetailView;
import com.servlets.AdminDAO;
import com.servlets.AlbumsDAO;
import com.servlets.CategoryDAO;

import com.servlets.LoginDAO;
import com.servlets.ProductDAO;
import com.servlets.ViewOrderDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class Login {

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private AlbumsDAO albumsDAO;

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private ViewOrderDAO viewOrderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AdminDAO adminDAO;

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
            if (loggedInUser != null) {
                List<com.models.Product> listPro = productDAO.findAll();
                model.addAttribute("listPro", listPro);
                model.addAttribute("login", loggedInUser);
                List<Albums> albumsList = albumsDAO.selectAlbums(phone);
                model.addAttribute("albums", albumsList);
                List<com.models.Categories> cate = categoryDAO.findAll();
                model.addAttribute("cate", cate);
                return "index";
            }
        } else {
            com.models.Admins adminLogin = loginDAO.loginadmin(phone, password);
            if (adminLogin != null) {
                session.setAttribute("adminLogin", adminLogin);
                com.models.Admins loggedAdmin = loginDAO.findByAdmin(phone);
                if (loggedAdmin != null) {
                    List<OrderdetailView> orderList = viewOrderDAO.findAllOrder();
                    model.addAttribute("orderList", orderList);
                    model.addAttribute("admin", loggedAdmin);

                    int roleID = loggedAdmin.getRoleID();

                    if (roleID == 3) {
                        return "indexad";
                    } else if (roleID == 2) {
                        List<Admins> adminList = adminDAO.findAll();
                        model.addAttribute("adminList", adminList);
                        return "manageadmin";
                    } else {
                        return "404";
                    }
                }
            }
            model.addAttribute("error", "Invalid username or password");
            return "account";
        }
        return "account";
    }

    @GetMapping("home")
    public String home(HttpSession session, ModelMap model) {
        com.models.Login login = (com.models.Login) session.getAttribute("login");
        if (login != null) {
            List<com.models.Product> listPro = productDAO.findAll();
            model.addAttribute("listPro", listPro);
            model.addAttribute("login", login);
            List<Albums> albumsList = albumsDAO.selectAlbums(login.getPhone());
            model.addAttribute("albums", albumsList);
            List<com.models.Categories> cate = categoryDAO.findAll();
            model.addAttribute("cate", cate);
        } else {
            List<com.models.Product> listPro = productDAO.findAll();
            model.addAttribute("listPro", listPro);
            List<com.models.Categories> cate = categoryDAO.findAll();
            model.addAttribute("cate", cate);
        }
        return "index"; // Tên của trang JSP cho trang chủ
    }

}
