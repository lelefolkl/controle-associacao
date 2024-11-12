/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.serializables;

import com.mycompany.controleassociacao.models.Member;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public final class MemberSerializable extends SerializableObject {

    private static MemberSerializable instance;
    private static ArrayList<Member> members;

    private MemberSerializable() {
        super("members.bin");
        try {
            members = (ArrayList<Member>) this.readObjects();
        } catch (Exception ex) {
            System.out.println("Error to load initial data on MemberSerializable");
        }
    }

    public static MemberSerializable getInstance() {
        if (instance == null) {
            instance = new MemberSerializable();
        }
        return instance;
    }

    public String createMember(Member member) {
        try {
            members.add(member);
            this.writeObjects(members);
            return "Associado criado com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao criar novo Associado";
        }
    }

    public Member getMemberById(int memberId) {

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == memberId) {
                return members.get(i);
            }
        }
        return null;
    }

    public String updateMember(int memberId, Member updatedMember) {
        try {
            Member member = this.getMemberById(memberId);

            member.setAddress(updatedMember.getAddress());
            member.setBirthDate(updatedMember.getBirthDate());
            member.setCellphone(updatedMember.getCellphone());
            member.setName(updatedMember.getName());
            member.setRg(updatedMember.getRg());

            this.writeObjects(members);
            return "Associado atualizado com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao atualizar dados do associado!";
        }
    }

    public String deleteMember(int memberId) {
        try {
            members.removeIf(member -> member.getId() == memberId);
            this.writeObjects(members);
            return "Associado atualizado com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao atualizar dados do associado!";
        }
    }
    
    public ArrayList<Member> getAll(){
        return members;
    }
}
