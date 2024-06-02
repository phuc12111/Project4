package com.controllers;

import com.models.OrderdetailView;
import com.models.Login;
import com.models.OrderDeatail;
import com.models.Orders;
import com.models.PurchasingInvoices;
import com.servlets.CategoryDAO;
import com.servlets.LoginDAO;
import com.servlets.ViewOrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "order")
public class ViewOrderDetailController {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ViewOrderDAO viewOrderDAO;

    @Autowired
    private LoginDAO loginDAO;

    @RequestMapping(value = "detail/{phone}", method = RequestMethod.GET)
    public String viewOrderDetail(@PathVariable("phone") String phone, ModelMap mm, HttpSession session) {
        try {
            List<com.models.Categories> cate = categoryDAO.findAll();
            mm.addAttribute("cate", cate);
            Login user = loginDAO.findPhone(phone);
            if (user == null) {
                mm.addAttribute("ordererror", "Bạn cần đăng nhập.");
                return "order_deatail";  // Ensure this JSP file name is correct
            } else {
                List<Orders> orderDetails = viewOrderDAO.getAllOrder(phone);
                mm.addAttribute("orderDetails", orderDetails);
                return "order_deatail";  // Ensure this JSP file name is correct
            }
        } catch (Exception e) {
            System.out.println("Error in viewOrderDetail: " + e.getMessage());
            e.printStackTrace();
            mm.addAttribute("ordererror", "An unexpected error occurred.");
            return "order_deatail";  // Ensure this JSP file name is correct
        }
    }

    @RequestMapping(value = "detailpro/{orderID}", method = RequestMethod.GET)
    public String viewOrderDetailPro(@PathVariable("orderID") int orderID, ModelMap mm, HttpSession session) {

        List<com.models.Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);

        List<PurchasingInvoices> orderDetails = viewOrderDAO.getAllPur(orderID);
        mm.addAttribute("orderDetails", orderDetails);
        return "order_deatail_pro";  

    }

    @RequestMapping(value = "orderde", method = RequestMethod.GET)
    public String viewOrder(ModelMap mm, HttpSession session) {

        List<OrderDeatail> order = viewOrderDAO.getAllOrderDetails();
        mm.addAttribute("order", order);
        return "orderad";
    }

    @RequestMapping(value = "delete/{orderID}", method = RequestMethod.GET)
    public String deleteOrderDetail(@PathVariable("orderID") int orderID, ModelMap mm) {
        try {
            viewOrderDAO.deleteOrder(orderID);
            mm.addAttribute("message", "Order deleted successfully.");
        } catch (Exception e) {
            mm.addAttribute("error", "Error deleting order: " + e.getMessage());
        }
        List<OrderDeatail> order = viewOrderDAO.getAllOrderDetails();
        mm.addAttribute("order", order);
        return "orderad";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchOrder(@RequestParam("phoneNumber") String phoneNumber, ModelMap model) {
        List<OrderDeatail> orderDetails = viewOrderDAO.searchOrdersByPhoneNumber(phoneNumber);
        if (orderDetails.isEmpty()) {
            model.addAttribute("error", "No orders found for the given phone number.");
        } else {
            model.addAttribute("order", orderDetails);
        }
        return "orderad";
    }

    @RequestMapping(value = "showupdate/{orderID}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("orderID") int orderID, ModelMap model) {

        OrderDeatail orderDetail = viewOrderDAO.getOrderDetail(orderID);
        model.addAttribute("orderDetail", orderDetail);
        return "orderupdate";
    }

    @RequestMapping(value = "update/{orderID}", method = RequestMethod.POST)
    public String processUpdateForm(@PathVariable("orderID") int orderID,
            @RequestParam("productID") int productID,
            @RequestParam("quantity") int quantity,
            @RequestParam("shipAddress") String shipAddress,
            ModelMap model) {
        try {
            viewOrderDAO.updateOrder(orderID, productID, quantity, shipAddress);
            model.addAttribute("message", "Order updated successfully.");
        } catch (Exception e) {
            model.addAttribute("error", "Error updating order: " + e.getMessage());
        }
        List<OrderDeatail> order = viewOrderDAO.getAllOrderDetails();
        model.addAttribute("order", order);
        return "orderad";
    }
}
