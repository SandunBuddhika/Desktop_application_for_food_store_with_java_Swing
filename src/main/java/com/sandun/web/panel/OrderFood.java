package com.sandun.web.panel;

import com.sandun.web.dto.ExtraIngredientDTO;
import com.sandun.web.dto.FoodDTO;
import com.sandun.web.entities.Food;
import com.sandun.web.model.AddExtraIngredient;
import com.sandun.web.model.ClickEffectManager;
import com.sandun.web.model.CustomExtraIngredient;
import com.sandun.web.model.FontManager;
import com.sandun.web.model.MyDecimalFormater;
import com.sandun.web.template.AdditionalIngredient;
import com.sandun.web.template.FoodItem;
import com.sandun.web.template.QTYDialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.sandun.web.service.FoodService;
import com.sandun.web.service.InvoiceService;

public class OrderFood extends javax.swing.JPanel {

    private FoodService foodService;
    private FoodDTO.Builder currentFood;
    private List<FoodDTO> order;
    private DefaultTableModel dtm;
    private InvoiceService invoiceService;
    private ClickEffectManager cem;

    public OrderFood() {
        cem = new ClickEffectManager(new Color(204, 204, 204), new Color(150, 150, 150));
        initComponents();
        foodService = new FoodService();
        order = new ArrayList<>();
        invoiceService = new InvoiceService();
        dtm = (DefaultTableModel) jTable1.getModel();
        new Thread(() -> {
            loadFoodItems();
        }).start();
        setUp();
    }

    private void setUp() {
        FontManager.setFontForLable(FontManager.outfitLight, 12f, jTable1);
        FontManager.setFontForLable(FontManager.outfitMedium, 24f, jLabel1);
        FontManager.setFontForLable(FontManager.outfitMedium, 18f, jLabel2);
        FontManager.setFontForLable(FontManager.outfitRegular, 14f, jLabel5);
        FontManager.setFontForLables(FontManager.nacelleRegular, 12f, jLabel6, extraTotalLable, jLabel3, jLabel4, totalLable, jLabel8);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanelRound1 = new com.sandun.web.template.MyPanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        myPanelRound2 = new com.sandun.web.template.MyPanelRound();
        customCode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        myPanelRound3 = new com.sandun.web.template.MyPanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodItem = new javax.swing.JPanel();
        myPanelRound4 = new com.sandun.web.template.MyPanelRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        myPanelRound5 = new com.sandun.web.template.MyPanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        myPanelRound6 = new com.sandun.web.template.MyPanelRound();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        totalLable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        extraTotalLable = new javax.swing.JLabel();
        myPanelRound7 = new com.sandun.web.template.MyPanelRound();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1029, 720));
        setMinimumSize(new java.awt.Dimension(1029, 720));

        myPanelRound1.setBackground(new java.awt.Color(204, 204, 204));
        myPanelRound1.setMaximumSize(new java.awt.Dimension(1017, 698));
        myPanelRound1.setMinimumSize(new java.awt.Dimension(1017, 698));
        myPanelRound1.setRoundBottomLeft(30);
        myPanelRound1.setRoundBottomRight(30);
        myPanelRound1.setRoundTopLeft(30);
        myPanelRound1.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Order");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Available Food Items");

        customCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customCodeKeyPressed(evt);
            }
        });

        jLabel7.setText("Custom Code");

        javax.swing.GroupLayout myPanelRound2Layout = new javax.swing.GroupLayout(myPanelRound2);
        myPanelRound2.setLayout(myPanelRound2Layout);
        myPanelRound2Layout.setHorizontalGroup(
            myPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customCode, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        myPanelRound2Layout.setVerticalGroup(
            myPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customCode, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Extra", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        myPanelRound3.setRoundBottomLeft(8);
        myPanelRound3.setRoundBottomRight(8);
        myPanelRound3.setRoundTopLeft(8);
        myPanelRound3.setRoundTopRight(5);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1005, 243));

        foodItem.setLayout(new java.awt.GridLayout(1, 0, 10, 10));
        jScrollPane1.setViewportView(foodItem);

        javax.swing.GroupLayout myPanelRound3Layout = new javax.swing.GroupLayout(myPanelRound3);
        myPanelRound3.setLayout(myPanelRound3Layout);
        myPanelRound3Layout.setHorizontalGroup(
            myPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanelRound3Layout.setVerticalGroup(
            myPanelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        myPanelRound4.setMaximumSize(new java.awt.Dimension(240, 194));
        myPanelRound4.setMinimumSize(new java.awt.Dimension(240, 194));
        myPanelRound4.setRoundBottomLeft(8);
        myPanelRound4.setRoundBottomRight(8);
        myPanelRound4.setRoundTopLeft(8);
        myPanelRound4.setRoundTopRight(8);

        jScrollPane3.setBorder(null);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(228, 32767));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(228, 16));

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(jPanel6);

        javax.swing.GroupLayout myPanelRound4Layout = new javax.swing.GroupLayout(myPanelRound4);
        myPanelRound4.setLayout(myPanelRound4Layout);
        myPanelRound4Layout.setHorizontalGroup(
            myPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        myPanelRound4Layout.setVerticalGroup(
            myPanelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        myPanelRound5.setRoundBottomLeft(8);
        myPanelRound5.setRoundBottomRight(8);
        myPanelRound5.setRoundTopLeft(8);
        myPanelRound5.setRoundTopRight(8);

        jLabel4.setText("Sub Total");

        jLabel8.setText("LKR 0.00");

        jButton2.setText("Add To Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanelRound5Layout = new javax.swing.GroupLayout(myPanelRound5);
        myPanelRound5.setLayout(myPanelRound5Layout);
        myPanelRound5Layout.setHorizontalGroup(
            myPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelRound5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        myPanelRound5Layout.setVerticalGroup(
            myPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        myPanelRound6.setRoundBottomLeft(8);
        myPanelRound6.setRoundBottomRight(8);
        myPanelRound6.setRoundTopLeft(8);
        myPanelRound6.setRoundTopRight(8);

        jButton1.setText("Check Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Total");

        totalLable.setText("LKR 0.00");

        jLabel6.setText("Extras");

        extraTotalLable.setText("LKR 0.00");

        javax.swing.GroupLayout myPanelRound6Layout = new javax.swing.GroupLayout(myPanelRound6);
        myPanelRound6.setLayout(myPanelRound6Layout);
        myPanelRound6Layout.setHorizontalGroup(
            myPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(extraTotalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        myPanelRound6Layout.setVerticalGroup(
            myPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(myPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(extraTotalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalLable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        myPanelRound7.setRoundBottomLeft(8);
        myPanelRound7.setRoundBottomRight(8);
        myPanelRound7.setRoundTopLeft(8);
        myPanelRound7.setRoundTopRight(8);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cart");

        javax.swing.GroupLayout myPanelRound7Layout = new javax.swing.GroupLayout(myPanelRound7);
        myPanelRound7.setLayout(myPanelRound7Layout);
        myPanelRound7Layout.setHorizontalGroup(
            myPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanelRound7Layout.setVerticalGroup(
            myPanelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout myPanelRound1Layout = new javax.swing.GroupLayout(myPanelRound1);
        myPanelRound1.setLayout(myPanelRound1Layout);
        myPanelRound1Layout.setHorizontalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addComponent(myPanelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(myPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myPanelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myPanelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(myPanelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(myPanelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanelRound1Layout.setVerticalGroup(
            myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myPanelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addComponent(myPanelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanelRound1Layout.createSequentialGroup()
                        .addComponent(myPanelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(myPanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myPanelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myPanelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myPanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (currentFood != null) {
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            QTYDialog dialog = new QTYDialog(topFrame, true, this, currentFood);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please Select a Food Item first", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!order.isEmpty()) {
            boolean orderState = invoiceService.checkOut(order);
            if (orderState) {
                reset();
                JOptionPane.showMessageDialog(this, "Your Food Order Is Now Complete!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Somethign Went Wrong Please Try Again", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your Must Least Order 1 Food item or more!!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void customCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customCodeKeyPressed
        if (evt.getKeyCode() == 10) {
            CustomExtraIngredient customExpression = new CustomExtraIngredient(customCode.getText());
            AddExtraIngredient addIngredientNonExpression = new AddExtraIngredient(this, customExpression, currentFood);
            addIngredientNonExpression.interpret();
        }
    }//GEN-LAST:event_customCodeKeyPressed

    private void reset() {
        jPanel6.removeAll();
        currentFood = null;
        int size = dtm.getRowCount();
        for (int i = size - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        jPanel6.revalidate();
        jPanel6.repaint();
        jLabel8.setText("LKR 0.00");
        totalLable.setText("LKR 0.00");
        extraTotalLable.setText("LKR 0.00");
    }

    public void addToTable() {
        double total = 0;
        String extra = "";
        currentFood.setExtraIngredients(new ArrayList<>());
        for (Component c : jPanel6.getComponents()) {
            if (c instanceof AdditionalIngredient) {
                AdditionalIngredient a = (AdditionalIngredient) c;
                if (a.getState()) {
                    ExtraIngredientDTO ei = a.getExtraIngredentDTO();
                    total += ei.getPrice();
                    extra += ei.getName() + ", ";
                    currentFood.addExtraIngredients(ei);
                }
            }
        }
        FoodDTO f = currentFood.build();
        total += f.getPrice();
        order.add(f);
        Vector<String> v = new Vector<>();
        v.add(f.getName());
        v.add(MyDecimalFormater.formatWithOutLKR(f.getPrice()));
        v.add(String.valueOf(f.getQty()));
        if (!extra.isBlank()) {
            v.add(extra.substring(0, extra.length() - 2));
        } else {
            v.add("None");
        }
        v.add(MyDecimalFormater.formatWithOutLKR(total * f.getQty()));
        dtm.addRow(v);
        calculateTotal();
        jLabel8.setText("LKR 0.00");
        resetSelected();
    }

    private void resetSelected() {
        for (Component c : jPanel6.getComponents()) {
            if (c instanceof AdditionalIngredient) {
                AdditionalIngredient a = (AdditionalIngredient) c;
                if (a.getState()) {
                    a.deSelect();
                }
            }
        }
    }

    private void calculateTotal() {
        double total = 0;
        double extraTotal = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int qty = Integer.parseInt(dtm.getValueAt(i, 2).toString());
            total += (Double.parseDouble(dtm.getValueAt(i, 4).toString().replaceAll(",", "")));
            extraTotal += (qty * Double.parseDouble(dtm.getValueAt(i, 1).toString().replaceAll(",", "")));
        }
        extraTotal = total - extraTotal;
        totalLable.setText(MyDecimalFormater.format(total));
        extraTotalLable.setText(MyDecimalFormater.format(extraTotal));
    }

    private void calculateSubTotal() {
        double subTotal = Double.parseDouble(jLabel8.getText().replaceAll("LKR ", "").replaceAll(",", ""));
        for (Component c : jPanel6.getComponents()) {
            if (c instanceof AdditionalIngredient) {
                AdditionalIngredient a = (AdditionalIngredient) c;
                if (a.getState()) {
                    ExtraIngredientDTO ei = a.getExtraIngredentDTO();
                    subTotal += ei.getPrice();
                }
            }
        }
        jLabel8.setText(MyDecimalFormater.format(subTotal));
    }

    private void loadFoodItems() {
        List<Food> list = foodService.getAllFoodItems();
        if (list != null && !list.isEmpty()) {
            foodItem.removeAll();
            GridLayout gl = (GridLayout) foodItem.getLayout();
            gl.setColumns(3);
            double size = list.size();
            int rows = (int) Math.round(size % 3 > 5 ? size / 3 + 1 : size / 3);
            gl.setRows(rows);
            for (Food f : list) {
                FoodItem item = new FoodItem(f);
                List<ExtraIngredientDTO> elDTO = item.getFood().getExtraIngredients();
                item.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        currentFood = new FoodDTO.Builder().setId(f.getId()).setName(f.getName()).setPath(f.getImg()).setPrice(f.getPrice()).setDescription(f.getDescription());
                        cem.showEffect(item.getBackPanel(), ClickEffectManager.HOLD_BLINK);
                        jLabel8.setText(MyDecimalFormater.format(f.getPrice()));
                        jPanel6.removeAll();
                        jPanel6.add(Box.createVerticalStrut(5));
                        ClickEffectManager extraCem = new ClickEffectManager(new Color(204, 204, 204), new Color(150, 150, 150));
                        if (elDTO != null && !elDTO.isEmpty()) {
                            for (ExtraIngredientDTO entry : elDTO) {
                                AdditionalIngredient ai = new AdditionalIngredient(entry);
                                ai.setStateChangeEvent((ItemEvent e1) -> {
                                    extraCem.showEffect(ai.getMyPanelRound1(), ClickEffectManager.BLINK);
                                    jLabel8.setText(MyDecimalFormater.format(f.getPrice()));
                                    calculateSubTotal();
                                });
                                jPanel6.add(ai);
                                jPanel6.add(Box.createVerticalStrut(5));
                            }
                        }
                        jPanel6.repaint();
                        jPanel6.revalidate();
                    }
                });
                foodItem.add(item);
            }
            foodItem.revalidate();
            foodItem.repaint();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customCode;
    private javax.swing.JLabel extraTotalLable;
    private javax.swing.JPanel foodItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private com.sandun.web.template.MyPanelRound myPanelRound1;
    private com.sandun.web.template.MyPanelRound myPanelRound2;
    private com.sandun.web.template.MyPanelRound myPanelRound3;
    private com.sandun.web.template.MyPanelRound myPanelRound4;
    private com.sandun.web.template.MyPanelRound myPanelRound5;
    private com.sandun.web.template.MyPanelRound myPanelRound6;
    private com.sandun.web.template.MyPanelRound myPanelRound7;
    private javax.swing.JLabel totalLable;
    // End of variables declaration//GEN-END:variables
}
