package gradeallocation.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentDetailsByGrade extends javax.swing.JFrame {

    public StudentDetailsByGrade() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Student details");
        //dabase connected using a method
        db_connect();
        pButton.setEnabled(false);
        nButton.setEnabled(false);
    }

    private void createDetails(StudentDetails studentDetails) {
        studDet.add(studentDetails);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        HDRadioButton = new javax.swing.JRadioButton();
        DRadioButton = new javax.swing.JRadioButton();
        CRadioButton = new javax.swing.JRadioButton();
        PRadioButton = new javax.swing.JRadioButton();
        FRadioButton = new javax.swing.JRadioButton();
        SARadioButton = new javax.swing.JRadioButton();
        SERadioButton = new javax.swing.JRadioButton();
        AFRadioButton = new javax.swing.JRadioButton();
        showButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studDetailsTextArea = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Select Grade Value");

        buttonGroup1.add(HDRadioButton);
        HDRadioButton.setText("HD");

        buttonGroup1.add(DRadioButton);
        DRadioButton.setText("D");

        buttonGroup1.add(CRadioButton);
        CRadioButton.setSelected(true);
        CRadioButton.setText("C");

        buttonGroup1.add(PRadioButton);
        PRadioButton.setText("P");

        buttonGroup1.add(FRadioButton);
        FRadioButton.setText("F");

        buttonGroup1.add(SARadioButton);
        SARadioButton.setText("SA");

        buttonGroup1.add(SERadioButton);
        SERadioButton.setText("SE");

        buttonGroup1.add(AFRadioButton);
        AFRadioButton.setText("AF");

        showButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        showButton.setText("Show");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        studDetailsTextArea.setColumns(20);
        studDetailsTextArea.setRows(5);
        jScrollPane1.setViewportView(studDetailsTextArea);

        cancelButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        pButton.setText("Pre");
        pButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtonActionPerformed(evt);
            }
        });

        nButton.setText("Nxt");
        nButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(HDRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(DRadioButton)
                                        .addGap(24, 24, 24)
                                        .addComponent(CRadioButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(FRadioButton)
                                        .addGap(26, 26, 26)
                                        .addComponent(SARadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(SERadioButton)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AFRadioButton)
                                    .addComponent(PRadioButton))))
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(pButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nButton)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(HDRadioButton)
                    .addComponent(DRadioButton)
                    .addComponent(CRadioButton)
                    .addComponent(PRadioButton))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FRadioButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SERadioButton)
                        .addComponent(AFRadioButton)
                        .addComponent(SARadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nButton)
                    .addComponent(pButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        studDet = new ArrayList<StudentDetails>();
        pos = 0;
        try {
            String retrieveQuery = "";
            String studDetails = "";
            int avail = 0;
            if (HDRadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade HD
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='HD' ORDER BY TOTAL";
            } else if (DRadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade D
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='D' ORDER BY TOTAL";
            } else if (CRadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade C
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='C' ORDER BY TOTAL";
            } else if (PRadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade P
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='P' ORDER BY TOTAL";
            } else if (FRadioButton.isSelected() == true) {
                avail = 1;
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='F' ORDER BY TOTAL";
            } else if (SARadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade SA
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='SA' ORDER BY TOTAL";
            } else if (SERadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade SE
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='SE' ORDER BY TOTAL";
            } else if (AFRadioButton.isSelected() == true) {
                avail = 1;
                //query to retrieve the student details for selected grade AF
                retrieveQuery = "SELECT * FROM MARKS WHERE GRADE='AF' ORDER BY TOTAL";
            } else {
                JOptionPane.showMessageDialog(null, "Select any grade", "Error Message", JOptionPane.ERROR_MESSAGE);
            }

            if (avail != 0) {
                //retrieve query created and executed then the values are stored in variables
                stmnt = conn.createStatement();
                resSet = stmnt.executeQuery(retrieveQuery);

                while (resSet.next()) {
                    stu_id = resSet.getString(1);
                    a1_mark = resSet.getInt(2);
                    a2_mark = resSet.getInt(3);
                    e_mark = resSet.getInt(4);
                    tot_mark = resSet.getInt(5);
                    grade = resSet.getString(6);

                    createDetails(new StudentDetails(stu_id, a1_mark, a2_mark, e_mark, tot_mark, grade));
                    //message created to display in text area
                    studDetails = "Student ID\t- " + studDet.get(pos).getId()
                            + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                            + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                            + "\nExam Mark\t- " + studDet.get(pos).getExam()
                            + "\nTotal\t- " + studDet.get(pos).getTot()
                            + "\nGrade\t- " + studDet.get(pos).getGrade();
                }

                if (studDetails.equals("")) {
                    studDetailsTextArea.setText("Student detail for selected grade is not available");
                } else {
                    studDetailsTextArea.setText(studDetails);
                }

                if (studDet.size() > 1) {
                    nButton.setEnabled(true);
                    pButton.setEnabled(true);
                } else {
                    pButton.setEnabled(false);
                    nButton.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetailsByGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showButtonActionPerformed

    private void pButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtonActionPerformed
        if (pos == 0) {
            pos = studDet.size() - 1;
            //text message created based on the retrieved value
            allGrade = "Student ID\t- " + studDet.get(pos).getId()
                    + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                    + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                    + "\nExam Mark\t- " + studDet.get(pos).getExam()
                    + "\nTotal\t- " + studDet.get(pos).getTot()
                    + "\nGrade\t- " + studDet.get(pos).getGrade();
        } else {
            pos = (pos - 1) % studDet.size();
            //text message created based on the retrieved value
            allGrade = "Student ID\t- " + studDet.get(pos).getId()
                    + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                    + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                    + "\nExam Mark\t- " + studDet.get(pos).getExam()
                    + "\nTotal\t- " + studDet.get(pos).getTot()
                    + "\nGrade\t- " + studDet.get(pos).getGrade();
        }
        studDetailsTextArea.setText(allGrade);
    }//GEN-LAST:event_pButtonActionPerformed

    private void nButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtonActionPerformed
        pos = (pos + 1) % studDet.size();
        //text message created based on the retrieved value
        allGrade = "Student ID\t- " + studDet.get(pos).getId()
                + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                + "\nExam Mark\t- " + studDet.get(pos).getExam()
                + "\nTotal\t- " + studDet.get(pos).getTot()
                + "\nGrade\t- " + studDet.get(pos).getGrade() + "\n\n";
        studDetailsTextArea.setText(allGrade);
    }//GEN-LAST:event_nButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDetailsByGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDetailsByGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDetailsByGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDetailsByGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDetailsByGrade().setVisible(true);
            }
        });
    }

    public void db_connect() {
        try {
            //embeded drive connected using its url value
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            //gradeAllocation database connected using its corresponding url
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GradeAllocation", "Grade", "grade");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connect cannot established");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AFRadioButton;
    private javax.swing.JRadioButton CRadioButton;
    private javax.swing.JRadioButton DRadioButton;
    private javax.swing.JRadioButton FRadioButton;
    private javax.swing.JRadioButton HDRadioButton;
    private javax.swing.JRadioButton PRadioButton;
    private javax.swing.JRadioButton SARadioButton;
    private javax.swing.JRadioButton SERadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nButton;
    private javax.swing.JButton pButton;
    private javax.swing.JButton showButton;
    private javax.swing.JTextArea studDetailsTextArea;
    // End of variables declaration//GEN-END:variables

    //necessary variables
    String stu_id = "";
    int a1_mark = 0;
    int a2_mark = 0;
    int e_mark = 0;
    int tot_mark = 0;
    String grade = "";
    String allGrade = "";
    int pos;
    ArrayList<StudentDetails> studDet;

    //creating object for database access
    Connection conn = null;
    ResultSet resSet = null;
    Statement stmnt = null;
}
