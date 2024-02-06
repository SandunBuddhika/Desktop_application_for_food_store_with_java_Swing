package com.sandun.web.template;

import com.sandun.web.dto.FoodDTO;
import com.sandun.web.entities.Food;
import com.sandun.web.model.ClickEffectManager;
import com.sandun.web.model.FontManager;
import com.sandun.web.model.MyDecimalFormater;
import javax.swing.ImageIcon;

public class FoodItem extends javax.swing.JPanel {

    private com.sandun.web.dto.FoodDTO food;


    public FoodItem(Food f) {
        initComponents();
        food = new FoodDTO.Builder(f).build();
        this.JLname.setText(food.getName());
        JLimg.setIcon(new ImageIcon(".//src//main//resources//imges//" + food.getPath()));
        this.JLprice.setText(MyDecimalFormater.format(food.getPrice()));
        this.JLdescription.setText("<html>" + food.getDescription() + "</html>");
        setUp();
    }

    private void setUp() {
        JLname.setFont(FontManager.getOutfitLight(16f));
        JLprice.setFont(FontManager.getOutfitLight(11f));
        JLdescription.setFont(FontManager.getOutfitLight(10f));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound1 = new com.sandun.web.template.MyPanelRound();
        JLimg = new javax.swing.JLabel();
        JLname = new javax.swing.JLabel();
        JLprice = new javax.swing.JLabel();
        JLdescription = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(325, 106));
        setPreferredSize(new java.awt.Dimension(325, 106));

        myPanelRound1.setBackground(new java.awt.Color(204, 204, 204));
        myPanelRound1.setMaximumSize(new java.awt.Dimension(325, 106));
        myPanelRound1.setRoundBottomLeft(20);
        myPanelRound1.setRoundBottomRight(20);
        myPanelRound1.setRoundTopLeft(20);
        myPanelRound1.setRoundTopRight(20);

        JLimg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLname.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        JLname.setText("Food Name");

        JLprice.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        JLprice.setText("LKR 1,000.00");

        JLdescription.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        JLdescription.setText("Discription");
        JLdescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        JLdescription.setAutoscrolls(true);
        JLdescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JLdescription.setMaximumSize(new java.awt.Dimension(46, 32));
        JLdescription.setMinimumSize(new java.awt.Dimension(46, 32));
        JLdescription.setPreferredSize(new java.awt.Dimension(46, 32));

        javax.swing.GroupLayout myPanelRound1Layout = new javax.swing.GroupLayout(myPanelRound1);
        myPanelRound1.setLayout(myPanelRound1Layout);
        myPanelRound1Layout.setHorizontalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLimg, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLname, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addComponent(JLdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        myPanelRound1Layout.setVerticalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLimg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addComponent(JLname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLprice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(myPanelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public com.sandun.web.dto.FoodDTO getFood() {
        return food;
    }

    public MyPanelRound getBackPanel() {
        return myPanelRound1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLdescription;
    private javax.swing.JLabel JLimg;
    private javax.swing.JLabel JLname;
    private javax.swing.JLabel JLprice;
    private com.sandun.web.template.MyPanelRound myPanelRound1;
    // End of variables declaration//GEN-END:variables
}
