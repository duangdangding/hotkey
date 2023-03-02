package com.lsh.hotkey.frame;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.lsh.hotkey.entry.TaskEntry;
import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.JobUtil;
import com.lsh.hotkey.utils.JsonUtil;
import com.lsh.hotkey.utils.SwingUtil;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TaskFrame extends JDialog {

	private TaskEntry taskEntry = new TaskEntry();
	private TaskEntry save = new TaskEntry();
	private IndexFrame parentF;
	private DefaultListModel listModel = new DefaultListModel();
	private int execIndex;
	private int state = Contains.TASKSTATE;
	private List<String> files = new ArrayList<>();

	public JTextField getjTextField2() {
		return jTextField2;
	}

	public void setjTextField2(JTextField jTextField2) {
		this.jTextField2 = jTextField2;
	}

	public JTextField getjTextField3() {
		return jTextField3;
	}

	public void setjTextField3(JTextField jTextField3) {
		this.jTextField3 = jTextField3;
	}

	public JTextField getjTextField4() {
		return jTextField4;
	}

	public void setjTextField4(JTextField jTextField4) {
		this.jTextField4 = jTextField4;
	}

	public JTextField getjTextField5() {
		return jTextField5;
	}

	public void setjTextField5(JTextField jTextField5) {
		this.jTextField5 = jTextField5;
	}

	public JTextField getjTextField6() {
		return jTextField6;
	}

	public void setjTextField6(JTextField jTextField6) {
		this.jTextField6 = jTextField6;
	}

	public JTextField getjTextField7() {
		return jTextField7;
	}

	public void setjTextField7(JTextField jTextField7) {
		this.jTextField7 = jTextField7;
	}

	public TaskFrame(IndexFrame parent, boolean modal) {
        super(parent, modal);
		Contains.window = this;
	    this.parentF = parent;
	    taskEntry = parentF.getTaskEntry();
        initComponents();
    }


	@SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jLabel3 = new JLabel("周");
        jLabel4 = new JLabel("月");
        jLabel5 = new JLabel("日");
        jLabel6 = new JLabel("时");
        jLabel7 = new JLabel("分");
        jLabel8 = new JLabel("秒");
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
	    jButton5 = new JButton("选择");
	    jButton6 = new JButton("选择");
	    jButton7 = new JButton("选择");
	    jButton8 = new JButton("选择");
	    jButton9 = new JButton("选择");
	    jButton10 = new JButton("选择");
        jRadioButton1 = new JRadioButton("提示消息");
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jRadioButton2 = new JRadioButton("打开程序");
	    jList1 = new JList<>();
        jScrollPane2 = new JScrollPane();
        jButton1 = new JButton("选择程序");
        jButton2 = new JButton("移除程序");
        jButton3 = new JButton("保存任务");
        jButton4 = new JButton("执行任务");
        jScrollPane3 = new JScrollPane();
        jLabel2 = new JLabel();
	    jLabel9 = new JLabel("任务名称");
	    jTextField1 = new JTextField();
		jRadioButton3 = new JRadioButton("执行CMD命令");
		jTextField8 = new JTextField();

        jLabel3.setFont(Contains.F_S_1_18);
        jLabel4.setFont(Contains.F_S_1_18);
        jLabel5.setFont(Contains.F_S_1_18);
        jLabel6.setFont(Contains.F_S_1_18);
        jLabel7.setFont(Contains.F_S_1_18);
        jLabel8.setFont(Contains.F_S_1_18);

        jTextField4.setMinimumSize(new Dimension(6, 24));

	    jButton5.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
			    jButton5ActionPerformed(evt);
		    }
	    });
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
	    jButton10.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent evt) {
			    jButton10ActionPerformed(evt);
		    }
	    });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
		        selectItem(e);
	        }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButton2);
	    jRadioButton2.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
			    selectItem(e);
		    }
	    });

	    jList1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
			    execIndex = jList1.getSelectedIndex();
		    }
	    });
        jScrollPane2.setViewportView(jList1);

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

        jLabel2.setFont(Contains.F_S_0_14);
	    jLabel2.setText("<html> <body  style=\"overflow-y: scroll;word-wrap: break-word;word-break: break-all;overflow-x: hidden\"> 秒:可出现\", - * /\"四个字符，有效范围为0-59的整数 <br> 分:可出现\", - * /\"四个字符，有效范围为0-59的整数 <br> 时:可出现\", - * /\"四个字符，有效范围为0-23的整数 <br> 日:可出现\", - * / ? L W C\"八个字符，有效范围为0-31的整数 <br> 月:可出现\", - * /\"四个字符，有效范围为1-12的整数或JAN-DEc <br> 周:可出现\", - * / ? L C #\"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，<br>2表示星期一， 依次类推<br> <br> (1)*：表示匹配该域的任意值，假如在分域使用*, 即表示每分钟都会触发事件。<br> (2)?:只能用在日和周两个域。它也匹配域的任意值，但实际不会。因为日和周会相互影响。<br> 例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, <br> 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。<br> (3)-:表示范围，例如在分域使用5-20，表示从5分到20分钟每分钟触发一次<br> (4)/：表示起始时间开始触发，然后每隔固定时间触发一次，例如在分域使用5/20,<br>则意味着5分钟触发一次，而25，45等分别触发一次.<br> (5),:表示列出枚举值值。例如：在分域使用5,20，则意味着在5和20分每分钟触发一次。<br> (6)L:表示最后，只能出现在周和日域，如果在周域使用5L,<br>意味着在最后的一个星期四触发。<br> (7)W:表示有效工作日(周一到周五),只能出现在日域，系统将在离指定日期的最近的有效工作日触发事件。<br> 例如：在 日使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，<br> 则在6日(周一)触发；如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份<br> (8)LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。<br> (9)#:用于确定每个月第几个星期几，只能出现在日域。例如在4#2，表示某月的第二个星期三。<br> <br> <!--举几个例子:--> <!--0 0 2 1 * ? * 表示在每月的1日的凌晨2点调度任务--> <!--0 15 10 ? * MON-FRI 表示周一到周五每天上午10：15执行作业--> <!--0 15 10 ? 6L 2002-2006 表示2002-2006年的每个月的最后一个星期五上午10:15执行作-->  一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。<br> 秒（0~59）<br> 分钟（0~59）<br> 小时（0~23）<br> 天（月）（0~31，但是你需要考虑你月的天数）<br> 月（0~11）<br> 天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）<br> <br> 其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),<br> 通配符。由于\"月份中的日期\"和\"星期中的日期\"这两个元素互斥的,必须要对其中一个设置?<br> <br> <!--0 0 10,14,16 * * ? 每天上午10点，下午2点，4点--> <!--0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时--> <!--0 0 12 ? * WED 表示每个星期三中午12点--> <!--\"0 0 12 * * ?\" 每天中午12点触发--> <!--\"0 15 10 ? * *\" 每天上午10:15触发--> <!--\"0 15 10 * * ?\" 每天上午10:15触发--> <!--\"0 15 10 * * ? *\" 每天上午10:15触发--> <!--\"0 15 10 * * ? 2005\" 2005年的每天上午10:15触发--> <!--\"0 * 14 * * ?\" 在每天下午2点到下午2:59期间的每1分钟触发--> <!--\"0 0/5 14 * * ?\" 在每天下午2点到下午2:55期间的每5分钟触发--> <!--\"0 0/5 14,18 * * ?\" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发--> <!--\"0 0-5 14 * * ?\" 在每天下午2点到下午2:05期间的每1分钟触发--> <!--\"0 10,44 14 ? 3 WED\" 每年三月的星期三的下午2:10和2:44触发--> <!--\"0 15 10 ? * MON-FRI\" 周一至周五的上午10:15触发--> <!--\"0 15 10 15 * ?\" 每月15日上午10:15触发--> <!--\"0 15 10 L * ?\" 每月最后一日的上午10:15触发--> <!--\"0 15 10 ? * 6L\" 每月的最后一个星期五上午10:15触发--> <!--\"0 15 10 ? * 6L 2002-2005\" 2002年至2005年的每月的最后一个星期五上午10:15触发--> <!--\"0 15 10 ? * 6#3\" 每月的第三个星期五上午10:15触发-->  有些子表达式能包含一些范围或列表<br> 例如：子表达式（天（星期））可以为 “MON-FRI”，“MON，WED，FRI”，“MON-WED,SAT”<br> “*”字符代表所有可能的值<br> 因此，“*”在子表达式（月）里表示每个月的含义，“*”在子表达式（天（星期））表示星期的每一天<br> “/”字符用来指定数值的增量<br> 例如：在子表达式（分钟）里的“0/15”表示从第0分钟开始，每15分钟<br> 在子表达式（分钟）里的“3/20”表示从第3分钟开始，每20分钟（它和“3，23，43”）的含义一样<br> “？”字符仅被用于天（月）和天（星期）两个子表达式，表示不指定值<br> 当2个子表达式其中之一被指定了值以后，为了避免冲突，需要将另一个子表达式的值设为“？”<br> “L” 字符仅被用于天（月）和天（星期）两个子表达式，它是单词“last”的缩写<br> 但是它在两个子表达式里的含义是不同的。<br> 在天（月）子表达式中，“L”表示一个月的最后一天<br> 在天（星期）自表达式中，“L”表示一个星期的最后一天，也就是SAT<br> 如果在“L”前有具体的内容，它就具有其他的含义了<br> 例如：“6L”表示这个月的倒数第６天，“FRIL”表示这个月的最一个星期五<br> 注意：在使用“L”参数时，不要指定列表或范围，因为这会导致问题<br> 字段 允许值 允许的特殊字符<br> 秒 0-59 , - * /<br> 分 0-59 , - * /<br> 小时 0-23 , - * /<br> 日期 1-31 , - * ? / L W C<br> 月份 1-12 或者 JAN-DEC , - * /<br> 星期 1-7 或者 SUN-SAT , - * ? / L C #<br> </body> </html>");
	    jScrollPane3.setViewportView(jLabel2);

		buttonGroup1.add(jRadioButton3);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(32, 32, 32)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3)
														.addComponent(jLabel6))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jButton8)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel7))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jButton5)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel4)))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGap(3, 3, 3)
																.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(jButton9)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jLabel8)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jButton10)
																.addGap(22, 22, 22))
														.addGroup(layout.createSequentialGroup()
																.addGap(4, 4, 4)
																.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jButton6)
																.addGap(4, 4, 4)
																.addComponent(jLabel5)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jButton7)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGap(119, 119, 119)
																.addComponent(jButton3))
														.addGroup(layout.createSequentialGroup()
																.addGap(34, 34, 34)
																.addComponent(jLabel9)
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(28, 28, 28)
												.addComponent(jRadioButton1)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGap(24, 24, 24)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jRadioButton3)
																.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																		.addComponent(jButton4)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jRadioButton2)
																				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
																.addGap(18, 18, 18)
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(jButton1)
																		.addComponent(jButton2))))))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(40, 40, 40)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel3)
														.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton6)
														.addComponent(jLabel4)
														.addComponent(jButton5)
														.addComponent(jButton7))
												.addGap(22, 22, 22)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(jLabel7)
														.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8)
														.addComponent(jButton8)
														.addComponent(jButton10)
														.addComponent(jButton9)
														.addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGap(10, 10, 10)
																.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addGap(57, 57, 57)
																.addComponent(jRadioButton1)))
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addGap(45, 45, 45)
																				.addComponent(jButton1))
																		.addGroup(layout.createSequentialGroup()
																				.addGap(52, 52, 52)
																				.addComponent(jRadioButton2)))
																.addGap(30, 30, 30)
																.addComponent(jButton2))
														.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jRadioButton3)
														.addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(25, 25, 25)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(46, 46, 46)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jButton3)
														.addComponent(jButton4)))
										.addGroup(layout.createSequentialGroup()
												.addGap(4, 4, 4)
												.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 682, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	    
        pack();
	    open2();
    }
    // 单选按钮组事件
    private void selectItem(ItemEvent e) {
	    Object source = e.getSource();
	    if (source == jRadioButton1 || source == jRadioButton3) {
		    jButton1.setEnabled(false);
		    jButton2.setEnabled(false);
	    } else {
		    jButton1.setEnabled(true);
		    jButton2.setEnabled(true);
	    }
    }
    
	// 设置内容
	String title = "";
	private void initFrame() {
		jButton4.setEnabled(false);
		if (state == 1) {
			//this.setTitle("新增");
			title = "新增";
			jButton1.setEnabled(false);
			jButton2.setEnabled(false);
			taskEntry = null;
		} else {
			title = "编辑";
			//this.setTitle("编辑");
		}

		if(taskEntry != null) {
			String[] s = taskEntry.getCronExpre().split(" ");
			jTextField2.setText(s[5]);
			jTextField3.setText(s[4]);
			jTextField4.setText(s[3]);
			jTextField5.setText(s[2]);
			jTextField6.setText(s[1]);
			jTextField7.setText(s[0]);
			jTextField1.setText(taskEntry.getTaskName());
			Integer execType = taskEntry.getExecType();
			if (execType == 1) {
				jRadioButton1.setSelected(true);
				jTextArea1.setText(taskEntry.getMessage());
			}
			if (execType == 2) {
				jRadioButton2.setSelected(true);
				String[] execs = taskEntry.getExecs();
				if (execs != null && execs.length > 0) {
					for (int i = 0; i < execs.length; i++) {
						String exec = execs[i];
						listModel.addElement(exec);
						files.add(exec);
					}
				}
			}
			if (execType == 3) {
				jRadioButton3.setSelected(true);
				jTextField8.setText(taskEntry.getCmd());
			}
		}
		jList1.setModel(listModel);
	}
    
    // 显示窗口
	private void open2() {
		initFrame();
		
		SwingUtil.setFrameTitle(this,title);
	}

	private void jButton5ActionPerformed(ActionEvent evt) {
		new WeekFrame(this,true);
	}

	private void jButton6ActionPerformed(ActionEvent evt) {
		new MonthFrame(this,true);
	}

	private void jButton7ActionPerformed(ActionEvent evt) {
    	new DayFrame(this,true);
	}

	private void jButton8ActionPerformed(ActionEvent evt) {
		new HoursFrame(this,true);
	}

	private void jButton9ActionPerformed(ActionEvent evt) {
		new MinuteFrame(this,true);
	}

	private void jButton10ActionPerformed(ActionEvent evt) {
		new SecondFrome(this,true);
	}
	// 选择程序
	private void jButton1ActionPerformed(ActionEvent evt) {
		int i = SwingUtil.openFile("");
		if (i == 1) {
			return ;
		} else {
			String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
			//System.out.println(absolutePath);
			absolutePath = absolutePath.replaceAll("\\\\","\\\\\\\\");
			listModel.addElement(absolutePath);
			files.add(absolutePath);
			//String msg = "";
		}
	}
	// 移除程序
	private void jButton2ActionPerformed(ActionEvent evt) {
		listModel.removeElementAt(execIndex);
		files.remove(execIndex);
	}
	// 保存任务
	private void jButton3ActionPerformed(ActionEvent evt) {
		String weekend = jTextField2.getText();
		weekend = Contains.completeTrime(weekend);
		String month = jTextField3.getText();
		month = Contains.completeTrime(month);
		String day = jTextField4.getText();
		day = Contains.completeTrime(day);
		String hours = jTextField5.getText();
		hours = Contains.completeTrime(hours);
		String minute = jTextField6.getText();
		minute = Contains.completeTrime(minute);
		String second = jTextField7.getText();
		second = Contains.completeTrime(second);
		String taskName = jTextField1.getText();
		String space = " ";
		String cron = second + space + minute + space + hours + space + day + space + month + space + weekend;
		save.setCronExpre(cron);
		boolean b = CronExpression.isValidExpression(cron);
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (!b) {
			JOptionPane.showMessageDialog(this,"任务不符合规则~");
			return;
		}
		int type ;
		String comment;
		if (jRadioButton1.isSelected()) {
			type = 1;
			String text = jTextArea1.getText();
			if (StrUtil.isBlank(text)) {
				JOptionPane.showMessageDialog(this,"消息不能为空~");
				return ;
			}
			save.setMessage(text);
			comment = "提示消息";
		} else if(jRadioButton2.isSelected()){
			type = 2;
			if (files.size() == 0) {
				JOptionPane.showMessageDialog(this,"程序列表不能为空~");
				return ;
			}
			save.setExecs(files.toArray(new String[files.size()]));
			comment = "打开程序";
		} else {
			type = 3;
			comment = "执行CMD命令";
			String cmd = jTextField8.getText().trim();
			if (cmd.length() == 0) {
				JOptionPane.showMessageDialog(this,"CMD命令不能为空~");
				return ;
			}
			save.setCmd(cmd);
		}
		if (StrUtil.isNotBlank(taskName)) {
			save.setTaskName(taskName);
		} else {
			JOptionPane.showMessageDialog(this,"任务名称不能为空~");
		}
		save.setExecType(type);
		// save.setComment(comment);
		String msg ="";
		boolean b1 = false;
		if (state == 2) {
			Integer taskId = taskEntry.getTaskId();
			for (int i = 0; i < Contains.TASKS.size(); i++) {
				int id = Contains.TASKS.get(i).getTaskId();
				if(id == taskId) {
					try {
						Contains.TASKS.remove(id);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(this,"任务修改失败，taskId要从0开始！请修改task.json文件~\n修改之后，关闭程序，重新打开程序~");
					}
				}
			}
			save.setTaskId(taskId);
			Contains.TASKS.add(save);
			boolean bsuc = JsonUtil.objectToJson(Contains.TASKS,Contains.HOTKEYROOT,Contains.TASKFILE);
			if (bsuc) {
				boolean existJobKey = JobUtil.isExistJobKey(taskName);
				if (existJobKey) {
					JobUtil.deleteJob(taskName);
				}
				initTaskT();
				b1 = true;
				msg = "修改成功~";
			}
		} else {
			// 任务中 和 任务列表中不存在此任务名 才可添加成功
			boolean existJobKey = JobUtil.isExistJobKey(taskName);
			boolean exsitName = false;
			if (CollUtil.isNotEmpty(Contains.TASKS)) {
				for (TaskEntry task : Contains.TASKS) {
					if (taskName.equals(task.getTaskName())) {
						exsitName = true;
						break;
					}
				}
			}
			if (!existJobKey && !exsitName) {
				save.setTaskId(Contains.TASKS.size());
				Contains.TASKS.add(save);
				boolean bsuc = JsonUtil.objectToJson(Contains.TASKS,Contains.HOTKEYROOT,Contains.TASKFILE);
				if (bsuc) {
					b1 = true;
					initTaskT();
					msg = "新增成功~";
				}
			} else {
				msg = "任务名字已经存在，需要换一个哦~";
			}
		}
		jButton4.setEnabled(b1);
		Contains.DIALOG.showMessageDialog(this,msg);
	}
	// 执行任务
	private void jButton4ActionPerformed(ActionEvent evt) {
		String taskName = save.getTaskName();
		boolean b = JobUtil.isExistJobKey(taskName);
		Contains.window = Contains.DIALOG;
		Contains.parentWindow = this;
		if (b) {
			JobUtil.deleteJob(save.getTaskName());
		}
		boolean run = JobUtil.bingTask(save);
		if (run) {
			Contains.DIALOG.showMessageDialog(this,"任务执行成功~");
			SwingUtil.closeWindow(Contains.window);
			SwingUtil.closeWindow(Contains.parentWindow);
		} else {
			Contains.DIALOG.showMessageDialog(this,"任务执行失败，请删除并结束所有的任务，之后重新添加！");
		}
	}

    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
	private JLabel jLabel9;
    private JList<String> jList1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
	private JTextField jTextField8;
	private JButton jButton6;
	private JButton jButton7;
	private JButton jButton8;
	private JButton jButton9;
	private JButton jButton10;

	private void initTaskT() {
		SwingUtil.setValueTable(parentF.getjTable2(),Contains.TASKS,Contains.TASKH);
	}
}
