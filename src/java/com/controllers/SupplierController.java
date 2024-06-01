/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Supplier;
import com.servlets.SupplierDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "supplier")
public class SupplierController {
    
    @Autowired
    private SupplierDAO supplierDAO;
    
    @Autowired
    private ServletContext servletContext;
    
    @ModelAttribute("supplier")
    public Supplier setSupplierForm() {
        return new Supplier();
    }
    
    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String showSuppliers(ModelMap model) {
        List<Supplier> listSupplier = supplierDAO.findAll();
        model.addAttribute("listSupplier", listSupplier);
        return "supplierad";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddSupplierForm(ModelMap model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", new Supplier());
        return "add_supplier";
    }
    
    @RequestMapping(value = "addSupplier", method = RequestMethod.POST)
    public String addSupplier(@ModelAttribute("supplier") Supplier supplier,
            @RequestParam("picture") MultipartFile file,
            ModelMap model) {

        if (!file.isEmpty()) {
            try {

                String fileName = file.getOriginalFilename();

                String savedFileName = "img/suppliers/" + fileName;
                String realPath = servletContext.getRealPath("/");
                Path filePath = Paths.get(realPath, savedFileName);
                Files.write(filePath, file.getBytes());

                supplier.setPicture(savedFileName);
            } catch (IOException e) {

                model.addAttribute("error", "Failed to upload image: " + e.getMessage());
                return "add_supplier";
            }
        }

        supplierDAO.add(supplier);
        List<Supplier> listSupplier = supplierDAO.findAll();
        model.addAttribute("listSupplier", listSupplier);
        return "supplierad";
    }
    
    @RequestMapping(value = "update/{supplierID}", method = RequestMethod.GET)
    public String showUpdateSupplierForm(@PathVariable("supplierID") int id, ModelMap model) {
        Supplier supplier = supplierDAO.get(id);
        model.addAttribute("supplierByID", supplier);
        return "supplierUpdate";
    }
    
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateSupplierr(@ModelAttribute("supplier") Supplier supplier, @RequestParam("picture") MultipartFile file, ModelMap model) {
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                String savedFileName = "img/suppliers/" + fileName;
                String realPath = servletContext.getRealPath("/");
                Path filePath = Paths.get(realPath, savedFileName);
                Files.write(filePath, file.getBytes());

                supplier.setPicture(savedFileName);
            }
            supplierDAO.update(supplier);
            model.addAttribute("success", "Supplier updated successfully");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update supplier");
        }
        List<Supplier> listSupplier = supplierDAO.findAll();
        model.addAttribute("listSupplier", listSupplier);
        return "supplierad";
    }
    
    @RequestMapping(value = "delete/{supplierID}", method = RequestMethod.GET)
    public String deleteSupplier(@PathVariable("supplierID") int id, ModelMap model) {
        supplierDAO.delete(id);
        List<Supplier> listSupplier = supplierDAO.findAll();
        model.addAttribute("listSupplier", listSupplier);
        return "supplierad";
    }
    
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String findSupplier(String keyword, ModelMap model) {
        List<Supplier> listSupplier = supplierDAO.find(keyword);
        model.addAttribute("listSupplier", listSupplier);
        return "supplierad";
    }
}
