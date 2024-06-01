/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Payment;
import java.util.List;

public interface PayDAO {

    List<Payment> getAllPayments();

    Payment getPaymentByID(int paymentID);

    void addPayment(Payment payment);

    void updatePayment(Payment payment);

    void deletePayment(int paymentID);

    List<Payment> searchPaymentsByPaymentName(String paymentName);
}
