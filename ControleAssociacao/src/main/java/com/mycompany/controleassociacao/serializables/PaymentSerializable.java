/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.serializables;

import com.mycompany.controleassociacao.models.Payment;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public final class PaymentSerializable extends SerializableObject {

    private static PaymentSerializable instance;
    private ArrayList<Payment> payments = new ArrayList<>();

    private PaymentSerializable() {
        super("/payments.bin");
        try {
            this.payments = (ArrayList<Payment>) this.readObjects();
        } catch (Exception ex) {
            System.out.println("Error to load initial data on PaymentSerializable");
        }
    }

    public static PaymentSerializable getInstance() {
        if (instance == null) {
            instance = new PaymentSerializable();
        }
        return instance;
    }

    public String registerPayment(Payment payment) {
        try {
            this.payments.add(payment);
            this.writeObjects(payments);
            return "Payment saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to save Payment";
        }
    }

    public Payment getPaymentById(int paymentId) {

        for (Payment payment : this.payments) {
            if (payment.getId() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    public String updatePaymentStatus(int paymentId, Payment.Status status) {
        try {
            Payment payment = this.getPaymentById(paymentId);
            payment.setStatus(status);

            this.writeObjects(payments);
            return "Payment updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to up Payment";
        }
    }

    public String deletePayment(int paymentId) {
        try {
            this.payments.removeIf(payment -> payment.getId() == paymentId);
            this.writeObjects(payments);
            return "Payment removed successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to remove Payment";
        }
    }

    public ArrayList<Payment> getPaymentsByMember(int memberId) {
        ArrayList<Payment> filtered = new ArrayList<>();

        for (Payment payment : this.payments) {
            if (payment.getMember().getId() == memberId) {
                filtered.add(payment);
            }
        }

        return filtered;
    }

    public ArrayList<Payment> getPaymentsByStatus(Payment.Status status) {
        ArrayList<Payment> filtered = new ArrayList<>();

        for (Payment payment : this.payments) {
            if (payment.getStatus() == status) {
                filtered.add(payment);
            }
        }

        return filtered;
    }

    public ArrayList<Payment> getPaymentsByDate(LocalDate startDate, LocalDate finalDate) {
        ArrayList<Payment> filtered = new ArrayList<>();

        for (Payment payment : this.payments) {
            LocalDate paymentDate = payment.getDate();
            if (
                    (paymentDate.isAfter(startDate) && paymentDate.isBefore(finalDate)) || 
                    paymentDate.equals(startDate) || 
                    paymentDate.equals(finalDate)
               ) {
                filtered.add(payment);
            }
        }

        return filtered;
    }
    
    public ArrayList<Payment> getPayments(){
        return this.payments;
    }
}
