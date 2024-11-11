/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.controleassociacao.views;

import com.mycompany.controleassociacao.controllers.MeetingController;
import com.mycompany.controleassociacao.models.Meeting;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Karol
 */
public class ListMeetings extends javax.swing.JPanel {

    private final MeetingController controller = new MeetingController();
    JPanel dataPanel = new JPanel();

    /**
     * Creates new form ListMembers
     */
    public ListMeetings() {
        initComponents();
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        listMeetings();
    }

    private void listMeetings() {
        ArrayList<Meeting> meetings = controller.getAllMeetings();

        meetings.forEach(meet -> {
            JLabel labelName = new JLabel(meet.getTitle());
            JLabel labelId = new JLabel(Integer.toString(meet.getId()));
            JButton buttonEdit = new JButton("Editar");
            JButton buttonDelete = new JButton("Cancelar");

            JPanel rowLayout = new JPanel();

            buttonDelete.addActionListener(e -> {
                this.deleteMeeting(meet.getId(), rowLayout);
            });
            buttonDelete.setBackground(Color.red);
            buttonDelete.setForeground(Color.white);
            buttonDelete.setBorder(null);

            buttonEdit.addActionListener(e -> {
                this.editMeeting(meet.getId());
            });
            buttonEdit.setBackground(Color.blue);
            buttonEdit.setForeground(Color.white);
            buttonEdit.setBorder(null);

            rowLayout.setLayout(new BoxLayout(rowLayout, BoxLayout.X_AXIS));
            rowLayout.add(labelName);
            rowLayout.add(Box.createHorizontalStrut(90));
            rowLayout.add(labelId);
            rowLayout.add(Box.createHorizontalStrut(90));
            rowLayout.add(buttonEdit);
            rowLayout.add(Box.createHorizontalStrut(90));
            rowLayout.add(buttonDelete);

            dataPanel.add(rowLayout);
            dataPanel.add(Box.createVerticalStrut(5));
        });

        scrollPanel.setViewportView(dataPanel);
    }

    private void deleteMeeting(int id, JPanel rowLayout) {
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar esta reunião?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.cancelMeeting(id);
            dataPanel.remove(rowLayout);
            dataPanel.revalidate();
            dataPanel.repaint();
        }
    }

    private void editMeeting(int id) {
        EditMeeting dialog = new EditMeeting(new javax.swing.JFrame(), true, id);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        for (Component comp : dataPanel.getComponents()) {
            dataPanel.remove(comp);
        }
        dataPanel.revalidate();
        dataPanel.repaint();
        listMeetings();
        dataPanel.revalidate();
        dataPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(643, 409));

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanel.setBorder(null);
        scrollPanel.setAlignmentX(0.0F);
        scrollPanel.setAlignmentY(0.0F);
        scrollPanel.setOpaque(false);
        scrollPanel.setPreferredSize(new java.awt.Dimension(643, 409));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
