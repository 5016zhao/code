package view;


import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import dao.UserDao;
import model.User;

public class SignInJFrame extends JFrame{
	UserDao userDao=new UserDao();
	JLabel topPicture;//上部图片
	JButton btnSignIn,btnSignUp,btnRetrieve;//登录按钮和注册按钮
	JLabel userName,userPassWord;//用户名标签和用户密码标签
	JTextField fieldUserName;//用户名文本框
	JPasswordField fieldPassWord;//用户密码文本框
	Font f1=new Font("宋体", Font.BOLD, 20);
	public SignInJFrame() {
		this.setTitle("登录窗口");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,607,450);
		this.setLayout(null);
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		//创建组件
		topPicture=new JLabel(new ImageIcon("image\\top.jpg"));
		btnSignIn=new JButton("登录");
		btnSignUp=new JButton("注册");
		btnRetrieve=new JButton("找回密码");
		userName=new JLabel("用户名：");
		userPassWord=new JLabel("密  码：");
		fieldUserName=new JTextField(150);
		fieldPassWord=new JPasswordField(150);
		fieldPassWord.setEchoChar('*');
		//设置窗口大小
		topPicture.setBounds(0,0,607,155);
		userName.setBounds(180, 210, 100, 25);
		userName.setFont(f1);
		fieldUserName.setBounds(260, 210, 130, 25);
		fieldUserName.setFont(f1);
		userPassWord.setBounds(180, 260, 90, 25);
		userPassWord.setFont(f1);
		fieldPassWord.setBounds(260, 260, 130, 25);
		fieldPassWord.setFont(f1);
		btnSignIn.setBounds(120, 320, 100, 40);
		btnSignUp.setBounds(250, 320, 100, 40);
		btnRetrieve.setBounds(380, 320, 100, 40);
		
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignInJFrame.this.setVisible(false);
				new SignUpJFrame();
			}
		});
		//登录
		btnSignIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=fieldUserName.getText();
				char[] pass=fieldPassWord.getPassword();
				String str=userDao.signIn(name,pass);

				if(str.equals("登录成功")) {
					SignInJFrame.this.setVisible(false);
					String s=fieldUserName.getText();
					if(name.equals("zzc")) {
						new ManagerJFrema();
					}
					else {
						new AddJFame(s);
					}
				}
				else JOptionPane.showMessageDialog(null, str);
			}
		});
		//通过名称和电话找回密码
		btnRetrieve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignInJFrame.this.setVisible(false);
				new RetrieveJFrame();
			}
		});
		//将组建添加到窗口
		this.add(topPicture);
		this.add(btnSignIn);
		this.add(btnSignUp);
		this.add(fieldPassWord);
		this.add(fieldUserName);
		this.add(userName);
		this.add(userPassWord);
		this.add(btnRetrieve);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignInJFrame();
	}

}
