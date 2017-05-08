/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.status.Ui;
import publicizehub_service.Class.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import publicizehub_service.connectionBuilder.ConnectionBuilder;
import publicizehub_service.report.Ui.*;
/**
 *
 * @author dell
 */
public class EditP1 extends javax.swing.JFrame {
    Tableview table = null;
    FinishedReportFrame frf = null;
    int checkCase = 0;
    EditP2 e2;
    EditP3 e3;
    int projectId = User.getSelectProjectId();
    int line=0;

    public EditP1() { //ไว้ test
        initComponents();
        setFrame();
    }
    
    public EditP1(Tableview table) {
        initComponents();
        this.table=table;
        setFrame();
        checkCase = 1;
    }
    
    public EditP1(FinishedReportFrame frf){
        initComponents();
        this.frf=frf;
        setFrame();
        e3.getjButton4().setEnabled(false);
        checkCase = 2;
    }
    
    public void setFrame(){
        e2 = new EditP2(this);
        e3 = new EditP3(this);
        DefaultTableModel mb=(DefaultTableModel) jTable1.getModel();
        Connection cn = ConnectionBuilder.getConnection();
        try {
            Statement st=cn.createStatement();
            ResultSet re=st.executeQuery("select projectNameThai, projectNameEnglish, department, advisors from project where id = '"+projectId+"'");
            while(re.next()){
                thaiName.setText(re.getString("projectNameThai"));
                engName.setText(re.getString("projectNameEnglish"));
                jComboBox1.setSelectedItem(re.getString("department"));
                advisors.setText(re.getString("advisors"));
            }
            Statement st2=cn.createStatement();
            ResultSet re2=st2.executeQuery("select * from committee where projectId = '"+projectId+"'");
            while(re2.next()){
                mb.addRow(new Object[0]);
                mb.setValueAt(re2.getString("studentId"), line, 0);
                mb.setValueAt(re2.getString("name"), line, 1);
                mb.setValueAt(re2.getString("faculty"), line, 2);
                mb.setValueAt(re2.getString("job"), line, 3);
                line++;
            }
            st.close();
            st2.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditP1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public JTextField getAdvisors() {
        return advisors;
    }

    public JTextField getEngName() {
        return engName;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public JTextField getThaiName() {
        return thaiName;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        thaiName = new javax.swing.JTextField();
        engName = new javax.swing.JTextField();
        advisors = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publicizehub_service/Image/kmutt.png"))); // NOI18N
        jLabel4.setText("jLabel3");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publicizehub_service/Image/Untitled-2.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel3.setFont(new java.awt.Font("ThaiSans Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ชื่อ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        jLabel10.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ชื่อโครงการ  (ภาษาไทย) ");

        jLabel11.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ชื่อโครงการ (ภาษาอังกฤษ)");

        jLabel13.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("อาจารย์ที่ปรึกษาโครงการ");

        jLabel15.setFont(new java.awt.Font("ThaiSans Neue", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("คณะกรรมการจัดทำโครงการ");

        thaiName.setBackground(new java.awt.Color(36, 47, 65));
        thaiName.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        thaiName.setForeground(new java.awt.Color(255, 255, 255));

        engName.setBackground(new java.awt.Color(36, 47, 65));
        engName.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        engName.setForeground(new java.awt.Color(255, 255, 255));

        advisors.setBackground(new java.awt.Color(36, 47, 65));
        advisors.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        advisors.setForeground(new java.awt.Color(255, 255, 255));

        jTextField7.setBackground(new java.awt.Color(36, 47, 65));
        jTextField7.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ชื่อ-นามสกุล");

        jLabel16.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("รหัสนักศึกษา");

        jTextField10.setBackground(new java.awt.Color(36, 47, 65));
        jTextField10.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสนักศึกษา", "ชื่อ - นามสกุล", "คณะ", "หน้าที่", "ลบ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        jLabel9.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("คณะ");

        jLabel19.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("หน้าที่");

        jTextField9.setBackground(new java.awt.Color(36, 47, 65));
        jTextField9.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));

        jButton7.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton7.setText("เพิ่ม");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publicizehub_service/Image/kmutt.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 137, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("ThaiSans Neue", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("กรอกรายละเอียด");

        jButton1.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton1.setText("หน้าถัดไป");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField11.setBackground(new java.awt.Color(36, 47, 65));
        jTextField11.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton2.setText("ย้อนกลับ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jButton3.setText("ลบ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("ThaiSans Neue", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("สังกัดโครงการ");

        jComboBox1.setFont(new java.awt.Font("ThaiSans Neue", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เลือก", "กลุ่มนักร้องประสานเสียง", "กลุ่มนักศึกษาคณะ ภาควิชา", "กลุ่มนักศึกษาทุนการศึกษา", "กลุ่มนักศึกษาทุนเพชรพระจอมเกล้า", "ชมรม 2B-KMUTT", "ชมรม Formula Student", "ชมรม KMUTT Cover Dance Club", "ชมรม KMUTT E-Sports", "ชมรม KMUTT Entrepreneur Club", "ชมรม KMUTT Green Heart", "ชมรมการลงทุน", "ชมรมคอมพิวเตอร์", "ชมรมจักรยานสีเขียว", "ชมรมดนตรีไทยและนาฎศิลป์", "ชมรมดาบสากล", "ชมรมดินสอสีขาว", "ชมรมติว", "ชมรมเทควันโด", "ชมรมเทนนิส", "ชมรมเทเบิลเทนนิส", "ชมรมธนบุรีโรบอทคอนเทส", "ชมรมนักวิทยุสมัครเล่นและเทคโนโลยีอวกาศเพื่อการวิจัย", "ชมรมนักศึกษาคริสเตียน", "ชมรมนักศึกษามุสลิม", "ชมรมบริดจ์", "ชมรมบันเทิงและดนตรีสากล", "ชมรมบาสเกตบอล", "ชมรมแบดมินตัน", "ชมรมเปตอง", "ชมรมพัฒนาเกมส์", "ชมรมพัฒนาศักยภาพและคุณธรรม", "ชมรมพุทธศาสตร์", "ชมรมเพาะกาย", "ชมรมฟุตซอล", "ชมรมฟุตบอล", "ชมรมไฟฟ้าวิชาการ", "ชมรมยูโด", "ชมรมรักบี้ฟุตบอล", "ชมรมโรตาแรคท์", "ชมรมแลกเปลี่ยนวัฒนธรรมนานาชาติ", "ชมรมวรรณศิลป์", "ชมรมวอลเลย์บอล", "ชมรมศิลปวัฒนธรรมทักษิณ", "ชมรมศิลปวัฒนธรรมล้านนา", "ชมรมศิลปวัฒนธรรมอีสาน", "ชมรมศิลปะภาพวาดการ์ตูนและวัฒนธรรมญี่ปุ่นสมัยนิยม", "ชมรมศิลปะและการถ่ายภาพ", "ชมรมสันทนาการและเชียร์", "ชมรมสัมปชัญโญสโมสร", "ชมรมหมากกระดาน", "ชมรมอนุรักษ์ทรัพยากรธรรมชาติและสิ่งแวดล้อม", "ชมรมอาสาพัฒนาชนบท", "ชมรมอิเล็กทรอนิกส์บางมด", "ชมรมอูคูเลเล่", "สภานักศึกษา", "สโมสรนักศึกษาคณะครุศาสตร์อุตสาหกรรมและเทคโนโลยี", "สโมสรนักศึกษาคณะเทคโนโลยีสารสนเทศ", "สโมสรนักศึกษาคณะวิทยาศาสตร์", "สโมสรนักศึกษาคณะวิศวกรรมศาสตร์", "สโมสรนักศึกษาคณะสถาปัตยกรรมศาสตร์และการออกแบบ", "สโมสรนักศึกษาโครงการร่วมบริหารหลักสูตรมีเดียอาตส์และเทคโนโลยี", "สื่อสารมวลชนและเทคโนโลยีมีเดีย", "หอพักนักศึกษา", "องค์การนักศึกษา", "คณะพลังงานสิ่งแวดล้อมและวัสดุ", "คณะวิศวกรรมศาสตร์", "คณะเทคโนโลยีสารสนเทศ", "คณะศิลปศาสตร์", "คณะทรัพยากรชีวภาพและเทคโนโลยี", "คณะสถาปัตยกรรมศาสตร์และการออกแบบ", "คณะวิทยาศาสตร์", "คณะครุศาสตร์อุตสาหกรรมและเทคโนโลยี", "สำนักงานอธิการบดี", "สำนักคอมพิวเตอร์", "สำนักสวนอุตสาหกรรม", "สำนักหอสมุด", "สำนักบริหารอาคารและสถานที่", "สำนักบัณฑิตศึกษาและกิจการนานาชาติ", "สำนักวิจัยและบริการวิทยาศาสตร์และเทคโนโลยี", "สถาบันการเรียนรู้", "สถาบันวิทยาการหุ่นยนต์ภาคสนาม", "ศูนย์การจัดการด้านพลังงานสิ่งแวดล้อมความปลอดภัยและอาชีวอนามัย", "บัณฑิตวิทยาลัยร่วมด้านพลังงานและสิ่งแวดล้อม", "บัณฑิตวิทยาลัยการจัดการและนวัตกรรม", "หน่วยงานในกำกับมหาวิทยาลัย" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(engName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(advisors, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(thaiName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(220, 220, 220))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jButton7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton3))
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(69, 69, 69))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thaiName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(engName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(advisors, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel19)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        e2.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(checkCase == 1){
            table.setVisible(true);
        }else if(checkCase == 2){
            frf.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String name =jTextField11.getText();
        String id =jTextField7.getText();
        String faculty=jTextField10.getText();
        String job=jTextField9.getText();
        if(!name.isEmpty() && !id.isEmpty() && !faculty.isEmpty() && !job.isEmpty()){
            DefaultTableModel mb=(DefaultTableModel) jTable1.getModel();
            mb.addRow(new Object[0]);
            mb.setValueAt(id, line, 0);
            mb.setValueAt(name, line, 1);
            mb.setValueAt(faculty, line, 2);
            mb.setValueAt(job, line, 3);
            line++;
            jTextField11.setText("");
            jTextField7.setText("");
            jTextField9.setText("");
            jTextField10.setText("");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean[] check = new boolean[jTable1.getRowCount()]; //เก็บว่าเลือกลบอันไหน
        for(int i = 0; i < check.length ;i++){
            if(jTable1.getValueAt(i, 4) == null){
                check[i] = false;
            }else {
                check[i] = (boolean)jTable1.getValueAt(i, 4);
            }
        }
        
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(int i = check.length-1; i >= 0 ;i--){ //วนลูปลบตัวที่เลือกออก
            if(check[i]){
                 model.removeRow(i);
                line--;
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(EditP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditP1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField advisors;
    private javax.swing.JTextField engName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField thaiName;
    // End of variables declaration//GEN-END:variables
}
