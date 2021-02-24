package com.lsh.hotkey.frame;

import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.SwingUtil;
import com.lsh.hotkey.utils.VideoUtil;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Administrator
 */
public class VideoToGif extends JDialog {

    public VideoToGif(Frame parent,boolean model) {
        super(parent,model);
        initComponents();
        SwingUtil.setFrameTitle(this,"视频转GIF");
    }

    public VideoToGif() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new JLabel("视频文件：");
        jTextField1 = new JTextField();
        jTextField1.setEnabled(false);
        jButton4 = new JButton("选择");
        jLabel8 = new JLabel("输出目录：");
        jTextField2 = new JTextField();
        jButton5 = new JButton("选择");
        jButton6 = new JButton("开始转换");
        jSlider1 = new JSlider();
        jLabel1 = new JLabel("开始：");
        jLabel2 = new JLabel("结束：");
        jSlider2 = new JSlider();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jLabel3 = new JLabel("帧率：");
        jSlider3 = new JSlider(1,15,1);
        jLabel4 = new JLabel("缩放：");
        jTextField5 = new JTextField();
        jLabel5 = new JLabel("建议0-2之间");

        jSlider1.setValue(0);
        jSlider2.setValue(0);
        jSlider1.setMinorTickSpacing(1);
        jSlider2.setMinorTickSpacing(1);
        jSlider1.setEnabled(false);
        jSlider2.setEnabled(false);
        // 绘制 刻度 和 标签
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);
        // 设置主刻度间隔
        jSlider1.setMajorTickSpacing(60);
        // 设置次刻度间隔
        jSlider1.setMinorTickSpacing(1);
        // 设置主刻度间隔
        jSlider2.setMajorTickSpacing(60);
        // 设置次刻度间隔
        jSlider2.setMinorTickSpacing(1);
        // 设置主刻度间隔
        jSlider3.setMajorTickSpacing(5);
        // 设置次刻度间隔
        jSlider3.setMinorTickSpacing(1);
        // 设置主刻度间隔
//        jSlider4.setMajorTickSpacing(0.5);
//        Hashtable labelTable = new Hashtable();
//        for (int i = 0; i <= 20; i++) {
//            labelTable.put(new Integer(i),String.valueOf(i / 10.0));
//        }
//        jSlider4.setLabelTable(labelTable);
        // 设置次刻度间隔
//        jSlider4.setMinorTickSpacing(0.1);
        // 绘制 刻度 和 标签
        jSlider3.setPaintTicks(true);
        jSlider3.setPaintLabels(true);
//        jSlider4.setPaintTicks(true);
//        jSlider4.setPaintLabels(true);

        jTextField3.setText("");
        jTextField4.setText("");

        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5)
                                                .addContainerGap(76, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton6)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel7)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel3))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel4)
                                                                                .addGap(24, 24, 24)))
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jSlider1, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                                                                                        .addComponent(jTextField1)
                                                                                        .addComponent(jSlider2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jSlider3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jTextField3, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                                                                        .addComponent(jTextField4)
                                                                                        .addComponent(jButton4)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(4, 4, 4)
                                                                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel5)))))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jSlider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jSlider2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jSlider3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5))
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(36, 36, 36))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    //    setPaintLabels(boolean b)	确定是否在滑块上绘制标签
//            setPaintTicks(boolean b)	确定是否在滑块上绘制刻度标记
//            setPaintTrack(boolean b)	确定是否在滑块上绘制滑
//    private int end = 0;
    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int i = SwingUtil.openJfile(0);
        if (i == 1) {
            return;
        } else {
            String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
            jTextField1.setText(absolutePath);

            VideoUtil.getVideoDuration(new File(absolutePath));
            int videoLen = (int) VideoUtil.videoLen;

            jSlider1.setMinimum(0);
            jSlider1.setMaximum(videoLen);
            jSlider1.setEnabled(true);

            jSlider2.setMinimum(0);
            jSlider2.setMaximum(videoLen);
            jSlider2.setEnabled(true);

            // 添加刻度改变监听器
            jSlider1.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    setTimetxt(jTextField3,jSlider1);
                }
            });
            // 添加刻度改变监听器
            jSlider2.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    setTimetxt(jTextField4,jSlider2);
                }
            });
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        SwingUtil.setTextFile(jTextField2,1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void setTimetxt(JTextField textField,JSlider jSlider) {
        int value = jSlider.getValue();
        int h = value / 3600;
        int i = value % 3600;
        int m = i / 60;
        int s = i % 60;
        String result = String.format("%02d",h) + ":" + String.format("%02d",m) + ":" + String.format("%02d",s);
        textField.setText(result);
//        textField.setText(value + "");
    }

    //    开始转换
    private void jButton6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String text1 = jTextField1.getText().trim();
        String text2 = jTextField2.getText().trim();
        if (text1.length() > 0 && text2.length() > 0) {
            String text3 = jTextField3.getText().trim();
            String text4 = jTextField4.getText().trim();
            int value1 = jSlider3.getValue();
            String value2 = jTextField5.getText().trim();
//            int start = 0;
            Contains.POOL.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        VideoUtil.buildGif(text1,text3,text4,value1,text2,value2);
                        Contains.wait.dispose();
                    } catch (Exception e) {
//                e.printStackTrace();
                        Contains.DIALOG.showMessageDialog(new VideoToGif(),e.getMessage());
                        return;
                    }
                }
            });
//            Thread thread = new Thread();
//            thread.start();
            Contains.wait = new WaitFrame(new VideoToGif(),true);
            Contains.DIALOG.showMessageDialog(this,"转换完成");

        } else {
            Contains.DIALOG.showMessageDialog(this,"不能为空！");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JSlider jSlider1;
    private JSlider jSlider2;
    private JSlider jSlider3;
    //    private JSlider jSlider4;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
