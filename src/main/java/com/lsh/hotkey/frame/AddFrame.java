package com.lsh.hotkey.frame;

import com.lsh.hotkey.entry.Hotkey;
import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.JsonUtil;
import com.lsh.hotkey.utils.SwingUtil;
import com.melloware.jintellitype.JIntellitype;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  
 * @author Administrator
 */
public class AddFrame extends JDialog {
	JOptionPane dialog = new JOptionPane();

	Hotkey hk = new Hotkey();
	private int id;
	private IndexFrame parentF;
	
	public AddFrame(IndexFrame parentF, boolean model) {
		super(parentF,model);
		Contains.window = this;
		this.parentF = parentF;
		initComponents();
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {

		buttonGroup1 = new ButtonGroup();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jTextField3 = new JTextField();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jComboBox1 = new JComboBox<>();
		jLabel6 = new JLabel();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jLabel5 = new JLabel();
		jRadioButton1 = new JRadioButton();
		jRadioButton2 = new JRadioButton();
		jButton3 = new JButton();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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

		jTextField3.setFont(new Font("宋体", 0, 16)); // NOI18N

		jLabel1.setFont(new Font("宋体", 1, 16)); // NOI18N
		jLabel1.setText("热键");

		jLabel2.setFont(new Font("宋体", 1, 16)); // NOI18N
		jLabel2.setText("内容");

		jLabel3.setFont(new Font("宋体", 1, 16)); // NOI18N
		jLabel3.setText("注释");

		jLabel4.setText("CTRL + SHIFT +");

		jComboBox1.setFont(new Font("宋体", 0, 14)); // NOI18N
		String[] keys = new String[]{"F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12"};
		jComboBox1.setModel(new DefaultComboBoxModel<>(keys));

		jLabel6.setFont(new Font("宋体", 1, 14)); // NOI18N
		jLabel6.setForeground(Color.red);
		jLabel6.setText("*");

		jTextArea1.setColumns(20);
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel5.setFont(new Font("宋体", 1, 14)); // NOI18N
		jLabel5.setText("加密");

		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setSelected(true);
		jRadioButton1.setText("是");

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setText("否");

		jButton3.setText("说明");
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(jLabel1)
																		.addComponent(jLabel5))
																.addGap(18, 18, 18))
														.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGap(24, 24, 24)
																.addComponent(jLabel4)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addGap(22, 22, 22)
																.addComponent(jRadioButton1)
																.addGap(18, 18, 18)
																.addComponent(jRadioButton2)))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
										.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addComponent(jLabel3)
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jButton1)
																.addGap(62, 62, 62)
																.addComponent(jButton2))
														.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE))
												.addGap(6, 6, 6)))
								.addComponent(jLabel6)
								.addGap(18, 18, 18)
								.addComponent(jButton3)
								.addContainerGap(35, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(17, 17, 17)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5)
										.addComponent(jRadioButton1)
										.addComponent(jRadioButton2))
								.addGap(9, 9, 9)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addGap(38, 38, 38)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(jButton3)))
										.addGroup(layout.createSequentialGroup()
												.addGap(41, 41, 41)
												.addComponent(jLabel2)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3)
										.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(27, 27, 27)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jButton1)
										.addComponent(jButton2))
								.addContainerGap(41, Short.MAX_VALUE))
		);

		pack();
		open2();
	}                      

	private void clearJfield() {
		jComboBox1.setSelectedIndex(0);
		jRadioButton1.setSelected(true);
		jTextArea1.setText("");
		jTextField3.setText("");
	}
	// 新增或修改
	private void jButton1ActionPerformed(ActionEvent evt) {
		String key = jComboBox1.getSelectedItem().toString();
		String action = jTextArea1.getText().trim();
		String updateM = "";
		int result = 0;
		Contains.window = dialog;
		Contains.parentWindow = this;
		if (!StringUtils.isBlank(action)) {
			int encrypt = 1;
			if (jRadioButton1.isSelected()) {
				encrypt = 0;
				action = Contains.textEncode(action);
			}
			Hotkey hotkey = new Hotkey();
			hotkey.setHotkey(key);
			hotkey.setKaction(action);
			hotkey.setExplain(jTextField3.getText());
			hotkey.setEncrypt(encrypt);
			if ( Contains.AUSTATE == 1) {
				//result = SqlUtil.saveHotkey(hotkey);
				int size = 0;
				if (Contains.HOTKEYS != null) {
					size = Contains.HOTKEYS.size();
				}
				hotkey.setKId(size);
				Contains.HOTKEYS.add(hotkey);
				boolean b = JsonUtil.objectToJson(Contains.HOTKEYS,Contains.HOTKEYROOT,Contains.JSONFILENAME);
				if (b) {
					registerRe(size,key);
					updateM = "新增成功~";
					parentF.initTable();
				}
			} else {
				hotkey.setKId(id);
				Contains.HOTKEYS.remove(id);
				Contains.HOTKEYS.add(hotkey);
				boolean b = JsonUtil.objectToJson(Contains.HOTKEYS,Contains.HOTKEYROOT,Contains.JSONFILENAME);
				if (b) {
					JIntellitype.getInstance().unregisterHotKey(id);
					registerRe(id,key);
					updateM = "修改成功~";
					parentF.initTable();
				}
			}
		} else {
				updateM +="内容不能为空~";
		}
		if (result == -2) {
			updateM += key+"已经被占用~";
		}
		if (result == -3) {
			updateM +="系统错误~";
		}
		dialog.showMessageDialog(this,updateM);
	}

	/**
	 * 重新注册
	 * @param key
	 */
	private void registerRe(int id,String key) {
		/*Map map = new HashMap();
		map.put("hotkey = ","'"+key+"'");
		Hotkey o = (Hotkey) SqlUtil.setlectAll(map).get(0);
		JIntellitype.getInstance().registerHotKey(o.getKId(), JIntellitype.MOD_CONTROL+JIntellitype.MOD_SHIFT, o.getKeycode());*/
		JIntellitype.getInstance().registerHotKey(id, JIntellitype.MOD_CONTROL+JIntellitype.MOD_SHIFT, Contains.keycode(key));
	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		String message = "Tab键用 ~ 代替\nEnter键用 = 代替\n";
		Contains.window = dialog;
		Contains.parentWindow = this;
		dialog.showMessageDialog(this,message);
	}

	/*private void flushTable() {
		// 刷新表格内容
		SwingUtil.initTable(parentF.getjTable1(),Contains.COMPLETEH,SwingUtil.getTableData(Contains.HOTKEYS));
		dispose();
	}*/
	
	// 设置内容
	private void initFrame() {
		if (Contains.AUSTATE == 1) {
			//clearJfield();
			hk = null;
			this.setTitle("新增");
		} else {
			this.setTitle("编辑");
		}
		
		hk = parentF.getHk();
		if (hk != null) {
			id = hk.getKId();
			jComboBox1.setSelectedItem(hk.getHotkey());
			Integer encrypt = hk.getEncrypt();
			String kaction = hk.getKaction();
			if (encrypt == 0) {
				jRadioButton1.setSelected(true);
				kaction = Contains.textDecode(kaction);
			} else {
				jRadioButton2.setSelected(true);
			}
			jTextArea1.setText(kaction);
			jTextField3.setText(hk.getExplain());
		}
	}
	
	// 显示窗口
	public void open2() {
		initFrame();

		SwingUtil.setFrameTitle(this);
	}

	private ButtonGroup buttonGroup1;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JTextField jTextField3;
	// End of variables declaration                   
}