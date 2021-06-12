import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class selectFrom extends javax.swing.JFrame {

    // Global toss objects
    JFrame f;
    ArrayList<loader> larr;
    loader target;
    
    // Private stuff
    private int protocal;
    private String[] preset = {"Level 120", "Perma", "Level 140", "Perma", "Level 200", "Perma",
                                "손재주 50레벨", "Perma", "손재주 100레벨", "Perma", "반레온 선행퀘", "Perma",
                                "핑크빈 선행퀘", "Perma", "노말 루타 각 10회", "Perma", "아카이럼 선행퀘", "Perma",
                                "카웅 선행퀘", "Perma", "노말 시그너스 선행퀘", "Perma", "스우 선행퀘", "Perma",
                                "데미안 선행퀘", "Perma", "루시드 선행퀘", "Perma", "윌 선행퀘", "Perma",
                                "유니온 일일퀘스트", "Daily", "아케인심볼 일일퀘스트", "Daily", "몬스터파크 2회", "Daily",
                                "몬스터컬렉션 탐험 보상", "Daily", "우르스 3회", "Daily", "헤이븐 일일퀘스트", "Daily",
                                "타락한 세계수 일일퀘스트", "Daily", "몬스터라이프 관리", "Daily", "노말 자쿰", "Daily",
                                "노말 힐라", "Daily", "노말 매그너스", "Daily", "카웅", "Daily", "반레온", "Daily", "혼테일", "Daily",
                                "노말 루타비스", "Daily", "노말 파풀라투스", "Daily", "노말 핑크빈", "Daily", "노말 아카이럼", "Daily",
                                "크리티아스 주간퀘스트", "Weekly", "헤이븐 주간퀘스트", "Weekly", "타락한 세계수 주간퀘스트", "Weekly", 
                                "카오스 자쿰", "Weekly", "하드 힐라", "Weekly", "하드 매그너스", "Weekly", "카오스 핑크빈", "Weekly",
                                "카오스 루타비스 4종", "Weekly", "카오스 파풀라투스", "Weekly", "이지/노말 시그너스", "Weekly", "스우", "Weekly",
                                "데미안", "Weekly", "루시드", "Weekly", "윌", "Weekly", "더스크", "Weekly", "듄켈", "Weekly", "진힐라", "Weekly"};
    
    public selectFrom() {
        // Fixed Init
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public selectFrom(JFrame f, loader target, int protocal){
        // Init
        this();
        this.f = f;
        this.protocal = protocal;
        this.target = target;
        
        // Populate Table
        populate();
    }
    
    public selectFrom(JFrame f, ArrayList<loader> larr, int protocal){
        // Init
        this();
        this.f = f;
        this.protocal = protocal;
        this.larr = larr;
        
        // Populate Table
        populate();
    }
    
    public JFrame getFrame(){
        return this;
    }
    
    private void populate(){
        DefaultTableModel model = (DefaultTableModel) selectJTable.getModel();
        switch(protocal){
            case 0:
                larr.forEach((l) -> {
                    model.addRow(new Object[]{l.getName(), false});
                });
                break;
            case 1:
                int temp = 0;
                while(temp < preset.length){
                    model.addRow(new Object[]{preset[temp], false});
                    temp += 2;
                }
                break;
            default:
                int temp2 = 2;
                while(temp2 + 2 < target.getContent().size()){
                    model.addRow(new Object[]{target.getContent().get(temp2), false});
                    temp2 += 3;
                }
                break;
        }
    }
    
    private void removeSelected(){
        DefaultTableModel model = (DefaultTableModel) selectJTable.getModel();
        for(int i = 0; i < model.getRowCount(); i++){
            if((boolean) model.getValueAt(i, 1)){
                for(loader l : larr){
                    if(l.getName().equals(model.getValueAt(i, 0)))
                        l.remove();
                }
            }
        }
    }
    
    private ArrayList<String> getSelectedPreset(){
        ArrayList<String> temp = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) selectJTable.getModel();
        for(int i = 0; i < model.getRowCount(); i++){
            if((boolean) model.getValueAt(i, 1)){
                temp.add((String) model.getValueAt(i, 0));
                temp.add(preset[(i * 2) + 1]);
                temp.add("n");
            }
        }
        return temp;
    }
    
    private ArrayList<String> getSelectedPresetSimple(){
        ArrayList<String> temp = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) selectJTable.getModel();
        for(int i = 0; i < model.getRowCount(); i++){
            if((boolean) model.getValueAt(i, 1))
                temp.add((String) model.getValueAt(i, 0));
        }
        return temp;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectJScrollPane = new javax.swing.JScrollPane();
        selectJTable = new javax.swing.JTable();
        selectJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        selectJTable.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        selectJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Select This", "Choose?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        selectJTable.getTableHeader().setReorderingAllowed(false);
        selectJScrollPane.setViewportView(selectJTable);
        if (selectJTable.getColumnModel().getColumnCount() > 0) {
            selectJTable.getColumnModel().getColumn(0).setResizable(false);
            selectJTable.getColumnModel().getColumn(1).setResizable(false);
            selectJTable.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        selectJButton.setText("Select");
        selectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(selectJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(selectJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectJButtonActionPerformed
        switch(protocal){
            case 0:
                removeSelected();
                break;
            case 1:
                target.addContent(getSelectedPreset());
                break;
            default:
                getSelectedPresetSimple().forEach((s) -> {
                    target.removeContent(s);
                });
                break;
        }
        
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_selectJButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        f.setEnabled(true);
        f.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new selectFrom().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton selectJButton;
    private javax.swing.JScrollPane selectJScrollPane;
    private javax.swing.JTable selectJTable;
    // End of variables declaration//GEN-END:variables
}
