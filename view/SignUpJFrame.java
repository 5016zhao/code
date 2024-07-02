package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dao.UserDao;
import dao.UserFileDao;
import model.User;

public class SignUpJFrame extends JFrame{
	UserDao userDao=new UserDao();
	UserFileDao userFileDao=new UserFileDao();
	JLabel zhuce;
	JLabel userName,userTel,userPassword,define;
	JTextField fieldUserName,fieldTel;
	JButton btnSignUp,btnClear,btnreturn;
	JPanel jPanel,jPanel2;
	JPasswordField fieldPassword,fieldDefine;//�û������ı���
	Font f1=new Font("����", Font.BOLD, 20);
	Color color=new Color(212,232,248);
	public SignUpJFrame() {
		this.setTitle("ע�ᴰ��");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,607,450);
		this.setLayout(new BorderLayout());
		init();//��ʼ���������
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		jPanel=new JPanel();
		jPanel2=new JPanel();
		jPanel.setLayout(null);
		jPanel.setBackground(color);
		zhuce=new JLabel(new ImageIcon("image/zhuce.png"));
		btnClear=new JButton("���");
		btnSignUp=new JButton("ע��");
		btnreturn=new JButton("����");
		userName=new JLabel("�� �� ����");
		userTel=new JLabel("��    ����");
		userPassword=new JLabel("��    �룺");
		define=new JLabel("ȷ�����룺");
		fieldDefine=new JPasswordField(150);
		fieldTel=new JTextField(150);
		fieldUserName=new JTextField(150);
		fieldPassword=new JPasswordField(150);
		fieldPassword.setEchoChar('*');
		fieldDefine.setEchoChar('*');
		//�¼�����
		//ע���¼�
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username=fieldUserName.getText(),password=fieldPassword.getText(),define=fieldDefine.getText(),tel=fieldTel.getText();
				boolean ok=true;
				char[] pass=password.toCharArray(),pass2=define.toCharArray(),Tel=tel.toCharArray();
				if(pass.equals(pass2)) {
					ok=false;
					JOptionPane.showMessageDialog(null, "�����������벻ͬ");
					
				}
				if(ok) {
					User user=new User(username,pass,Tel);
					String str=userDao.reg(user);
					JOptionPane.showMessageDialog(null, str);
					if(str.equals("ע��ɹ�")) {
//						ArrayList<User> users = userFileDao.getUser();
//						userFileDao.weiterUsers(users);
//						SignUpJFrame.this.setVisible(false);
//						new SignInJFrame();
					}
//					else {
//						JOptionPane.showMessageDialog(null, str);
//						JOptionPane.showMessageDialog(null,"ע��ʧ��");
//					}
				}
			}
		});
		btnreturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpJFrame.this.setVisible(false);
				new SignInJFrame();
			}
		});
		btnClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fieldUserName.setText(null);
				fieldTel.setText(null);
				fieldPassword.setText(null);
				fieldDefine.setText(null);
			}
		});
		
		
		
		//���������С
		zhuce.setBounds(0,0,607,150);
		userName.setBounds(180, 0, 130, 25);
		userName.setFont(f1);
		fieldUserName.setBounds(280, 0, 130, 25);
		fieldUserName.setFont(f1);
		userTel.setBounds(180, 45, 130, 25);
		userTel.setFont(f1);
		fieldTel.setBounds(280, 45, 130, 25);
		fieldTel.setFont(f1);
		userPassword.setBounds(180, 95, 130, 25);
		userPassword.setFont(f1);
		fieldPassword.setBounds(280, 95, 130, 25);
		fieldPassword.setFont(f1);
		define.setBounds(180, 145, 130, 25);
		define.setFont(f1);
		fieldDefine.setBounds(280, 145, 130, 25);
		fieldDefine.setFont(f1);
		btnSignUp.setBounds(150, 190, 80, 30);
		btnClear.setBounds(280, 190, 80, 30);
		btnreturn.setBounds(400,190,80,25);
		//������������
		jPanel2.add(zhuce);
		jPanel.add(btnClear);
		jPanel.add(btnSignUp);
		jPanel.add(userTel);
		jPanel.add(fieldTel);
		jPanel.add(fieldPassword);
		jPanel.add(fieldUserName);
		jPanel.add(userName);
		jPanel.add(userPassword);
		jPanel.add(define);
		jPanel.add(fieldDefine);
		jPanel.add(btnreturn);
		this.add(jPanel2,BorderLayout.NORTH);
		this.add(jPanel,BorderLayout.CENTER);
		
	}
}
