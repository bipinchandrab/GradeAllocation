package gradeallocation.model;

import gradeallocation.presenter.GradeAllocationForStud;
import gradeallocation.presenter.MarkUpdate;
import gradeallocation.view.ListOfBorderlineStudents;
import gradeallocation.view.StudentDetailsByGrade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomePage extends javax.swing.JFrame implements IConnect {

    public HomePage() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Grade Allocation");
        //dabase connected using a method
        db_connect();
        //table created with given column names
        table_create();
        //values inserted in mark table with given initial values
        insert_value();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradeAlloButton = new javax.swing.JButton();
        updateMarkButton = new javax.swing.JButton();
        brdrlneButton = new javax.swing.JButton();
        studDetailsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gradeAlloButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeAlloButton.setText("Grade Allocation");
        gradeAlloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeAlloButtonActionPerformed(evt);
            }
        });

        updateMarkButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        updateMarkButton.setText("Update Marks");
        updateMarkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMarkButtonActionPerformed(evt);
            }
        });

        brdrlneButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        brdrlneButton.setText("Borderline Students list");
        brdrlneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brdrlneButtonActionPerformed(evt);
            }
        });

        studDetailsButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        studDetailsButton.setText("Student Details");
        studDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studDetailsButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Grade Allocation");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("The Unit Coordinator can allocate");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Grade for Students");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(brdrlneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gradeAlloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateMarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateMarkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeAlloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brdrlneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gradeAlloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeAlloButtonActionPerformed
        //Grade allocation page opened by using object created for GradeAllocationForStud class
        GradeAllocationForStud ind = new GradeAllocationForStud();
        ind.setVisible(true);
    }//GEN-LAST:event_gradeAlloButtonActionPerformed

    private void updateMarkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMarkButtonActionPerformed
        //Mark Update page opened by using object created for MarkUpdate class
        MarkUpdate markUpdate = new MarkUpdate();
        markUpdate.setVisible(true);
    }//GEN-LAST:event_updateMarkButtonActionPerformed

    private void brdrlneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brdrlneButtonActionPerformed
        //list of borderline students page opened by using object created for ListOfBorderlineStudents class
        ListOfBorderlineStudents brdr = new ListOfBorderlineStudents();
        brdr.setVisible(true);
    }//GEN-LAST:event_brdrlneButtonActionPerformed

    private void studDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studDetailsButtonActionPerformed
        //student details page opened by using object created for StudentDetailsByGrade class
        StudentDetailsByGrade studDet = new StudentDetailsByGrade();
        studDet.setVisible(true);
    }//GEN-LAST:event_studDetailsButtonActionPerformed
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brdrlneButton;
    private javax.swing.JButton gradeAlloButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton studDetailsButton;
    private javax.swing.JButton updateMarkButton;
    // End of variables declaration//GEN-END:variables

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

    private void table_create() {
        try {
            resSet = conn.getMetaData().getTables(null, "GRADE", "MARKS", null);
            if (resSet.next()) {
                //drop table executed when the marks table already available
                conn.createStatement().executeUpdate("DROP TABLE MARKS");
            }

            stmnt = conn.createStatement();
            //if the table is not available then marks table created using the given query
            stmnt.execute("CREATE TABLE MARKS (STUDENTID VARCHAR(8) NOT NULL, ASSIGNMENT1 INT NOT NULL, ASSIGNMENT2 INT NOT NULL, EXAM INT NOT NULL, TOTAL INT NOT NULL, GRADE VARCHAR(4) NOT NULL, PRIMARY KEY (STUDENTID))");

        } catch (SQLException ex) {
            System.out.println("Table creation failed");
        }
    }

    public void insert_value() {
        try {
            //given value inserted in marks table using insert query
            stmnt.executeUpdate("INSERT INTO MARKS(STUDENTID,ASSIGNMENT1,ASSIGNMENT2,EXAM,TOTAL,GRADE) VALUES('S01',20,0,25,45,'?'),('S02',0,0,0,0,'?'),('S03',15,0,0,15,'?')");
        } catch (SQLException ex) {
            System.out.println("Insertion of values failed");
        }
    }

    //database instances created and initialized to null
    Connection conn = null;
    ResultSet resSet = null;
    Statement stmnt = null;
}
