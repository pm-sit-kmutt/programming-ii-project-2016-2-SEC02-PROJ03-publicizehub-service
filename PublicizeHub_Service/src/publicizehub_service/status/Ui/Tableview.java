/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.status.Ui;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;
import publicizehub_service.activity_form.Ui.KMUTTPublicizeService;
import publicizehub_service.connectionBuilder.ConnectionBuilder;
import publicizehub_service.Class.User;
import publicizehub_service.report.Ui.SubmitFrame;
/**
 *
 * @author dell
 */
public class Tableview extends javax.swing.JFrame {
    private KMUTTPublicizeService home;
    private Connection con;
    private Statement st;
    private ResultSet re;
            
    public Tableview() {
        initComponents();
    }

    
    public Tableview(KMUTTPublicizeService home) {
        initComponents();
        this.home = home;
        con = ConnectionBuilder.getConnection();
        setFrame();
    }
    
    public void setFrame(){
        DefaultTableModel de = (DefaultTableModel)viewProject.getModel();
        int line =0;
        
        try {
            st = con.createStatement();
            re = st.executeQuery("select id, projectNameThai, openTime, status from project where not status = 0 and responsible = '"+User.getUsername()+"'");
            while(re.next()){
                de.addRow(new Object[0]);
                de.setValueAt(re.getString("projectNameThai"), line, 0);
                de.setValueAt(re.getString("openTime"), line, 1);
                if(re.getString("status").equals("1")){
                    de.setValueAt("รออนุมัติ", line, 2);
                }else if(re.getString("status").equals("2")){
                    de.setValueAt("อนุมัติแล้ว", line, 2);
                }else if(re.getString("status").equals("3")){
                    de.setValueAt("รอปิดโครงการ", line, 2);
                }
                de.setValueAt("ดู comment", line, 3);
                line++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewProject = new javax.swing.JTable();
        back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));

        viewProject.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        viewProject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ชื่อโครงการ", "วันที่เปิดโครงการ", "สถานะของโครงการ", "ดู Comment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewProject.setRowHeight(23);
        viewProject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewProject);
        if (viewProject.getColumnModel().getColumnCount() > 0) {
            viewProject.getColumnModel().getColumn(0).setMinWidth(180);
            viewProject.getColumnModel().getColumn(0).setMaxWidth(180);
            viewProject.getColumnModel().getColumn(1).setMinWidth(100);
            viewProject.getColumnModel().getColumn(1).setMaxWidth(100);
            viewProject.getColumnModel().getColumn(2).setMinWidth(120);
            viewProject.getColumnModel().getColumn(2).setMaxWidth(120);
            viewProject.getColumnModel().getColumn(3).setMinWidth(120);
            viewProject.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        back.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        back.setText("ย้อนกลับ");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("ThaiSans Neue", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ตรวจสอบสถานะ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(back)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(227, 227, 227))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(back)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        try {    
            if(st != null){
                st.close();
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void viewProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProjectMouseClicked
       int row = 0;
       int col = 0;
       if(viewProject.getValueAt(viewProject.getSelectedRow(), viewProject.getSelectedColumn()) != null){
            row = viewProject.getSelectedRow();
            col = viewProject.getSelectedColumn();
       }
       if (col==2){
           setVisible(false);
           try {
               if(!re.isBeforeFirst()){
                    re.absolute(row+1);
                    User.setSelectProjectId(re.getInt("id"));
               }
           } catch (SQLException ex) {
               Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
           }
           if(viewProject.getValueAt(row, col).equals("รออนุมัติ")){
               EditP1 e1 = new EditP1(this);
               e1.setVisible(true);
           }else if(viewProject.getValueAt(row, col).equals("อนุมัติแล้ว")){
               SubmitFrame sf = new SubmitFrame(this);
               sf.setVisible(true);
           }else if(viewProject.getValueAt(row, col).equals("รอปิดโครงการ")){
               SubmitFrame sf = new SubmitFrame(this);
               sf.setVisible(true);
           }
       }if(col==3){
           try {
               if(!re.isBeforeFirst()){
                    re.absolute(row+1);
                    User.setSelectProjectId(re.getInt("id"));
                    Comment cm=new Comment(this, rootPaneCheckingEnabled);
                    cm.setVisible(true);
               }
           } catch (SQLException ex) {
               Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_viewProjectMouseClicked

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
            java.util.logging.Logger.getLogger(Tableview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tableview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tableview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tableview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tableview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable viewProject;
    // End of variables declaration//GEN-END:variables
}
