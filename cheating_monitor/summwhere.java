package summwhere;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class summwhere extends javax.swing.JFrame {
    private String name;
    private int x;
    public summwhere() {
        name = "";
        x = 0;
        File dir = new File("C:\\tempS\\");
        dir.mkdir();
        initComponents();
        this.setLocationRelativeTo(null);
    }
    private ArrayList<String> parseProcess(){
        ArrayList<String> lst = new ArrayList<>();
        try {
            String line;
            Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                while ((line = input.readLine()) != null)
                    lst.add(line);
            }
        } catch (IOException err) {
            System.out.println("Process Parse Error");
        }
        return lst;
    }
    class detectJob extends TimerTask {
        @Override
        public void run() {
            screenshot sc = new screenshot();
            email em = new email();
            sc.saveScreenShot(name + Integer.toString(x));
            em.sendEmail(name + Integer.toString(x), parseProcess());
            x++;
        }
    }
    public void delete(File file) throws IOException{
        if(file.isDirectory()){
            if(file.list().length==0){
                file.delete();	
            }else{
        	String files[] = file.list();
                    for (String temp : files) {
                        File fileDelete = new File(file, temp);
                        delete(fileDelete);
                    }
                    if(file.list().length==0){
                        file.delete();
                    }
                }
            }else{
            file.delete();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textJScrollPane = new javax.swing.JScrollPane();
        textJTextArea = new javax.swing.JTextArea();
        submitJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("summwhere");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textJTextArea.setEditable(false);
        textJTextArea.setColumns(20);
        textJTextArea.setRows(5);
        textJTextArea.setText("Keep this program on.\nIf the program is closed, an alarm will be\nsent to the server and you will be assumed\nas cheating.\nEnter the name of your account in the text\nbox below and press the button on the right\nof the text box.");
        textJScrollPane.setViewportView(textJTextArea);

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameJTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitJButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        name = nameJTextField.getText();
        submitJButton.setEnabled(false);
        nameJTextField.setEditable(false);
        Timer timer = new Timer();
        timer.schedule(new detectJob(), 0, 300000);
    }//GEN-LAST:event_submitJButtonActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            delete(new File("C:\\tempS\\"));
        } catch (IOException ex) {
            Logger.getLogger(summwhere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(summwhere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(summwhere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(summwhere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(summwhere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            int confirmed = JOptionPane.showConfirmDialog(null, 
                "This program will send some information of your PC to a remote location.\n"
                        + "This program does not contain any kind of key logger or is meant to steal private information.\n"
                        + "The information will be used, and will be only used, for examination of your PC's behavior during the full time duration of the scrim.\n"
                        + "Acquired information will remain private and will be discarded once examination is over and you've been cleared.\n"
                        + "Please press yes to show that you understand and wish continue", "Warning",
                JOptionPane.YES_NO_OPTION);
            if(confirmed == JOptionPane.YES_OPTION)
                new summwhere().setVisible(true);
            else
                System.exit(0);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JScrollPane textJScrollPane;
    private javax.swing.JTextArea textJTextArea;
    // End of variables declaration//GEN-END:variables
}