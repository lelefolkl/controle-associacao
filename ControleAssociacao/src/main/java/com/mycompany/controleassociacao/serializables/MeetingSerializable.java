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
    private static ArrayList<Meeting> meetings;

    private MeetingSerializable() {
        super("meeting.bin");
        try {
            meetings = (ArrayList<Meeting>) this.readObjects();
        } catch (Exception ex) {
            ex.printStackTrace();
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
            meetings.add(meeting);
            this.writeObjects(meetings);
            return "Reunião criada com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao criar nova reunião!";
        }
    }

    public String updateMeeting(int meetingId, Meeting updatedMeeting) {
        try {
            Meeting meeting = this.getMeetingById(meetingId);

            meeting.setTitle(updatedMeeting.getTitle());
            meeting.setAddress(updatedMeeting.getAddress());
            meeting.setDate(updatedMeeting.getDate());
            meeting.setMeetingAgenda(updatedMeeting.getMeetingAgenda());
            meeting.setMembers(updatedMeeting.getMembers());

            this.writeObjects(meetings);
            return "Reunião atualizada com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao atualizar dados da reunião!";
        }
    }

    public String removeMembersFromMeeting(int meetingId, ArrayList<Member> membersToRemove) {
        try {
            Meeting meeting = this.getMeetingById(meetingId);
            membersToRemove.forEach(member -> {
                meeting.removeMember(member);
            });

            this.writeObjects(meetings);
            return "Reunião atualizada com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao atualizar dados da reunião!";
        }
    }

    public String addMembersToMeeting(int meetingId, ArrayList<Member> membersToAdd) {
        try {
            Meeting meeting = this.getMeetingById(meetingId);
            membersToAdd.forEach(member -> {
                meeting.addMember(member);
            });

            this.writeObjects(meetings);
            return "Reunião atualizada com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao atualizar dados da reunião!";
        }
    }

    public String removeMeeting(int meetingId) {
        try {
            meetings.removeIf(meeting -> meeting.getId() == meetingId);
            this.writeObjects(meetings);
            return "Reunião cancelada com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao cancelar reunião!";
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
        return meetings;
    }

    public String addConfirmation(int meetingId, Member memberConfirmed) {

        try {
            Meeting meeting = this.getMeetingById(meetingId);
            meeting.addConfirmation(memberConfirmed);
            this.writeObjects(meetings);
            return "Reunião atualizada com sucesso!";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Erro ao atualizar dados da reunião!";
        }
    }
}
