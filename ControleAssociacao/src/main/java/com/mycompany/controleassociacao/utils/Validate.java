/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.utils;

import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class Validate {

    public static boolean hasEmptyData(ArrayList<String> list){
        for(String item: list){
            if(item == null || item.equals("")) return true;
        }
        return false;
    }
    
}
