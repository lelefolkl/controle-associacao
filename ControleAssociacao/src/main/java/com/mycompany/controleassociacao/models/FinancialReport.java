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

    public FinancialReport(List<Payment> allPayments) {

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
        String str = "";

        str += "\n Total confirmado: " + Float.toString(this.totalApproved);
        str += "\n Total pendente: " + Float.toString(this.totalPendent);
        str += "\n Total recusado: " + Float.toString(this.totalRefused);
        
        str += "\n\n Pagamentos Aprovados: ";
        for(Payment confirmed: this.approvedPayments){
            str += confirmed.toString();
        }
        
        str += "\n\n Pagamentos Pendentes: ";
        for(Payment pendent: this.pendentPayments){
            str += pendent.toString();
        }
        
        str += "\n\n Pagamentos Recusados: ";
        for(Payment refused: this.refusedPayments){
            str += refused.toString();
        }
        return str;
    }
}
