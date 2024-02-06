package com.sandun.web.template;

import com.sandun.web.dto.ExtraIngredientDTO;
import com.sandun.web.model.FontManager;
import com.sandun.web.model.MyDecimalFormater;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AdditionalIngredient extends javax.swing.JPanel {

    private ExtraIngredientDTO ingredentDTO;

    public AdditionalIngredient() {
        initComponents();
        setUp();
    }

    public AdditionalIngredient(ExtraIngredientDTO dto) {
        initComponents();
        this.ingredentDTO = dto;
        jRadioButton1.setText(this.ingredentDTO.getName() + " (" + MyDecimalFormater.format(this.ingredentDTO.getPrice()) + ")");
        setUp();
    }

    private void setUp() {
        jRadioButton1.setFont(FontManager.getOutfitLight(12f));
    }

    public ExtraIngredientDTO getExtraIngredentDTO() {
        return ingredentDTO;
    }

    public void setStateChangeEvent(ItemListener event) {
        jRadioButton1.addItemListener(event);
    }

    public void deSelect() {
        jRadioButton1.setSelected(false);
    }

    public MyPanelRound getMyPanelRound1() {
        return myPanelRound1;
    }

    public void changeState(boolean b) {
        jRadioButton1.setSelected(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound1 = new com.sandun.web.template.MyPanelRound();
        jRadioButton1 = new javax.swing.JRadioButton();

        setMaximumSize(new java.awt.Dimension(214, 45));
        setMinimumSize(new java.awt.Dimension(214, 45));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(214, 45));

        myPanelRound1.setBackground(new java.awt.Color(204, 204, 204));
        myPanelRound1.setMaximumSize(new java.awt.Dimension(214, 45));
        myPanelRound1.setMinimumSize(new java.awt.Dimension(214, 45));
        myPanelRound1.setRoundBottomLeft(10);
        myPanelRound1.setRoundBottomRight(10);
        myPanelRound1.setRoundTopLeft(10);
        myPanelRound1.setRoundTopRight(10);

        jRadioButton1.setText("Addition Ithem Name");

        javax.swing.GroupLayout myPanelRound1Layout = new javax.swing.GroupLayout(myPanelRound1);
        myPanelRound1.setLayout(myPanelRound1Layout);
        myPanelRound1Layout.setHorizontalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanelRound1Layout.setVerticalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    public boolean getState() {
        return jRadioButton1.isSelected();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton jRadioButton1;
    private com.sandun.web.template.MyPanelRound myPanelRound1;
    // End of variables declaration//GEN-END:variables
}
