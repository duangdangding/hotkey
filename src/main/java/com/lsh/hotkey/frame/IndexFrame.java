package com.lsh.hotkey.frame;

import com.lsh.hotkey.entry.ExcelData;
import com.lsh.hotkey.entry.Hotkey;
import com.lsh.hotkey.entry.TaskEntry;
import com.lsh.hotkey.utils.*;
import com.melloware.jintellitype.JIntellitype;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class IndexFrame extends JFrame implements KeyListener {
	public static WaitFrame wait;

	private boolean isMW = true;
	private Hotkey hk = new Hotkey();
	private TaskEntry taskEntry = new TaskEntry();

	public Hotkey getHk() {
		return hk;
	}
	public void setHk(Hotkey hk) {
		this.hk = hk;
	}
	public JTable getjTable1() {
		return jTable1;
	}
	public void setjTable1(JTable jTable1) {
		this.jTable1 = jTable1;
	}

	public TaskEntry getTaskEntry() {
		return taskEntry;
	}

	public void setTaskEntry(TaskEntry taskEntry) {
		this.taskEntry = taskEntry;
	}

	public JTable getjTable2() {
		return jTable2;
	}

	public void setjTable2(JTable jTable2) {
		this.jTable2 = jTable2;
	}

	/**
	 * Creates new form IndexFrame
	 */
	public IndexFrame() {
		initComponents();
		this.setTimer(jLabel2);
		initHotT();
		Contains.window = this;
	}

	//设置Timer 1000ms实现一次动作 实际是一个线程   
	private void setTimer(JLabel time){
		final JLabel varTime = time;
		Timer timeAction = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();
				//转换日期显示格式   
				SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 EEEE hh:mm:ss");
				varTime.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
	}
	private static final int MIN_PROGRESS = 0;
	private static final int MAX_PROGRESS = 100;

	private static int currentProgress = MIN_PROGRESS;
	private void initComponents() {
		jTabbedPane1 = new JTabbedPane();
		//jButton7 = new JButton();
		/*jButton7.setText("定时任务");
		jButton7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});*/

		// 补全
		completePanel();
		// 小工具
		toolkit();
		// 菜单
		//menu();
		// 定时任务
		taskPanel();
		// 底部时间
		bottomTimer();
		// 居中
		pack();
	}

	// 定时任务
	private void taskPanel() {
		jPanel3 = new JPanel();
		jScrollPane2 = new JScrollPane();
		jTable2 = new JTable();
		jPanel5 = new JPanel();
		jButton10 = new JButton();
		jButton11 = new JButton();
		jButton13 = new JButton();
		jButton14 = new JButton();
		jButton15 = new JButton();
		jButton16 = new JButton();
		jButton12 = new JButton();

		// 初始化表格数据
		SwingUtil.tableCenter(jTable2,Contains.TASKH,SwingUtil.getTableData(Contains.TASKS));
		//SwingUtil.tableCenter(jTable2);
		jScrollPane2.setViewportView(jTable2);

		jButton10.setText("新增");
		jButton10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});

		jButton11.setText("删除");
		jButton11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});

		jButton13.setText("全选");
		jButton13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});

		jButton14.setText("编辑");
		jButton14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});

		jButton15.setText("备份");
		jButton15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});

		jButton16.setText("导入");
		jButton16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton16ActionPerformed(evt);
			}
		});

		jButton12.setText("执行任务");
		jButton12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});

		GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addComponent(jButton10)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton11)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton14)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton13)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton15)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton16)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton12)
								.addGap(0, 0, Short.MAX_VALUE))
		);
		jPanel5Layout.setVerticalGroup(
				jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jButton10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//								.addComponent(jButton11, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton12, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 858, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
		);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
								.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
		);
		jTabbedPane1.addTab("定时任务", jPanel3);
	}

	//菜单
	private void menu() {
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenu2 = new JMenu();
		jMenu3 = new JMenu();

		jMenuBar1.setPreferredSize(new Dimension(109, 30));

		jMenu1.setText("File");
		jMenu1.setFont(Contains.F_YH_0_14);
		jMenu1.setMinimumSize(new Dimension(27, 25));
		jMenu1.setPreferredSize(new Dimension(27, 25));
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenu2.setFont(Contains.F_YH_0_14);
		jMenuBar1.add(jMenu2);

		jMenu3.setText("jMenu3");
		jMenu3.setFont(Contains.F_YH_0_14);
		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);
	}

	// 底部时间显示
	private void bottomTimer() {
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel1.setText("当前时间：");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
						.addComponent(jTabbedPane1, GroupLayout.Alignment.TRAILING)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
	}

	//小工具
	private void toolkit() {
		jPanel2 = new JPanel();
		jButton6 = new JButton("定时关机");
		jButton7 = new JButton("文件查重");
		jButton17 = new JButton("重命名文件");
		jButton18 = new JButton("视频转GIF");

		jButton6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton17.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton17ActionPerformed(evt);
			}
		});
		jButton18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton18ActionPerformed(evt);
			}
		});
		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);

		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGap(21, 21, 21)
								.addComponent(jButton6)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton7)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton17)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton18)
								.addContainerGap(570, Short.MAX_VALUE))
		);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jButton6)
										.addComponent(jButton7)
										.addComponent(jButton17)
										.addComponent(jButton18))
								.addContainerGap(525, Short.MAX_VALUE))
		);

		jTabbedPane1.addTab("小工具", jPanel2);
	}

	// 补全panel
	private void completePanel() {
		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jPanel4 = new JPanel();
		jButton1 = new JButton("新增");
		jButton2 = new JButton("删除");
		jButton3 = new JButton("明文");
		jButton4 = new JButton("全选");
		jButton5 = new JButton("编辑");
		jButton8 = new JButton("备份");
		jButton9 = new JButton("导入");
		SwingUtil.tableCenter(jTable1,Contains.COMPLETEH,null);
		jScrollPane1.setViewportView(jTable1);

		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		jButton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jButton8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jButton9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup()
								.addComponent(jButton1)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton5)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton4)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton3)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton8)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton9)
								.addGap(0, 0, Short.MAX_VALUE))
		);
		jPanel4Layout.setVerticalGroup(
				jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 858, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
		);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
		);
		jTabbedPane1.addTab("补全操作", jPanel1);
	}
	// 新增
	private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		this.setHk(null);
		Contains.AUSTATE = 1;
		AddFrame addFrame = new AddFrame(this, true);
	}
	// 解除绑定热键
	private void removeKey(int id) {
		JIntellitype.getInstance().unregisterHotKey(id);
		Contains.HOTKEYS.remove(id);
	}
	// 删除
	private void jButton2ActionPerformed(ActionEvent evt) {
		String message = "";
		int [] selectRows = jTable1.getSelectedRows();  //获得所有被选中的索引
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (selectRows.length > 0) {
			int valuex=Contains.DIALOG.showConfirmDialog(this,"确认删除选中吗？", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (valuex == JOptionPane.YES_OPTION) {
				for (int selectRow : selectRows) {
					//int id = Integer.valueOf((String) jTable1.getValueAt(selectRow, 0));
					removeKey(selectRow);
				}
				boolean b = JsonUtil.objectToJson(Contains.HOTKEYS,Contains.HOTKEYROOT,Contains.JSONFILENAME);
				if (b) {
					initHotT();
					message = "删除成功~";
				} else {
					message = "系统错误~";
				}
				Contains.DIALOG.showMessageDialog(this,message);
			}
		} else {
			message = "请先选择需要删除的行~";
			Contains.DIALOG.showMessageDialog(this,message);
		}
	}
	// 明文
	private void jButton3ActionPerformed(ActionEvent evt) {
		isMW = !isMW;
		String text = jButton3.getText();
		initHotT();
		if ("明文".equals(text)) {
			jButton3.setText("密文");
		} else {
			jButton3.setText("明文");
		}
	}
	// 全选
	private void jButton4ActionPerformed(ActionEvent evt) {
		String text = jButton4.getText();
		if ("全选".equals(text)) {
			jButton4.setText("取消全选");
			jTable1.selectAll();    //选中所有的行
		} else {
			jButton4.setText("全选");
			jTable1.clearSelection();  //取消选择
		}
	}
	// 编辑
	private void jButton5ActionPerformed(ActionEvent evt) {
		//获得所有被选中的索引
		int [] selectRows = jTable1.getSelectedRows();
		int length = selectRows.length;
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (length > 0) {
			if (length == 1) {
				int selectRow = selectRows[0];
				int id = Integer.valueOf((String) jTable1.getValueAt(selectRow, 0)).intValue();
				Hotkey hotkey = Contains.HOTKEYS.get(id);
				this.setHk(hotkey);
				Contains.AUSTATE = 2;
				AddFrame addFrame = new AddFrame(this, true);
			} else {
				Contains.DIALOG.showMessageDialog(this,"只能选择一个进行修改~");
			}
		} else {
			Contains.DIALOG.showMessageDialog(this,"先选择需要编辑的行(单选)~");
		}
	}

	//定时关机
	private void jButton6ActionPerformed(ActionEvent evt) {
		new ShutdownFrame(this, true);
	}

	//文件查重
	private void jButton7ActionPerformed(ActionEvent evt) {
		Contains.POOL.execute(new Runnable() {
			@Override
			public void run() {
				// 进度条显示之前父窗口不可用
				new DocumentDuplicationCheck(new IndexFrame(),true);
			}
		});
		wait = new WaitFrame(new IndexFrame(),true);
		wait.showBar();
	}
	// 文件重命名
	private void jButton17ActionPerformed(ActionEvent evt) {
		new RenameFrame(new IndexFrame(),true);
	}
	// 视频转GIF
	private void jButton18ActionPerformed(ActionEvent evt) {
		new VideoToGif(this,true);
	}

	// 备份
	private void jButton8ActionPerformed(ActionEvent evt) {
		int i = SwingUtil.openDir();
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (i == 1) {
			return ;
		} else {
			String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
			ExcelData data =new ExcelData();
			data.setList(Contains.HOTKEYS);
			data.setHeaders(Contains.COMPLETEH);
			data.setSheetName(Contains.YMDHMS.format(new Date()));
			String msg = "";
			try {
				PoiUtil.createExccel(absolutePath,data);
				msg = "备份成功~";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "备份失败！";
			}
			Contains.DIALOG.showMessageDialog(this,msg);
		}
	}

	// 导入
	private void jButton9ActionPerformed(ActionEvent evt) {
		int i = SwingUtil.openFile("excel");
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (i == 1) {
			return ;
		} else {
			int option = Contains.DIALOG.showConfirmDialog(null, "要删除现在的热键吗？", "导入提示", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION){
				for (int i1 = 0; i1 < Contains.HOTKEYS.size(); i1++) {
					removeKey(Contains.HOTKEYS.get(i1).getKId());
				}
				Contains.HOTKEYS = new ArrayList<>();
			}
			String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
			String msg = "";
			try {
				List<Hotkey> hotkeys = PoiUtil.parseExcel(absolutePath, Hotkey.class,Contains.HOTKEYS.size());
				Contains.HOTKEYS.addAll(hotkeys);
				boolean b = JsonUtil.objectToJson(Contains.HOTKEYS,Contains.HOTKEYROOT,Contains.JSONFILENAME);
				if (b) {
					isMW = false;
					initHotT();
					msg = "导入成功~";
				} else {
					msg = "系统错误~";
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg = "导入失败！";
			}
			Contains.DIALOG.showMessageDialog(this,msg);
		}
	}
	// 定时任务 新增
	private void jButton10ActionPerformed(ActionEvent evt) {
		this.setTaskEntry(null);
		Contains.TASKSTATE = 1;
		new TaskFrame(this, true);

	}
	// 定时任务 删除
	private void jButton11ActionPerformed(ActionEvent evt) {
		String message = "";
		int [] selectRows = jTable2.getSelectedRows();  //获得所有被选中的索引
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (selectRows.length > 0) {
			int valuex=Contains.DIALOG.showConfirmDialog(this,"确认删除选中吗？", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (valuex == JOptionPane.YES_OPTION) {
				for (int selectRow : selectRows) {
					//int id = Integer.valueOf((String) jTable1.getValueAt(selectRow, 0));
					//int id = (Integer) jTable2.getValueAt(selectRow, 0);
					String tName = (String) jTable2.getValueAt(selectRow, 6);
					Contains.TASKS.remove(selectRow);
					JobUtil.deleteJob(tName);
				}
				boolean b = JsonUtil.objectToJson(Contains.TASKS,Contains.HOTKEYROOT,Contains.TASKFILE);
				if (b) {
					initTaskT();
					message = "删除成功~";
				} else {
					message = "系统错误~";
				}
				Contains.DIALOG.showMessageDialog(this,message);
			}
		} else {
			message = "请先选择需要删除的行~";
			Contains.DIALOG.showMessageDialog(this,message);
		}
	}
	// 定时任务 全选
	private void jButton13ActionPerformed(ActionEvent evt) {
		String text = jButton13.getText();
		if ("全选".equals(text)) {
			jButton13.setText("取消全选");
			jTable2.selectAll();    //选中所有的行
		} else {
			jButton13.setText("全选");
			jTable2.clearSelection();  //取消选择
		}
	}
	// 定时任务 编辑
	private void jButton14ActionPerformed(ActionEvent evt) {
		//获得所有被选中的索引
		int [] selectRows = jTable2.getSelectedRows();
		int length = selectRows.length;
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (length > 0) {
			if (length == 1) {
				int selectRow = selectRows[0];
				Integer id = (Integer) jTable2.getValueAt(selectRow, 0);
				for (TaskEntry task : Contains.TASKS) {
					if (id.equals(task.getTaskId())) {
						this.setTaskEntry(task);
						break;
					}
				}
				Contains.TASKSTATE = 2;
				new TaskFrame(this, true);
			} else {
				Contains.DIALOG.showMessageDialog(this,"只能选择一个进行修改~");
			}
		} else {
			Contains.DIALOG.showMessageDialog(this,"先选择需要编辑的行(单选)~");
		}
	}
	// 定时任务 备份
	private void jButton15ActionPerformed(ActionEvent evt) {
		int i = SwingUtil.openDir();
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (i == 1) {
			return ;
		} else {
			String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
			ExcelData data =new ExcelData();
			data.setList(Contains.TASKS);
			data.setHeaders(Contains.TASKH);
			data.setSheetName(Contains.YMDHMS.format(new Date()));
			String msg = "";
			try {
				PoiUtil.createExccel(absolutePath,data);
				msg = "备份成功~";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "备份失败！";
			}
			Contains.DIALOG.showMessageDialog(this,msg);
		}
	}
	// 定时任务 导入
	private void jButton16ActionPerformed(ActionEvent evt) {
		int i = SwingUtil.openFile("excel");
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (i == 1) {
			return ;
		} else {
			int option = Contains.DIALOG.showConfirmDialog(null, "要删除现在的任务吗？", "导入提示", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION){
				for (int i1 = 0; i1 < Contains.TASKS.size(); i1++) {
					String taskName = Contains.TASKS.get(i1).getTaskName();
					boolean existJobKey = JobUtil.isExistJobKey(taskName);
					if (existJobKey) {
						JobUtil.deleteJob(taskName);
					}
					Contains.TASKS.remove(i1);
				}
				Contains.TASKS = new ArrayList<>();
			}
			String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
			String msg = "";
			try {
				List<TaskEntry> taskEntries = PoiUtil.parseExcel(absolutePath, TaskEntry.class,Contains.TASKS.size());
				Contains.TASKS.addAll(taskEntries);
				boolean b = JsonUtil.objectToJson(Contains.TASKS,Contains.HOTKEYROOT,Contains.TASKFILE);
				if (b) {
					isMW = false;
					initTaskT();
					msg = "导入成功~";
				} else {
					msg = "系统错误~";
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg = "导入失败！";
			}
			Contains.DIALOG.showMessageDialog(this,msg);
		}
	}
	// 执行任务
	private void jButton12ActionPerformed(ActionEvent evt) {
		String message = "";
		int [] selectRows = jTable2.getSelectedRows();  //获得所有被选中的索引
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (selectRows.length > 0) {
			for (int selectRow : selectRows) {
				String tName = (String) jTable2.getValueAt(selectRow, 6);
				if (JobUtil.isExistJobKey(tName)) {
					message = "任务已经启动了哦~";
				} else {
					String tn = "";
					for (int i = 0; i < Contains.TASKS.size(); i++) {
						TaskEntry taskEntry1 = Contains.TASKS.get(i);
						if (tName.equals(taskEntry1.getTaskName())) {
							JobUtil.bingTask(taskEntry1);
							tn += tName + "，";
							break;
						}
					}
					message = tName+"任务启动成功~";
				}
			}
			Contains.DIALOG.showMessageDialog(this,message);
		} else {
			message = "请先选择需要执行任务的行~";
			Contains.DIALOG.showMessageDialog(this,message);
		}
	}

	private void initTaskT() {
		SwingUtil.setValueTable(jTable2,Contains.TASKS,Contains.TASKH);
	}
	public void initHotT() {
		SwingUtil.setValueTable(jTable1,Contains.HOTKEYS,Contains.COMPLETEH);
	}

	public void open() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				IndexFrame win = new IndexFrame();
				String title = "自动补全系统 "+Contains.props.getProperty("version")+" 作者：卢少";
				win.setTitle(title);
				//win.setTitle("自动补全系统  作者：卢少 QQ:2538808545");
				//win.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				//String path = ClassUtils.getDefaultClassLoader().getResource("imgs/logn.png").getPath();
				ImageIcon icon=new ImageIcon(JsonUtil.toData("imgs/logn.png"),"");
				win.setIconImage(icon.getImage());
				win.setResizable(false);
				//SwingUtil.setFrameTitle(this,title,"imgs/logn.png");
				Integer runtime = (Integer) Contains.CONFIG.get("runtime");
				if (runtime >= 2) {
					miniTray(win);
				} else {
					win.setVisible(true);
				}

				//居中
				win.setLocationRelativeTo(null);
			}
		});
//		获取焦点
		this.setFocusable(true);
	}

	static SystemTray tray = SystemTray.getSystemTray();
	private static TrayIcon trayIcon = null;

	//窗口最小化到任务栏托盘
	private static void miniTray(JFrame mf) {
		ImageIcon trayImg=new ImageIcon(JsonUtil.toData("imgs/logn.png"),"");
		PopupMenu pop = new PopupMenu();  //增加托盘右击菜单
		MenuItem show = new MenuItem("还原");
		MenuItem exit = new MenuItem("exit");

		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 按下还原键
				//tray.remove(trayIcon);
				mf.setVisible(true);
				//mf.setExtendedState(JFrame.NORMAL);
				//mf.toFront();
			}//actionPerformed
		});//addActionListener

		exit.addActionListener(new ActionListener() { // 按下退出键
			@Override
			public void actionPerformed(ActionEvent e) {
				tray.remove(trayIcon);
				System.exit(0);
			}//actionPerformed

		});//addActionListener

		pop.add(show);
		pop.add(exit);

		trayIcon = new TrayIcon(trayImg.getImage(), "自动补全系统", pop);
		trayIcon.setImageAutoSize(true);
		trayIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 鼠标器双击事件
				if (e.getClickCount() == 2) {
					//tray.remove(trayIcon); // 移去托盘图标
					mf.setVisible(true);
					mf.setExtendedState(JFrame.NORMAL); // 还原窗口
					mf.toFront();
				}//if
			}//mouseClicked
		});//addMouseListener

		try {
			tray.add(trayIcon);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}

	}

	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private JButton jButton7;
	private JButton jButton8;
	private JButton jButton9;
	private JButton jButton10;
	private JButton jButton11;
	private JButton jButton12;
	private JButton jButton13;
	private JButton jButton14;
	private JButton jButton15;
	private JButton jButton16;
	private JButton jButton17;
	private JButton jButton18;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTabbedPane jTabbedPane1;
	private JTable jTable1;
	private JTable jTable2;


	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("anxai");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("taiqi");
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
