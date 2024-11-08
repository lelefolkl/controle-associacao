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
    private ArrayList<Member> members = new ArrayList<>();

    private MemberSerializable() {
        super("/members.bin");
        try {
            this.members = (ArrayList<Member>) this.readObjects();
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
            this.members.add(member);
            this.writeObjects(members);
            return "Member saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to save member";
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
            return "Member updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to update Member";
        }
    }

    public String deleteMember(int memberId) {
        try {
            members.removeIf(member -> member.getId() == memberId);
            this.writeObjects(members);
            return "Member updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to update Member";
        }
    }
}
