/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controleassociacao.serializables;

import com.mycompany.controleassociacao.models.Meeting;
import com.mycompany.controleassociacao.models.Member;
import java.util.ArrayList;

/**
 *
 * @author Karol
 */
public final class MeetingSerializable extends SerializableObject {

    private static MeetingSerializable instance;
    private ArrayList<Meeting> meetings = new ArrayList<>();

    private MeetingSerializable() {
        super("/meeting.bin");
        try {
            this.meetings = (ArrayList<Meeting>) this.readObjects();
        } catch (Exception ex) {
            System.out.println("Error to load initial data on MeetingSerializable");
        }
    }

    public static MeetingSerializable getInstance() {
        if (instance == null) {
            instance = new MeetingSerializable();
        }
        return instance;
    }

    public String createMeeting(Meeting meeting) {
        try {
            this.meetings.add(meeting);
            this.writeObjects(meetings);
            return "Meeting saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to save meeting";
        }
    }

    public String updateMeeting(int meetingId, Meeting updatedMeeting) {
        try {
            Meeting meeting = this.getMeetingById(meetingId);

            meeting.setAddress(updatedMeeting.getAddress());
            meeting.setDate(updatedMeeting.getDate());
            meeting.setMeetingAgenda(updatedMeeting.getMeetingAgenda());
            meeting.setMembers(updatedMeeting.getMembers());

            this.writeObjects(meetings);
            return "Meeting updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to update meeting";
        }
    }

    public String removeMembersFromMeeting(int meetingId, ArrayList<Member> membersToRemove) {
        try {
            Meeting meeting = this.getMeetingById(meetingId);
            membersToRemove.forEach(member -> {
                meeting.removeMember(member);
            });

            this.writeObjects(meetings);
            return "Meeting updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to update meeting";
        }
    }

    public String addMembersToMeeting(int meetingId, ArrayList<Member> membersToAdd) {
        try {
            Meeting meeting = this.getMeetingById(meetingId);
            membersToAdd.forEach(member -> {
                meeting.addMember(member);
            });

            this.writeObjects(meetings);
            return "Meeting updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to update meeting";
        }
    }

    public String removeMeeting(int meetingId) {
        try {
            this.meetings.removeIf(meeting -> meeting.getId() == meetingId);
            this.writeObjects(meetings);
            return "Meeting removed successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to remove meeting";
        }
    }

    public Meeting getMeetingById(int meetingId) {

        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).getId() == meetingId) {
                return meetings.get(i);
            }
        }
        return null;

    }

    public ArrayList<Meeting> getAllMeetings() {
        return this.meetings;
    }

    public String addConfirmation(int meetingId, Member memberConfirmed) {

        try {
            Meeting meeting = this.getMeetingById(meetingId);
            meeting.addConfirmation(memberConfirmed);
            this.writeObjects(meetings);
            return "Meeting updated successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error to updated meeting";
        }
    }
}