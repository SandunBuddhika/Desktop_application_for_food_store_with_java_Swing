package com.sandun.web.template;

import com.sandun.web.model.ClickEffectManager;
import com.sandun.web.model.FontManager;

public class ChatOrderItem extends javax.swing.JPanel {

    private long invoiceId;

    private ClickEffectManager cem;

    public ChatOrderItem() {
        initComponents();
    }

    public ChatOrderItem(String name, long invoiceId, ClickEffectManager cem) {
        initComponents();
        jLabel1.setText(name);
        this.cem = cem;
        this.invoiceId = invoiceId;
        setUp();
    }

    public ChatOrderItem(String name,  ClickEffectManager cem) {
        initComponents();
        jLabel1.setText(name);
        this.cem = cem;
        setUp();
    }

    private void setUp() {
        FontManager.setFontForLable(FontManager.nacelleRegular, 13f, jLabel1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound4 = new com.sandun.web.template.MyPanelRound();
        jLabel1 = new javax.swing.JLabel();

        myPanelRound4.setBackground(new java.awt.Color(204, 204, 204));
        myPanelRound4.setRoundBottomLeft(10);
        myPanelRound4.setRoundBottomRight(10);
        myPanelRound4.setRoundTopLeft(10);
        myPanelRound4.setRoundTopRight(10);
        myPanelRound4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myPanelRound4MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Order Name");

        javax.swing.GroupLayout myPanelRound4Layout = new javax.swing.GroupLayout(myPanelRound4);
        myPanelRound4.setLayout(myPanelRound4Layout);
        myPanelRound4Layout.setHorizontalGroup(
            myPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelRound4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        myPanelRound4Layout.setVerticalGroup(
            myPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myPanelRound4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myPanelRound4MouseClicked
        cem.showEffect(myPanelRound4, ClickEffectManager.HOLD_BLINK);
    }//GEN-LAST:event_myPanelRound4MouseClicked

    public MyPanelRound getMyPanelRound4() {
        return myPanelRound4;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.sandun.web.template.MyPanelRound myPanelRound4;
    // End of variables declaration//GEN-END:variables
}
