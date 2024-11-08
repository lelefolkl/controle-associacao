/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.controllers;

import com.mycompany.controleassociacao.models.FinancialReport;
import java.time.LocalDate;
import java.time.YearMonth;

/**
 *
 * @author Karol
 */
public class FinancialReportController {

    private PaymentController paymentController = new PaymentController();

    public FinancialReport getGeneralReport() {
        return new FinancialReport(paymentController.getAllPayments());
    }

    public FinancialReport getReportByMember(int memberId) {
        return new FinancialReport(paymentController.getPaymentsByMember(memberId));
    }

    public FinancialReport getReportByMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1); // First day of the month
        LocalDate endOfMonth = yearMonth.atEndOfMonth(); // Last day of the month

        return new FinancialReport(paymentController.getPaymentsByDate(startOfMonth, endOfMonth));
    }
}
