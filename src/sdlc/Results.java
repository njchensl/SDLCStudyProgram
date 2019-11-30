/*
 * Frank Chen
 * Results JFrame
 * 30NOV19
 * Dispays the results for the user to look at
 * Marks right answers in green and wrong answers in red (if applicable)
 */
package sdlc;

/**
 *
 * @author njche
 */
public class Results extends javax.swing.JPanel {

    /**
     * Creates new form Results
     *
     * @param results
     */
    public Results(String results) {
        initComponents();
        this.txtResults.setText("<html>" + results + "</html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spResults = new javax.swing.JScrollPane();
        txtResults = new javax.swing.JTextPane();
        txtResults.setContentType("text/html");
        btnBack = new javax.swing.JButton();

        txtResults.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtResults.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtResultsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtResultsFocusLost(evt);
            }
        });
        spResults.setViewportView(txtResults);

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spResults)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(spResults, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        SDLC.setMainContentPane(new Welcome());
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtResultsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtResultsFocusGained
        txtResults.setEditable(false);
    }//GEN-LAST:event_txtResultsFocusGained

    private void txtResultsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtResultsFocusLost
        txtResults.setEditable(true);
    }//GEN-LAST:event_txtResultsFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane spResults;
    private javax.swing.JTextPane txtResults;
    // End of variables declaration//GEN-END:variables
}