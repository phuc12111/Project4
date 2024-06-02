/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.models;

import java.sql.Timestamp;
import java.time.LocalDate;


public class Orders {

    private int orderID;
   
    private LocalDate orderDate;

    
    private Timestamp deliveryDate;
    private String shipAddress;
    private String status;
    private double total;
    private int paymentID;
    private int deliveryID;
    private String phone;

    public Orders(int orderID, LocalDate orderDate, Timestamp deliveryDate, String shipAddress, String status, double total, int paymentID, int deliveryID, String phone) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.shipAddress = shipAddress;
        this.status = status;
        this.total = total;
        this.paymentID = paymentID;
        this.deliveryID = deliveryID;
        this.phone = phone;
    }

    public Orders() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
