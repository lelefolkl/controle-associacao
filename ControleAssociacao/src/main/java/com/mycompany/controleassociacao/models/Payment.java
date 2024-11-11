/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.models;

import com.mycompany.controleassociacao.utils.UUIDGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Karol
 */
public class Payment implements Serializable {

    public enum Method {
        CREDIT_CARD, PIX, BANK_SLIP, TED;

        @Override
        public String toString() {
            switch (this) {
                case CREDIT_CARD:
                    return "Cartão de crédito";
                case PIX:
                    return "Pix";
                case BANK_SLIP:
                    return "Boleto";
                case TED:
                    return "Transferência";
                default:
                    return super.toString();
            }
        }
    };

    public enum Status {
        APPROVED, PENDING, REFUSED;

        @Override
        public String toString() {
            switch (this) {
                case APPROVED:
                    return "Aprovado";
                case PENDING:
                    return "Pendente";
                case REFUSED:
                    return "Recusado";
                default:
                    return super.toString();
            }
        }
    };

    private Method method;
    private float value;
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

    public int getId() {
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

    @Override
    public String toString() {
        return "\n\n Associado: " + this.member.getName() + "\n valor: " + Float.toString(this.value)
                + "\n data: " + this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n status: "
                + this.status.toString() + "\n metódo de pagamento: " + this.method.toString();
    }

}
