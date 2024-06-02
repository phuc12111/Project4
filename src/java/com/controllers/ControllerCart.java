package com.controllers;

import com.models.Cart;
import com.models.Categories;
import com.models.Deliveries;
import com.models.Payment;
import com.models.Product;
import com.servlets.CartDAO;
import com.servlets.CategoryDAO;
import com.servlets.DeliveriesDAO;
import com.servlets.LoginDAO;
import com.servlets.PayDAO;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "cart")
public class ControllerCart {

    @Autowired
    private CartDAO cartDAO;

    @Autowired
    private DeliveriesDAO deliveriesDAO;

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private PayDAO payDAO;
    
     @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = "add/{productID}", method = RequestMethod.GET)
    public String addToCart(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = cartDAO.findById(productID);
        if (product != null) {
            Cart item = cartItems.get(productID);
            if (item == null) {
                item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productID, item);
            } else {
                item.setQuantity(item.getQuantity() + 1);
            }
        }
        updateSessionAttributes(session, cartItems);
        return "redirect:/index.htm";
    }

    @RequestMapping(value = "remove/{productID}", method = RequestMethod.GET)
    public String viewRemove(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {

        List<Deliveries> listde = deliveriesDAO.findAll();
        mm.addAttribute("listde", listde);
         List<com.models.Categories> cate = categoryDAO.findAll();
            mm.addAttribute("cate", cate);

        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(productID)) {
            cartItems.remove(productID);
        }
        updateSessionAttributes(session, cartItems);
        return "cart";
    }

    public double totalPrice(HashMap<Integer, Cart> cartItems) {
        double total = 0;
        for (Cart item : cartItems.values()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String showcart(ModelMap mm, HttpSession session) {
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        List<Deliveries> listde = deliveriesDAO.findAll();
        mm.addAttribute("listde", listde);
        List<Payment> pay = payDAO.getAllPayments();
        mm.addAttribute("pay", pay);
         List<com.models.Categories> cate = categoryDAO.findAll();
                mm.addAttribute("cate", cate);
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);

            mm.addAttribute("login", login);
            return "cart";

        } else {

            return "account";
        }
    }

    @RequestMapping(value = "cartship", method = RequestMethod.POST)
    public String showcartship(ModelMap mm, @RequestParam("shipperName") String shipperName, HttpSession session) {
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
         List<com.models.Categories> cate = categoryDAO.findAll();
            mm.addAttribute("cate", cate);
        List<Deliveries> listde = deliveriesDAO.findAll();
        mm.addAttribute("listde", listde);
        List<Payment> pay = payDAO.getAllPayments();
        mm.addAttribute("pay", pay);
        Deliveries deliveries = deliveriesDAO.findByShipperName(shipperName);
        mm.addAttribute("deliveries", deliveries);

        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);

            mm.addAttribute("login", login);
            return "cart";

        } else {

            return "cart";
        }
    }

    @RequestMapping(value = "deletecart/{productID}", method = RequestMethod.GET)
    public String giamcart(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {
        List<com.models.Categories> cate = categoryDAO.findAll();
            mm.addAttribute("cate", cate);
        List<Deliveries> listde = deliveriesDAO.findAll();
        mm.addAttribute("listde", listde);

        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = cartDAO.findById(productID);
        if (product != null) {
            Cart item = cartItems.get(productID);
            if (item != null) {
                item.setQuantity(item.getQuantity() - 1);
                if (item.getQuantity() <= 0) {
                    cartItems.remove(productID);
                } else {
                    cartItems.put(productID, item);
                }
            }
            updateSessionAttributes(session, cartItems);
        }
        return "cart";
    }

    @RequestMapping(value = "addcart/{productID}", method = RequestMethod.GET)
    public String tangcart(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {
            List<com.models.Categories> cate = categoryDAO.findAll();
            mm.addAttribute("cate", cate);
        List<Deliveries> listde = deliveriesDAO.findAll();
        mm.addAttribute("listde", listde);
        
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = cartDAO.findById(productID);
        if (product != null) {
            Cart item = cartItems.get(productID);
            if (item == null) {
                item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productID, item);
            } else {
                item.setQuantity(item.getQuantity() + 1);
            }
            updateSessionAttributes(session, cartItems);
        }
        return "cart";
    }

    @RequestMapping(value = "clearCart", method = RequestMethod.GET)
    public String clearCart(ModelMap mm, HttpSession session) {

        List<Deliveries> listde = deliveriesDAO.findAll();
        mm.addAttribute("listde", listde);
        List<com.models.Categories> cate = categoryDAO.findAll();
            mm.addAttribute("cate", cate);

        session.removeAttribute("myCartItems");
        session.setAttribute("myCartTotal", 0.0);
        session.setAttribute("myCartNum", 0);
        return "cart";
    }
    private void updateSessionAttributes(HttpSession session, HashMap<Integer, Cart> cartItems) {
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
    }

    @RequestMapping(value = "addcate/{categoryID}/{productID}", method = RequestMethod.GET)
    public String addToCartcate(ModelMap mm, HttpSession session, @PathVariable("productID") int productID,@PathVariable("categoryID") int categoryID) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = cartDAO.findById(productID);
        if (product != null) {
            Cart item = cartItems.get(productID);
            if (item == null) {
                item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(productID, item);
            } else {
                item.setQuantity(item.getQuantity() + 1);
            }
        }
        List<Product> pro = categoryDAO.findAllpro(categoryID);
        mm.addAttribute("pro", pro);
        
        List<com.models.Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);
        Categories catedal = categoryDAO.findById(categoryID);
        mm.addAttribute("catedal", catedal);
        updateSessionAttributes(session, cartItems);
        return "detailCategory";
    }
    
}
