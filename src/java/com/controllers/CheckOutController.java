package com.controllers;

import com.models.Cart;
import com.models.Orders;
import com.models.PurchasingInvoices;
import com.servlets.CheckoutDAO;
import com.servlets.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping(value = "check")
public class CheckOutController {

    @Autowired
    private CheckoutDAO checkoutDAO;

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String viewCheckout(ModelMap mm, HttpSession session,
            @RequestParam("deliveryID") int deliveryID,
            @RequestParam("status") int status,
            @RequestParam("shipAddress") String shipAddress,
            @RequestParam("total") double total,
            @RequestParam("phone") String phone) {

       
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null || cartItems.isEmpty()) {
            mm.addAttribute("error", "Your cart is empty.");
            return "error";
        }

        
        if (shipAddress == null || shipAddress.isEmpty() || phone == null || phone.isEmpty()) {
            mm.addAttribute("error", "Invalid input parameters.");
            return "error";
        }

        
        Orders order = new Orders();
        
       LocalDate today = LocalDate.now();
        order.setOrderDate(today);

        Calendar deliveryCalendar = Calendar.getInstance();
        deliveryCalendar.add(Calendar.DATE, 3); 
        order.setDeliveryDate(new Timestamp(deliveryCalendar.getTimeInMillis()));
        order.setShipAddress(shipAddress);
        order.setPhone(phone);
        order.setTotal(total);
        order.setPaymentID(status);
        order.setDeliveryID(deliveryID);
        order.setStatus("Wait for confirmation");

        
        int orderId = checkoutDAO.createOrder(order);
        List<PurchasingInvoices> purchasingInvoicesList = new ArrayList<>();
        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
            Cart cart = entry.getValue();
            PurchasingInvoices purchasingInvoices = new PurchasingInvoices();
            purchasingInvoices.setOrderID(orderId);
            purchasingInvoices.setProductID(cart.getProduct().getProductID());
            purchasingInvoices.setPrice(cart.getProduct().getPrice());
            purchasingInvoices.setQuantity(cart.getQuantity());
            purchasingInvoicesList.add(purchasingInvoices);
        }
        checkoutDAO.createOrderDetails(purchasingInvoicesList, orderId);

        // Clear cart session attributes
        session.removeAttribute("myCartItems");
        session.setAttribute("myCartTotal", 0.0);
        session.setAttribute("myCartNum", 0);

        // Redirect based on payment status
        if (status == 1) {
            List<com.models.Product> listPro = productDAO.findAll();
            mm.addAttribute("listPro", listPro);
            return "index";
        } else if (status == 2) {
            return "confirm";
        } else {
            return "help";
        }
    }
}
