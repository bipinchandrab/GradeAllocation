package gradeallocation.presenter;

import gradeallocation.model.IConnect;
import gradeallocation.view.StudentDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GradeAllocationForStud extends javax.swing.JFrame implements IConnect, IQuery {

    public GradeAllocationForStud() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Grade Allocation for Students");
        //dabase connected using a method
        db_connect();
        pButton.setEnabled(false);
        nButton.setEnabled(false);
    }

    public void allocateGrade() {
        if (tot_mark < 50) {
            if (a1_mark == 0 && a2_mark == 0 && e_mark == 0) {
                //assigning grade "AF" if the student not submitted any assignment
                grade = "AF";
            } else if (tot_mark < 50 && tot_mark > 44) {
                if (e_mark < 25 && a1_mark > 9 && a2_mark > 14) {
                    //if the student total is between 45 to 50 and the student got fail in only exam then grade SE will be allocated to them
                    grade = "SE";
                } else if ((a1_mark < 10 && a2_mark > 14 && e_mark > 24) || (a1_mark > 9 && a2_mark < 15 && e_mark > 24)) {
                    //if the student total is between 45 to 50 and the student got fail in any one assignment then grade SA will be allocated to them
                    grade = "SA";
                } else {
                    //in any other cases grade F is allocated to them
                    grade = "F";
                }
            } else {
                //assigning grade "F"
                grade = "F";
            }
        } else if (tot_mark < 65 && tot_mark > 49) {
            //assigning grade "P" if the student mark is between 50 to 64
            grade = "P";
        } else if (tot_mark < 75 && tot_mark > 64) {
            //assigning grade "C" if the student mark is between 65 to 74
            grade = "C";
        } else if (tot_mark < 85 && tot_mark > 74) {
            //assigning grade "D" if the student mark is between 75 to 84
            grade = "D";
        } else if (tot_mark < 101 && tot_mark > 84) {
            //assigning grade "HD" if the student mark is between 85 to 100
            grade = "HD";
        }
    }

    @Override
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

    public void allocateGradeInd(String stu_id) throws SQLException {
        stmnt = conn.createStatement();
        resSet = stmnt.executeQuery("SELECT * FROM MARKS WHERE STUDENTID='" + stu_id + "'");
        //the student details for entered student id retrieved and stored in local variables
        if (resSet.next()) {
            stu_id = resSet.getString(1);
            a1_mark = resSet.getShort(2);
            a2_mark = resSet.getShort(3);
            e_mark = resSet.getShort(4);
            tot_mark = resSet.getShort(5);
            allocateGrade();

            //query executed for updating the data in database
            stmnt.executeUpdate("UPDATE MARKS SET GRADE='" + grade + "' WHERE STUDENTID='" + stu_id + "'");
            gradeTextArea.setText("Calculated Grade:\n\nStudent ID\t- " + stu_id
                    + "\nAssignment 1\t- " + a1_mark
                    + "\nAssignment 2\t- " + a2_mark
                    + "\nExam\t- " + e_mark
                    + "\nTotal\t- " + tot_mark
                    + "\nGrade\t- " + grade);
        } else {
            //the entered student id is not found means then error message dialog box displayed
            JOptionPane.showMessageDialog(null, "Entered student id is not found", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void query() {
        try {
            stmnt = conn.createStatement();
            stmnt.executeUpdate("UPDATE MARKS SET GRADE='" + grade + "' WHERE STUDENTID='" + stu_id + "'");
            //text message created based on the retrieved value
            allGrade = "Student ID\t- " + studDet.get(pos).getId()
                    + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                    + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                    + "\nExam Mark\t- " + studDet.get(pos).getExam()
                    + "\nTotal\t- " + studDet.get(pos).getTot()
                    + "\nGrade\t- " + studDet.get(pos).getGrade();
        } catch (SQLException ex) {
            System.out.println("Grade cannot be allocated");
        }
    }

    @Override
    public void createDetails(StudentDetails studentDetails) {
        studDet.add(studentDetails);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        studIDTextField = new javax.swing.JTextField();
        allocateGradeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        allGradeAllButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeTextArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        pButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Enter Student id");

        allocateGradeButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        allocateGradeButton.setText("Allocate Grade");
        allocateGradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allocateGradeButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("(OR)");

        allGradeAllButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        allGradeAllButton.setText("Allocate Grade for All");
        allGradeAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allGradeAllButtonActionPerformed(evt);
            }
        });

        gradeTextArea.setColumns(20);
        gradeTextArea.setRows(5);
        jScrollPane1.setViewportView(gradeTextArea);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(studIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(allocateGradeButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(allGradeAllButton)
                .addGap(18, 18, 18)
                .addComponent(pButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(allocateGradeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allGradeAllButton)
                    .addComponent(pButton)
                    .addComponent(nButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allocateGradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allocateGradeButtonActionPerformed
        if (!studIDTextField.getText().equals("")) {
            try {
                //the entered student id is not null executing the allocation grade for individual student
                allocateGradeInd(studIDTextField.getText().toUpperCase());
            } catch (SQLException ex) {
                System.out.println("Grade cannot be allocated");
            }
        } else {
            //the entered student id is null then error message dialog box displayed
            JOptionPane.showMessageDialog(null, "Enter Student id", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_allocateGradeButtonActionPerformed

    private void allGradeAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allGradeAllButtonActionPerformed
        studDet = new ArrayList<StudentDetails>();
        pos = 0;
        studIDTextField.setText("");
        try {
            //the student details retrieved and stored in local variables
            resSet = conn.createStatement().executeQuery("SELECT * FROM MARKS");
            while (resSet.next()) {
                stu_id = resSet.getString(1);
                a1_mark = resSet.getShort(2);
                a2_mark = resSet.getShort(3);
                e_mark = resSet.getShort(4);
                tot_mark = resSet.getShort(5);
                allocateGrade();
                createDetails(new StudentDetails(stu_id, a1_mark, a2_mark, e_mark, tot_mark, grade));
                query();

                if (studDet.size() > 1) {
                    pButton.setEnabled(true);
                    nButton.setEnabled(true);
                }
            }
            //student details can be viewed in text area
            gradeTextArea.setText(allGrade);
        } catch (SQLException ex) {
            System.out.println("Grade cannot be allocated");
        }
    }//GEN-LAST:event_allGradeAllButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //closing this window
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
        gradeTextArea.setText(allGrade);
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
        gradeTextArea.setText(allGrade);
    }//GEN-LAST:event_nButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GradeAllocationForStud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeAllocationForStud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeAllocationForStud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeAllocationForStud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeAllocationForStud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allGradeAllButton;
    private javax.swing.JButton allocateGradeButton;
    private javax.swing.JTextArea gradeTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nButton;
    private javax.swing.JButton pButton;
    private javax.swing.JTextField studIDTextField;
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
