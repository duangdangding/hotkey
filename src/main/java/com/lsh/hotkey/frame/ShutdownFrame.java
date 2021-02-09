package com.lsh.hotkey.frame;

import com.lsh.hotkey.utils.Contains;
import com.lsh.hotkey.utils.JsonUtil;
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
public class ShutdownFrame extends JDialog {
	JOptionPane dialog = new JOptionPane();

    public ShutdownFrame(Frame parent, boolean modal) {
        super(parent, modal);
	    Contains.window = this;
        initComponents();
    }

    private void initComponents() {

        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(Contains.F_S_0_14);
        jLabel2.setText("定时时长：");

        jLabel3.setFont(Contains.F_S_0_14);
        jLabel3.setText("分钟");

        jLabel4.setFont(Contains.F_S_0_14);
        jLabel4.setText("秒");

        jButton1.setText("开始计时");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("取消关机");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
	    SwingUtil.setFrameTitle(this,"定时关机");
	    //init();
    }
    
   /* private void init() {
	    ImageIcon icon=new ImageIcon(JsonUtil.toData("imgs/add.png"),"");
	    this.setIconImage(icon.getImage());
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
    }*/
	// 开始定时
    private void jButton1ActionPerformed(ActionEvent evt) {
	    String minu = jTextField1.getText().trim();
	    String second = jTextField2.getText().trim();
	    Integer seconds = 0;
	    Contains.window = dialog;
	    Contains.parentWindow = dialog;
	    try {
		    
	    	if ("".equals(minu) && "".equals(second)) {
			    int option = dialog.showConfirmDialog(null, "没有填写时间就是立即关机呐", "立即关机提示", JOptionPane.YES_NO_OPTION);
			    if(option != JOptionPane.YES_OPTION){
				    return;
			    }
		    } else {
	    		String msg = "系统将在";
	    		if (minu.length() > 0) {
				    if (StringUtils.isNumeric(minu)) {
				    	//不能使用Integer 因为有缓存
					    //Integer m = Integer.valueOf(minu);
					    int m = Integer.valueOf(minu);
					    seconds += m * 60;
					    msg += m+"分钟";
				    } else {
					    dialog.showMessageDialog(this,"m:请输入正确的数字！");
					    return;
				    }
			    }
	    		if (second.length() > 0) {
				    if (StringUtils.isNumeric(second)) {
					    Integer s = Integer.valueOf(second);
					    seconds += s;
					    msg += s+"秒";
				    } else {
					    dialog.showMessageDialog(this,"s:请输入正确的数字！");
					    return;
				    }
			    }
			    dialog.showMessageDialog(this,msg+"之后关闭！如果需要取消关机，请点击取消关机按钮！\n" +
					    "不足1分钟系统会提示一分钟计算，实际关机时间以设置时间为准！");
		    }
		    Contains.exeCMD("shutdown /s /t " + seconds);
	    }catch (NumberFormatException e) {
		    dialog.showMessageDialog(this,"请输入数字~");
	    }
    }
	// 取消关机
    private void jButton2ActionPerformed(ActionEvent evt) {
	    String s = Contains.exeCMD("shutdown /a");
	    Contains.window = dialog;
	    Contains.parentWindow = this;
	    dialog.showMessageDialog(this,"已取消关机！");
    }

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField1;
    private JTextField jTextField2;
}
