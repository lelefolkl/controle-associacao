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
public class Member implements Serializable {

    private String name;
    private String address;
    private LocalDate birthDate;
    private String cellphone;
    private String rg;
    final private LocalDate createdAt;
    private boolean isActive;
    final private int id;

    public Member(String name, String address, LocalDate birthDate, String cellphone, String rg) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.cellphone = cellphone;
        this.rg = rg;
        this.createdAt = LocalDate.now();
        this.isActive = true;
        this.id = UUIDGenerator.generateUniqueIntID();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void enable() {
        this.isActive = true;
    }

    public void disable() {
        this.isActive = false;
    }
}
