/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemPackage;

import javax.swing.JOptionPane;

/**
 *
 * @author NishanV
 */
public class CashierUI extends javax.swing.JFrame {

    /**
     * Creates new form CashierUI
     */
    public CashierUI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_NewOrder = new javax.swing.JButton();
        jButton_returnVideo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton_buy = new javax.swing.JButton();
        jButton_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton_NewOrder.setText("New Order");
        jButton_NewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NewOrderActionPerformed(evt);
            }
        });

        jButton_returnVideo.setText("Return Video");
        jButton_returnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_returnVideoActionPerformed(evt);
            }
        });

        jButton_buy.setText("Buy Video");
        jButton_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buyActionPerformed(evt);
            }
        });

        jButton_logout.setText("Logout");
        jButton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_NewOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_returnVideo))
                .addGap(18, 18, 18)
                .addComponent(jButton_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_logout)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_NewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_buy, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_returnVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_logout)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_NewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NewOrderActionPerformed
        DBConnect connect = new DBConnect();
        boolean memberIdExists = false;
        String customerName = null;
        String memberIdRet = null;
        String memberId = JOptionPane.showInputDialog(null, "Enter Customer's Member ID", "Member ID required", WIDTH);
        if(memberId.equals("") || memberId.equals(null)){}
        else{
            String query = "select * from members where memberId = "+memberId+" and type = 2";
            try{
                connect.rs = connect.st.executeQuery(query);
                if(connect.rs.next() == true){
                    memberIdExists = true;
                    customerName = connect.rs.getString("fname")+" "+connect.rs.getString("lname");
                    memberIdRet = connect.rs.getString("memberId");
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Customer Found!!");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            if(memberIdExists == true){
               PlaceOrder order = new PlaceOrder(this, memberIdExists, customerName, memberIdRet);
               order.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton_NewOrderActionPerformed

    private void jButton_returnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_returnVideoActionPerformed
        DBConnect connect = new DBConnect();
        String custId = JOptionPane.showInputDialog("Enter Customer ID:");
        String query = "select * from orders where memberId = '"+custId+"' and returned = 'no'";
        boolean resultFound = true;
        try{
            connect.rs = connect.st.executeQuery(query);
            if(connect.rs.next() == false)
                resultFound = false;
            else{
                query = "select fname, lname from members where memberId = "+custId;
                connect.rs = connect.st.executeQuery(query);
                connect.rs.next();
                ReturnVideo returnVideo = new ReturnVideo(this, true, connect.rs.getString("fname")+connect.rs.getString("lname"), custId);
                returnVideo.setVisible(true);
            }
        }catch(Exception e){
           // JOptionPane.showMessageDialog(null, e);
        }
        if(resultFound == false)
            JOptionPane.showMessageDialog(null, "Invalid Customer ID or Customer Didn't Ordered Anything");
    }//GEN-LAST:event_jButton_returnVideoActionPerformed

    private void jButton_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buyActionPerformed
        BuyVideo bv = new BuyVideo();
        bv.setVisible(true);
    }//GEN-LAST:event_jButton_buyActionPerformed

    private void jButton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logoutActionPerformed
        MainLogin login = new MainLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton_logoutActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CashierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_NewOrder;
    private javax.swing.JButton jButton_buy;
    private javax.swing.JButton jButton_logout;
    private javax.swing.JButton jButton_returnVideo;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
