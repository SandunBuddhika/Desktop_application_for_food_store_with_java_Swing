/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.sandun.web.template;

import com.sandun.web.model.FontManager;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author SANDUN BUDDHIKA
 */
public class HomeMenuItem extends javax.swing.JPanel {

    public HomeMenuItem() {
        initComponents();
    }

    public HomeMenuItem(String name, ImageIcon logo) {
        initComponents();
        this.name.setText(name);
        if (logo != null) {
            this.icon.setIcon(logo);
        }
        setUp();
    }

    private void setUp() {
        name.setFont(FontManager.getOutfitLight(12f));
    }

    public MyPanelRound getMyPanelRound2() {
        return myPanelRound2;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound2 = new com.sandun.web.template.MyPanelRound();
        icon = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        myPanelRound2.setBackground(new java.awt.Color(245, 245, 245));
        myPanelRound2.setRoundBottomLeft(20);
        myPanelRound2.setRoundBottomRight(20);
        myPanelRound2.setRoundTopLeft(20);
        myPanelRound2.setRoundTopRight(20);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        name.setText("Item name");

        javax.swing.GroupLayout myPanelRound2Layout = new javax.swing.GroupLayout(myPanelRound2);
        myPanelRound2.setLayout(myPanelRound2Layout);
        myPanelRound2Layout.setHorizontalGroup(
            myPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanelRound2Layout.setVerticalGroup(
            myPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private com.sandun.web.template.MyPanelRound myPanelRound2;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
