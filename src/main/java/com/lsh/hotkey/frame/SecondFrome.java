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
public class SecondFrome extends JDialog {
	private Font font = new Font("宋体", 1, 14);
	private String seconCron = "";
	private JTextField textField;
	
    public SecondFrome(TaskFrame parent, boolean modal) {
        super(parent, modal);
	    Contains.window = this;
	    textField = parent.getjTextField7();
	    seconCron = textField.getText().trim();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton4 = new JRadioButton();
        jCheckBox1 = new JCheckBox();
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
        jCheckBox33 = new JCheckBox();
        jCheckBox34 = new JCheckBox();
        jCheckBox35 = new JCheckBox();
        jCheckBox36 = new JCheckBox();
        jCheckBox37 = new JCheckBox();
        jCheckBox38 = new JCheckBox();
        jCheckBox39 = new JCheckBox();
        jCheckBox40 = new JCheckBox();
        jCheckBox41 = new JCheckBox();
        jCheckBox42 = new JCheckBox();
        jCheckBox43 = new JCheckBox();
        jCheckBox44 = new JCheckBox();
        jCheckBox45 = new JCheckBox();
        jCheckBox46 = new JCheckBox();
        jCheckBox47 = new JCheckBox();
        jCheckBox48 = new JCheckBox();
        jCheckBox49 = new JCheckBox();
        jCheckBox50 = new JCheckBox();
        jCheckBox51 = new JCheckBox();
        jCheckBox52 = new JCheckBox();
        jCheckBox53 = new JCheckBox();
        jCheckBox54 = new JCheckBox();
        jCheckBox55 = new JCheckBox();
        jCheckBox56 = new JCheckBox();
        jCheckBox57 = new JCheckBox();
        jCheckBox58 = new JCheckBox();
        jCheckBox59 = new JCheckBox();
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
        jCheckBox60 = new JCheckBox();
        jButton1 = new JButton();
        jButton2 = new JButton();

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(font); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("每秒");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(font); // NOI18N
        jRadioButton2.setText("周期");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(font); // NOI18N
	    jRadioButton3.setText("从");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(font); // NOI18N
        jRadioButton4.setText("指定");

        jCheckBox1.setFont(font); // NOI18N
        jCheckBox1.setText("00");

        jCheckBox2.setFont(font); // NOI18N
        jCheckBox2.setText("01");

        jCheckBox3.setFont(font); // NOI18N
        jCheckBox3.setText("02");

        jCheckBox4.setFont(font); // NOI18N
        jCheckBox4.setText("03");

        jCheckBox5.setFont(font); // NOI18N
        jCheckBox5.setText("04");

        jCheckBox6.setFont(font); // NOI18N
        jCheckBox6.setText("05");

        jCheckBox7.setFont(font); // NOI18N
        jCheckBox7.setText("06");

        jCheckBox8.setFont(font); // NOI18N
        jCheckBox8.setText("07");

        jCheckBox9.setFont(font); // NOI18N
        jCheckBox9.setText("08");

        jCheckBox10.setFont(font); // NOI18N
        jCheckBox10.setText("09");

        jCheckBox11.setFont(font); // NOI18N
        jCheckBox11.setText("10");

        jCheckBox12.setFont(font); // NOI18N
        jCheckBox12.setText("11");

        jCheckBox13.setFont(font); // NOI18N
        jCheckBox13.setText("12");

        jCheckBox14.setFont(font); // NOI18N
        jCheckBox14.setText("13");

        jCheckBox15.setFont(font); // NOI18N
        jCheckBox15.setText("14");

        jCheckBox16.setFont(font); // NOI18N
        jCheckBox16.setText("15");

        jCheckBox17.setFont(font); // NOI18N
        jCheckBox17.setText("16");

        jCheckBox18.setFont(font); // NOI18N
        jCheckBox18.setText("17");

        jCheckBox19.setFont(font); // NOI18N
        jCheckBox19.setText("18");

        jCheckBox20.setFont(font); // NOI18N
        jCheckBox20.setText("19");

        jCheckBox21.setFont(font); // NOI18N
        jCheckBox21.setText("20");

        jCheckBox22.setFont(font); // NOI18N
        jCheckBox22.setText("21");

        jCheckBox23.setFont(font); // NOI18N
        jCheckBox23.setText("22");

        jCheckBox24.setFont(font); // NOI18N
        jCheckBox24.setText("23");

        jCheckBox25.setFont(font); // NOI18N
        jCheckBox25.setText("24");

        jCheckBox26.setFont(font); // NOI18N
        jCheckBox26.setText("25");

        jCheckBox27.setFont(font); // NOI18N
        jCheckBox27.setText("26");

        jCheckBox28.setFont(font); // NOI18N
        jCheckBox28.setText("27");

        jCheckBox29.setFont(font); // NOI18N
        jCheckBox29.setText("28");

        jCheckBox30.setFont(font); // NOI18N
        jCheckBox30.setText("29");

        jCheckBox31.setFont(font); // NOI18N
        jCheckBox31.setText("30");

        jCheckBox32.setFont(font); // NOI18N
        jCheckBox32.setText("31");

        jCheckBox33.setFont(font); // NOI18N
        jCheckBox33.setText("32");

        jCheckBox34.setFont(font); // NOI18N
        jCheckBox34.setText("33");

        jCheckBox35.setFont(font); // NOI18N
        jCheckBox35.setText("34");

        jCheckBox36.setFont(font); // NOI18N
        jCheckBox36.setText("35");

        jCheckBox37.setFont(font); // NOI18N
        jCheckBox37.setText("36");

        jCheckBox38.setFont(font); // NOI18N
        jCheckBox38.setText("37");

        jCheckBox39.setFont(font); // NOI18N
        jCheckBox39.setText("38");

        jCheckBox40.setFont(font); // NOI18N
        jCheckBox40.setText("39");

        jCheckBox41.setFont(font); // NOI18N
        jCheckBox41.setText("40");

        jCheckBox42.setFont(font); // NOI18N
        jCheckBox42.setText("41");

        jCheckBox43.setFont(font); // NOI18N
        jCheckBox43.setText("42");

        jCheckBox44.setFont(font); // NOI18N
        jCheckBox44.setText("43");

        jCheckBox45.setFont(font); // NOI18N
        jCheckBox45.setText("44");

        jCheckBox46.setFont(font); // NOI18N
        jCheckBox46.setText("45");

        jCheckBox47.setFont(font); // NOI18N
        jCheckBox47.setText("46");

        jCheckBox48.setFont(font); // NOI18N
        jCheckBox48.setText("47");

        jCheckBox49.setFont(font); // NOI18N
        jCheckBox49.setText("48");

        jCheckBox50.setFont(font); // NOI18N
        jCheckBox50.setText("49");

        jCheckBox51.setFont(font); // NOI18N
        jCheckBox51.setText("50");

        jCheckBox52.setFont(font); // NOI18N
        jCheckBox52.setText("51");

        jCheckBox53.setFont(font); // NOI18N
        jCheckBox53.setText("52");

        jCheckBox54.setFont(font); // NOI18N
        jCheckBox54.setText("53");

        jCheckBox55.setFont(font); // NOI18N
        jCheckBox55.setText("54");

        jCheckBox56.setFont(font); // NOI18N
        jCheckBox56.setText("55");

        jCheckBox57.setFont(font); // NOI18N
        jCheckBox57.setText("56");

        jCheckBox58.setFont(font); // NOI18N
        jCheckBox58.setText("57");

        jCheckBox59.setFont(font); // NOI18N
        jCheckBox59.setText("58");

        jLabel1.setFont(font); // NOI18N
        jLabel1.setText("从");

        //jLabel2.setFont(font); // NOI18N
        //jLabel2.setText("从");

        jLabel3.setFont(font); // NOI18N
        jLabel3.setText("-");

        jLabel4.setFont(font); // NOI18N
        jLabel4.setText("秒内");

        jLabel5.setFont(font); // NOI18N
        jLabel5.setText("秒开始，每");

        jLabel6.setFont(font); // NOI18N
        jLabel6.setText("秒执行一次");

        jCheckBox60.setFont(font); // NOI18N
        jCheckBox60.setText("59");

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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                                        .addComponent(jCheckBox8))
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
                                        .addComponent(jLabel4)))
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
                                .addComponent(jCheckBox32)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox33)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox34)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox35)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox36)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox37)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox38)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox39)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox41)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox42)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox43)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox44)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox45)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox46)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox47)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox48)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox49)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox50)))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox51)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox52)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox53)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox54)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox55)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox56)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox57)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox58)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox59)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox60))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(jCheckBox1)
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
                    .addComponent(jCheckBox32)
                    .addComponent(jCheckBox33)
                    .addComponent(jCheckBox34)
                    .addComponent(jCheckBox35)
                    .addComponent(jCheckBox36)
                    .addComponent(jCheckBox37)
                    .addComponent(jCheckBox38)
                    .addComponent(jCheckBox39)
                    .addComponent(jCheckBox40))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox41)
                    .addComponent(jCheckBox42)
                    .addComponent(jCheckBox43)
                    .addComponent(jCheckBox44)
                    .addComponent(jCheckBox45)
                    .addComponent(jCheckBox46)
                    .addComponent(jCheckBox47)
                    .addComponent(jCheckBox48)
                    .addComponent(jCheckBox49)
                    .addComponent(jCheckBox50))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox51)
                    .addComponent(jCheckBox52)
                    .addComponent(jCheckBox53)
                    .addComponent(jCheckBox54)
                    .addComponent(jCheckBox55)
                    .addComponent(jCheckBox56)
                    .addComponent(jCheckBox57)
                    .addComponent(jCheckBox58)
                    .addComponent(jCheckBox59)
                    .addComponent(jCheckBox60))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        init();
	    SwingUtil.setFrameTitle(this);
    }// </editor-fold>//GEN-END:initComponents

	private void init() {
		if (seconCron.length() > 0) {
			if ("*".equals(seconCron)) {
				jRadioButton1.setSelected(true);
			}
			if (seconCron.contains("-")) {
				jRadioButton2.setSelected(true);
				String[] zq = seconCron.split("-");
				jTextField1.setText(zq[0]);
				if (zq.length >= 2) {
					jTextField2.setText(zq[1]);
				}
			}
			if (seconCron.contains("/")) {
				jRadioButton3.setSelected(true);
				String[] jg = seconCron.split("/");
				jTextField3.setText(jg[0]);
				if (jg.length >= 2) {
					jTextField4.setText(jg[1]);
				}
			}
			if (seconCron.contains(",")) {
				jRadioButton4.setSelected(true);
				String[] other = seconCron.split(",");
				for (int i = 0; i < other.length; i++) {
					SwingUtil.selectBox(this,other[i]);
				}
			}
			if (StringUtils.isNumeric(seconCron)){
				jRadioButton4.setSelected(true);
				SwingUtil.selectBox(this,seconCron);
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
    private JCheckBox jCheckBox1;
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
    private JCheckBox jCheckBox33;
    private JCheckBox jCheckBox34;
    private JCheckBox jCheckBox35;
    private JCheckBox jCheckBox36;
    private JCheckBox jCheckBox37;
    private JCheckBox jCheckBox38;
    private JCheckBox jCheckBox39;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox40;
    private JCheckBox jCheckBox41;
    private JCheckBox jCheckBox42;
    private JCheckBox jCheckBox43;
    private JCheckBox jCheckBox44;
    private JCheckBox jCheckBox45;
    private JCheckBox jCheckBox46;
    private JCheckBox jCheckBox47;
    private JCheckBox jCheckBox48;
    private JCheckBox jCheckBox49;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox50;
    private JCheckBox jCheckBox51;
    private JCheckBox jCheckBox52;
    private JCheckBox jCheckBox53;
    private JCheckBox jCheckBox54;
    private JCheckBox jCheckBox55;
    private JCheckBox jCheckBox56;
    private JCheckBox jCheckBox57;
    private JCheckBox jCheckBox58;
    private JCheckBox jCheckBox59;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox60;
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
