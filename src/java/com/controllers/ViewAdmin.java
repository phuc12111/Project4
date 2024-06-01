/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Admins;
import com.models.OrderdetailView;
import com.servlets.AdminDAO;
import com.servlets.ViewOrderDAO;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("admin")
public class ViewAdmin {

    @Autowired
    private ViewOrderDAO viewOrderDAO;

    @Autowired
    private AdminDAO adminDAO;

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String showShipper(ModelMap model) {
        List<OrderdetailView> orderList = viewOrderDAO.findAllOrder();
        model.addAttribute("orderList", orderList);
        return "indexad";
    }

    @RequestMapping(value = "deleteAdmins", method = RequestMethod.GET)
    public String deleteShipper(String adminID, ModelMap model) {
        adminDAO.delete(adminID);
        List<Admins> adminList = adminDAO.findAll();
        model.addAttribute("adminList", adminList);
        return "manageadmin";
    }

    @RequestMapping(value = "findAdmins", method = RequestMethod.GET)
    public String findAdmins(String keyword, ModelMap model) {
        List<Admins> listAdmins = adminDAO.find(keyword);
        model.addAttribute("adminList", listAdmins);
        return "manageadmin";
    }

    @RequestMapping(value = "showAddAdminsForm", method = RequestMethod.GET)
    public String showAddAdminsForm() {
        return "add_admin";
    }

    @ModelAttribute("admin")
    public Admins setAdminsForm() {
        return new Admins();
    }

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(value = "addAdmins", method = RequestMethod.POST)
    public String addAdmins(@ModelAttribute("admin") Admins admin,
            @RequestParam("image") MultipartFile file,
            ModelMap model) {

        admin.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        if (!file.isEmpty()) {
            try {

                String fileName = file.getOriginalFilename();

                String savedFileName = "img/products/" + fileName;
                String realPath = servletContext.getRealPath("/");
                Path filePath = Paths.get(realPath, savedFileName);
                Files.write(filePath, file.getBytes());

                admin.setAvatar(savedFileName);
            } catch (IOException e) {

                model.addAttribute("error", "Failed to upload image: " + e.getMessage());
                return "manageadmin";
            }
        }

        adminDAO.add(admin);
        List<Admins> adminList = adminDAO.findAll();
        model.addAttribute("adminList", adminList);
        return "manageadmin";
    }

    @RequestMapping(value = "showUpdate", method = RequestMethod.GET)
    public String showUpdateAdminsForm(@RequestParam("id") String id, ModelMap model) {
        Admins adm = adminDAO.get(id);
        model.addAttribute("adm", adm);
        return "adminUpdate";
    }

    @RequestMapping(value = "updateAdmin", method = RequestMethod.POST)
    public String updateAdmin(@ModelAttribute("adm") Admins admin, @RequestParam("image") MultipartFile file, ModelMap model) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                String savedFileName = "img/products/" + fileName;
                String realPath = servletContext.getRealPath("/");
                Path filePath = Paths.get(realPath, savedFileName);
                Files.write(filePath, file.getBytes());

                admin.setAvatar(savedFileName);
            }
            adminDAO.update(admin);
            model.addAttribute("success", "Admin updated successfully");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update admin");
        }
        List<Admins> adminList = adminDAO.findAll();
        model.addAttribute("adminList", adminList);
        return "manageadmin";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, ModelMap model) {
        session.removeAttribute("admin");
        List<Admins> adminList = adminDAO.findAll();
        model.addAttribute("adminList", adminList);
        return "manageadmin";
    }

}
