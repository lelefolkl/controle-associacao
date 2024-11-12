/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.utils;

import java.util.UUID;

/**
 *
 * @author Karol
 */
public class UUIDGenerator {
    public static int generateUniqueIntID() {
        UUID uuid = UUID.randomUUID();
        return uuid.hashCode(); 
    }
}
