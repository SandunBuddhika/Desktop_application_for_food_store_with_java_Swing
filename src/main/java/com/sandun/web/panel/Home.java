package com.sandun.web.panel;

import com.sandun.web.entities.enums.UserType;
import com.sandun.web.model.ChatManager;
import com.sandun.web.model.ChatOpenChecker;
import com.sandun.web.model.ClickEffectManager;
import com.sandun.web.model.FontManager;
import com.sandun.web.model.MessageListener;
import com.sandun.web.model.SessionManager;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import org.hibernate.Session;

public class Home extends javax.swing.JPanel {

    private ChatOpenChecker isChatOpen;
    private ClickEffectManager cem;
    private boolean isOrderEnable;

    public Home() {
        initComponents();
        this.isChatOpen = new ChatOpenChecker(false);
        this.cem = new ClickEffectManager(new Color(245, 245, 245), new Color(230, 230, 230));
        setUp();
    }

    private void setUp() {
        FontManager.setFontForLable(FontManager.outfitMedium, 24f, jLabel2);
        System.out.println(homeMenuItem1.getBackground());
        if (SessionManager.getUSER().getType() == UserType.CUSTOMER) {
            homeMenuItem1.setVisible(false);
            isOrderEnable = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound1 = new com.sandun.web.template.MyPanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        homeMenuItem4 = new com.sandun.web.template.HomeMenuItem("Dashboard", new ImageIcon(".//src//main//resources//imges//dashboard.png"));
        homeMenuItem3 = new com.sandun.web.template.HomeMenuItem("Order", new ImageIcon(".//src//main//resources//imges//order2.png"));
        homeMenuItem2 = new com.sandun.web.template.HomeMenuItem("Chat", new ImageIcon(".//src//main//resources//imges//chat.png"));
        homeMenuItem1 = new com.sandun.web.template.HomeMenuItem("Order Management", new ImageIcon(".//src//main//resources//imges//Order Management.png"));
        subTapPanel = new com.sandun.web.template.MyPanelRound();

        setBackground(new java.awt.Color(255, 255, 255));

        myPanelRound1.setBackground(new java.awt.Color(207, 207, 207));
        myPanelRound1.setRoundBottomRight(30);
        myPanelRound1.setRoundTopRight(30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imges/appLogo1.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Syzygy Foods");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.GridLayout(4, 0, 0, 5));

        homeMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMenuItem4MouseClicked(evt);
            }
        });
        jPanel1.add(homeMenuItem4);

        homeMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMenuItem3MouseClicked(evt);
            }
        });
        jPanel1.add(homeMenuItem3);

        homeMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMenuItem2MouseClicked(evt);
            }
        });
        jPanel1.add(homeMenuItem2);

        homeMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMenuItem1MouseClicked(evt);
            }
        });
        jPanel1.add(homeMenuItem1);

        javax.swing.GroupLayout myPanelRound1Layout = new javax.swing.GroupLayout(myPanelRound1);
        myPanelRound1.setLayout(myPanelRound1Layout);
        myPanelRound1Layout.setHorizontalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanelRound1Layout.setVerticalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        subTapPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout subTapPanelLayout = new javax.swing.GroupLayout(subTapPanel);
        subTapPanel.setLayout(subTapPanelLayout);
        subTapPanelLayout.setHorizontalGroup(
            subTapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );
        subTapPanelLayout.setVerticalGroup(
            subTapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subTapPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeMenuItem3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuItem3MouseClicked
        cem.showEffect(homeMenuItem3.getMyPanelRound2(), ClickEffectManager.HOLD_BLINK);
        OrderFood orderFood = new OrderFood();
        subTapPanel.removeAll();
        subTapPanel.setLayout(new BorderLayout());
        subTapPanel.add(orderFood);
        subTapPanel.repaint();
        subTapPanel.revalidate();
        isChatOpen.setIsChatOpen(false);
    }//GEN-LAST:event_homeMenuItem3MouseClicked

    private void homeMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuItem2MouseClicked
        cem.showEffect(homeMenuItem2.getMyPanelRound2(), ClickEffectManager.HOLD_BLINK);
        isChatOpen.setIsChatOpen(true);
        Chat chat = new Chat();
        MessageListener ml = new MessageListener();
        ChatManager cm = new ChatManager(chat, ml, isChatOpen);
        chat.setChatManager(cm);
        ml.setChatManager(cm);
        subTapPanel.removeAll();
        subTapPanel.setLayout(new BorderLayout());
        subTapPanel.add(chat);
        subTapPanel.repaint();
        subTapPanel.revalidate();
    }//GEN-LAST:event_homeMenuItem2MouseClicked

    private void homeMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuItem1MouseClicked
        cem.showEffect(homeMenuItem1.getMyPanelRound2(), ClickEffectManager.HOLD_BLINK);
        OrderManagement orderManagement = new OrderManagement();
        subTapPanel.removeAll();
        subTapPanel.setLayout(new BorderLayout());
        subTapPanel.add(orderManagement);
        subTapPanel.repaint();
        subTapPanel.revalidate();
        isChatOpen.setIsChatOpen(false);
    }//GEN-LAST:event_homeMenuItem1MouseClicked

    private void homeMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMenuItem4MouseClicked
        cem.showEffect(homeMenuItem4.getMyPanelRound2(), ClickEffectManager.HOLD_BLINK);
    }//GEN-LAST:event_homeMenuItem4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.sandun.web.template.HomeMenuItem homeMenuItem1;
    private com.sandun.web.template.HomeMenuItem homeMenuItem2;
    private com.sandun.web.template.HomeMenuItem homeMenuItem3;
    private com.sandun.web.template.HomeMenuItem homeMenuItem4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.sandun.web.template.MyPanelRound myPanelRound1;
    private com.sandun.web.template.MyPanelRound subTapPanel;
    // End of variables declaration//GEN-END:variables
}
