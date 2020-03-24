package com.zpf.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class Caltulator_UI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static int count=1;
	/**
	 * Launch the application.
	 * 创建计算器基本图形
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//计算机界面
					Caltulator_UI frame = new Caltulator_UI();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 创建textField的GET方法
	 */
	public String getTextField() {
		return textField.getText();
	}

	/**
	 * Create the frame.
	 * 构造方法
	 */
	public Caltulator_UI() {
		//窗体基本设置
		setTitle("\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//第一个JPanel面板，包含文本框，显示计算数据
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 516, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		textField.setFont(new Font("宋体", Font.PLAIN, 30));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setBounds(56, 13, 415, 57);
		panel.add(textField);
		textField.setColumns(10);
		
		//第二个JPaner面板,主要是按钮组件,并设置监听器
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 110, 520, 316);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 5, 10, 10));
		
		JButton btnNewButton = new JButton("7");
		btnNewButton.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("8");
		btnNewButton_1.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("9");
		btnNewButton_2.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.setForeground(new Color(138, 43, 226));
		btnNewButton_3.setBackground(UIManager.getColor("Desktop.background"));
		btnNewButton_3.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("*");
		btnNewButton_7.setBackground(UIManager.getColor("Desktop.background"));
		btnNewButton_7.setForeground(new Color(138, 43, 226));
		btnNewButton_7.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("1");
		btnNewButton_8.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("2");
		btnNewButton_9.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("3");
		btnNewButton_10.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("+");
		btnNewButton_11.setBackground(UIManager.getColor("Desktop.background"));
		btnNewButton_11.setForeground(new Color(138, 43, 226));
		btnNewButton_11.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("0");
		btnNewButton_12.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton(".");
		btnNewButton_13.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("=");
		btnNewButton_14.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
				String ss=textField.getText();
				//System.out.println(ss);		//测试
				Calculate calculate=new Calculate();
				String num=calculate.calcluate(ss);
				//System.out.println(num);		//测试
				textField.setText(num);
			}
		});
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_19 = new JButton("-");
		btnNewButton_19.setBackground(UIManager.getColor("Desktop.background"));
		btnNewButton_19.setForeground(new Color(138, 43, 226));
		btnNewButton_19.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 50));
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_19);
		
		JButton btnNewButton_15 = new JButton("AC");
		btnNewButton_15.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				count=1;
			}
		});
		panel_1.add(btnNewButton_15);
		
		//负号
		JButton btnNewButton_16 = new JButton("+/-");//为便于与减号进行区分，此处用中文输入法的负号
		btnNewButton_16.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 30));
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 设置静态成员变量控制负号的输入
				 */
				if(count%2==1) {//按第一次负号
					String string1=textField.getText();
					String string2=string1.substring(0, string1.length()-1);
					
					char ch=string1.charAt(string1.length()-1);
					String fuhao=string2+"(-"+ch+")";
					textField.setText(fuhao);
				}
				if(count%2==0) {//按第二次负号
					//String str=textField.getText()+e.getActionCommand();
					//textField.setText(str.substring(0,str.length()-2));
					String str1=textField.getText();
					int lastLK=str1.lastIndexOf("(");//最后一个左括号索引值
					String str2=str1.substring(lastLK);
					int lastRK=str2.lastIndexOf(")");
					String str3=str2.substring(2,lastRK);//负号字符串
					String str4=str1.substring(0, lastLK);//去掉负号的字符串
					String str=str4+str3;
					textField.setText(str);
				}
				count++;
			}
		});
		panel_1.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("(");
		btnNewButton_17.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton(")");
		btnNewButton_18.setFont(new Font("宋体",Font.BOLD,30));
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText()+e.getActionCommand());
			}
		});
		panel_1.add(btnNewButton_18);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(103, 439, 259, 50);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_20 = new JButton("DEL");
		btnNewButton_20.setFont(new Font("宋体", Font.BOLD, 30));
		btnNewButton_20.setBounds(48, 0, 211, 45);
		btnNewButton_20.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sa=textField.getText();
				textField.setText(sa.substring(0, sa.length()-1));
				count=1;
			}
		});
		panel_2.add(btnNewButton_20);
	}
}
