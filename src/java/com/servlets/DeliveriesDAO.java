/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Deliveries;
import java.util.List;

/**
 *
 * @author asus
 */
public interface DeliveriesDAO {

    public Deliveries findByShipperName(String shipperName);

    public List<Deliveries> findAll();

    public void addDelivery(Deliveries delivery);

    public void updateDelivery(Deliveries delivery);

    public void deleteDelivery(int deliveryID);

    public List<Deliveries> searchDeliveriesByDeliveryName(String shipperName);

    public Deliveries findById(int deliveryID);

}
