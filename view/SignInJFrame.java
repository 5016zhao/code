package view;


import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import dao.UserDao;
import model.User;

public class SignInJFrame extends JFrame{
	UserDao userDao=new UserDao();
	JLabel topPicture;//�ϲ�ͼƬ
	JButton btnSignIn,btnSignUp,btnRetrieve;//��¼��ť��ע�ᰴť
	JLabel userName,userPassWord;//�û�����ǩ���û������ǩ
	JTextField fieldUserName;//�û����ı���
	JPasswordField fieldPassWord;//�û������ı���
	Font f1=new Font("����", Font.BOLD, 20);
	public SignInJFrame() {
		this.setTitle("��¼����");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,607,450);
		this.setLayout(null);
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		//�������
		topPicture=new JLabel(new ImageIcon("image\\top.jpg"));
		btnSignIn=new JButton("��¼");
		btnSignUp=new JButton("ע��");
		btnRetrieve=new JButton("�һ�����");
		userName=new JLabel("�û�����");
		userPassWord=new JLabel("��  �룺");
		fieldUserName=new JTextField(150);
		fieldPassWord=new JPasswordField(150);
		fieldPassWord.setEchoChar('*');
		//���ô��ڴ�С
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
		//��¼
		btnSignIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=fieldUserName.getText();
				char[] pass=fieldPassWord.getPassword();
				String str=userDao.signIn(name,pass);

				if(str.equals("��¼�ɹ�")) {
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
		//ͨ�����ƺ͵绰�һ�����
		btnRetrieve.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SignInJFrame.this.setVisible(false);
				new RetrieveJFrame();
			}
		});
		//���齨��ӵ�����
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
