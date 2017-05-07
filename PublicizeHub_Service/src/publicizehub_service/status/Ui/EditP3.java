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
    EditP1 edit1;
    int line1 = 0;
    int line2 = 0;
    int projectId=User.getSelectProjectId();

    public EditP3() {
        initComponents();
        setFrame();
    }
    
    public EditP3(EditP1 edit1) {
       initComponents();
       this.edit1 = edit1;
       setFrame();
    }
    
    public void setFrame(){
        jSpinner1.setEditor(new JSpinner.DateEditor(jSpinner1, "dd-MM-yyyy"));
        DefaultTableModel mb1=(DefaultTableModel) jTable1.getModel();
        DefaultTableModel mb2=(DefaultTableModel) jTable2.getModel();

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
                mb1.setValueAt(re2.getString("date"), line1, 2); 
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
        ProjectDetail.setRationale(edit1.e2.getRationale().getText());
        ProjectDetail.setPlaceType(edit1.e2.getPlaceType().getSelectedIndex());
        ProjectDetail.setPlaceLocation(edit1.e2.getPlaceLocation().getText());
        ProjectDetail.setNumOfStudent((int)edit1.e2.getNumOfStudent().getValue());
        ProjectDetail.setStartTime(java.sql.Date.valueOf(df.format((java.util.Date)edit1.e2.getStartTime().getValue())));
        ProjectDetail.setEndTime(java.sql.Date.valueOf(df.format((java.util.Date)edit1.e2.getEndTime().getValue())));
        ProjectDetail.setObjective(edit1.e2.getObjective().getText());
        ProjectDetail.setExpected(expected.getText());
        ProjectDetail.setCommittee(Committee.jTableToArrayCommittee(edit1.getjTable1()));
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
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        expected = new javax.swing.JTextArea();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        jLabel8.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ผลที่คาดว่าจะได้รับ");

        jLabel7.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("รายละเอียดงบประมาณ");

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
        jButton4.setText("แก้ไข");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(36, 47, 65));
        jTextField2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

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

        jTable2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ลำดับ", "รายละเอียด", "จำนวนเงิน", "ลบ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
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

        jTable1.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
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

        expected.setBackground(new java.awt.Color(36, 47, 65));
        expected.setColumns(20);
        expected.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        expected.setForeground(new java.awt.Color(255, 255, 255));
        expected.setRows(5);
        jScrollPane4.setViewportView(expected);

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7))
                            .addComponent(jLabel8))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton8)
                    .addComponent(jButton2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        edit1.e2.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
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
                int delete = stD.executeUpdate("delete from committee where projectId = '"+projectId+"'");
                Statement stD2 = con.createStatement();
                int delete2 = stD2.executeUpdate("delete from process where projectId = '"+projectId+"'");
                Statement stD3 = con.createStatement();
                int delete3 = stD3.executeUpdate("delete from money where projectId = '"+projectId+"'");
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
            edit1.table.setVisible(true);
            dispose();
            edit1.e2.dispose();
            edit1.dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String list = jTextField4.getText();
        String date = df.format(jSpinner1.getValue());
        if(!list.isEmpty() && !date.isEmpty()){
            DefaultTableModel mb=(DefaultTableModel) jTable1.getModel();
            mb.addRow(new Object[0]); 
            mb.setValueAt(line1+1, line1, 0);
            mb.setValueAt(list, line1, 1);
            mb.setValueAt(date, line1, 2);
            line1++;
            jTextField4.setText("");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
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
            jSpinner2.setValue(0);
        }
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
