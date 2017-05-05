/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.activity_form.Ui;

import java.sql.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import publicizehub_service.Class.*;
import publicizehub_service.connectionBuilder.ConnectionBuilder;

/**
 *
 * @author dell
 */
public class FromP3 extends javax.swing.JFrame {
    FromP1 from1;
    int line1=0;
    int line2=0;


    /**
     * Creates new form EditP3
     */
    public FromP3() {
        initComponents();
        jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "dd-MM-yyyy"));
    }
    
    public FromP3(FromP1 from1) {
        initComponents();
        this.from1 = from1;
        jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "dd-MM-yyyy"));     
    }
    
    public void setProjectDetail() throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ProjectDetail.setResponsible(User.getUsername());
        ProjectDetail.setProjectNameThai(from1.getThaiName().getText());
        ProjectDetail.setProjectNameEnglish(from1.getEngName().getText());
        if(from1.getjComboBox1().getSelectedItem().toString().equals("เลือก")){
            ProjectDetail.setDepartment("");
        }else{
            ProjectDetail.setDepartment(from1.getjComboBox1().getSelectedItem().toString());
        }
        ProjectDetail.setAdvisors(from1.getAdvisors().getText());
        ProjectDetail.setRationale(from1.p2.getRationale().getText());
        ProjectDetail.setPlaceType(from1.p2.getPlaceType().getSelectedIndex());
        ProjectDetail.setPlaceLocation(from1.p2.getPlaceLocation().getText());
        ProjectDetail.setNumOfStudent((int)from1.p2.getNumOfStudent().getValue());
        ProjectDetail.setNumCome(0);
        ProjectDetail.setBudget(0);
        ProjectDetail.setOpenTime(new java.sql.Date(new Date().getTime()));
        ProjectDetail.setStartTime(java.sql.Date.valueOf(df.format((Date)from1.p2.getStartTime().getValue())));
        ProjectDetail.setEndTime(java.sql.Date.valueOf(df.format((Date)from1.p2.getEndTime().getValue())));
        ProjectDetail.setCloseTime(null);
        ProjectDetail.setStatus(1);
        ProjectDetail.setObjective(from1.p2.getObjective().getText());
        ProjectDetail.setExpected(expected.getText());
        ProjectDetail.setCommittee(Committee.jTableToArrayCommittee(from1.getjTable1()));
        ProjectDetail.setComment(null);
        ProjectDetail.setProcess(ProjectProcess.jTableToArrayProcess(jTable1));
        ProjectDetail.setMoney(Money.jTableToArrayMoney(jTable2));
        ProjectDetail.setCost(Money.getSumCost());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        expected = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        jButton3.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("ย้อนกลับ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("ส่ง");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(36, 47, 65));
        jTextField2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("รายละเอียดงบประมาณ");

        jLabel10.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("จำนวนเงิน");

        jButton6.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("เพิ่ม");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ลำดับ", "รายละเอียด", "จำนวนเงิน", "ลบ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(2).setMinWidth(100);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable2.getColumnModel().getColumn(3).setMinWidth(50);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel11.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ขั้นตอนการดำเนินงาน");

        jLabel12.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("รายการ");

        jTextField4.setBackground(new java.awt.Color(36, 47, 65));
        jTextField4.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("วันที่ดำเนินการ");

        jButton8.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setText("เพิ่ม");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ลำดับ", "รายการ", "วันที่ดำเนินการ", "ลบ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(2).setMinWidth(100);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jPanel3.setBackground(new java.awt.Color(97, 212, 195));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publicizehub_service/Image/kmutt.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 137, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton2.setText("ลบ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton7.setText("ลบ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        jLabel8.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ผลที่คาดว่าจะได้รับ");

        expected.setBackground(new java.awt.Color(36, 47, 65));
        expected.setColumns(20);
        expected.setForeground(new java.awt.Color(255, 255, 255));
        expected.setRows(5);
        jScrollPane2.setViewportView(expected);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton7))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jButton2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        from1.p2.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            setProjectDetail();
        } catch (ParseException ex) {
            Logger.getLogger(FromP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ProjectDetail.check()){
            System.out.println("Ok");
            Connection con = ConnectionBuilder.getConnection();
            try {
                PreparedStatement pt = con.prepareStatement("insert into project "
                        + "values(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pt.setString(1, ProjectDetail.getResponsible());
                pt.setString(2, ProjectDetail.getProjectNameThai());
                pt.setString(3, ProjectDetail.getProjectNameEnglish());
                pt.setString(4, ProjectDetail.getDepartment());
                pt.setString(5, ProjectDetail.getAdvisors());
                pt.setString(6, ProjectDetail.getRationale());
                pt.setInt(7, ProjectDetail.getPlaceType());
                pt.setString(8, ProjectDetail.getPlaceLocation());
                pt.setInt(9, ProjectDetail.getNumOfStudent());
                pt.setInt(10, ProjectDetail.getNumCome());
                pt.setString(11, ProjectDetail.getObjective());
                pt.setString(12, ProjectDetail.getExpected());
                pt.setDouble(13, ProjectDetail.getBudget());
                pt.setDouble(14, ProjectDetail.getCost());
                pt.setDate(15, ProjectDetail.getOpenTime());
                pt.setDate(16, ProjectDetail.getStartTime());
                pt.setDate(17, ProjectDetail.getEndTime());
                pt.setDate(18, ProjectDetail.getCloseTime());
                pt.setInt(19, ProjectDetail.getStatus());
                int a = pt.executeUpdate();
                System.out.println(a);
                pt.close();
                PreparedStatement pt2 =  con.prepareStatement("insert into committee "
                        + "values((select id form project where ), ?, ?, ?)");
                Committee[] arryCommittee = ProjectDetail.getCommittee();
                for (int i = 0; i < arryCommittee.length; i++) {
                    pt2.setString(1, arryCommittee[i].getStudentId());
                }
            } catch (SQLException ex) {
                Logger.getLogger(FromP3.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "เปิดโครงการเรียบร้อย คุณสามารถดูสถานะของโครงการได้ที่ หน้าตรวจสอบสถานะ/แก้ไข");
            from1.home.setVisible(true);
            dispose();
            from1.p2.dispose();
            from1.dispose();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String list =jTextField4.getText();
        String date = df.format(jSpinner1.getValue());
        DefaultTableModel mb=(DefaultTableModel) jTable1.getModel();
        mb.addRow(new Object[0]); 
        mb.setValueAt(line1+1, line1, 0);
        mb.setValueAt(list, line1, 1);
        mb.setValueAt(date, line1, 2);
        line1++;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String text  = jTextField2.getText();
        double money = (double)jSpinner2.getValue();
        DefaultTableModel mb=(DefaultTableModel) jTable2.getModel();
        mb.addRow(new Object[0]);
        mb.setValueAt(line2+1, line2, 0);
        mb.setValueAt(text, line2, 1);
        mb.setValueAt(money, line2, 2);
        line2++;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean[] check = new boolean[jTable1.getRowCount()]; //เก็บว่าเลือกลบอันไหน
        for(int i = 0; i < check.length ;i++){
            if(jTable1.getValueAt(i, 3) == null){
                check[i] = false;
            }else {
                check[i] = (boolean)jTable1.getValueAt(i, 3);
            }
        }
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i = check.length-1; i >= 0 ;i--){ //วนลูปลบตัวที่เลือกออก
            if(check[i]){
                model.removeRow(i);
                line1--;
            }
        }
        
        for(int i = 0; i< jTable1.getRowCount();i++){ //วนลูปเปลี่ยนลำดับที่
            model.setValueAt(i+1, i, 0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        boolean[] check = new boolean[jTable2.getRowCount()]; //เก็บว่าเลือกลบอันไหน
        for(int i = 0; i < check.length ;i++){
            if(jTable2.getValueAt(i, 3) == null){
                check[i] = false;
            }else {
                check[i] = (boolean)jTable2.getValueAt(i, 3);
            }
        }
        
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        for(int i = check.length-1; i >= 0 ;i--){ //วนลูปลบตัวที่เลือกออก
            if(check[i]){
                model.removeRow(i);
                line2--;
            }
        }
        for(int i = 0; i< jTable2.getRowCount();i++){ //วนลูปเปลี่ยนลำดับที่
            model.setValueAt(i+1, i, 0);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FromP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromP3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea expected;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
