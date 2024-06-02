/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Timestamp;

/**
 *
 * @author asus
 */
public class OrderdetailView {

    private int orderID;
    private Timestamp orderDate;
    private Timestamp deliveryDate;
    private String shipAddress;
    private String status;
    private String paymentName;
    private String deliveryName;
    private String productName;
    private int productID;
    private double price;
    private int quantity;
    private String phone;
    private String picture;
    private String memberName;
    private double total;

    public OrderdetailView(int orderID, Timestamp orderDate, Timestamp deliveryDate, String shipAddress, String status, String paymentName, String deliveryName, String productName, int productID, double price, int quantity, String phone, String picture, String memberName, double total) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.shipAddress = shipAddress;
        this.status = status;
        this.paymentName = paymentName;
        this.deliveryName = deliveryName;
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.phone = phone;
        this.picture = picture;
        this.memberName = memberName;
        this.total = total;
    }

    

    public OrderdetailView() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
