/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.controllers;

import com.mycompany.controleassociacao.models.Meeting;
import com.mycompany.controleassociacao.models.Member;
import com.mycompany.controleassociacao.serializables.MeetingSerializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public class MeetingController {

    final private MeetingSerializable serializable = MeetingSerializable.getInstance();

    public MeetingController() {
    }

    public String createMeeting(String title, LocalDate date, String address, String meetingAgenda, ArrayList<Member> members) {
        Meeting newMeeting = new Meeting(title, date, address, meetingAgenda, members);
        return serializable.createMeeting(newMeeting);
    }

    public String editMeeting(int meetingId, Meeting updatedData) {
        return serializable.updateMeeting(meetingId, updatedData);
    }

    public String cancelMeeting(int meetingId) {
        return serializable.removeMeeting(meetingId);
    }

    public String addMembersToMeeting(int meetingId, ArrayList<Member> membersToAdd) {
         return serializable.addMembersToMeeting(meetingId, membersToAdd);
    }

    public String removeGuestFromMeeting(int meetingId, ArrayList<Member> membersToRemove) {
        return serializable.removeMembersFromMeeting(meetingId, membersToRemove);
    }

    public Meeting getMeetingById(int meetingId) {
        return serializable.getMeetingById(meetingId);
    }

    public ArrayList<Meeting> listMeetings() {
        return serializable.getAllMeetings();
    }

    public ArrayList<Member> getConfirmationsByMeeting(int meetingId) {
        return this.getMeetingById(meetingId).getConfirmations();
    }

    public String addConfirmation(int meetingId, Member memberConfirmed) {
        return serializable.addConfirmation(meetingId, memberConfirmed);
    }

    public ArrayList<Meeting> getAllMeetings(){
        return serializable.getAllMeetings();
    }
}
