package com.lsh.hotkey.frame;

import com.lsh.hotkey.thread.SerachThread;
import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.SwingUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class RenameFrame extends JDialog {
    private static CountDownLatch latch;

    public RenameFrame() {}

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    /**
     * Creates new form RenameFrame
     */
    public RenameFrame(Frame parent, boolean modal) {
        super(parent, modal);
        Contains.window = this;
        initComponents();
        SwingUtil.setFrameTitle(this,"批量重命名");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        buttonGroup3 = new ButtonGroup();
        buttonGroup4 = new ButtonGroup();
        jLabel1 = new JLabel("文件夹：");
        jTextField1 = new JTextField();
        jButton1 = new JButton("选择");
        jRadioButton1 = new JRadioButton("顺序");
        jRadioButton2 = new JRadioButton("倒序");
        jRadioButton3 = new JRadioButton("数字");
        jRadioButton4 = new JRadioButton("汉字");
        localjrbq = new JRadioButton("前缀");
        localjrbh = new JRadioButton("后缀");
        localjrbf = new JRadioButton("覆盖");
        jLabel2 = new JLabel("位置：");
        jLabel3 = new JLabel("格式：");
        jCheckBox2 = new JCheckBox("1");
        jCheckBox3 = new JCheckBox("2");
        jTextField2 = new JTextField();
        jLabel4 = new JLabel("自定义：");
        gs2q = new JRadioButton("前缀");
        gs2h = new JRadioButton("后缀");
        jButton2 = new JButton("重命名");
        jLabel5 = new JLabel();

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        buttonGroup1.add(jRadioButton2);
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        buttonGroup2.add(jRadioButton4);
        buttonGroup3.add(localjrbq);
        buttonGroup3.add(localjrbh);
        buttonGroup3.add(localjrbf);
        localjrbf.setSelected(true);
        buttonGroup4.add(gs2q);
        buttonGroup4.add(gs2h);
        gs2h.setSelected(true);

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        jLabel5.setForeground(new Color(255, 0, 102));
        jLabel5.setText("<html><body>格式里面1和2组合使用<br>格式1里面的数字是1,2，3。。。阿拉伯数字<br>汉字是一二三。。。" +
                "<br>格式2中的前缀和后缀是对于格式1来说的<br> 位置里面的前后缀是对于格式1和格式2组合来说的<br>" +
                "覆盖：如果只选择了格式2自定义重命名，结果为：“内容”_1,也就是内容+数字顺序组合</body></html>   ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jCheckBox2)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jRadioButton1)
                                                                                        .addComponent(jRadioButton3)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jCheckBox3)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel4)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jRadioButton2)
                                                                        .addComponent(jRadioButton4)
                                                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(gs2q)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(gs2h)))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(localjrbq)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(localjrbh)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(localjrbf)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(217, 217, 217)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton1)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jLabel3)
                                        .addComponent(jCheckBox2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton4))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBox3)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gs2q)
                                        .addComponent(gs2h))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(localjrbq)
                                        .addComponent(localjrbh)
                                        .addComponent(localjrbf))
                                .addGap(36, 36, 36)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(ActionEvent e){
        jButton2.setEnabled(false);
        WaitFrame waitFrame = new WaitFrame(new RenameFrame(),true);
        RameThread thread = new RameThread(waitFrame);
//        thread.start();
        Contains.window = Contains.DIALOG;
        Contains.parentWindow = this;
        String textt = jTextField1.getText().trim();
        
        if (textt.length() > 0) {
            String[] paths = textt.split(";");
            int length = paths.length;
            Contains.FILESS = new ArrayList<>();
            File[] roots = {};
            Set<String> pathSet = Arrays.stream(paths).collect(Collectors.toSet());
            roots = new File[pathSet.size()];
            Iterator<String> iterator = pathSet.iterator();
            int index = 0;
            while (iterator.hasNext()) {
                File file = new File(iterator.next());
                if (file.exists()) {
                    roots[index] = file;
                    index++;
                }
            }
            try {
                latch = new CountDownLatch(length);
                for (int i = 0; i < length; i++) {
                    Contains.POOL.execute(new SerachThread(roots[i],latch,1));
                }
                // 结束线程池
                latch.await();
            } catch (InterruptedException ee) {
                Contains.DIALOG.showMessageDialog(this,ee.getMessage());
                return;
            }
            boolean selected2 = jCheckBox2.isSelected();
            boolean selected3 = jCheckBox3.isSelected();
            String result = "";
            if (selected2 || selected3) {
//            后缀
                boolean localq = localjrbq.isSelected();
//            前缀
                boolean localh = localjrbh.isSelected();
                int size = Contains.FILESS.size();
                try {
                    for (int i = 0; i < size; i++) {
                        String path = Contains.FILESS.get(i);
                        int ind = path.lastIndexOf(File.separator);
                        String fileNameq = path.substring(0,ind + 1);
                        String fileNameh = path.substring(ind + 1);
                        String type = "";
                        String fileName = "";
                        try {
                            int index2 = fileNameh.lastIndexOf(".");
                            fileName = fileNameh.substring(0, index2);
                            type = fileNameh.substring(index2);
                        } catch (Exception exception) {
                            fileName = fileNameh;
                        }

                        String newName = "";
                        String text = jTextField2.getText().trim();
                        boolean sbtn5 = gs2q.isSelected();
                        if (selected2) {
                            boolean sbtn1 = jRadioButton1.isSelected();
                            boolean sbtn4 = jRadioButton4.isSelected();
                            if (sbtn1) {
                                result = (i + "");
                            } else {
                                result = ((size - i) + "");
                            }
                            if (sbtn4) {
                                result = Contains.numToString(result);
                            }
                        } else {
                            if (!text.isEmpty()) {
                                if (sbtn5) {
                                    result = text + i + "_";
                                } else {
                                    result = "_" + text + i;
                                }
                            }
                        }
                        if (selected2 && selected3) {
                            if (sbtn5) {
                                result = text + result;
                            } else {
                                result += text;
                            }
                        }
                        if (localq) {
                            newName = result + fileName + type;
                        } else if (localh) {
                            newName = fileName + result + type;
                        } else {
                            newName = result + type;
                        }
//                判断文件名是否合法
                        if (newName.length() <= 255) {
                            boolean matches = newName.matches("[^(A-Za-z0-9\\\\u4e00-\\\\u9fa5_\\-\\.)]");
                            if (matches) {
                                Contains.DIALOG.showMessageDialog(this,"从" + newName + "开始，文件名不符合规则！");
                                return;
                            } else {
                                //                    使用cmd重命名文件
//                            String s = Contains.exeCMD("rename " + path + " " + newName);
                                new File(path).renameTo(new File(fileNameq + newName));
                            }
                        } else {
                            Contains.DIALOG.showMessageDialog(this,"从" + newName + "开始，文件名太长！");
                            return;
                        }
                    }
                } catch (Exception exception) {
                    Contains.DIALOG.showMessageDialog(this,exception.getMessage());
                    return;
                }finally {
                    thread.stopThread();
                    jButton2.setEnabled(true);
                }
            } else {
                Contains.DIALOG.showMessageDialog(this,"先选择一个格式！");
                thread.stopThread();
                jButton2.setEnabled(true);
                return;
            }
        } else {
            thread.stopThread();
            jButton2.setEnabled(true);
            Contains.DIALOG.showMessageDialog(this,"请先选择文件夹！");
            return;
        }
        thread.stopThread();
    }
    private void jButton1ActionPerformed(ActionEvent e){
        new FileList(this,true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup4;
    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton localjrbq;
    private JRadioButton localjrbh;
    private JRadioButton localjrbf;
    private JRadioButton gs2q;
    private JRadioButton gs2h;
    private JTextField jTextField1;
    private JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
    class RameThread extends Thread{
        private WaitFrame waitFrame;

        public WaitFrame getWaitFrame() {
            return waitFrame;
        }

        public void setWaitFrame(WaitFrame waitFrame) {
            this.waitFrame = waitFrame;
        }

        public RameThread(WaitFrame waitFrame) {
            this.waitFrame = waitFrame;
        }
        @Override
        public void run() {
            waitFrame.showBar();
        }
        
        public void stopThread() {
            waitFrame.dispose();
            this.interrupt();
        }
    }
}
