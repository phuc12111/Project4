/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.OrderDeatail;
import com.models.OrderdetailView;
import java.util.List;

/**
 *
 * @author asus
 */
public interface ViewOrderDAO {

    public List<OrderdetailView> getAllOrderInfo(String phone);

    public List<OrderdetailView> findAllOrder();

    List<OrderDeatail> getAllOrderDetails();

    public void updateOrder(int orderID, int productID, int quantity, String shipAddress);

    public void deleteOrder(int orderID);

    public List<OrderDeatail> searchOrdersByPhoneNumber(String phoneNumber);
    
    public OrderDeatail getOrderDetail(int orderID) ;
}
