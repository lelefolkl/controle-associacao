/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.controllers;

import com.mycompany.controleassociacao.models.Payment;
import com.mycompany.controleassociacao.serializables.PaymentSerializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class PaymentController {

    final PaymentSerializable serializable = PaymentSerializable.getInstance();

    public PaymentController() {
    }

    public Payment getPaymentById(int paymentId) {
        return serializable.getPaymentById(paymentId);
    }

    public ArrayList<Payment> getPaymentsByMember(int memberId) {
        return serializable.getPaymentsByMember(memberId);
    }

    public ArrayList<Payment> getPaymentsByStatus(Payment.Status status) {
        return serializable.getPaymentsByStatus(status);
    }

    public ArrayList<Payment> getPaymentsByDate(LocalDate startDate, LocalDate finalDate) {
        return serializable.getPaymentsByDate(startDate, finalDate);
    }
    
    public ArrayList<Payment> getAllPayments(){
        return serializable.getPayments();
    }

}
