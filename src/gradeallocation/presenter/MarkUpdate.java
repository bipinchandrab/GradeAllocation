package gradeallocation.presenter;

import gradeallocation.model.IConnect;
import gradeallocation.view.StudentDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MarkUpdate extends javax.swing.JFrame implements IConnect, IQuery {

    public MarkUpdate() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Mark Update");
        //dabase connected using a method
        db_connect();
    }

    public void clear() {
        //all the text fields cleared
        studIDTextField.setText("");
        a1MarkTextField.setText("");
        a2MarkTextField.setText("");
        eMarkTextField.setText("");
    }

    @Override
    public void query() {
        try {
            stmnt = conn.createStatement();
            resSet = stmnt.executeQuery("SELECT * FROM MARKS WHERE STUDENTID='" + studIDTextField.getText().toUpperCase() + "'");

            if (resSet.next()) {
                //copying data from database to corresponding variables
                studIDTextField.setText(resSet.getString(1));
                a1MarkTextField.setText(resSet.getString(2));
                a2MarkTextField.setText(resSet.getString(3));
                eMarkTextField.setText(resSet.getString(4));
            } else {
                clear();
                //message dialog box displayed if the entered student id is not found in the database
                JOptionPane.showMessageDialog(null, "Student data not found", "Error Messagae", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Marks are not displayed", "Error Message", JOptionPane.ERROR_MESSAGE);
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
        viewMarksjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        a1MarkTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        a2MarkTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        eMarkTextField = new javax.swing.JTextField();
        uptButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeAllTextArea = new javax.swing.JTextArea();
        clsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Enter Student id");

        viewMarksjButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        viewMarksjButton.setText("View");
        viewMarksjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMarksjButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Assignment 1");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Assignment 2");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Exam");

        uptButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        uptButton.setText("Update");
        uptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uptButtonActionPerformed(evt);
            }
        });

        gradeAllTextArea.setColumns(20);
        gradeAllTextArea.setRows(5);
        jScrollPane1.setViewportView(gradeAllTextArea);

        clsButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        clsButton.setText("Cancel");
        clsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uptButton)
                        .addGap(18, 18, 18)
                        .addComponent(clsButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(viewMarksjButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(studIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel4))
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(a1MarkTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                .addComponent(a2MarkTextField)
                                .addComponent(eMarkTextField)))))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(viewMarksjButton)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a1MarkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(a2MarkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(eMarkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uptButton)
                    .addComponent(clsButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewMarksjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMarksjButtonActionPerformed

        if (studIDTextField.equals("")) {
            //message dialog box displayed if the entered student id is null
            JOptionPane.showMessageDialog(null, "Enter student id", "Error Messagae", JOptionPane.ERROR_MESSAGE);
        } else {
            //if the student id is not null query executed
            query();

        }

    }//GEN-LAST:event_viewMarksjButtonActionPerformed

    private void uptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uptButtonActionPerformed
        studDet = new ArrayList<StudentDetails>();
        pos = 0;
        if (studIDTextField.equals("") || a1MarkTextField.equals("") || a2MarkTextField.equals("") || eMarkTextField.equals("")) {
            //message dialog box displayed if all the text fields are empty
            JOptionPane.showMessageDialog(null, "All the fields cannot be empty", "Error Message", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                //if all the text fields are not empty then checking it is in required range
                if (Integer.parseInt(a1MarkTextField.getText()) > 20) {
                    //message dialog box displayed if the entered assignment 1 mark is greater than 20
                    JOptionPane.showMessageDialog(null, "Enter 0 to 20 in Assignment 1 mark", "Error Message", JOptionPane.ERROR_MESSAGE);
                } else if (Integer.parseInt(a2MarkTextField.getText()) > 30) {
                    //message dialog box displayed if the entered assignment 2 mark is greater than 30
                    JOptionPane.showMessageDialog(null, "Enter 0 to 30 in Assignment 2 mark", "Error Message", JOptionPane.ERROR_MESSAGE);
                } else if (Integer.parseInt(eMarkTextField.getText()) > 50) {
                    //message dialog box displayed if the entered exam mark is greater than 50
                    JOptionPane.showMessageDialog(null, "Enter 0 to 50 in Exam mark", "Error Message", JOptionPane.ERROR_MESSAGE);
                } else {
                    //the entered text field marks are stored in local variables
                    stu_id = studIDTextField.getText().toUpperCase();
                    a1_mark = Integer.parseInt(a1MarkTextField.getText());
                    a2_mark = Integer.parseInt(a2MarkTextField.getText());
                    e_mark = Integer.parseInt(eMarkTextField.getText());
                    tot_mark = a1_mark + a2_mark + e_mark;
                    //new student details are updated in database
                    PreparedStatement pre = conn.prepareStatement("UPDATE MARKS SET ASSIGNMENT1=?,"
                            + "ASSIGNMENT2=?,"
                            + "EXAM=?,"
                            + "TOTAL=? "
                            + "WHERE STUDENTID=?");
                    pre.setInt(1, a1_mark);
                    pre.setInt(2, a2_mark);
                    pre.setInt(3, e_mark);
                    pre.setInt(4, tot_mark);
                    pre.setString(5, stu_id);
                    int success = pre.executeUpdate();
                    if (success > 0) {
                        clear();
                        createDetails(new StudentDetails(stu_id, a1_mark, a2_mark, e_mark, tot_mark, grade));

                        //the updated marks will be viewed in text area
                        gradeAllTextArea.setText("Updated Student details are:\n\nStudent ID\t- " + studDet.get(pos).getId()
                                + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                                + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                                + "\nExam Mark\t- " + studDet.get(pos).getExam()
                                + "\nTotal\t- " + studDet.get(pos).getTot());
                        //message dialog box displayed when the mark is updated
                        JOptionPane.showMessageDialog(null, "Marks Updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        //message dialog box displayed when the mark is not updated
                        JOptionPane.showMessageDialog(null, "Marks not updated", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (NumberFormatException ex) {
                //message dialog box displayed when other than numbers entered
                JOptionPane.showMessageDialog(null, "All the marks must be integer numbers or should not be empty", "Error Message", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Marks not updated", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_uptButtonActionPerformed

    private void clsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clsButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_clsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MarkUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkUpdate().setVisible(true);
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a1MarkTextField;
    private javax.swing.JTextField a2MarkTextField;
    private javax.swing.JButton clsButton;
    private javax.swing.JTextField eMarkTextField;
    private javax.swing.JTextArea gradeAllTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField studIDTextField;
    private javax.swing.JButton uptButton;
    private javax.swing.JButton viewMarksjButton;
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
