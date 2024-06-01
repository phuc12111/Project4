/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Payment;
import com.servlets.PayDAO;
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
@RequestMapping(value = "pay")
public class PaymentController {

    @Autowired
    private PayDAO payDAO;

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String viewPayments(ModelMap model) {
        List<Payment> payments = payDAO.getAllPayments();
        model.addAttribute("payments", payments);
        return "paymentsad";
    }

    @RequestMapping(value = "delete/{paymentID}", method = RequestMethod.GET)
    public String deletePayment(@PathVariable("paymentID") int paymentID, ModelMap model) {
        try {
            payDAO.deletePayment(paymentID);
            model.addAttribute("message", "Order deleted successfully.");
        } catch (Exception e) {
            model.addAttribute("error", "Error deleting order: " + e.getMessage());
        }
        List<Payment> payments = payDAO.getAllPayments();
        model.addAttribute("payments", payments);
        return "paymentsad";
    }

    @RequestMapping(value = "update/{paymentID}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("paymentID") int paymentID, ModelMap mm) {
        Payment payment = payDAO.getPaymentByID(paymentID);
        mm.addAttribute("payment", payment);
        return "payupdate";
    }

    @RequestMapping(value = "update/{paymentID}", method = RequestMethod.POST)
    public String updatePayment(@PathVariable("paymentID") int paymentID, Payment payment, ModelMap mm) {
        payDAO.updatePayment(payment);
        List<Payment> payments = payDAO.getAllPayments();
        mm.addAttribute("payments", payments);
        return "paymentsad";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchPayment(@RequestParam("paymentName") String paymentName, ModelMap model) {
        List<Payment> payments = payDAO.searchPaymentsByPaymentName(paymentName);
        model.addAttribute("payments", payments);
        return "paymentsad";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String showAddPaymentForm(ModelMap model) {
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "payadd";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPayment(@ModelAttribute("payment") Payment payment, ModelMap model) {
        try {
            payDAO.addPayment(payment);
            List<Payment> payments = payDAO.getAllPayments();
            model.addAttribute("payments", payments);
            model.addAttribute("payments", payments);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error adding payment: " + e.getMessage());
        }
        return "paymentsad";
    }
}
