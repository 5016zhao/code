package view;

import dao.UserDao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

//�һش���
public class RetrieveJFrame extends JFrame{
	UserDao userDao=new UserDao();
	JLabel name,tel,tip,note;
	JTextField fieldName,fieldTel,fieldtip;
	JButton btnsure,btnreturn;
	public RetrieveJFrame() {
		this.setTitle("�һش���");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,500,300);
		this.setLayout(null);
		init();//��ʼ���������
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		name=new JLabel("�û�����");
		tel=new JLabel("��    ����");
		tip=new JLabel("��    ʾ��");
		fieldName=new JTextField(150);
		fieldTel=new JTextField(150);
		note=new JLabel("ע��:���������û�����ע��ʱ�ĵ绰���һ���������,�������ʾ����ʾ����");
		fieldtip=new JTextField(150);
		fieldtip.setEditable(false);
		btnsure=new JButton("ȷ��");
		btnreturn=new JButton("����");
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

				if(!str.equals("�û�����绰����ȷ")){
					fieldtip.setText(str);
					JOptionPane.showMessageDialog(null,"�����Ѿ�չʾ����ʾ����");
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
