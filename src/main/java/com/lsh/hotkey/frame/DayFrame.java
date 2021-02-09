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
public class DayFrame extends JDialog {

	private String dayCron = "";
	private JTextField textField;

    public DayFrame(TaskFrame parent, boolean modal) {
        super(parent, modal);
        Contains.window = this;
	    textField = parent.getjTextField4();
	    dayCron = textField.getText().trim();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jRadioButton1 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jRadioButton7 = new JRadioButton();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jCheckBox4 = new JCheckBox();
        jCheckBox5 = new JCheckBox();
        jCheckBox6 = new JCheckBox();
        jCheckBox7 = new JCheckBox();
        jCheckBox8 = new JCheckBox();
        jCheckBox9 = new JCheckBox();
        jCheckBox10 = new JCheckBox();
        jCheckBox11 = new JCheckBox();
        jCheckBox12 = new JCheckBox();
        jCheckBox13 = new JCheckBox();
        jCheckBox14 = new JCheckBox();
        jCheckBox15 = new JCheckBox();
        jCheckBox16 = new JCheckBox();
        jCheckBox17 = new JCheckBox();
        jCheckBox18 = new JCheckBox();
        jCheckBox19 = new JCheckBox();
        jCheckBox20 = new JCheckBox();
        jCheckBox21 = new JCheckBox();
        jCheckBox22 = new JCheckBox();
        jCheckBox23 = new JCheckBox();
        jCheckBox24 = new JCheckBox();
        jCheckBox25 = new JCheckBox();
        jCheckBox26 = new JCheckBox();
        jCheckBox27 = new JCheckBox();
        jCheckBox28 = new JCheckBox();
        jCheckBox29 = new JCheckBox();
        jCheckBox30 = new JCheckBox();
        jCheckBox31 = new JCheckBox();
        jCheckBox32 = new JCheckBox();
        jLabel1 = new JLabel();
        //jLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jLabel3 = new JLabel();
        jTextField2 = new JTextField();
        jLabel4 = new JLabel();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton6 = new JRadioButton();
        jRadioButton5 = new JRadioButton();
        //jLabel7 = new JLabel();
        jTextField5 = new JTextField();
        jLabel8 = new JLabel();

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(Contains.F_S_1_14);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("每天");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(Contains.F_S_1_14);
        jRadioButton3.setText("周期");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(Contains.F_S_1_14);
	    jRadioButton4.setText("从");

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(Contains.F_S_1_14);
        jRadioButton7.setText("指定");

        jCheckBox2.setFont(Contains.F_S_1_14);
        jCheckBox2.setText("01");

        jCheckBox3.setFont(Contains.F_S_1_14);
        jCheckBox3.setText("02");

        jCheckBox4.setFont(Contains.F_S_1_14);
        jCheckBox4.setText("03");

        jCheckBox5.setFont(Contains.F_S_1_14);
        jCheckBox5.setText("04");

        jCheckBox6.setFont(Contains.F_S_1_14);
        jCheckBox6.setText("05");

        jCheckBox7.setFont(Contains.F_S_1_14);
        jCheckBox7.setText("06");

        jCheckBox8.setFont(Contains.F_S_1_14);
        jCheckBox8.setText("07");

        jCheckBox9.setFont(Contains.F_S_1_14);
        jCheckBox9.setText("08");

        jCheckBox10.setFont(Contains.F_S_1_14);
        jCheckBox10.setText("09");

        jCheckBox11.setFont(Contains.F_S_1_14);
        jCheckBox11.setText("10");

        jCheckBox12.setFont(Contains.F_S_1_14);
        jCheckBox12.setText("11");

        jCheckBox13.setFont(Contains.F_S_1_14);
        jCheckBox13.setText("12");

        jCheckBox14.setFont(Contains.F_S_1_14);
        jCheckBox14.setText("13");

        jCheckBox15.setFont(Contains.F_S_1_14);
        jCheckBox15.setText("14");

        jCheckBox16.setFont(Contains.F_S_1_14);
        jCheckBox16.setText("15");

        jCheckBox17.setFont(Contains.F_S_1_14);
        jCheckBox17.setText("16");

        jCheckBox18.setFont(Contains.F_S_1_14);
        jCheckBox18.setText("17");

        jCheckBox19.setFont(Contains.F_S_1_14);
        jCheckBox19.setText("18");

        jCheckBox20.setFont(Contains.F_S_1_14);
        jCheckBox20.setText("19");

        jCheckBox21.setFont(Contains.F_S_1_14);
        jCheckBox21.setText("20");

        jCheckBox22.setFont(Contains.F_S_1_14);
        jCheckBox22.setText("21");

        jCheckBox23.setFont(Contains.F_S_1_14);
        jCheckBox23.setText("22");

        jCheckBox24.setFont(Contains.F_S_1_14);
        jCheckBox24.setText("23");

        jCheckBox25.setFont(Contains.F_S_1_14);
        jCheckBox25.setText("24");

        jCheckBox26.setFont(Contains.F_S_1_14);
        jCheckBox26.setText("25");

        jCheckBox27.setFont(Contains.F_S_1_14);
        jCheckBox27.setText("26");

        jCheckBox28.setFont(Contains.F_S_1_14);
        jCheckBox28.setText("27");

        jCheckBox29.setFont(Contains.F_S_1_14);
        jCheckBox29.setText("28");

        jCheckBox30.setFont(Contains.F_S_1_14);
        jCheckBox30.setText("29");

        jCheckBox31.setFont(Contains.F_S_1_14);
        jCheckBox31.setText("30");

        jCheckBox32.setFont(Contains.F_S_1_14);
        jCheckBox32.setText("31");

        jLabel1.setFont(Contains.F_S_1_14);
        jLabel1.setText("从");

        //jLabel2.setFont(Contains.F_S_1_14);
        //jLabel2.setText("从");

        jLabel3.setText("-");

        jLabel4.setFont(Contains.F_S_1_14);
        jLabel4.setText("日内");

        jLabel5.setFont(Contains.F_S_1_14);
        jLabel5.setText("日开始，每");

        jLabel6.setFont(Contains.F_S_1_14);
        jLabel6.setText("天执行一次");

	    jButton1.setText("确定");
	    jButton1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
			    jButton1ActionPerformed(evt);
		    }
	    });

	    jButton2.setText("取消");
	    jButton2.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
			    dispose();
		    }
	    });

	    buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(Contains.F_S_1_14);
        jRadioButton2.setText("不指定");

	    buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(Contains.F_S_1_14);
        jRadioButton6.setText("本月最后一天");

	    buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(Contains.F_S_1_14);
	    jRadioButton5.setText("每月");

        //jLabel7.setFont(Contains.F_S_1_14);
        //jLabel7.setText("每月");

        jLabel8.setFont(Contains.F_S_1_14);
        jLabel8.setText("日最近的工作日");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        //.addComponent(jLabel2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)))))
                        .addContainerGap(195, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(jLabel7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton7, GroupLayout.Alignment.LEADING)
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
                                        .addComponent(jCheckBox6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox8)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox11)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox12)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox13)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox14)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox21)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox22)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox23)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox24)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox25)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox26)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox27)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox28)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox29)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox16)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox17)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox18)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox19)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox20))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox31)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox32))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jButton1)
                                .addGap(71, 71, 71)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jRadioButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        //.addComponent(jLabel2)
                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        //.addComponent(jLabel7)
                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(jRadioButton5))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
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
                    .addComponent(jCheckBox13)
                    .addComponent(jCheckBox14)
                    .addComponent(jCheckBox15)
                    .addComponent(jCheckBox16)
                    .addComponent(jCheckBox17)
                    .addComponent(jCheckBox18)
                    .addComponent(jCheckBox19)
                    .addComponent(jCheckBox20))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox21)
                    .addComponent(jCheckBox22)
                    .addComponent(jCheckBox23)
                    .addComponent(jCheckBox24)
                    .addComponent(jCheckBox25)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox27)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox29)
                    .addComponent(jCheckBox30))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox31)
                    .addComponent(jCheckBox32))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
        init();
	    SwingUtil.setFrameTitle(this,"设置天");
    }// </editor-fold>//GEN-END:initComponents

	private void init() {
		if (dayCron.length() > 0) {
			if ("*".equals(dayCron)) {
				jRadioButton1.setSelected(true);
			}
			if ("?".equals(dayCron)){
				jRadioButton2.setSelected(true);
			}
			if (dayCron.contains("-")) {
				jRadioButton3.setSelected(true);
				String[] zq = dayCron.split("-");
				jTextField1.setText(zq[0]);
				if (zq.length >= 2) {
					jTextField2.setText(zq[1]);
				}
			}
			if (dayCron.contains("/")) {
				jRadioButton4.setSelected(true);
				String[] zq = dayCron.split("/");
				jTextField3.setText(zq[0]);
				if (zq.length >= 2) {
					jTextField4.setText(zq[1]);
				}
			}
			if (dayCron.contains("W")) {
				jRadioButton5.setSelected(true);
				String[] W = dayCron.split("W");
				if (W.length >= 1) {
					jTextField5.setText(W[0]);
				}
			}
			if (dayCron.contains("L")) {
				jRadioButton6.setSelected(true);
			}
			if (dayCron.contains(",")) {
				jRadioButton7.setSelected(true);
				String[] other = dayCron.split(",");
				for (int i = 0; i < other.length; i++) {
					SwingUtil.selectBox(this,other[i]);
				}
			}
			if (StringUtils.isNumeric(dayCron)){
				jRadioButton7.setSelected(true);
				SwingUtil.selectBox(this,dayCron);
			}
		} else {
			jRadioButton1.setSelected(true);
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		if (jRadioButton1.isSelected()) {
			textField.setText("*");
		} else if (jRadioButton2.isSelected()) {
			textField.setText("?");
		} else if (jRadioButton3.isSelected()) {
			String text1 = jTextField1.getText();
			String text2 = jTextField2.getText();
			textField.setText(text1 + "-" + text2);
		} else if (jRadioButton4.isSelected()) {
			String text1 = jTextField3.getText();
			String text2 = jTextField4.getText();
			textField.setText(text1 + "/" + text2);
		} else if (jRadioButton5.isSelected()) {
			String text = jTextField5.getText();
			textField.setText(text + "W");
		} else {
			textField.setText("L");
		}
		this.dispose();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox11;
    private JCheckBox jCheckBox12;
    private JCheckBox jCheckBox13;
    private JCheckBox jCheckBox14;
    private JCheckBox jCheckBox15;
    private JCheckBox jCheckBox16;
    private JCheckBox jCheckBox17;
    private JCheckBox jCheckBox18;
    private JCheckBox jCheckBox19;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox20;
    private JCheckBox jCheckBox21;
    private JCheckBox jCheckBox22;
    private JCheckBox jCheckBox23;
    private JCheckBox jCheckBox24;
    private JCheckBox jCheckBox25;
    private JCheckBox jCheckBox26;
    private JCheckBox jCheckBox27;
    private JCheckBox jCheckBox28;
    private JCheckBox jCheckBox29;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox30;
    private JCheckBox jCheckBox31;
    private JCheckBox jCheckBox32;
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
    //private JLabel jLabel7;
    private JLabel jLabel8;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton3;
    private JRadioButton jRadioButton4;
    private JRadioButton jRadioButton7;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton6;
    private JRadioButton jRadioButton5;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
