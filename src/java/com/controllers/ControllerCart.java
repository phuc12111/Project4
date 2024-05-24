package com.controllers;

import com.models.Cart;
import com.models.Product;
import com.servlets.CartDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "cart")
public class ControllerCart {

    @Autowired
    private CartDAO CartDAO;

    @RequestMapping(value = "add/{productID}", method = RequestMethod.GET)
    public String addToCart(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = CartDAO.findById(productID);
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
    public String showcart() {
        return "cart";
    }
    


@RequestMapping(value = "deletecart/{productID}", method = RequestMethod.GET)
    public String giamcart(ModelMap mm, HttpSession session, @PathVariable("productID") int productID) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = CartDAO.findById(productID);
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
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Product product = CartDAO.findById(productID);
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
    public String clearCart(HttpSession session) {
        session.removeAttribute("myCartItems");
        session.setAttribute("myCartTotal", 0.0);
        session.setAttribute("myCartNum", 0);
        return "cart";
    }
    
//    @RequestMapping(value = "checkout", method = RequestMethod.POST)
//    public String viewCheckout(ModelMap mm, HttpSession session,
//                               @RequestParam("shipperName") String shipperName,
//                               @RequestParam("username") String username) {
//        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
//        if (cartItems == null || cartItems.isEmpty()) {
//            mm.addAttribute("error", "Your cart is empty.");
//            return "eror";
//        }
//
//        // Lấy thông tin người dùng và shipper từ username và shipperName
//        User user = productDAO.findByUser(username);
//        Shipper shipper = productDAO.findByName(shipperName);
//
//        if (user == null || shipper == null) {
//            mm.addAttribute("error", "Invalid user or shipper.");
//            return "eror";
//        }
//
//        // Tạo đơn hàng
//        Orders order = new Orders();
//        order.setUserID(user.getUserId());
//        order.setShipperID(shipper.getShipperID());
//        order.setOrderDate(new Timestamp(new Date().getTime()));
//        order.setTotalAmount(totalPrice(cartItems)); // Calculate total amount from cartItems
//        order.setStatus("Pending");
//
//        int orderId = productDAO.createOrder(order);
//
//        // Thêm các sản phẩm vào chi tiết đơn hàng
//        List<OrderDetails> orderDetailsList = new ArrayList<>();
//        for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
//            OrderDetails orderDetail = new OrderDetails();
//            orderDetail.setOrderID(orderId);
//            orderDetail.setIdpro(entry.getValue().getProduct().getIdpro());
//            orderDetail.setQuantity(entry.getValue().getQuantity());
//            orderDetail.setPrice(entry.getValue().getProduct().getPrice());
//            orderDetailsList.add(orderDetail);
//        }
//        productDAO.createOrderDetails(orderDetailsList);
//
////        // Xóa giỏ hàng sau khi thanh toán thành công
////        session.removeAttribute("myCartItems");
////        session.setAttribute("myCartTotal", 0.0);
////        session.setAttribute("myCartNum", 0);
//
//        // Chuyển hướng đến trang xác nhận thanh toán thành công
//        return "cart_empty";
//    }
    private void updateSessionAttributes(HttpSession session, HashMap<Integer, Cart> cartItems) {
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
    }
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    @RequestMapping(value = "checkout", method = RequestMethod.POST)
//public String viewCheckout(ModelMap mm, HttpSession session,
//                           @RequestParam("shipperName") String shipperName,
//                           @RequestParam("username") String username) {
//    HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
//    if (cartItems == null || cartItems.isEmpty()) {
//        mm.addAttribute("error", "Your cart is empty.");
//        return "eror";
//    }
//
//    // Lấy thông tin người dùng và shipper từ username và shipperName
//    User user = productDAO.findByUser(username);
//    Shipper shipper = productDAO.findByName(shipperName);
//
//    if (user == null || shipper == null) {
//        mm.addAttribute("error", "Invalid user or shipper.");
//        return "eror";
//    }
//
//    // Tạo đơn hàng
//    Orders order = new Orders();
//    order.setUserID(user.getUserId());
//    order.setShipperID(shipper.getShipperID());
//    order.setOrderDate(new Timestamp(new Date().getTime()));
//    order.setTotalAmount(totalPrice(cartItems)); // Calculate total amount from cartItems
//    order.setStatus("Pending");
//
//    int orderId = productDAO.createOrder(order);
//
//    // Thêm các sản phẩm vào chi tiết đơn hàng
//    List<OrderDetails> orderDetailsList = new ArrayList<>();
//    for (Map.Entry<Integer, Cart> entry : cartItems.entrySet()) {
//        OrderDetails orderDetail = new OrderDetails();
//        orderDetail.setOrderID(orderId);
//        orderDetail.setIdpro(entry.getValue().getProduct().getIdpro());
//        orderDetail.setQuantity(entry.getValue().getQuantity());
//        orderDetail.setPrice(entry.getValue().getProduct().getPrice());
//        orderDetailsList.add(orderDetail);
//    }
//
//    // Tạo đơn hàng trước, sau đó thêm chi tiết đơn hàng
//    productDAO.createOrderDetails(orderDetailsList, orderId);
//
//    // Xóa giỏ hàng sau khi thanh toán thành công
//    session.removeAttribute("myCartItems");
//    session.setAttribute("myCartTotal", 0.0);
//    session.setAttribute("myCartNum", 0);
//
//    
//     String vnp_OrderInfo = "Thông tin đơn hàng"; // Thay thế bằng thông tin đơn hàng thích hợp
//    String orderType = "Loại đơn hàng"; // Thay thế bằng loại đơn hàng thích hợp
//
//    // Gửi yêu cầu tạo mã thanh toán VNPAY
//    String paymentUrl = createVnPayPayment(vnp_OrderInfo, orderType, totalPrice(cartItems));
//
//    // Chuyển hướng đến trang hiển thị phương thức thanh toán VNPAY
//    return "redirect:" + paymentUrl;
//}
//
//    
//    
//    private String createVnPayPayment(String vnp_OrderInfo, String orderType, double amount) {
//    // Tạo yêu cầu thanh toán và nhận URL thanh toán từ VNPAY
//    // Đây là nơi bạn gửi yêu cầu tạo mã thanh toán VNPAY và nhận URL thanh toán từ VNPAY
//    // Trả về URL thanh toán để chuyển hướng người dùng đến trang thanh toán VNPAY
//    // Ví dụ: https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?vnp_Amount=1806000&vnp_Command=pay&vnp_CreateDate=20210801153333&vnp_CurrCode=VND&vnp_IpAddr=127.0.0.1&vnp_Locale=vn&vnp_OrderInfo=Thanh+toan+don+hang+%3A5&vnp_OrderType=other&vnp_ReturnUrl=https%3A%2F%2Fdomainmerchant.vn%2FReturnUrl&vnp_TmnCode=DEMOV210&vnp_TxnRef=5&vnp_Version=2.1.0&vnp_SecureHash=3e0d61a0c0534b2e36680b3f7277743e8784cc4e1d68fa7d276e79c23be7d6318d338b477910a27992f5057bb1582bd44bd82ae8009ffaf6d141219218625c42
//    
//    return "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html"; // Thay thế bằng URL thanh toán từ VNPAY
//}
//    
//    

}
