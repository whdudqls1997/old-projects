import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class main extends javax.swing.JFrame{
    
    // Global toss objects
    public ArrayList<loader> larr;
    
    // Private Stuff
    private Clock clk;

    public main() throws IOException {
        // Fixed lines
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Initialize
        larr = new ArrayList<>();
        
        // Create Folder
        File directory = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/msHomework");
        if(!directory.exists())
            directory.mkdir();
        
        // Read Folder
        for(File f : directory.listFiles()){
            String temp = f.getName().substring(0, f.getName().length() - 4);
            selectJComboBox.addItem(temp);
            larr.add(new loader(temp));
        }
        
        // Init Clock
        clk = Clock.offset(Clock.systemUTC(), Duration.ofHours(9));
        setTime();
    }
    
    // Updates Clock
    private void setTime(){
        currTimeJTextField.setText(clk.instant().toString().substring(0, 10) + " " + clk.instant().toString().substring(11, 16));
    }
    
    // Reload file list
    private void reloadlarr() throws IOException{
        larr = new ArrayList<>();
        File directory = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/msHomework");
        for(File f : directory.listFiles()){
            String temp = f.getName().substring(0, f.getName().length() - 4);
            larr.add(new loader(temp));
        }
    }
    
    // Reload ComboBox accordingly
    private void reloadComboBox(){
        selectJComboBox.removeAllItems();
        for(loader l : larr)
            selectJComboBox.addItem(l.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currTimeJLabel = new javax.swing.JLabel();
        resetTimeJLabel = new javax.swing.JLabel();
        resetWTimeJLabel = new javax.swing.JLabel();
        currTimeJTextField = new javax.swing.JTextField();
        resetTimeJTextField = new javax.swing.JTextField();
        resetWTimeTextField = new javax.swing.JTextField();
        updateJLabel = new javax.swing.JLabel();
        updateJButton = new javax.swing.JButton();
        selectJComboBox = new javax.swing.JComboBox<>();
        selectJButton = new javax.swing.JButton();
        selectJLabel = new javax.swing.JLabel();
        infoJScrollPane = new javax.swing.JScrollPane();
        infoJTextArea = new javax.swing.JTextArea();
        addcharJButton = new javax.swing.JButton();
        removecharJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MS Homework Tracker");
        setIconImages(null);
        setResizable(false);

        currTimeJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currTimeJLabel.setText("Current Time :");

        resetTimeJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetTimeJLabel.setText("Weekly Resets in :");

        resetWTimeJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetWTimeJLabel.setText("Daily Resets in :");

        currTimeJTextField.setEditable(false);
        currTimeJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        currTimeJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        resetTimeJTextField.setEditable(false);
        resetTimeJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resetTimeJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        resetWTimeTextField.setEditable(false);
        resetWTimeTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resetWTimeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        updateJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateJLabel.setText("Time Update");

        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        selectJComboBox.setFont(new java.awt.Font("맑은 고딕", 0, 11)); // NOI18N

        selectJButton.setText("Select");
        selectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectJButtonActionPerformed(evt);
            }
        });

        selectJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectJLabel.setText("Select Character :");

        infoJTextArea.setEditable(false);
        infoJTextArea.setColumns(20);
        infoJTextArea.setRows(5);
        infoJScrollPane.setViewportView(infoJTextArea);

        addcharJButton.setText("Add Character");
        addcharJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcharJButtonActionPerformed(evt);
            }
        });

        removecharJButton.setText("Remove Character");
        removecharJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removecharJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoJScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resetTimeJLabel)
                                .addGap(18, 18, 18)
                                .addComponent(resetWTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currTimeJLabel)
                                    .addComponent(resetWTimeJLabel))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resetTimeJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(currTimeJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(selectJLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(removecharJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(addcharJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currTimeJLabel)
                    .addComponent(currTimeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateJLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetWTimeJLabel)
                            .addComponent(resetTimeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetTimeJLabel)
                            .addComponent(resetWTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(updateJButton)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectJLabel)
                    .addComponent(selectJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectJButton))
                .addGap(13, 13, 13)
                .addComponent(addcharJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removecharJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("Tracker for MS homeworks");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        setTime(); // Update Time
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void selectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectJButtonActionPerformed
        // Create new form
        character c = new character(this, selectJComboBox.getSelectedItem().toString(), larr);
        c.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_selectJButtonActionPerformed

    private void addcharJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcharJButtonActionPerformed
        String temp = JOptionPane.showInputDialog("Enter name : ");
        String temp2 = JOptionPane.showInputDialog("Enter profession : ");
        ArrayList<String> temp3 = new ArrayList<>();
        temp3.add(temp); temp3.add(temp2);
        try {
            loader temp4 = new loader(temp);
            temp4.addContent(temp3);
            larr.add(temp4);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Create new form
        character c = new character(this, temp, larr);
        c.setVisible(true);
        this.setEnabled(false);
        
        // Override Frame Close Listener & reload accordingly
        c.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    reloadlarr();
                    reloadComboBox();
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_addcharJButtonActionPerformed

    private void removecharJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removecharJButtonActionPerformed
        // Create new form
        selectFrom sf = new selectFrom(this, larr, 0);
        sf.setVisible(true);
        this.setEnabled(false);
        
        // Override Frame Close Listener & reload accordingly
        sf.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    reloadlarr();
                    reloadComboBox();
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_removecharJButtonActionPerformed
        public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new main().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcharJButton;
    private javax.swing.JLabel currTimeJLabel;
    private javax.swing.JTextField currTimeJTextField;
    private javax.swing.JScrollPane infoJScrollPane;
    private javax.swing.JTextArea infoJTextArea;
    private javax.swing.JButton removecharJButton;
    private javax.swing.JLabel resetTimeJLabel;
    private javax.swing.JTextField resetTimeJTextField;
    private javax.swing.JLabel resetWTimeJLabel;
    private javax.swing.JTextField resetWTimeTextField;
    private javax.swing.JButton selectJButton;
    private javax.swing.JComboBox<String> selectJComboBox;
    private javax.swing.JLabel selectJLabel;
    private javax.swing.JButton updateJButton;
    private javax.swing.JLabel updateJLabel;
    // End of variables declaration//GEN-END:variables
}
