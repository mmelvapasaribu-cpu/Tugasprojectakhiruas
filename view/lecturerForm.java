/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import controller.lectureController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.lecture;

/**
 *
 * @author ASUS
 */
public class lecturerForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(lecturerForm.class.getName());

    
    private final lectureController lecturerController = new lectureController();
    private DefaultTableModel tableModel;
    private String selectedNidn = null;

    public lecturerForm() {
        initComponents();
        setupTable();
        loadData();
    }

    private void setupTable() {
        tableModel = new DefaultTableModel(
            new Object[]{"NIDN", "Nama", "Keahlian"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(tableModel);

        jTable1.getSelectionModel().addListSelectionListener(evt -> {
            int row = jTable1.getSelectedRow();
            if (row >= 0) {
                jTextFieldNIDN.setText(tableModel.getValueAt(row, 0).toString());
                jTextFieldNama.setText(tableModel.getValueAt(row, 1).toString());
                jComboBoxMK.setSelectedItem(tableModel.getValueAt(row, 2).toString());
                selectedNidn = tableModel.getValueAt(row, 0).toString();
                jTextFieldNIDN.setEditable(false);
            }
        });
    }

    private void loadData() {
        tableModel.setRowCount(0);
        List<lecture> lecturers = lecturerController.getAll();
        for (lecture l : lecturers) {
            tableModel.addRow(new Object[]{l.getNidn(), l.getName(), l.getExpertise()});
        }
    }

    private void clearForm() {
        jTextFieldCardID.setText("");
        jTextFieldNIDN.setText("");
        jTextFieldNama.setText("");
        jComboBoxMK .setSelectedIndex(0);
        jTextFieldNIDN.setEditable(true);
        selectedNidn = null;
        jTable1.clearSelection();
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        String idCard = jTextFieldCardID.getText().trim();
        String nidn = jTextFieldNIDN.getText().trim();
        String nama = jTextFieldNama.getText().trim();
        String keahlian = jComboBoxMK.getSelectedItem().toString();

        if (idCard.isEmpty() || nidn.isEmpty() || nama.isEmpty() || keahlian.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
            return;
        }

        lecture lecturer = new lecture(idCard, nama, nidn, keahlian);
        int result = lecturerController.create(lecturer);

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Data dosen berhasil ditambahkan.");
            clearForm();
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data dosen.");
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedNidn == null) {
            JOptionPane.showMessageDialog(this, "Pilih data dosen yang akan diupdate dari tabel.");
            return;
        }

        String idCard = jTextFieldCardID.getText().trim();
        String nama = jTextFieldNama.getText().trim();
        String keahlian = jComboBoxMK.getSelectedItem().toString();

        lecture lecturer = new lecture(idCard, nama, selectedNidn, keahlian);
        int result = lecturerController.update(lecturer, selectedNidn);

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Data dosen berhasil diupdate.");
            clearForm();
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data dosen.");
        }
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedNidn == null) {
            JOptionPane.showMessageDialog(this, "Pilih data dosen yang akan dihapus dari tabel.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus data dosen dengan NIDN " + selectedNidn + "?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int result = lecturerController.delete(selectedNidn);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Data dosen berhasil dihapus.");
                clearForm();
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data dosen.");
            }
        }
    }

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {
        clearForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonReset = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldNIDN = new javax.swing.JTextField();
        jTextFieldCardID = new javax.swing.JTextField();
        jComboBoxMK = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("LECTURER");

        jLabel2.setText("Nama");

        jLabel3.setText("NIDN");

        jLabel4.setText("CardID");

        jLabel5.setText("Mata Kuliah");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(this::jButtonResetActionPerformed);

        jButtonDelete.setText("Delete");

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(this::jButtonSaveActionPerformed);

        jTextFieldNama.setText("Nama");
        jTextFieldNama.addActionListener(this::jTextFieldNamaActionPerformed);

        jTextFieldNIDN.setText("NIDN");

        jTextFieldCardID.setText("CardID");

        jComboBoxMK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(61, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldCardID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReset))
                            .addComponent(jTextFieldNIDN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButtonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSave))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxMK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNIDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonReset)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonSave)
                    .addComponent(jTextFieldCardID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new lecturerForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBoxMK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldCardID;
    private javax.swing.JTextField jTextFieldNIDN;
    private javax.swing.JTextField jTextFieldNama;
    // End of variables declaration//GEN-END:variables
}
