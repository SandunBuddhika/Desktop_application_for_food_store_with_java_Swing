package com.sandun.web.template;

import com.sandun.web.model.FontManager;
import javax.swing.JLabel;

public class MessageTemplate extends javax.swing.JPanel {


    public MessageTemplate() {
        initComponents();
    }

    public MessageTemplate(String message) {
        initComponents();
        jLabel1.setText("<html>"+message+"</html>");
        setUp();
    }

    private void setUp() {
        FontManager.setFontForLable(FontManager.nacelleRegular, 12f, jLabel1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound1 = new com.sandun.web.template.MyPanelRound();
        jLabel1 = new javax.swing.JLabel();

        myPanelRound1.setBackground(new java.awt.Color(204, 204, 204));
        myPanelRound1.setRoundBottomLeft(20);
        myPanelRound1.setRoundBottomRight(20);
        myPanelRound1.setRoundTopLeft(20);
        myPanelRound1.setRoundTopRight(20);

        jLabel1.setText("Message");
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 16));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 16));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 16));
        jLabel1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout myPanelRound1Layout = new javax.swing.GroupLayout(myPanelRound1);
        myPanelRound1.setLayout(myPanelRound1Layout);
        myPanelRound1Layout.setHorizontalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanelRound1Layout.setVerticalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public MyPanelRound getMyPanelRound1() {
        return myPanelRound1;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.sandun.web.template.MyPanelRound myPanelRound1;
    // End of variables declaration//GEN-END:variables
}
