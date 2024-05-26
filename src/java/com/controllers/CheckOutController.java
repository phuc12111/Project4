/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Cart;
import com.models.Deliveries;
import com.models.Orders;
import com.models.PurchasingInvoices;
import com.servlets.CheckoutDAO;
import com.servlets.DeliveriesDAO;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "check")
public class CheckOutController {

    @Autowired
    private CheckoutDAO checkoutDAO;

    @Autowired
    private DeliveriesDAO deliveriesDAO;

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String viewCheckout(ModelMap mm, HttpSession session,
            @RequestParam("deliveryID") int deliveryID,
            @RequestParam("status") int status,
            @RequestParam("shipAddress") String shipAddress,
            @RequestParam("phone") String phone
    ) {

        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null || cartItems.isEmpty()) {
            mm.addAttribute("error", "Your cart is empty.");
            return "error";
        }

 
        Orders order = new Orders();
        Date currentDate = new Date();
        Timestamp orderTimestamp = new Timestamp(currentDate.getTime());
        order.setOrderDate(orderTimestamp);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, 3); // Thêm 3 ngày
        Date deliveryDate = calendar.getTime();
        Timestamp deliveryTimestamp = new Timestamp(deliveryDate.getTime());
        order.setDeliveryDate(deliveryTimestamp);

        order.setShipAddress(shipAddress);
        order.setPhone(phone);
        order.setPaymentID(status);
        order.setDeliveryID(deliveryID);

       
        if (status == 1) {
            order.setStatus("chưa thanh toán");
        } else if (status == 2) {
            order.setStatus("đã thanh toán");
        }

        
        int orderId = checkoutDAO.createOrder(order);

        
        List<PurchasingInvoices> purchasingInvoiceslist = new ArrayList<>();
        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            PurchasingInvoices purchasingInvoices = new PurchasingInvoices();
            purchasingInvoices.setOrderID(orderId);
            purchasingInvoices.setProductID(entry.getValue().getProduct().getProductID());
            purchasingInvoices.setPrice(entry.getValue().getProduct().getPrice());
            purchasingInvoices.setQuantity(entry.getValue().getQuantity());
            purchasingInvoiceslist.add(purchasingInvoices);
        }

        
        checkoutDAO.createOrderDetails(purchasingInvoiceslist, orderId);

       
        session.removeAttribute("myCartItems");
        session.setAttribute("myCartTotal", 0.0);
        session.setAttribute("myCartNum", 0);

        if (status == 1) {
            return "index";
        } else if (status == 2) {
            return "confirm";
        }

        return "help";
    }
}
