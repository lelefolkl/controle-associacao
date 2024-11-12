/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.controllers;

import com.mycompany.controleassociacao.models.Member;
import com.mycompany.controleassociacao.serializables.MemberSerializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class MemberController {
    final private MemberSerializable serializable = MemberSerializable.getInstance();
    
    public MemberController(){}
    
    public Member getMemberById(int memberId) {
        return serializable.getMemberById(memberId);
    }
    
    public String createMember(String name, String address, LocalDate birthDate, String cellphone, String rg){
        Member newMember = new Member(name, address, birthDate, cellphone, rg);
        return serializable.createMember(newMember);   
    }
    
    public String deleteMember(int memberId){
        return serializable.deleteMember(memberId);
    }
    
    public String updateMember(int memberId, Member updatedMember){
        return serializable.updateMember(memberId, updatedMember);
    }
    
    public ArrayList<Member> getAllMembers() {
        return serializable.getAll();
    }
}
