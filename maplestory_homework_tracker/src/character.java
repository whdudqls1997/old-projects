import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class character extends javax.swing.JFrame{
    
    // Global toss objects
    JFrame f;
    ArrayList<loader> larr;
    
    // Private stuff
    private loader target;
    
    public character(){
        // Fixed init
        initComponents();
        this.setLocationRelativeTo(null);
        tasksJTable.setAutoCreateRowSorter(true);
    }
    
    public character(JFrame f, String name, ArrayList<loader> larr){
        // Initialize Call
        this();
        this.f = f;
        this.larr = larr;
        
        // Find target loader
        for(loader l : larr){
            if(l.getName().equals(name))
                target = l;
        }
        
        // Load Table
        loadTable();
    }
    
    public JFrame getFrame(){
        return this;
    }
    
    private void loadTable(){
        ArrayList<String> temp = target.getContent();
        nameJTextField.setText(temp.get(0));
        professionJTextField.setText(temp.get(1));
        
        int t = 2;
        DefaultTableModel model = (DefaultTableModel) tasksJTable.getModel();
        model.setRowCount(0);
        
        while(t + 2 < temp.size()){
            boolean bool;
            bool = temp.get(t + 2).equals("y");
            model.addRow(new Object[]{temp.get(t), temp.get(t+1), bool});
            t+=3;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableJScrollPane = new javax.swing.JScrollPane();
        tasksJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        addcJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        resetDailyJButton = new javax.swing.JButton();
        resetWeeklyJButton = new javax.swing.JButton();
        nameJLabel = new javax.swing.JLabel();
        professionJLabel = new javax.swing.JLabel();
        dailyJLabel = new javax.swing.JLabel();
        weeklyJLabel = new javax.swing.JLabel();
        permaJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        professionJTextField = new javax.swing.JTextField();
        dailyJTextField = new javax.swing.JTextField();
        weeklyJTextField = new javax.swing.JTextField();
        permaJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Character");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tasksJTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tasksJTable.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        tasksJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task Name", "Type", "Complete?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksJTable.setRowHeight(24);
        tasksJTable.getTableHeader().setReorderingAllowed(false);
        tableJScrollPane.setViewportView(tasksJTable);
        if (tasksJTable.getColumnModel().getColumnCount() > 0) {
            tasksJTable.getColumnModel().getColumn(0).setResizable(false);
            tasksJTable.getColumnModel().getColumn(1).setResizable(false);
            tasksJTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            tasksJTable.getColumnModel().getColumn(2).setResizable(false);
            tasksJTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        addJButton.setText("Add Task");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        removeJButton.setText("Remove Task");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });

        addcJButton.setText("Add Custom Task");
        addcJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcJButtonActionPerformed(evt);
            }
        });

        exitJButton.setText("Save and Exit");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });

        resetDailyJButton.setText("Reset All Daily");
        resetDailyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetDailyJButtonActionPerformed(evt);
            }
        });

        resetWeeklyJButton.setText("Reset All Weekly");
        resetWeeklyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetWeeklyJButtonActionPerformed(evt);
            }
        });

        nameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJLabel.setText("Name :");

        professionJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        professionJLabel.setText("Profession :");

        dailyJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dailyJLabel.setText("Daily Progression :");

        weeklyJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weeklyJLabel.setText("Weekly Progression :");

        permaJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        permaJLabel.setText("Perma Objects Progression :");

        nameJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        professionJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        dailyJTextField.setEditable(false);
        dailyJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        weeklyJTextField.setEditable(false);
        weeklyJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        permaJTextField.setEditable(false);
        permaJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addcJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetDailyJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetWeeklyJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(professionJLabel)
                        .addGap(158, 158, 158)
                        .addComponent(professionJTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dailyJLabel)
                        .addGap(112, 112, 112)
                        .addComponent(dailyJTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weeklyJLabel)
                        .addGap(95, 95, 95)
                        .addComponent(weeklyJTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(permaJLabel)
                        .addGap(43, 43, 43)
                        .addComponent(permaJTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJLabel)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professionJLabel)
                    .addComponent(professionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dailyJLabel)
                    .addComponent(dailyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weeklyJLabel)
                    .addComponent(weeklyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(permaJLabel)
                    .addComponent(permaJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(addcJButton)
                    .addComponent(exitJButton)
                    .addComponent(removeJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tableJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetDailyJButton)
                    .addComponent(resetWeeklyJButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            target.save();
        } catch (IOException ex) {
            Logger.getLogger(character.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        f.setEnabled(true);
        f.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        selectFrom sf = new selectFrom(this, target, 1);
        sf.setVisible(true);
        this.setEnabled(false);
        
        sf.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadTable();
            }
        });
    }//GEN-LAST:event_addJButtonActionPerformed

    private void addcJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addcJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        selectFrom sf = new selectFrom(this, target, 2);
        sf.setVisible(true);
        this.setEnabled(false);
        
        sf.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loadTable();
            }
        });
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void resetDailyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDailyJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetDailyJButtonActionPerformed

    private void resetWeeklyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetWeeklyJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetWeeklyJButtonActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(character.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new character().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton addcJButton;
    private javax.swing.JLabel dailyJLabel;
    private javax.swing.JTextField dailyJTextField;
    private javax.swing.JButton exitJButton;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel permaJLabel;
    private javax.swing.JTextField permaJTextField;
    private javax.swing.JLabel professionJLabel;
    private javax.swing.JTextField professionJTextField;
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton resetDailyJButton;
    private javax.swing.JButton resetWeeklyJButton;
    private javax.swing.JScrollPane tableJScrollPane;
    private javax.swing.JTable tasksJTable;
    private javax.swing.JLabel weeklyJLabel;
    private javax.swing.JTextField weeklyJTextField;
    // End of variables declaration//GEN-END:variables
}
