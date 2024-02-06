package com.sandun.web.template;

import com.sandun.web.dto.FoodDTO;
import com.sandun.web.dto.OrderManagerDTO;
import com.sandun.web.model.ClickEffectManager;
import com.sandun.web.model.FontManager;
import javax.swing.ImageIcon;

/**
 *
 * @author SANDUN BUDDHIKA
 */
public class OrderItem extends MyPanelRound {

    private OrderManagerDTO order;
    private boolean isSelected;
    private boolean isRunning;
    private ClickEffectManager cem;

    public OrderItem() {
        initComponents();
        setUp();
    }

    public OrderItem(OrderManagerDTO order, ClickEffectManager cem) {
        initComponents();
        this.order = order;
        this.cem = cem;
        setUp();

    }

    public OrderManagerDTO getOrder() {
        return order;
    }

    private void setUp() {
        this.setRoundBottomLeft(20);
        this.setRoundBottomRight(20);
        this.setRoundTopRight(20);
        this.setRoundTopLeft(20);
        jLabel1.setIcon(new ImageIcon(".//src//main//resources//imges//" + order.getFood().get(0).getPath()));
        jLabel3.setText(String.valueOf(order.getId()));
        String name = order.getFood().toString();
        jLabel5.setText(name.substring(1, name.length() - 1));
        jLabel7.setText(String.valueOf(order.getTotal()));
        FontManager.setFontForLables(FontManager.outfitRegular, 12f, jLabel2, jLabel3, jLabel5, jLabel4, jLabel6, jLabel7);
    }

    public void switchImages() {
        if (!isRunning) {
            isRunning = true;
            new Thread(() -> {
                try {
                    int i = order.getFood().size() - 1;
                    int j = 0;
                    while (isSelected) {
                        jLabel1.setIcon(new ImageIcon(".//src//main//resources//imges//" + order.getFood().get(j).getPath()));
                        j++;
                        if (j > i) {
                            j = 0;
                        }
                        this.revalidate();
                        this.repaint();
                        Thread.sleep(1000);
                    }
                    isRunning = false;
                } catch (Exception e) {
                }
            }).start();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(207, 207));
        setMinimumSize(new java.awt.Dimension(207, 207));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("O_ID:");

        jLabel3.setText("None");

        jLabel4.setText("Food:");

        jLabel5.setText("None");

        jLabel6.setText("Toral:");

        jLabel7.setText("None");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        isSelected = true;
        switchImages();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        isSelected = false;
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        cem.showEffect(this, ClickEffectManager.HOLD_BLINK);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
