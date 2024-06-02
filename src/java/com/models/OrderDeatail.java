/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Timestamp;

public class OrderDeatail {

    private int orderID;
    private Timestamp orderDate;
    private Timestamp deliveryDate;
    private String shipAddress;
    private String status;
    private int paymentID;
    private int deliveryID;
    private String phone;
    private int productID;
    private double price;
    private int quantity;
    private double total;

    public OrderDeatail(int orderID, Timestamp orderDate, Timestamp deliveryDate, String shipAddress, String status, int paymentID, int deliveryID, String phone, int productID, double price, int quantity, double total) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.shipAddress = shipAddress;
        this.status = status;
        this.paymentID = paymentID;
        this.deliveryID = deliveryID;
        this.phone = phone;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public OrderDeatail() {
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

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
