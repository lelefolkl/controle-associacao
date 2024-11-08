
package com.mycompany.controleassociacao.controllers;

import com.mycompany.controleassociacao.models.Adm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Karol
 */
public class LoginController {
    public LoginController(){}
    final private Adm adm = new Adm();
    
    
    public boolean hasAccess(String email, String password) {
        return adm.getEmail().equals(email) && adm.getPassword().equals(password); 
    }
}
