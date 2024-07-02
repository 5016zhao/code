package view;

import dao.UserDao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

//找回窗口
public class RetrieveJFrame extends JFrame{
	UserDao userDao=new UserDao();
	JLabel name,tel,tip,note;
	JTextField fieldName,fieldTel,fieldtip;
	JButton btnsure,btnreturn;
	public RetrieveJFrame() {
		this.setTitle("找回窗口");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,500,300);
		this.setLayout(null);
		init();//初始化窗口组件
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		name=new JLabel("用户名：");
		tel=new JLabel("电    话：");
		tip=new JLabel("提    示：");
		fieldName=new JTextField(150);
		fieldTel=new JTextField(150);
		note=new JLabel("注意:您需输入用户名和注册时的电话来找回您的密码,密码会显示在提示框中");
		fieldtip=new JTextField(150);
		fieldtip.setEditable(false);
		btnsure=new JButton("确定");
		btnreturn=new JButton("返回");
		name.setBounds(150,10,100,25);
		fieldName.setBounds(200,10,130,25);
		tel.setBounds(150,40,100,25);
		fieldTel.setBounds(200,40,130,25);
		tip.setBounds(150,70,100,25);
		fieldtip.setBounds(200,70,130,25);
		note.setBounds(30,100,500,30);
		btnsure.setBounds(130,130,100,30);
		btnreturn.setBounds(280,130,100,30);

		btnreturn.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RetrieveJFrame.this.setVisible(false);
				new SignInJFrame();
			}
		});
		btnsure.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=fieldName.getText(),tel=fieldTel.getText();
				char[] ch=tel.toCharArray();
				String str=userDao.UserRetrieve(name,ch);

				if(!str.equals("用户名或电话不正确")){
					fieldtip.setText(str);
					JOptionPane.showMessageDialog(null,"密码已经展示在提示框中");
				}
				else{
					JOptionPane.showMessageDialog(null,str);
				}
			}
		});
		this.add(name);
		this.add(fieldName);
		this.add(tel);
		this.add(fieldTel);
		this.add(tip);
		this.add(fieldtip);
		this.add(btnsure);
		this.add(note);
		this.add(btnreturn);
	}
}
