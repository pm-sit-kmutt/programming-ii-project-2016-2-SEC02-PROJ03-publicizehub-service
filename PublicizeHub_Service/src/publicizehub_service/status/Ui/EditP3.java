/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.status.Ui;

import java.sql.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import publicizehub_service.Class.*;
import publicizehub_service.activity_form.Ui.FromP3;
import publicizehub_service.connectionBuilder.ConnectionBuilder;

/**
 *
 * @author dell
 */
public class EditP3 extends javax.swing.JFrame {
    private EditP1 edit1;
    private int line1 = 0;
    private int line2 = 0;
    private int projectId = User.getSelectProjectId();

    public EditP3() {
        initComponents();
    }
    
    public EditP3(EditP1 edit1) {
       initComponents();
       this.edit1 = edit1;
       setFrame();
    }
    
    public void setFrame(){
        check4.setText("");
        check5.setText("");
        check6.setText("");
        jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "dd-MM-yyyy"));
        DefaultTableModel mb1=(DefaultTableModel) jTable1.getModel();
        DefaultTableModel mb2=(DefaultTableModel) jTable2.getModel();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Connection cn=ConnectionBuilder.getConnection();
        try {
            Statement st = cn.createStatement();
            ResultSet re = st.executeQuery("select expected from project where id = '"+projectId+"'");
            while(re.next()){
                expected.setText(re.getString("expected"));
            }
            Statement st2 = cn.createStatement();
            ResultSet re2 = st2.executeQuery("select * from process where projectId = '"+projectId+"'");
            while(re2.next()){
                mb1.addRow(new Object[0]);
                mb1.setValueAt(line1+1, line1, 0);
                mb1.setValueAt(re2.getString("text"), line1, 1);
                mb1.setValueAt(df.format(re2.getDate("date")), line1, 2); 
                line1++;
            }
            Statement st3 = cn.createStatement();
            ResultSet re3 = st3.executeQuery("select * from money where projectId = '"+projectId+"'");
            while(re3.next()){
                mb2.addRow(new Object[0]);
                mb2.setValueAt(line2+1, line2, 0);
                mb2.setValueAt(re3.getString("text"), line2, 1);
                mb2.setValueAt(re3.getDouble("cost"), line2, 2);
                line2++;        
            }  
            st.close();
            st2.close();
            st3.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditP1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setProjectDetail() throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        ProjectDetail.setProjectNameThai(edit1.getThaiName().getText());
        ProjectDetail.setProjectNameEnglish(edit1.getEngName().getText());
        if(edit1.getjComboBox1().getSelectedItem().toString().equals("เลือก")){
            ProjectDetail.setDepartment("");
        }else{
            ProjectDetail.setDepartment(edit1.getjComboBox1().getSelectedItem().toString());
        }
        ProjectDetail.setAdvisors(edit1.getAdvisors().getText());
        ProjectDetail.setRationale(edit1.getE2().getRationale().getText());
        ProjectDetail.setPlaceType(edit1.getE2().getPlaceType().getSelectedIndex());
        ProjectDetail.setPlaceLocation(edit1.getE2().getPlaceLocation().getText());
        ProjectDetail.setNumOfStudent((int)edit1.getE2().getNumOfStudent().getValue());
        ProjectDetail.setStartTime(new Date(((java.util.Date)edit1.getE2().getStartTime().getValue()).getTime()));
        ProjectDetail.setEndTime(new Date(((java.util.Date)edit1.getE2().getEndTime().getValue()).getTime()));
        ProjectDetail.setObjective(edit1.getE2().getObjective().getText());
        ProjectDetail.setExpected(expected.getText());
        ProjectDetail.setCommittee(Committee.jTableToArrayCommittee(edit1.getjTable1()));
        ProjectDetail.setProcess(ProjectProcess.jTableToArrayProcess(jTable1));
        ProjectDetail.setMoney(Money.jTableToArrayMoney(jTable2));
        ProjectDetail.setCost(Money.getSumCost());
    }

    public JButton getjButton4() {
        return edit;
    }

    public JSpinner getjSpinner1() {
        return jSpinner1;
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
        back = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        seeComment = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        insert2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        delete2 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        expected = new javax.swing.JTextArea();
        check1 = new javax.swing.JLabel();
        check2 = new javax.swing.JLabel();
        check3 = new javax.swing.JLabel();
        check4 = new javax.swing.JLabel();
        check5 = new javax.swing.JLabel();
        check6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        back.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(51, 51, 51));
        back.setText("ย้อนกลับ");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        edit.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        edit.setForeground(new java.awt.Color(51, 51, 51));
        edit.setText("แก้ไข");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

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
                .addContainerGap(447, Short.MAX_VALUE))
        );

        seeComment.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        seeComment.setText("ดู Comment");
        seeComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeCommentActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(36, 47, 65));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("รายละเอียดค่าใช้จ่าย");

        jLabel10.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("จำนวนเงิน");

        insert2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        insert2.setForeground(new java.awt.Color(51, 51, 51));
        insert2.setText("เพิ่ม");
        insert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert2ActionPerformed(evt);
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
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(50);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(3).setMinWidth(50);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        delete2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        delete2.setText("ลบ");
        delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete2ActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1495129577477L), null, null, java.util.Calendar.DAY_OF_MONTH));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

        jLabel8.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ผลที่คาดว่าจะได้รับ");

        expected.setBackground(new java.awt.Color(36, 47, 65));
        expected.setColumns(20);
        expected.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        expected.setForeground(new java.awt.Color(255, 255, 255));
        expected.setRows(5);
        jScrollPane2.setViewportView(expected);

        check1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        check1.setForeground(new java.awt.Color(255, 0, 51));
        check1.setText("*");

        check2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        check2.setForeground(new java.awt.Color(255, 0, 51));
        check2.setText("*");

        check3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        check3.setForeground(new java.awt.Color(255, 0, 51));
        check3.setText("*");

        check4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        check4.setForeground(new java.awt.Color(255, 0, 51));
        check4.setText("*");

        check5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        check5.setForeground(new java.awt.Color(255, 0, 51));
        check5.setText("*");

        check6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        check6.setForeground(new java.awt.Color(255, 0, 51));
        check6.setText("*");

        jLabel11.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ขั้นตอนการดำเนินงาน");

        jLabel12.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("รายการ");

        jTextField4.setBackground(new java.awt.Color(36, 47, 65));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("วันที่ดำเนินการ");

        insert.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        insert.setForeground(new java.awt.Color(51, 51, 51));
        insert.setText("เพิ่ม");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
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
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(50);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        delete.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        delete.setText("ลบ");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(169, 169, 169)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(check1)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(check6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(insert2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(delete2))
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(check2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(check3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(check4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(insert)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(delete)))
                                .addGap(0, 15, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(seeComment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check1))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(insert)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(delete)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check4))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(insert2)
                            .addComponent(delete2)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check5)
                            .addComponent(check6)))
                    .addComponent(check2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seeComment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
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

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        edit1.getE2().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            setProjectDetail();
        } catch (ParseException ex) {
            Logger.getLogger(FromP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ProjectDetail.check()){
            Connection con = ConnectionBuilder.getConnection();
            try {
                PreparedStatement pt = con.prepareStatement("update project set projectNameThai = ?, projectNameEnglish = ?, department = ?, "
                        + "advisors = ?, placeType = ?, placeLocation = ?, numOfStudent = ?, rationale = ?, objective = ?, expected = ?, cost = ?, "
                        + "startTime = ?, endTime = ? where id = ?");
                pt.setString(1, ProjectDetail.getProjectNameThai());
                pt.setString(2, ProjectDetail.getProjectNameEnglish());
                pt.setString(3, ProjectDetail.getDepartment());
                pt.setString(4, ProjectDetail.getAdvisors());
                pt.setInt(5, ProjectDetail.getPlaceType());
                pt.setString(6, ProjectDetail.getPlaceLocation());
                pt.setInt(7, ProjectDetail.getNumOfStudent());
                pt.setString(8, ProjectDetail.getRationale());
                pt.setString(9, ProjectDetail.getObjective());
                pt.setString(10, ProjectDetail.getExpected());
                pt.setDouble(11, ProjectDetail.getCost());
                pt.setDate(12, ProjectDetail.getStartTime());
                pt.setDate(13, ProjectDetail.getEndTime());
                pt.setInt(14, projectId);
                int a = pt.executeUpdate();
                System.out.println(a);
                pt.close();
                
                Statement stD = con.createStatement();
                stD.executeUpdate("delete from committee where projectId = '"+projectId+"'");
                Statement stD2 = con.createStatement();
                stD2.executeUpdate("delete from process where projectId = '"+projectId+"'");
                Statement stD3 = con.createStatement();
                stD3.executeUpdate("delete from money where projectId = '"+projectId+"'");
                stD.close();
                stD2.close();
                stD3.close();
                
                PreparedStatement pt2 =  con.prepareStatement("insert into committee "
                        + "values(?, ?, ?, ?, ?)");
                Committee[] arryCommittee = ProjectDetail.getCommittee();
                for (int i = 0; i < arryCommittee.length; i++) {
                    pt2.setInt(1, projectId);
                    pt2.setString(2, arryCommittee[i].getStudentId());
                    pt2.setString(3, arryCommittee[i].getName());
                    pt2.setString(4, arryCommittee[i].getFaculty());
                    pt2.setString(5, arryCommittee[i].getJob());
                    int b = pt2.executeUpdate();
                    System.out.println(b);
                }
                pt2.close();
                
                PreparedStatement pt3 =  con.prepareStatement("insert into process "
                        + "values(?, ?, ?)");
                ProjectProcess[] arryProcess = ProjectDetail.getProcess();
                for (int i = 0; i < arryProcess.length; i++) {
                    pt3.setInt(1, projectId);
                    pt3.setString(2, arryProcess[i].getText());
                    pt3.setDate(3, arryProcess[i].getDate());
                    int c = pt3.executeUpdate();
                    System.out.println(c);
                }
                pt3.close();
                
                PreparedStatement pt4 =  con.prepareStatement("insert into money "
                        + "values(?, ?, ?)");
                Money[] arryMoney = ProjectDetail.getMoney();
                for (int i = 0; i < arryMoney.length; i++) {
                    pt4.setInt(1, projectId);
                    pt4.setString(2, arryMoney[i].getText());
                    pt4.setDouble(3, arryMoney[i].getCost());
                    int d = pt4.executeUpdate();
                    System.out.println(d);
                }
                pt4.close();

                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(FromP3.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "แก้ไขสำเร็จ คุณสามารถดูสถานะของโครงการได้ที่ หน้าตรวจสอบสถานะ/แก้ไข");
            edit1.getTable().setVisible(true);
            dispose();
            edit1.getE2().dispose();
            edit1.dispose();
        }
    }//GEN-LAST:event_editActionPerformed

    private void seeCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeCommentActionPerformed
        Comment comment = new Comment(this, rootPaneCheckingEnabled);
        comment.setVisible(true);
    }//GEN-LAST:event_seeCommentActionPerformed

    private void insert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert2ActionPerformed
        String text  = jTextField2.getText();
        double money = (double)jSpinner2.getValue();
        if(!text.isEmpty() && money != 0){
            DefaultTableModel mb=(DefaultTableModel) jTable2.getModel();
            mb.addRow(new Object[0]);
            mb.setValueAt(line2+1, line2, 0);
            mb.setValueAt(text, line2, 1);
            mb.setValueAt(money, line2, 2);
            line2++;
            jTextField2.setText("");
            jSpinner2.setValue(0.0);
            check5.setText("");
            check6.setText("");
        } else {
            if(text.isEmpty()){
                check5.setText("*");
            } else {
                check5.setText("");
            }    
            if(money == 0){
                check6.setText("*");
            } else {
                check6.setText("");
            }    
        }
    }//GEN-LAST:event_insert2ActionPerformed

    private void delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete2ActionPerformed
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
    }//GEN-LAST:event_delete2ActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String list = jTextField4.getText();
        String date = df.format(jSpinner1.getValue());
        if(!list.isEmpty()){
            DefaultTableModel mb=(DefaultTableModel) jTable1.getModel();
            mb.addRow(new Object[0]);
            mb.setValueAt(line1+1, line1, 0);
            mb.setValueAt(list, line1, 1);
            mb.setValueAt(date, line1, 2);
            line1++;
            jTextField4.setText("");
            check4.setText("");
        }else{
            check4.setText("*");
        }
    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
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
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(EditP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditP3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditP3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel check1;
    private javax.swing.JLabel check2;
    private javax.swing.JLabel check3;
    private javax.swing.JLabel check4;
    private javax.swing.JLabel check5;
    private javax.swing.JLabel check6;
    private javax.swing.JButton delete;
    private javax.swing.JButton delete2;
    private javax.swing.JButton edit;
    private javax.swing.JTextArea expected;
    private javax.swing.JButton insert;
    private javax.swing.JButton insert2;
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
    private javax.swing.JButton seeComment;
    // End of variables declaration//GEN-END:variables
}
