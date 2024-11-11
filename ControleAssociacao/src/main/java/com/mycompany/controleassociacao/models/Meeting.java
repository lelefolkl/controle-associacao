/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.models;

import com.mycompany.controleassociacao.utils.UUIDGenerator;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class Meeting implements Serializable{
    private String title;
    private LocalDate date;
    private String address;
    private String meetingAgenda;
    private ArrayList<Member> members;
    private ArrayList<Member> confirmations;
    final private int id;
    
    public Meeting(String title, LocalDate date, String address, String meetingAgenda, ArrayList<Member> members) {
        this.title = title;
        this.date = date;
        this.address = address;
        this.meetingAgenda = meetingAgenda;
        this.members = members;
        this.confirmations = new ArrayList<>();
        this.id = UUIDGenerator.generateUniqueIntID();
    }
    
    public int getId() {
        return this.id;
    }

     public void setTitle(String title) {
        this.title = title;
    }

    
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMeetingAgenda() {
        return meetingAgenda;
    }

    public void setMeetingAgenda(String meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
    
    public void setMembers(ArrayList<Member> members){
        this.members = members;
    }
    
    public void removeMember(Member memberToRemove){
        this.members.removeIf(member -> member.getId() == memberToRemove.getId());
    }
    
    public void addMember(Member member){
        this.members.add(member);
    }

    public ArrayList<Member> getConfirmations() {
        return confirmations;
    }

    public void addConfirmation(Member confirmated) {
        this.confirmations.add(confirmated);
    }
    
    public void setConfirmations(ArrayList<Member> confirmations){
        this.confirmations = confirmations;
    }
}
