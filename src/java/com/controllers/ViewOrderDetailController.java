package com.controllers;

import com.models.OrderdetailView;
import com.models.Login;
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

@Controller
@RequestMapping(value = "order")
public class ViewOrderDetailController {

    @Autowired
    private ViewOrderDAO viewOrderDAO;
    
    @Autowired
    private LoginDAO loginDAO;

    @RequestMapping(value = "detail/{phone}", method = RequestMethod.GET)
    public String viewOrderDetail(@PathVariable("phone") String phone, ModelMap mm, HttpSession session) {
        
        Login user = loginDAO.findPhone(phone);

        if (user == null) {
            mm.addAttribute("ordererror", "Bạn cần đăng nhập.");
            return "order_deatail";
        } else {
            List<OrderdetailView> orderDetails = viewOrderDAO.getAllOrderInfo(phone);
            mm.addAttribute("orderDetails", orderDetails);
            return "order_deatail";
        }
    }
}
