/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lsh.hotkey.frame;

import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.SwingUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;

/**
 *
 * @author Administrator
 */
public class FileList extends JDialog {
	private DefaultListModel listModel = new DefaultListModel();
	DocumentDuplicationCheck parent = null;
	RenameFrame renameFrame = null;
	private int[] selectIndex;
	private String clazz;

    public FileList(DocumentDuplicationCheck parent, boolean modal) {
        super(parent, modal);
	    Contains.window = this;
	    this.parent = parent;
	    initListModel(parent.fileListStr);
        initComponents();
        clazz = parent.getClass().getSimpleName();
	    SwingUtil.setFrameTitle(this,"文件列表");
    }
    public FileList(RenameFrame parent, boolean modal) {
        super(parent, modal);
	    Contains.window = this;
		clazz = parent.getClass().getSimpleName();
	    this.renameFrame = parent;
	    initListModel(renameFrame.getjTextField1().getText());
        initComponents();
	    SwingUtil.setFrameTitle(this,"文件列表");
    }
    private void initListModel(String filelist) {
	    if (!StringUtils.isEmpty(filelist)) {
		    String[] files = filelist.split(";");
		    for (int i = 0; i < files.length; i++) {
			    listModel.addElement(files[i]);
		    }
	    }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        jScrollPane2 = new JScrollPane();
        jList1 = new JList<>();
        jButton1 = new JButton("选择文件夹");
        jButton2 = new JButton("移除文件夹");
	    jButton3 = new JButton("确定");
	    jButton4 = new JButton("取消");

        jList1.setModel(listModel);
        jList1.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
		        selectIndex = jList1.getSelectedIndices();
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
			    dispose();
		    }
	    });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
			    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					    .addGroup(layout.createSequentialGroup()
							    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									    .addGroup(layout.createSequentialGroup()
											    .addGap(27, 27, 27)
											    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
									    .addGroup(layout.createSequentialGroup()
											    .addGap(112, 112, 112)
											    .addComponent(jButton3)
											    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											    .addComponent(jButton4)))
							    .addGap(31, 31, 31)
							    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									    .addComponent(jButton1)
									    .addComponent(jButton2))
							    .addContainerGap(30, Short.MAX_VALUE))
	    );
	    layout.setVerticalGroup(
			    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					    .addGroup(layout.createSequentialGroup()
							    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
									    .addGroup(layout.createSequentialGroup()
											    .addGap(77, 77, 77)
											    .addComponent(jButton1)
											    .addGap(61, 61, 61)
											    .addComponent(jButton2))
									    .addGroup(layout.createSequentialGroup()
											    .addGap(26, 26, 26)
											    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
							    .addGap(29, 29, 29)
							    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									    .addComponent(jButton3)
									    .addComponent(jButton4))
							    .addGap(0, 32, Short.MAX_VALUE))
	    );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	    int i = SwingUtil.openDir();
	    if (i == 1) {
	    	return;
	    } else {
		    String absolutePath = Contains.JFILE.getSelectedFile().getAbsolutePath();
		    listModel.addElement(absolutePath);
	    }
    }

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    	if (selectIndex != null) {
		    int length = selectIndex.length;
		    if (length > 0) {
			    for (int i = length-1; i >= 0; i--) {
				    listModel.removeElementAt(selectIndex[i]);
			    }
		    }
	    }
    }
	private void jButton3ActionPerformed(ActionEvent evt) {
		String s = listModelToStr();
		if (clazz.equals("DocumentDuplicationCheck")) {
			if (Contains.AUSTATE == 1) {
				parent.getExclude().setText(s);
			} else {
				parent.getClude().setText(s);
			}
		}
		if (clazz.equals("RenameFrame")) {
			renameFrame.getjTextField1().setText(s);
		}
		
	}

	private String listModelToStr() {
		Enumeration elements = listModel.elements();
		StringBuffer sb = new StringBuffer();
		while (elements.hasMoreElements()) {
			String element = (String) elements.nextElement();
			sb.append(element).append(";");
		}
		return sb.toString();
	}

    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
    private JList<String> jList1;
    private JScrollPane jScrollPane2;
}
