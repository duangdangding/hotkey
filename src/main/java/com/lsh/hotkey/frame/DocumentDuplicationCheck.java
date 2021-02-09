package com.lsh.hotkey.frame;

import com.alibaba.fastjson.JSON;
import com.lsh.hotkey.entry.FilePojo;
import com.lsh.hotkey.thread.SerachThread;
import com.lsh.hotkey.utils.*;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Administrator
 */
public class DocumentDuplicationCheck extends JDialog {
	private JedisUtil jedisUtil = new JedisUtil();
	private JOptionPane dialog = new JOptionPane();
	private static CountDownLatch latch;
	private List<FilePojo> filePojos = new ArrayList<>();
	private Properties properties = new Properties();
	String fileListStr = "";
	public static volatile WaitFrame wait;
	private List<FilePojo> resultClumns = null;
	private Map<String,List<FilePojo>> resultMap = null;
	private HashMap<String,List<FilePojo>> cacheMap = new HashMap<>();

	public JTextField getExclude() {
		return exclude;
	}

	public JTextField getClude() {
		return clude;
	}

	public DocumentDuplicationCheck(){}
	public DocumentDuplicationCheck(IndexFrame parent, boolean modal) {
		super(parent, modal);
		Contains.window = this;
		properties = FileUtil.readProp(Contains.SETPROP);
		// 使用redis获取缓存
		try{
			String fileIndexs = jedisUtil.get("fileIndexs").toString();
			Contains.FILES = JsonUtil.jsonToList(fileIndexs, FilePojo.class);

			initComponents();
			initFileTa(Contains.FILES);
		} catch (Exception e) {
			dialog.showMessageDialog(this,e.getMessage());
		} finally {
			// 缓存获取之后,数据填充之后关闭进度条
			parent.wait.closeBar();
		}

		if (properties != null) {
			clude.setText(properties.get("cludeStr").toString());
			exclude.setText(properties.get("excludeStr").toString());
		}
		SwingUtil.setFrameTitle(this,"文件查重和搜索");
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		buttonGroup1 = new ButtonGroup();
		buttonGroup2 = new ButtonGroup();
		buttonGroup3 = new ButtonGroup();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		exclude = new JTextField(20);
		clude = new JTextField(20);
		jLabel10 = new JLabel();
		jLabel11 = new JLabel();
		jTextField3 = new JTextField();
		jTextField4 = new JTextField();
		k = new JRadioButton("K");
		m = new JRadioButton("M");
		g = new JRadioButton("G");
		sizeJcb = new JCheckBox("匹配大小");
		nameJcb = new JCheckBox("匹配文件名");
		makeDown = new JButton("建立索引");
		startSerch = new JButton("开始检索");
		stayJcb = new JCheckBox("保留");
		newDatejrd = new JRadioButton("日期最新");
		oldDatejrd = new JRadioButton("日期最旧");
		delBtn = new JButton("删除");
		select1 = new JButton("选择");
		select2 = new JButton("选择");
		jLabel8 = new JLabel();
		resultMsg = new JLabel();
		fileNamejrd = new JRadioButton("文件名");
		fileTypejrd = new JRadioButton("文件类型");
		contentJrd = new JRadioButton("文本内容");
		jTextField5 = new JTextField();
		serchBtn = new JButton("开始查询");
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jLabel1 = new JLabel();
//		expreJrd = new JRadioButton("使用*号");

		jLabel2.setFont(Contains.F_S_1_14);
		jLabel2.setText("文件排除");
		jLabel3.setFont(Contains.F_S_1_14);
		jLabel3.setText("查询范围");
		jLabel4.setFont(Contains.F_S_1_14);
		jLabel4.setText("大小限制");
		jLabel5.setFont(Contains.F_S_1_14);
		jLabel5.setText("重复条件");

		jLabel6.setForeground(new Color(255, 0, 0));
		jLabel6.setText("<html><body>*建立索引：根据查询范围和文件排除组合产生<br>*开始检索：建立索引之后开始检索</body></html>");

		jLabel10.setText("大于");
		jLabel11.setText("小于");

		buttonGroup1.add(k);
		buttonGroup1.add(m);
		m.setSelected(true);
		buttonGroup1.add(g);

		nameJcb.setSelected(true);

		buttonGroup2.add(newDatejrd);
		newDatejrd.setSelected(true);
		buttonGroup2.add(oldDatejrd);

		jLabel8.setForeground(new Color(255, 0, 0));
		jLabel8.setText("*可手动选择，可复制粘贴，用英文:(分号)隔开");

		//resultMsg.setText("索引未建立。。。");

		buttonGroup3.add(fileNamejrd);
		fileNamejrd.setSelected(true);
		buttonGroup3.add(fileTypejrd);
		buttonGroup3.add(contentJrd);
//		buttonGroup3.add(expreJrd);

		select1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				select1ActionPerformed(evt);
			}
		});
		select2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				select2ActionPerformed(evt);
			}
		});
		makeDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnActionPerformed(evt);
			}
		});
		startSerch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnActionPerformed(evt);
			}
		});
		delBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnActionPerformed(evt);
			}
		});
		serchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnActionPerformed(evt);
			}
		});

		SwingUtil.tableCenter(jTable1,Contains.SERCHFILEHEADER,null);
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rightMenu(e);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jLabel1.setForeground(new Color(255, 0, 0));
		jLabel1.setText("<html><body>*文件名：通过文件名模糊查询路径<br>*文件类型： 如txt<br>*文本内容：先查询文件路径是否包含，" +
				"再查询文本文件是否包含内容<br> 文本文件类型有：xml,txt,doc,docx,ppt,pptx,xls,xlsx,pdf<br>" +
				"多个可以用英文,(逗号隔开)</body></html>      ");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		this.setPreferredSize(new Dimension(1169,850));

		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(27, 27, 27)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jLabel3)
																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(clude))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jLabel2)
																				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(exclude, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																		.addComponent(select1)
																		.addComponent(select2)))
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(makeDown)
																		.addGap(27, 27, 27)
																		.addComponent(startSerch))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabel5)
																		.addGap(18, 18, 18)
																		.addComponent(sizeJcb)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(nameJcb)))
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																.addComponent(jLabel8)
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
																				.addGroup(layout.createSequentialGroup()
																						.addComponent(jLabel4)
																						.addGap(18, 18, 18)
																						.addComponent(jLabel10)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(jLabel11)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(k)
																						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(m))
																				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																						.addGroup(layout.createSequentialGroup()
																								.addGap(2, 2, 2)
																								.addComponent(stayJcb)
																								.addGap(18, 18, 18)
																								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																										.addGroup(layout.createSequentialGroup()
																												.addComponent(delBtn)
																												.addGap(0, 0, Short.MAX_VALUE))
																										.addGroup(layout.createSequentialGroup()
																												.addComponent(newDatejrd)
																												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																												.addComponent(oldDatejrd))))))
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(g)))
														.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(resultMsg, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
												.addContainerGap())
										.addGroup(layout.createSequentialGroup()
												.addComponent(fileNamejrd)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(fileTypejrd)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(contentJrd)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
//												.addComponent(expreJrd)
//												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jTextField5)
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(serchBtn)
												.addGap(32, 32, 32))))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(60, 60, 60)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel2)
										.addComponent(exclude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(select1))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel3)
										.addComponent(clude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(select2))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel8)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4)
										.addComponent(jLabel10)
										.addComponent(jLabel11)
										.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(k)
										.addComponent(m)
										.addComponent(g))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5)
										.addComponent(sizeJcb)
										.addComponent(nameJcb))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(makeDown)
										.addComponent(startSerch))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(41, 41, 41)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(stayJcb)
										.addComponent(newDatejrd)
										.addComponent(oldDatejrd))
								.addGap(33, 33, 33)
								.addComponent(delBtn)
								.addGap(19, 19, 19)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
								.addComponent(resultMsg, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addGap(174, 174, 174))
						.addGroup(layout.createSequentialGroup()
								.addGap(11, 11, 11)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(fileNamejrd)
										.addComponent(fileTypejrd)
										.addComponent(contentJrd)
										.addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(serchBtn)
//										.addComponent(expreJrd)
								)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1)
								.addContainerGap())
		);

		pack();
	}

	/**
	 * 文件排除
	 * @param event
	 */
	private void select1ActionPerformed(ActionEvent event) {
		String excludeStr = exclude.getText();
		this.fileListStr = excludeStr;
		Contains.AUSTATE = 1;
		new FileList(this,true);
	}

	/**
	 * 查找范围
	 * @param event
	 */
	private void select2ActionPerformed(ActionEvent event) {
		String cludeStr = clude.getText();
		this.fileListStr = cludeStr;
		Contains.AUSTATE = 2;
		new FileList(this,true);
	}
	private void btnActionPerformed(ActionEvent evt) {
		Contains.window = dialog;
		Contains.parentWindow = this;
		String excludeStr = exclude.getText().trim();
		String cludeStr = clude.getText().trim();
		String btnStr = evt.getActionCommand();

		//建立索引
		if ("建立索引".equals(btnStr) || Contains.FILES.isEmpty()) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					createFileIndex(cludeStr,excludeStr);
					initFileTa(Contains.FILES);
					wait.closeBar();
				}
			});
			thread.start();
			wait = new WaitFrame(new DocumentDuplicationCheck(),true);
			wait.showBar();
			return;
		}

		// 开始检索
		List<FilePojo> resultPojos ; //缓存列表
		if("开始检索".equals(btnStr)) {
			Map<String,List<FilePojo>> maps = new HashMap<>();
			resultMap = new HashMap<>();
			resultPojos = new ArrayList<>();
			String gt = jTextField3.getText().trim();
			String lt = jTextField4.getText().trim();
			if (!(gt.isEmpty() && lt.isEmpty())) {
				long gti = 0;
				long lti = 0;
				try {
					if (!StringUtils.isEmpty(gt)) {
						gti = Integer.valueOf(gt);
					}
					if (!StringUtils.isEmpty(lt)) {
						lti = Integer.valueOf(lt);
					}
				} catch (NumberFormatException numberFormatException) {
					dialog.showMessageDialog(this,"大小限制请输入数字！");
					return;
				}
				String unit = "";
				Enumeration<AbstractButton> elements = buttonGroup1.getElements();
				while (elements.hasMoreElements()) {
					AbstractButton abstractButton = elements.nextElement();
					if (abstractButton.isSelected()) {
						unit = abstractButton.getText();
						break;
					}
				}

				// 单位转换
				switch (unit) {
					case "K" :
						gti = gti*1024;
						lti = lti*1024;
						break;
					case "M" :
						gti = gti*1024*1024;
						lti = lti*1024*1024;
						break;
					case "G" :
						gti = gti*1024*1024*1024;
						lti = lti*1024*1024*1024;
						break;
				}
//				先根据大小筛选一遍
				for (FilePojo file : Contains.FILES) {
					if (file != null ) {
						Long size = file.getFileSize();
						if (gti < lti) {
							if (size > gti && size < lti) {
								resultPojos.add(file);
							}
						} else {
							if (size > gti || size < lti) {
								resultPojos.add(file);
							}
						}
					}
				}
			} else {
				resultPojos = Contains.FILES;
			}

			boolean jcb1 = sizeJcb.isSelected();
			if (jcb1) {
				// 进行分组排序
				for (FilePojo file : resultPojos) {
					Contains.groupFile(file,file.getFileSize()+"",maps);
				}
				//	去除 value的长度为1
				Contains.disLenOne(maps);
				resultMap.putAll(maps);
			}

			// 默认文件名重复
			boolean jcb2 = nameJcb.isSelected();
			if(jcb2) {
				// 先大小重复再按照文件名重复查询
				if (jcb1) {
//					复制对象
					cacheMap.clear();
					cacheMap.putAll(resultMap);
//					清空内容
					resultMap = new HashMap<>();
					Iterator<Map.Entry<String, List<FilePojo>>> it = cacheMap.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<String, List<FilePojo>> next = it.next();
						List<FilePojo> value = next.getValue();
						Map<String, List<FilePojo>> stringListMap = repeatFileName(value);
						resultMap.putAll(stringListMap);
					}
				} else {
					// 只按照文件名重复查询
					Map<String, List<FilePojo>> stringListMap = repeatFileName(resultPojos);
					resultMap.putAll(stringListMap);
				}
			}
			resultClumns = new ArrayList<>();
			Iterator<Map.Entry<String, List<FilePojo>>> it = resultMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, List<FilePojo>> next = it.next();
				List<FilePojo> value = next.getValue();
				for (FilePojo s : value) {
					resultClumns.add(s);
				}
			}
			initFileTa(resultClumns);
			return;
		}

		// 删除
		if("删除".equals(btnStr)) {
			// 有结果才删除
			//				要删除的List 文件名
			List<String> deleteList = new ArrayList<>();
			if(resultClumns != null && !resultClumns.isEmpty()) {
				cacheMap.clear();
				cacheMap.putAll(resultMap);
				if (stayJcb.isSelected()) {
					boolean old = oldDatejrd.isSelected();
					Iterator<Map.Entry<String, List<FilePojo>>> iterator = cacheMap.entrySet().iterator();
					while (iterator.hasNext()) {
						List<FilePojo> value = iterator.next().getValue();
						// 排序 顺序
						Collections.sort(value, new Comparator<FilePojo>() {
							@Override
							public int compare(FilePojo o1, FilePojo o2) {
								Long size1 = Contains.getCtime(o1.getCreateTime());
								Long size2 = Contains.getCtime(o2.getCreateTime());
								return (int) (size1 - size2);
							}
						});
						int size = value.size();
						if (old) {
							getDelList(value,size,deleteList,1);
						} else {
							getDelList(value,size-1,deleteList,0);
						}
					}
				}
			}// 选择文件列表进行删除
			else {
				int[] selectedRows = jTable1.getSelectedRows();
				if (selectedRows.length > 0) {
					for (int i = 0; i < selectedRows.length; i++) {
						String path = jTable1.getValueAt(selectedRows[i], 0).toString();
						deleteList.add(path);
					}
				}
			}
//				开始删除文件
			deleteFileAndCol(deleteList);
			return;
		}

		//文件查询
		if("开始查询".equals(btnStr)) {
			boolean fnSelect = fileNamejrd.isSelected();
			boolean ftSelect = fileTypejrd.isSelected();
			boolean conSelect = contentJrd.isSelected();
//			boolean expreSelect = expreJrd.isSelected();
			String content = jTextField5.getText().trim();
			if (StringUtils.isEmpty(content)) {
				dialog.showMessageDialog(this,"请输入要查询的内容！");
				return;
			}
			List<FilePojo> lists = new ArrayList<>();
			//文件名
			if (fnSelect) {
				String[] split = content.toUpperCase().split(",");
//				数组转set
//				Set<String> types = Arrays.stream(split).collect(Collectors.toSet());
				for (FilePojo pojo : Contains.FILES) {
					String filePath = pojo.getFilePath().toUpperCase();
					for (int i = 0; i < split.length; i++) {
						String s = split[i];
						if (filePath.contains(s)) {
							lists.add(pojo);
							break;
						}
					}
					
				}
			}
			// 文件类型
			else if (ftSelect) {
				String[] split = content.toUpperCase().split(",");
//				数组转set
				Set<String> types = Arrays.stream(split).collect(Collectors.toSet());
				for (FilePojo pojo : Contains.FILES) {
					String type = pojo.getFileType().toUpperCase();
					if (types.contains(type)) {
						lists.add(pojo);
					}
				}
			}
			// 文本内容
			else if (conSelect) {
//				首先把文本文档查询出来
				String[] split = content.toUpperCase().split(",");
				for (FilePojo pojo : Contains.FILES) {
					String filePath = pojo.getFilePath().toUpperCase();
					for (int i = 0; i < split.length; i++) {
						String s = split[i];
						if (filePath.contains(s)) {
							lists.add(pojo);
							break;
						}
					}
				}
			}
			//正则表达式
			/*else {
				Pattern compile = Pattern.compile(content);
				for (FilePojo pojo : Contains.FILES) {
					String filePath = pojo.getFilePath();
					boolean matches = Pattern.matches(content, filePath);
					if (matches) {
						lists.add(pojo);
					}
				}
			}*/
			initFileTa(lists);
			resultMsg.setText(Contains.SLABLE + "文件个数：" + lists.size() + Contains.ELABLE);
			return;
		}
	}

	/**
	 * 删除文件并重新加载table
	 * @param deleteList
	 */
	private void deleteFileAndCol(List<String> deleteList) {
		if (!deleteList.isEmpty()) {
			int size = deleteList.size();
			int valuex = dialog.showConfirmDialog(this,"确认删除选中文件" + size + "个", "请确认",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (valuex == JOptionPane.YES_OPTION) {
				for (int j = 0; j < size; j++) {
					String path = deleteList.get(j);
					for (int i = resultClumns.size() - 1; i >= 0; i--) {
						String filePath = resultClumns.get(i).getFilePath();
						if (path.equals(filePath)) {
							Contains.exeCMD("del " + path);
							resultClumns.remove(i);
							break;
						}
					}
				}
				initFileTa(resultClumns);
			} else {
				return;
			}
		}
	}

	/**
	 * 获取要删除的文件路径
	 * @param value
	 * @param end 到哪个位置结束
	 * @param result
	 * @param start 从第几个开始
	 */
	private void getDelList(List<FilePojo> value,int end,List<String> result,int start) {
		for (int i = start; i < end; i++) {
			String filePath = value.get(i).getFilePath();
			result.add(filePath);
		}
	}

	/**
	 * 给Jtable加右键菜单
	 * @param event
	 */
	private void rightMenu(MouseEvent event){
		if (event.getButton() == 3) {
			jpm = new JPopupMenu();
			this.add(jpm);
			item1 = new JMenuItem("复制所选文件名");
			item2 = new JMenuItem("复制所选文件路径");
			item3 = new JMenuItem("删除所选文件");
			jpm.add(item1);
			jpm.add(item2);
			jpm.add(item3);
			jpm.show(jTable1, event.getX(),event.getY());
			item1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					menuClick(e);
				}
			});
			item2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					menuClick(e);
				}
			});
			item3.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					menuClick(e);
				}
			});
		}
	}

	/**
	 * 文件列表右键菜单事件
	 * @param event
	 */
	private void menuClick(MouseEvent event) {
		jpm.setVisible(false);
		Object source = event.getSource();
		int[] selectedRows = jTable1.getSelectedRows();
		StringBuffer paths = new StringBuffer();
		StringBuffer names = new StringBuffer();
		jTable1.clearSelection();
		for (int i = 0; i < selectedRows.length; i++) {
			String path = jTable1.getValueAt(selectedRows[i], 0).toString();
			paths.append(path).append(",");
			String name = jTable1.getValueAt(selectedRows[i], 1).toString();
			names.append(name).append(",");
			jTable1.addRowSelectionInterval(selectedRows[i],selectedRows[i]);
		}

		// 文件名
		if (source.equals(item1)) {
			SwingUtil.setClipboard(names.toString());
		}
		// 文件路径
		else if (source.equals(item2)) {
			SwingUtil.setClipboard(paths.toString());
		}
		// 删除文件
		else {
			String[] pathss = paths.toString().split(",");
			if (pathss.length > 0){
				deleteFileAndCol(Arrays.asList(pathss));
			}
		}
	}

	private JPopupMenu jpm;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	private ButtonGroup buttonGroup1;
	private ButtonGroup buttonGroup2;
	private ButtonGroup buttonGroup3;
	private JButton makeDown;
	private JButton startSerch;
	private JButton delBtn;
	private JButton select1;
	private JButton select2;
	private JButton serchBtn;
	private JCheckBox sizeJcb;
	private JCheckBox nameJcb;
	private JCheckBox stayJcb;
	private JLabel jLabel1;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel8;
	private JLabel resultMsg;
	private JRadioButton k;
	private JRadioButton m;
	private JRadioButton g;
	private JRadioButton newDatejrd;
	private JRadioButton oldDatejrd;
	private JRadioButton fileNamejrd;
	private JRadioButton fileTypejrd;
	private JRadioButton contentJrd;
//	private JRadioButton expreJrd;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JTextField exclude;
	private JTextField clude;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JTextField jTextField5;

	private void initFileTa(List<FilePojo> files) {
		SwingUtil.setValueTable(jTable1,files,Contains.SERCHFILEHEADER);
	}

	/**
	 * 建立索引
	 * @param cludeStr
	 * @param excludeStr
	 */
	private void createFileIndex(String cludeStr,String excludeStr) {
		long start = System.currentTimeMillis();
		resultMsg.setText("开始建立索引。。。。");
		File[] roots = {};
		Contains.FILES = new ArrayList<>();
		// 如果要搜索的文件夹为空，获取所有的硬盘分区
		if (!StringUtils.isEmpty(cludeStr)) {
			String[] ss = cludeStr.split(";");
			Set<String> paths = Arrays.stream(ss).collect(Collectors.toSet());
			roots = new File[paths.size()];
			Iterator<String> iterator = paths.iterator();
			int index = 0;
			while (iterator.hasNext()) {
				File file = new File(iterator.next());
				if (file.exists()) {
					roots[index] = file;
					index++;
				}
			}
		} else {
			roots = File.listRoots();
		}
		if (roots.length == 0) {
			dialog.showMessageDialog(this,"没有可以查询的文件夹！如果查询全盘可以不填写！");
			return;
		}

		// 使用多线程
		int length = roots.length;
		if (length > 0) {
			latch = new CountDownLatch(length);
			for (int i = 0; i < length; i++) {
				Contains.POOL.execute(new SerachThread(roots[i],latch));
			}
			try {
				// 结束线程池
				latch.await();
			} catch (InterruptedException ee) {
				ee.printStackTrace();
			}
			// 排除文件夹, 先查询出全部的文件，再排除
			if (!StringUtils.isEmpty(excludeStr)) {
				String[] split = excludeStr.split(";");
				if (split.length > 0) {
					Iterator<String> execs = Arrays.stream(split).collect(Collectors.toSet()).iterator();
					while (execs.hasNext()) {
						String exec = execs.next().toUpperCase();
						for (int i = Contains.FILES.size() - 1; i >= 0; i--) {
							String filePath = Contains.FILES.get(i).getFilePath().toUpperCase();
							if (filePath.indexOf(exec) != -1) {
								Contains.FILES.remove(i);
							}
						}
					}
				}
			}
			//	把索引存Redis
			try {
				jedisUtil.set("fileIndexs", JSON.toJSON(Contains.FILES).toString());
				long end = System.currentTimeMillis();
				StringBuffer sb = new StringBuffer(Contains.SLABLE + "索引建立成功~<br>");
				sb.append("任务耗时：" + (end - start) + "ms<br>")
						.append("文件总数：" + Contains.FILES.size() + "个" + Contains.ELABLE);
				resultMsg.setText(sb.toString());
			}catch (Exception e) {
				resultMsg.setText("建立索引失败！");
//				e.printStackTrace();
			}
			if (properties == null) {
				properties = new Properties();
			}
			properties.setProperty("cludeStr",cludeStr);
			properties.setProperty("excludeStr",excludeStr);
			FileUtil.whiteProp(Contains.SETPROP,properties);
			dialog.setVisible(false);
		}
	}

	/**
	 * 去除value的List长度2为1的 其他的放进ListModel
	 * @param maps
	 */
	private void disLenOneToListModel(Map<String, List<FilePojo>> maps) {
		Iterator<Map.Entry<String, List<FilePojo>>> it = maps.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<FilePojo>> next = it.next();
			List<FilePojo> value = next.getValue();
			if (value.size() < 2) {
				it.remove();
			} /*else {
				for (FilePojo s : value) {
					//listModel.addElement(s);
				}
			}*/
		}
	}

	/**
	 * 文件名重复
	 * @param files
	 */
	private Map<String, List<FilePojo>> repeatFileName(List<FilePojo> files) {
		Map<String, List<FilePojo>> nameMaps = new HashMap<>();
		for (FilePojo file : files) {
			Contains.groupFile(file,file.getFileName(),nameMaps);
		}
		//	去除 value的长度为1 并放进ListModel
		disLenOneToListModel(nameMaps);
		return nameMaps;
	}

}
