/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.models;

import com.mycompany.controleassociacao.utils.UUIDGenerator;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Karol
 */
public class Payment implements Serializable {
    public enum Method {CREDIT_CARD, PIX, BANK_SLIP, TED};
    public enum Status {APPROVED, PENDING, REFUSED};
    
    private Method method;
    private float   value;
    private LocalDate date;
    private Status status;
    private Member member;
    final private int id;

    public Payment(Method method, float value, Member member) {
        this.method = method;
        this.value = value;
        this.status = Status.PENDING;
        this.member = member;
        this.date = LocalDate.now();
        this.id = UUIDGenerator.generateUniqueIntID();
    }

    public int getId(){
        return this.id;
    }
    
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    
}
