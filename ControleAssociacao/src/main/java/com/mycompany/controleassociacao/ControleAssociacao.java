/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.controleassociacao;

import com.mycompany.controleassociacao.views.Login;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Karol
 */
public class ControleAssociacao {

    public static void main(String[] args) {
        JFrame frame = new Login();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
