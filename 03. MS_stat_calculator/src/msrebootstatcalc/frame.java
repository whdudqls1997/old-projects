package msrebootstatcalc;

import java.text.DecimalFormat;

public class frame extends javax.swing.JFrame {
    
    private double dmg;
    private double igd;
    private double atk;
    
    private MSRebootStatCalc t;
    private static DecimalFormat df1 = new DecimalFormat("#.#");
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public frame() {
        //init
        initComponents();
        this.setLocationRelativeTo(null);
        //init calc
        t = new MSRebootStatCalc();
    }
    
    private double igdEstimate(double X, double Y){
        double temp;
        double i;
        for(i = 0.0; i < 50.0; i += 0.01){
            temp = 100*X - i*X - 9900 + 100*i; //(X*(1 - (i/100))) + (i/100);//(X/(100 - i/100)) - (1/(1 - i/100)) + 1;
            System.out.println(temp);
            if(temp > (Y - 0.1) && temp < (Y + 0.1))
                break;
        }
        return i;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dmgtxt = new javax.swing.JTextField();
        igdtxt = new javax.swing.JTextField();
        atktxt = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MSCalc by zimdak");
        setResizable(false);

        jLabel1.setText("보총 (보스데미지% + 데미지%) : ");

        jLabel2.setText("방무 (소수점 첫째자리까지만 넣어주세요) : ");

        jLabel3.setText("아이템 공퍼 총합 : ");

        btn.setText("계산");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        txt.setEditable(false);
        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn)
                                .addGap(14, 14, 14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dmgtxt)
                            .addComponent(igdtxt)
                            .addComponent(atktxt, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dmgtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(igdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(atktxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        dmg = Double.valueOf(dmgtxt.getText());
        igd = Double.valueOf(igdtxt.getText());
        atk = Double.valueOf(atktxt.getText());
        
        int avg = (t.getDmgT(dmg) + t.getIgdT(igd) + t.getAtkT(atk))/3;
        
        if(dmg < 100.0 || dmg > 800.0){
            txt.setText("보총 수치가 너무 낮아 계산이 불가능합니다.\n" +  "계산을 종료합니다.");
        }else if(igd > 97.0 || igd < 90.0){
            txt.setText("방무는 97% 이하, 90 이상으로 입력해주세요.\n" + "계산을 종료합니다.");
        }else{
            txt.setText("등급은 1(가장 낮음)에서 70(가장 높음)까지 있습니다\n\n" + 
                    "현 보총의 등급은 " + t.getDmgT(dmg) + " 입니다.\n" +
                    "현 방무의 등급은 " + t.getIgdT(igd) + " 입니다.\n" +
                    "현 공퍼의 등급은 " + t.getAtkT(atk) + " 입니다.\n\n" +
                    "평균 등급은 " + avg + " 입니다.\n\n" +
                    avg + " 등급의 적정 수치는 \n" +
                    "보총: " + t.getFull(avg).get(0).intValue() +"% / " +
                    "방무: " + t.getFull(avg).get(1) +"% / " +
                    "공퍼: " + t.getFull(avg).get(2).intValue() +"% 입니다.\n\n" +
                    (avg + 1) + " 등급의 적정 수치는 \n" +
                    "보총: " + t.getFull(avg + 1).get(0).intValue() +"% / " +
                    "방무: " + t.getFull(avg + 1).get(1) +"% / " +
                    "공퍼: " + t.getFull(avg + 1).get(2).intValue() +"% 입니다.\n\n" +
                    (avg + 2) + " 등급의 적정 수치는 \n" +
                    "보총: " + t.getFull(avg + 2).get(0).intValue() +"% / " +
                    "방무: " + t.getFull(avg + 2).get(1) +"% / " +
                    "공퍼: " + t.getFull(avg + 2).get(2).intValue() +"% 입니다.\n\n" +
                    "평균 등급의 적정 수치에 도달하기 위해선 \n" + 
                    "보총: " + (int)(t.getFull(avg).get(0).intValue() - dmg) + "% / " +
                    "방무: " + 
                    df2.format(igdEstimate(igd, t.getFull(avg).get(1))) + "% / " +
                    "공퍼: " + (int)(t.getFull(avg).get(2).intValue() - atk) + "% 가 필요합니다.");
        }
    }//GEN-LAST:event_btnActionPerformed
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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new frame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField atktxt;
    private javax.swing.JButton btn;
    private javax.swing.JTextField dmgtxt;
    private javax.swing.JTextField igdtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
