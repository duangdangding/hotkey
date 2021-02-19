package com.lsh.hotkey.frame;

import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.SwingUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Administrator
 */
public class MonthFrame extends JDialog {
	private String monCron = "";
	private JTextField textField;

    public MonthFrame(TaskFrame parent, boolean modal) {
        super(parent, modal);
	    Contains.window = this;
	    textField = parent.getjTextField3();
	    monCron = textField.getText().trim();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jRadioButton1 = new JRadioButton("每月");
        jRadioButton2 = new JRadioButton("周期");
        jRadioButton3 = new JRadioButton("从");
        jRadioButton4 = new JRadioButton("指定");
        jCheckBox2 = new JCheckBox("01");
        jCheckBox3 = new JCheckBox("02");
        jCheckBox4 = new JCheckBox("03");
        jCheckBox5 = new JCheckBox("04");
        jCheckBox6 = new JCheckBox("05");
        jCheckBox7 = new JCheckBox("06");
        jCheckBox8 = new JCheckBox("07");
        jCheckBox9 = new JCheckBox("08");
        jCheckBox10 = new JCheckBox("09");
        jCheckBox11 = new JCheckBox("10");
        jCheckBox12 = new JCheckBox("11");
        jCheckBox13 = new JCheckBox("12");
        jLabel1 = new JLabel("从");
        //jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel("-");
        jTextField2 = new JTextField();
        jLabel4 = new JLabel("月内");
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jLabel5 = new JLabel("日开始，每");
        jLabel6 = new JLabel("月执行一次");
        jButton1 = new JButton("确定");
        jButton2 = new JButton("取消");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(Contains.F_S_1_14);
        jRadioButton1.setSelected(true);
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(Contains.F_S_1_14);
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(Contains.F_S_1_14);
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(Contains.F_S_1_14);
        
        jCheckBox2.setFont(Contains.F_S_1_14);
        jCheckBox3.setFont(Contains.F_S_1_14);
        jCheckBox4.setFont(Contains.F_S_1_14);
        jCheckBox5.setFont(Contains.F_S_1_14);
        jCheckBox6.setFont(Contains.F_S_1_14);
        jCheckBox7.setFont(Contains.F_S_1_14);
        jCheckBox8.setFont(Contains.F_S_1_14);
        jCheckBox9.setFont(Contains.F_S_1_14);
        jCheckBox10.setFont(Contains.F_S_1_14);
        jCheckBox11.setFont(Contains.F_S_1_14);
        jCheckBox12.setFont(Contains.F_S_1_14);
        jCheckBox13.setFont(Contains.F_S_1_14);
        
        jLabel1.setFont(Contains.F_S_1_14);
        jLabel3.setFont(Contains.F_S_1_14);
        jLabel4.setFont(Contains.F_S_1_14);
        jLabel5.setFont(Contains.F_S_1_14);
        jLabel6.setFont(Contains.F_S_1_14);

	    jButton1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
			    jButton1ActionPerformed(evt);
		    }
	    });

	    jButton2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
			    dispose();
		    }
	    });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioButton4, GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1, GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        //.addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox11)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox12)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox13)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jCheckBox2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox8)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox9)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jRadioButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        //.addComponent(jLabel2)
                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8)
                    .addComponent(jCheckBox9)
                    .addComponent(jCheckBox10))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox11)
                    .addComponent(jCheckBox12)
                    .addComponent(jCheckBox13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
	    init();
	    SwingUtil.setFrameTitle(this,"设置月");
    }// </editor-fold>//GEN-END:initComponents

	private void init() {
		if (monCron.length() > 0) {
			if ("*".equals(monCron)) {
				jRadioButton1.setSelected(true);
			}
			if (monCron.contains("-")) {
				jRadioButton2.setSelected(true);
				String[] zq = monCron.split("-");
				jTextField1.setText(zq[0]);
				if (zq.length >= 2) {
					jTextField2.setText(zq[1]);
				}
			}
			if (monCron.contains("/")) {
				jRadioButton3.setSelected(true);
				String[] jg = monCron.split("/");
				jTextField3.setText(jg[0]);
				if (jg.length >= 2) {
					jTextField4.setText(jg[1]);
				}
			}
			if (monCron.contains(",")) {
				jRadioButton4.setSelected(true);
				String[] other = monCron.split(",");
				for (int i = 0; i < other.length; i++) {
					SwingUtil.selectBox(this,other[i]);
				}
			}
			if (StringUtils.isNumeric(monCron)){
				jRadioButton4.setSelected(true);
				SwingUtil.selectBox(this,monCron);
			}
		} else {
			jRadioButton1.setSelected(true);
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		if (jRadioButton1.isSelected()) {
			textField.setText("*");
		} else if (jRadioButton2.isSelected()) {
			String text1 = jTextField1.getText();
			String text2 = jTextField2.getText();
			textField.setText(text1 + "-" + text2);
		} else if (jRadioButton3.isSelected()) {
			String text1 = jTextField3.getText();
			String text2 = jTextField4.getText();
			textField.setText(text1 + "/" + text2);
		} else {
			String selectBox = SwingUtil.getSelectBox(this);
			textField.setText(selectBox);
		}
		dispose();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox11;
    private JCheckBox jCheckBox12;
    private JCheckBox jCheckBox13;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox8;
    private JCheckBox jCheckBox9;
    private JLabel jLabel1;
    //private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
