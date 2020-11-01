package com.lsh.hotkey.frame;

import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.SwingUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class WeekFrame extends JDialog {
	String[] weeks = new String[] { "日", "一", "二", "三", "四", "五", "六" };
	private String weekCron = "";
	private JTextField textField;

	public WeekFrame(TaskFrame parent, boolean modal) {
		super(parent, modal);
		Contains.window = this;
		textField = parent.getjTextField2();
		weekCron = textField.getText().trim();
		initComponents();
	}

	private Font font = new Font("宋体", 1, 14);

	@SuppressWarnings("unchecked")
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jRadioButton1 = new javax.swing.JRadioButton();
		jCheckBox2 = new javax.swing.JCheckBox();
		jCheckBox3 = new javax.swing.JCheckBox();
		jCheckBox4 = new javax.swing.JCheckBox();
		jCheckBox5 = new javax.swing.JCheckBox();
		jCheckBox6 = new javax.swing.JCheckBox();
		jCheckBox7 = new javax.swing.JCheckBox();
		jCheckBox8 = new javax.swing.JCheckBox();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jComboBox1 = new javax.swing.JComboBox<>();
		jComboBox2 = new javax.swing.JComboBox<>();
		jComboBox3 = new javax.swing.JComboBox<>();
		jComboBox4 = new javax.swing.JComboBox<>();
		jRadioButton2 = new javax.swing.JRadioButton();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		jRadioButton5 = new javax.swing.JRadioButton();
		jRadioButton6 = new javax.swing.JRadioButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("每周");

		jCheckBox2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox2.setText("日");

		jCheckBox3.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox3.setText("一");

		jCheckBox4.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox4.setText("二");

		jCheckBox5.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox5.setText("三");

		jCheckBox6.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox6.setText("四");

		jCheckBox7.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox7.setText("五");

		jCheckBox8.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jCheckBox8.setText("六");

		jLabel1.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jLabel1.setText("从星期");

		jLabel3.setText("-");

		jLabel4.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jLabel4.setText("内");

		jLabel5.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jLabel5.setText("周的星期");

		jButton1.setText("确定");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("取消");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(weeks));

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(weeks));

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(weeks));

		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(weeks));

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jRadioButton2.setText("不指定");

		buttonGroup1.add(jRadioButton3);
		jRadioButton3.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jRadioButton3.setText("周期");

		buttonGroup1.add(jRadioButton4);
		jRadioButton4.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jRadioButton4.setText("第");

		buttonGroup1.add(jRadioButton5);
		jRadioButton5.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jRadioButton5.setText("本月最后一个星期");

		buttonGroup1.add(jRadioButton6);
		jRadioButton6.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
		jRadioButton6.setText("指定");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(59, 59, 59)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jRadioButton2)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jRadioButton4)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel5)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jRadioButton1))
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(jButton1)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jCheckBox2)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jCheckBox3)))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jCheckBox4)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jCheckBox5)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(jButton2)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jCheckBox6)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jCheckBox7)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(jCheckBox8))))
														.addComponent(jRadioButton6)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jRadioButton5)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jRadioButton3)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel1)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel4)))
												.addGap(0, 98, Short.MAX_VALUE))))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(46, 46, 46)
								.addComponent(jRadioButton1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jRadioButton2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jLabel4)
										.addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3)
										.addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jRadioButton3))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5)
										.addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jRadioButton4))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jRadioButton5)
										.addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jRadioButton6)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jCheckBox2)
										.addComponent(jCheckBox3)
										.addComponent(jCheckBox4)
										.addComponent(jCheckBox5)
										.addComponent(jCheckBox6)
										.addComponent(jCheckBox7)
										.addComponent(jCheckBox8))
								.addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton1)
										.addComponent(jButton2))
								.addContainerGap(31, Short.MAX_VALUE))
		);

		init();
		pack();
		SwingUtil.setFrameTitle(this);
	}// </editor-fold>                        

	private void jButton1ActionPerformed(ActionEvent evt) {
		if (jRadioButton1.isSelected()) {
			textField.setText("*");
		} else if (jRadioButton2.isSelected()) {
			textField.setText("?");
		} else if (jRadioButton3.isSelected()) {
			String text1 = (String) jComboBox1.getSelectedItem();
			text1 = getweekCro(text1) + "";
			String text2 = (String) jComboBox2.getSelectedItem();
			text2 = getweekCro(text2) + "";
			textField.setText(text1 + "-" + text2);
		} else if (jRadioButton4.isSelected()) {
			String text1 = jTextField3.getText();
			String text2 = (String) jComboBox3.getSelectedItem();
			text2 = getweekCro(text2) + "";
			textField.setText(text1 + "#" + text2);
		} else if (jRadioButton5.isSelected()) {
			String text = (String) jComboBox4.getSelectedItem();
			text = getweekCro(text) + "";
			textField.setText(text + "L");
		} else {
			String text = SwingUtil.getSelectBox(this);
			text = text.replaceAll("日","1").replaceAll("一","2").replaceAll("二","3")
					.replaceAll("三","4").replaceAll("四","5").replaceAll("五","6")
					.replaceAll("六","7");
			textField.setText(text);
		}
		this.dispose();
	}

	private void init() {
		if (weekCron.length() > 0) {
			if ("*".equals(weekCron)) {
				jRadioButton1.setSelected(true);
			} 
			if ("?".equals(weekCron)){
				jRadioButton2.setSelected(true);
			} 
			if (weekCron.contains("-")) {
				jRadioButton3.setSelected(true);
				String[] zq = weekCron.split("-");
				jComboBox1.setSelectedItem(getweekCro2(zq[0]));
				if (zq.length >= 2) {
					jComboBox2.setSelectedItem(getweekCro2(zq[1]));
				}
			} 
			if (weekCron.contains("#")) {
				jRadioButton4.setSelected(true);
				String[] jg = weekCron.split("#");
				jTextField3.setText(jg[0]);
				if (jg.length >= 2) {
					jComboBox3.setSelectedItem(getweekCro2(jg[1]));
				}
			} 
			if (weekCron.contains("L")) {
				jRadioButton5.setSelected(true);
				String[] last = weekCron.split("L");
				if (last.length >= 1) {
					jComboBox4.setSelectedItem(getweekCro2(last[0]));
				}
			} 
			if (weekCron.contains(",")) {
				jRadioButton6.setSelected(true);
				String[] other = weekCron.split(",");
				for (int i = 0; i < other.length; i++) {
					selectBox(this,other[i]);
				}
			} 
			if (StringUtils.isNumeric(weekCron)){
				jRadioButton6.setSelected(true);
				selectBox(this,weekCron);
			}
		} else {
			jRadioButton1.setSelected(true);
		}
	}

	private void selectBox(Container ct,String str) {
		int cron = Integer.valueOf(str);
		List<JCheckBox> allJCheckBox = SwingUtil.getAllJCheckBox(ct, null);
		for (JCheckBox jCheckBox : allJCheckBox) {
			int num = getweekCro(jCheckBox.getText());
			if (num == cron) {
				jCheckBox.setSelected(true);
				break;
			}
		}
	}
	
	private int getweekCro(String str) {
		int num = 0;
		switch (str) {
			case "日" :
				num = 1;
				break;
			case "一" :
				num = 2;
				break;
			case "二" :
				num = 3;
				break;
			case "三" :
				num = 4;
				break;
			case "四" :
				num = 5;
				break;
			case "五" :
				num = 6;
				break;
			case "六" :
				num = 7;
				break;
		}
		return num;
	}
	private String getweekCro2(String str) {
		String num = "";
		switch (str) {
			case "1" :
				num = "日";
				break;
			case "2" :
				num = "一";
				break;
			case "3" :
				num = "二";
				break;
			case "4" :
				num = "三";
				break;
			case "5" :
				num = "四";
				break;
			case "6" :
				num = "五";
				break;
			case "7" :
				num = "六";
				break;
		}
		return num;
	}

	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JCheckBox jCheckBox3;
	private javax.swing.JCheckBox jCheckBox4;
	private javax.swing.JCheckBox jCheckBox5;
	private javax.swing.JCheckBox jCheckBox6;
	private javax.swing.JCheckBox jCheckBox7;
	private javax.swing.JCheckBox jCheckBox8;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;
	private javax.swing.JComboBox<String> jComboBox3;
	private javax.swing.JComboBox<String> jComboBox4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JRadioButton jRadioButton5;
	private javax.swing.JRadioButton jRadioButton6;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration                   
}
