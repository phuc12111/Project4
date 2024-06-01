/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Deliveries;
import com.servlets.DeliveriesDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "ship")
public class DeliveriesController {

    @Autowired
    private DeliveriesDAO deliveriesDAO;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String showDeliveries(ModelMap model) {
        List<Deliveries> deliveries = deliveriesDAO.findAll();
        model.addAttribute("deliveries", deliveries);
        return "deliveriesad";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddDeliveryForm(ModelMap model) {
        Deliveries deliveries = new Deliveries();
        model.addAttribute("delivery", new Deliveries());
        return "deliveriesadd";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDelivery(@ModelAttribute("delivery") Deliveries delivery, ModelMap model) {
        deliveriesDAO.addDelivery(delivery);
        List<Deliveries> deliveries = deliveriesDAO.findAll();
        model.addAttribute("deliveries", deliveries);
        return "deliveriesad";
    }

    @RequestMapping(value = "edit/{deliveryID}", method = RequestMethod.GET)
    public String showEditDeliveryForm(@PathVariable("deliveryID") int deliveryID, ModelMap model) {
        Deliveries delivery = deliveriesDAO.findById(deliveryID);
        model.addAttribute("delivery", delivery);
        return "deliveriesupdate";
    }

    @RequestMapping(value = "edit/{deliveryID}", method = RequestMethod.POST)
    public String editDelivery(@PathVariable("deliveryID") int deliveryID, @ModelAttribute("delivery") Deliveries delivery, ModelMap model) {
        delivery.setDeliveryID(deliveryID);
        deliveriesDAO.updateDelivery(delivery);
        List<Deliveries> deliveries = deliveriesDAO.findAll();
        model.addAttribute("deliveries", deliveries);
        return "deliveriesad";
    }

    @RequestMapping(value = "delete/{deliveryID}", method = RequestMethod.GET)
    public String deleteDelivery(@PathVariable("deliveryID") int deliveryID, ModelMap model) {
        deliveriesDAO.deleteDelivery(deliveryID);
        List<Deliveries> deliveries = deliveriesDAO.findAll();
        model.addAttribute("deliveries", deliveries);
        return "deliveriesad";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchDelivery(@RequestParam("shipperName") String shipperName, ModelMap model) {
        List<Deliveries> deliveries = deliveriesDAO.searchDeliveriesByDeliveryName(shipperName);
        model.addAttribute("deliveries", deliveries);
        return "deliveriesad";
    }
}
