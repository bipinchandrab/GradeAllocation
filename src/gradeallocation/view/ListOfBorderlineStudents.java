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

public class ListOfBorderlineStudents extends javax.swing.JFrame implements IView{

    public ListOfBorderlineStudents() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("List of Borderline Students");
        //dabase connected using a method
        db_connect();
        pButton.setEnabled(false);
        nButton.setEnabled(false);
    }

    @Override
    public void borderlineStudents(int value) {
        try {
            //query to retrieve all the data from database in created and executed
            stmnt = conn.createStatement();
            resSet = stmnt.executeQuery("select * from MARKS");

            while (resSet.next()) {
                stu_id = resSet.getString(1);
                tot_mark = Integer.parseInt(resSet.getString(5));
                if ((50 - value) == tot_mark) {
                    //if the student missed P grade by 1 or 2 marks they added in borderline cases list
                    message = message + "Student id " + stu_id + " missed P grade by " + (50 - tot_mark) + " mark(s)\n";
                    avail = 1;
                } else if ((65 - value) == tot_mark) {
                    //if the student missed C grade by 1 or 2 marks they added in borderline cases list
                    message = message + "Student id " + stu_id + " missed C grade by " + (65 - tot_mark) + " mark(s)\n";
                    avail = 1;
                } else if ((75 - value) == tot_mark) {
                    //if the student missed D grade by 1 or 2 marks they added in borderline cases list
                    message = message + "Student id " + stu_id + " missed D grade by " + (75 - tot_mark) + " mark(s)\n";
                    avail = 1;
                } else if ((85 - value) == tot_mark) {
                    //if the student missed HD grade by 1 or 2 marks they added in borderline cases list
                    message = message + "Student id " + stu_id + " missed HD grade by " + (85 - tot_mark) + " mark(s)\n";
                    avail = 1;
                }
            }
            if (avail == 0) {
                //text message displayed when no students found for tolerance value 1 or 2
                brdrTextArea.setText("Student details not available for the given tolerance value");
            } else {
                //text area displays the details of border line students
                brdrTextArea.setText(message);
            }
        } catch (SQLException ex) {
            //exception handled
            Logger.getLogger(ListOfBorderlineStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void createDetails(StudentDetails studentDetails) {
        studDet.add(studentDetails);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        showTolButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        brdrTextArea = new javax.swing.JTextArea();
        clsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tolTField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        stTField = new javax.swing.JTextField();
        endTField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        showRangeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pButton = new javax.swing.JButton();
        nButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        showTolButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        showTolButton.setText("Show");
        showTolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTolButtonActionPerformed(evt);
            }
        });

        brdrTextArea.setColumns(20);
        brdrTextArea.setRows(5);
        jScrollPane1.setViewportView(brdrTextArea);

        clsButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        clsButton.setText("Cancel");
        clsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clsButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter Tolerance Value");

        tolTField.setToolTipText("1 or 2");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Enter Start Range");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Enter End Range");

        showRangeButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        showRangeButton.setText("Show");
        showRangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRangeButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("(or)");

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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(clsButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tolTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showTolButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stTField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(showRangeButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nButton)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(182, 182, 182))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tolTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showTolButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(stTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(endTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showRangeButton)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nButton)
                            .addComponent(pButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clsButton)
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

    private void showTolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTolButtonActionPerformed
        if (Integer.parseInt(tolTField.getText()) == 1 || Integer.parseInt(tolTField.getText()) == 2) {
            borderlineStudents(Integer.parseInt(tolTField.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "Entered Tolerance value must be 0 or 1", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_showTolButtonActionPerformed

    private void clsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clsButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_clsButtonActionPerformed

    private void showRangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRangeButtonActionPerformed
        studDet = new ArrayList<StudentDetails>();
        pos = 0;
        if (!stTField.getText().equals("")) {
            if (!endTField.getText().equals("")) {
                try {
                    //finding marks in between the ranges if the both starting and end ranges are not null
                    int startRange = Integer.parseInt(stTField.getText());
                    int endRange = Integer.parseInt(endTField.getText());
                    String studDetails = "";
                    int avail = 0;

                    //query to retrieve all the data from database created and executed then retrieved values stored in local variable
                    stmnt = conn.createStatement();
                    resSet = stmnt.executeQuery("SELECT * FROM MARKS");

                    while (resSet.next()) {
                        stu_id = resSet.getString(1);
                        a1_mark = resSet.getInt(2);
                        a2_mark = resSet.getInt(3);
                        e_mark = resSet.getInt(4);
                        tot_mark = resSet.getInt(5);
                        grade = resSet.getString(6);

                        createDetails(new StudentDetails(stu_id, a1_mark, a2_mark, e_mark, tot_mark, grade));
                        if (tot_mark >= startRange && tot_mark <= endRange) {
                            avail = 1;
                            allGrade = "Student ID\t- " + studDet.get(pos).getId()
                                    + "\nAssignment 1\t- " + studDet.get(pos).getAss1()
                                    + "\nAssignment 2\t- " + studDet.get(pos).getAss2()
                                    + "\nExam Mark\t- " + studDet.get(pos).getExam()
                                    + "\nTotal\t- " + studDet.get(pos).getTot()
                                    + "\nGrade\t- " + studDet.get(pos).getGrade();
                        }
                        if (avail == 0) {
                            //text message displayed when no students available for the entered start and end marks
                            brdrTextArea.setText("Student details not available for the given range value");
                        } else {
                            //text area displays the student details when start and end ranges matches with retrieved marks
                            brdrTextArea.setText(allGrade);
                        }
                    }

                    if (studDet.size() > 1) {
                        nButton.setEnabled(true);
                        pButton.setEnabled(true);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ListOfBorderlineStudents.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "End range cannot be empty", "Error Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Starting range cannot be empty", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_showRangeButtonActionPerformed

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
        brdrTextArea.setText(allGrade);
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
        brdrTextArea.setText(allGrade);
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
            java.util.logging.Logger.getLogger(ListOfBorderlineStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListOfBorderlineStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListOfBorderlineStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListOfBorderlineStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListOfBorderlineStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea brdrTextArea;
    private javax.swing.JButton clsButton;
    private javax.swing.JTextField endTField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nButton;
    private javax.swing.JButton pButton;
    private javax.swing.JButton showRangeButton;
    private javax.swing.JButton showTolButton;
    private javax.swing.JTextField stTField;
    private javax.swing.JTextField tolTField;
    // End of variables declaration//GEN-END:variables

    //necessary variables
    String stu_id = "";
    int a1_mark = 0;
    int a2_mark = 0;
    int e_mark = 0;
    int tot_mark = 0;
    String grade = "";
    String allGrade = "";
    String message = "";
    int avail = 0;
    int pos;
    ArrayList<StudentDetails> studDet;

    //creating object for database access
    Connection conn = null;
    ResultSet resSet = null;
    Statement stmnt = null;
}
