/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.controleassociacao.views.payment;

import com.mycompany.controleassociacao.controllers.PaymentController;
import com.mycompany.controleassociacao.models.Payment;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;
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
public class ListPayments extends javax.swing.JPanel {

    private final PaymentController controller = new PaymentController();
    JPanel dataPanel = new JPanel();

    /**
     * Creates new form ListPayments
     */
    public ListPayments() {
        initComponents();
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        listPayments();
    }

    private void listPayments() {
        ArrayList<Payment> payments = controller.getAllPayments();

        payments.forEach(payment -> {
            JLabel labelName = new JLabel(payment.getMember().getName());
            JLabel labelId = new JLabel(payment.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            JLabel valueLabel = new JLabel(Float.toString(payment.getValue()));
            JLabel statusLabel = new JLabel(payment.getStatus().toString());

            JButton buttonEdit = new JButton("Atualizar");
            JButton buttonDelete = new JButton("Excluir");

            JPanel rowLayout = new JPanel();
            Dimension buttonDimension = new Dimension(80, 24);

            buttonDelete.addActionListener(e -> {
                this.deletePayment(payment.getId(), rowLayout);
            });
            buttonDelete.setBackground(Color.red);
            buttonDelete.setForeground(Color.white);
            buttonDelete.setBorder(null);
            buttonDelete.setMaximumSize(buttonDimension);
            buttonDelete.setMinimumSize(buttonDimension);

            buttonEdit.addActionListener(e -> {
                this.editPayment(payment.getId());
            });
            buttonEdit.setBackground(Color.blue);
            buttonEdit.setForeground(Color.white);
            buttonEdit.setBorder(null);
            buttonEdit.setMaximumSize(buttonDimension);
            buttonEdit.setMinimumSize(buttonDimension);

            rowLayout.setLayout(new BoxLayout(rowLayout, BoxLayout.X_AXIS));
            rowLayout.add(labelName);
            rowLayout.add(Box.createHorizontalStrut(32));
            rowLayout.add(valueLabel);
            rowLayout.add(Box.createHorizontalStrut(32));
            rowLayout.add(statusLabel);
            rowLayout.add(Box.createHorizontalStrut(32));
            rowLayout.add(labelId);
            rowLayout.add(Box.createHorizontalStrut(32));
            rowLayout.add(buttonEdit);
            rowLayout.add(Box.createHorizontalStrut(32));
            rowLayout.add(buttonDelete);

            dataPanel.add(rowLayout);
            dataPanel.add(Box.createVerticalStrut(5));
        });

        scrollPanel.setViewportView(dataPanel);
    }

    private void deletePayment(int id, JPanel rowLayout) {
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este pagamento?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            controller.deletePayment(id);
            dataPanel.remove(rowLayout);
            dataPanel.revalidate();
            dataPanel.repaint();
        }
    }

    private void editPayment(int id) {
        EditPaymentStatus dialog = new EditPaymentStatus(new javax.swing.JFrame(), true, id);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setVisible(true);

        for (Component comp : dataPanel.getComponents()) {
            dataPanel.remove(comp);
        }
        dataPanel.revalidate();
        dataPanel.repaint();
        listPayments();
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
            .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
