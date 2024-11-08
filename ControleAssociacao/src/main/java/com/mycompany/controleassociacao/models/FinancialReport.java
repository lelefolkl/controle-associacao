/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karol
 */
public class FinancialReport implements Serializable {

    private float totalApproved = 0;
    private float totalPendent = 0;
    private float totalRefused = 0;
    final private List<Payment> pendentPayments = new ArrayList<>();
    final private List<Payment> approvedPayments = new ArrayList<>();
    final private List<Payment> refusedPayments = new ArrayList<>();
    private List<Payment> allPayments;

    public FinancialReport(List<Payment> allPayments) {
        this.allPayments = allPayments;

        allPayments.forEach(payment -> {
            if (payment.getStatus() == Payment.Status.APPROVED) {
                this.approvedPayments.add(payment);
                this.totalApproved += payment.getValue();
            } else if (payment.getStatus() == Payment.Status.REFUSED) {
                this.refusedPayments.add(payment);
                this.totalRefused += payment.getValue();
            } else {
                this.pendentPayments.add(payment);
                this.totalPendent += payment.getValue();
            }
        });
    }

    @Override
    public String toString() {
        return "";
    }
}
