package com.lsh.hotkey.frame;

import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class WaitFrame extends JDialog {

    public WaitFrame() { }
    public WaitFrame(JFrame parent, boolean modal) {
        super(parent, modal);
    }

    public WaitFrame(DocumentDuplicationCheck documentDuplicationCheck, boolean modal) {
        super(documentDuplicationCheck, modal);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jProgressBar1 = new JProgressBar();
        jProgressBar1.setIndeterminate(true);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    public void showBar(){
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("");
//        大小不可变
        this.setResizable(false);
//        这句话必须放在setVisible(true)语句之前才能生效
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
//        this.setUndecorated(true);
    }
    public void closeBar() {
        this.dispose();
        this.setVisible(false);
        this.setEnabled(false);
    }

    private JProgressBar jProgressBar1;

   /* public static void main(String[] args) {
        WaitFrame waitFrame = new WaitFrame();
        waitFrame.showBar();
        waitFrame.closeBar();

    }*/
}
