package view;

import dao.GoodsDao;
import dao.GoodsFile;
import dao.UserDao;
import model.Goods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class AddJFame extends JFrame{
	UserDao userDao=new UserDao();
	GoodsDao GoodsDao=new GoodsDao();
	String userName;
	JTextField tip;
	//�����������黹���������ģ��˳�
	JLabel mainPic,welcome,id,name,publisher,descriptions,kind;
	JButton btnShare,btnPost,btnRevert,btnOneself,btnExit,btnTt,btnadd,btnRr;
	JButton btnsure,btnreturn;
	
	JButton btnUpdata,btnRemove,btnLogout;
	JRadioButton rbnDurables,rbnConsumables;//����Ʒ������Ʒ
	JTextField tid,tname,tpublisher;
	JTextArea tdescriptions;
    ButtonGroup buttonGroup;
	JTable jTable1,jTable2,jTable3;
	JScrollPane jScrollPane1,jScrollPane2,jScrollPane3;
	JLabel lname,tel,ltip,note;
	JTextField lpass;
	JPasswordField fieldName,fieldTel,fieldtip;
	JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel0,jPanel5;
	Font f2=new Font("����", Font.BOLD, 35);
	Font f1=new Font("����", Font.BOLD, 20);
	public AddJFame() {
		this.setTitle("�û�ʹ��ƽ̨");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,650,500);
		this.setLayout(null);
		init();//��ʼ���������
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public AddJFame(String name) {
		userName=name;
		this.setTitle("����ƽ̨");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,650,500);
		this.setLayout(null);
		init();//��ʼ���������
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		mainPic=new JLabel(new ImageIcon("image\\mainPic.jpeg"));
		
		jPanel0=new JPanel();
		jPanel0.setLayout(null);
		jPanel1=new JPanel();
		jPanel1.setLayout(null);
		jPanel2=new JPanel();
		jPanel2.setLayout(null);
		jPanel3=new JPanel();
		jPanel3.setLayout(null);
		jPanel4=new JPanel();
		jPanel4.setLayout(null);
		jPanel5=new JPanel();
		jPanel5.setLayout(null);
		jTable1=new JTable();
		jTable2=new JTable();
		jTable3=new JTable();
		
		jScrollPane1=new JScrollPane(jTable1);
		jScrollPane2=new JScrollPane(jTable2);
		jScrollPane3=new JScrollPane(jTable3);
		btnShare=new JButton("�����б�");
		btnPost=new JButton("��Ҫ����");
		btnRevert=new JButton("��Ʒ�黹");
		btnOneself=new JButton("��������");
		btnExit=new JButton("�˳�");
		btnTt=new JButton("���");
		btnRr=new JButton("�黹");
		btnUpdata=new JButton("�޸���Ϣ");
		btnRemove=new JButton("ȡ������");
		btnLogout=new JButton("ע��");
		btnsure=new JButton("ȷ��");
		btnreturn=new JButton("����");
		welcome=new JLabel("��ӭʹ�ù�����Ʒ����ƽ̨");
		lname=new JLabel("ԭ  ��  �룺");
		
		tel=new JLabel("��  ��  �룺");
		ltip=new JLabel("ȷ�����룺");
		fieldName=new  JPasswordField(150);
		lpass=new JTextField(150);
		fieldTel=new JPasswordField(150);
		welcome.setBounds(50, 10, 500, 300);
		welcome.setFont(f2);
		jPanel0.add(welcome);
		jPanel0.setBounds(100, 120, 500, 400);
		jPanel1.setBounds(100, 120, 500, 400);
		jPanel2.setBounds(100, 120, 500, 400);
		jPanel3.setBounds(100, 120, 500, 400);
		jPanel4.setBounds(100, 120, 500, 400);
		jPanel5.setBounds(100, 120, 500, 400);
		mainPic.setBounds(0,0,650,120);
		btnShare.setBounds(0,120,100,70);
		btnPost.setBounds(0,190,100,70);
		btnRevert.setBounds(0,260,100,70);
		btnOneself.setBounds(0 ,330,100,70);
		btnExit.setBounds(0,400,100,70);
		jScrollPane1.setBounds(50,40,430,220);
		jScrollPane2.setBounds(50,40,430,220);
		jScrollPane3.setBounds(50,40,430,220);
		btnadd=new JButton("���");
		jTable1.getTableHeader().setReorderingAllowed(false);
		jTable1.getTableHeader().setResizingAllowed(false);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable2.getTableHeader().setReorderingAllowed(false);
		jTable2.getTableHeader().setResizingAllowed(false);
		jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable3.getTableHeader().setReorderingAllowed(false);
		jTable3.getTableHeader().setResizingAllowed(false);
		jTable3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		buttonGroup=new ButtonGroup();
		id=new JLabel("��  �ţ�");
		id.setFont(f1);
		jPanel4.add(id);
		name=new JLabel("��  �ƣ�");
		name.setFont(f1);
		jPanel4.add(name);
		kind=new JLabel("��  ��");
		kind.setFont(f1);
		jPanel4.add(kind);
		publisher=new JLabel("�����ߣ�");
		publisher.setFont(f1);
		jPanel4.add(publisher);
		descriptions=new JLabel("������");
		descriptions.setFont(f1);
		jPanel4.add(descriptions);
		rbnDurables=new JRadioButton("����Ʒ");
		jPanel4.add(rbnDurables);
		rbnConsumables=new JRadioButton("����Ʒ");
		jPanel4.add(rbnConsumables);
		buttonGroup.add(rbnConsumables);
		buttonGroup.add(rbnDurables);
		jPanel4.add(btnadd);
		tid=new JTextField(150);
		tid.setEditable(false);
		tid.setFont(f1);
		jPanel4.add(tid);
		tdescriptions=new JTextArea(200,100);
		tdescriptions.setFont(f1);
		jPanel4.add(tdescriptions);
		tname=new JTextField(150);
		tname.setFont(f1);
		jPanel4.add(tname);
		tpublisher=new JTextField(150);
		tpublisher.setEditable(false);
		tpublisher.setFont(f1);
		tpublisher.setText(userName);
		jPanel4.add(tpublisher);
		id.setBounds(20,20,100,30);
		tid.setBounds(100,20,130,30);
		name.setBounds(290,20,100,30);
		tname.setBounds(370,20,130,30);
		kind.setBounds(20,80,100,30);
		rbnDurables.setBounds(90,80,80,30);
		rbnConsumables.setBounds(170,80,80,30);
		publisher.setBounds(290,80,100,30);
		tpublisher.setBounds(370,80,130,30);
		descriptions.setBounds(20,140,100,30);
		tdescriptions.setBounds(100,140,370,100);
		btnadd.setBounds(230,260,100,40);


		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int t=jTable3.getSelectedRow();
				String[][] s= GoodsDao.getMyShear(userName);
				int ok=JOptionPane.showConfirmDialog(null, "ȷ��Ҫȡ��������","��ʾ",JOptionPane.YES_NO_OPTION);
				if(ok==JOptionPane.YES_OPTION) {
					GoodsDao.abolishShear(s[t][0]);
					System.out.println(s[t][0]);
					String[][]str=GoodsDao.getMyShear(userName);
					showGoods3(str);
					JOptionPane.showMessageDialog(null, "ȡ���ɹ�");
				}
			}
		});
		btnsure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pass1=fieldName.getText(),pass2=fieldTel.getText(),pass3=fieldtip.getText();
				int ok=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ������","��ʾ",JOptionPane.YES_NO_OPTION);
				if(ok==JOptionPane.YES_OPTION) {
					String str=userDao.changePassword(userName, pass1,pass2,pass3);
					JOptionPane.showMessageDialog(null, str);
					if(str.equals("�޸ĳɹ�")) {
						AddJFame.this.setVisible(false);
						new SignInJFrame();
					}
				}
			}
		});
		btnreturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id=new JLabel("���˷���");
				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				id.setBounds(230, 10, 100, 20);
				btnRemove.setBounds(50, 300, 100, 30);
				btnUpdata.setBounds(220, 300, 100, 30);
				btnLogout.setBounds(380, 300, 100, 30);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel2.setVisible(false);
				jPanel4.setVisible(false);
				jPanel5.setVisible(false);
				jPanel3.setVisible(true);
				jPanel3.add(jScrollPane3);
				jPanel3.add(id);
				jPanel3.add(tip);
				jPanel3.add(btnLogout);
				jPanel3.add(btnRemove);
				jPanel3.add(btnUpdata);
				String[][]str=GoodsDao.getMyShear(userName);
				showGoods3(str);
			}
		});
		btnUpdata.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jPanel0.setVisible(false);
				jPanel2.setVisible(false);
				jPanel3.setVisible(false);
				jPanel4.setVisible(false);
				jPanel1.setVisible(false);
				jPanel5.setVisible(true);

				note=new JLabel("ע��:��������ԭ������������������������룬������ɺ���Ҫ���µ�¼");
				fieldtip=new JPasswordField(150);
				
				lname.setBounds(130,10,100,25);
				fieldName.setBounds(200,10,130,25);
				tel.setBounds(130,40,100,25);
				fieldTel.setBounds(200,40,130,25);
				ltip.setBounds(130,70,100,25);
				fieldtip.setBounds(200,70,130,25);
				note.setBounds(30,100,500,30);
				btnsure.setBounds(130,130,100,30);
				btnreturn.setBounds(280,130,100,30);
				jPanel5.add(lname);
				jPanel5.add(fieldName);
				jPanel5.add(tel);
				jPanel5.add(fieldTel);
				jPanel5.add(ltip);
				jPanel5.add(fieldtip);
				jPanel5.add(btnsure);
				jPanel5.add(note);
				jPanel5.add(btnreturn);
			}
		});
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ok=JOptionPane.showConfirmDialog(null, "ȷ��Ҫע���˺���","��ʾ",JOptionPane.YES_NO_OPTION);
				if(ok==JOptionPane.YES_OPTION) {
					String str=userDao.logoutUser(userName);
					JOptionPane.showMessageDialog(null, str);
					if(str.equals("ע���ɹ�")) {
						AddJFame.this.setVisible(false);
						new SignInJFrame();
					}
				}
			}
		});
		
		btnRr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ok=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�黹��Ʒ��","��ʾ",JOptionPane.YES_NO_OPTION);
				if(ok==JOptionPane.YES_OPTION) {
					int t=jTable2.getSelectedRow();
					String[][] s= GoodsDao.getMyGoods(userName);
					String id=s[t][0];
					GoodsDao.revert(id);
					String[][]str=GoodsDao.getMyGoods(userName);
					showGoods2(str);
				}
			}
		});
		btnadd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText(),name=tname.getText();
				if((!rbnConsumables.isSelected()&&!rbnDurables.isSelected())){
					JOptionPane.showMessageDialog(null,"��ѡ�����");
				}
				else if(name.isEmpty()){
					JOptionPane.showMessageDialog(null,"��ѡ������");
				}
				else{
					int ok=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�����Ʒ��","��ʾ",JOptionPane.YES_NO_OPTION);
					if(ok==JOptionPane.YES_OPTION) {
						String kind=rbnDurables.isSelected()?"����Ʒ":"����Ʒ";
						String publisher=tpublisher.getText(),scriptions=tdescriptions.getText();
						Goods good=new Goods(id,name,kind,"�����",publisher,scriptions,null);
						GoodsDao.addGood(good);
						tname.setText(null);
						tdescriptions.setText(null);
						String s=generatesID();
						tid.setText(s);
						JOptionPane.showMessageDialog(null,"��ӳɹ�");
					}
				}
			}
		});
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
				int t=jTable1.getSelectedRow();
				String[][] s= GoodsDao.getGoods();
				String[] ss=new String[7];
				System.arraycopy(s[t], 0, ss, 0, 7);
				tip.setText(ss[5]);
			}
		});
		jTable2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
				int t=jTable2.getSelectedRow();
				String[][] s= GoodsDao.getMyGoods(userName);
				String[] ss=new String[7];
				System.arraycopy(s[t], 0, ss, 0, 7);
				tip.setText(ss[5]);
			}
		});
		jTable3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
				int t=jTable3.getSelectedRow();
				String[][] s= GoodsDao.getMyShear(userName);
				String[] ss=new String[7];
				System.arraycopy(s[t], 0, ss, 0, 7);
				tip.setText(ss[5]);
			}
		});
		btnTt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int ok=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�����Ʒ��","��ʾ",JOptionPane.YES_NO_OPTION);
				if(ok==JOptionPane.YES_OPTION) {
					String[][] s= GoodsDao.getGoods();
					String[] ss=new String[7];
					int t=jTable1.getSelectedRow();
	                System.arraycopy(s[t], 0, ss, 0, 7);
					ss[6]=userName;
					Goods goods=new Goods(ss[0],ss[1],ss[2],ss[3],ss[4],ss[5],ss[6]);
					String str=GoodsDao.Lending(goods);
					JOptionPane.showMessageDialog(null,str);
					String[][]st= GoodsDao.getGoods();
					showGoods(st);
				}
			}
		});
		//չʾ
		btnShare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel jShow=new JLabel("��飺");
				
				btnTt.setBounds(230, 310, 100, 30);

				jShow.setBounds(50,270,100,25);
				tip=new JTextField(500);
				tip.setBounds(90,270, 390, 25);
				tip.setEditable(false);
				jPanel0.setVisible(false);
				jPanel2.setVisible(false);
				jPanel3.setVisible(false);
				jPanel4.setVisible(false);
				jPanel5.setVisible(false);
				jPanel1.setVisible(true);
				jPanel1.add(jScrollPane1);
				jPanel1.add(jShow);
				jPanel1.add(tip);
				jPanel1.add(btnTt);
				String[][]str= GoodsDao.getGoods();
				showGoods(str);
			}
		});
		//�黹
		btnRevert.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

				btnRr.setBounds(230, 310, 100, 30);
				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel3.setVisible(false);
				jPanel4.setVisible(false);
				jPanel5.setVisible(false);
				jPanel2.setVisible(true);
				jPanel2.add(jScrollPane2);
				jPanel2.add(tip);
				jPanel2.add(btnRr);
				String[][]str=GoodsDao.getMyGoods(userName);
				showGoods2(str);
			}
		});
		//��������   �޸����룬���ƣ�ע����ȡ�������޸���Ϣ
		btnOneself.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				id=new JLabel("���˷���");
				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				id.setBounds(230, 10, 100, 20);
				btnRemove.setBounds(50, 300, 100, 30);
				btnUpdata.setBounds(220, 300, 100, 30);
				btnLogout.setBounds(380, 300, 100, 30);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel2.setVisible(false);
				jPanel4.setVisible(false);
				jPanel5.setVisible(false);
				jPanel3.setVisible(true);
				jPanel3.add(jScrollPane3);
				jPanel3.add(id);
				jPanel3.add(tip);
				jPanel3.add(btnLogout);
				jPanel3.add(btnRemove);
				jPanel3.add(btnUpdata);
				String[][]str=GoodsDao.getMyShear(userName);
				showGoods3(str);
			}
		});

		//����   ���Ϊ8λ�����
		btnPost.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println(userName);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel2.setVisible(false);
				jPanel3.setVisible(false);
				jPanel5.setVisible(false);
				jPanel4.setVisible(true);

				String s=generatesID();
				tid.setText(s);

			}
		});
		btnExit.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddJFame.this.setVisible(false);
				new SignInJFrame();
			}
		});
		
		this.add(mainPic);
		this.add(btnExit);
		this.add(btnRevert);
		this.add(btnShare);
		this.add(btnOneself);
		this.add(btnPost);
		this.add(btnExit);
		this.add(jPanel0);
		this.add(jPanel1);
		this.add(jPanel2);
		this.add(jPanel3);
		this.add(jPanel4);
		this.add(jPanel5);
		jPanel0.setVisible(true);
		jPanel1.setVisible(false);
		jPanel2.setVisible(false);
		jPanel4.setVisible(false);
		jPanel5.setVisible(false);
		jPanel3.setVisible(false);
	}
	public String generatesID(){
		char[] ch={'0','1','2','3','4','5','6','7','8','9'};
		Random random=new Random();
		StringBuilder s=new StringBuilder();
		String st;
        do {
            for (int i = 1; i <= 8; i++) {
                int t = random.nextInt(10);
                s.append(ch[t]);
            }
            st = new String(s);
        } while (!GoodsDao.checkID(st));
		return st;
	}
	//չʾ��Ʒ
	public void showGoods(String[][] str){
		String[] s={"���","����","���","״̬","������"};

		DefaultTableModel defaultTableModel=new DefaultTableModel(str,s);
		jTable1.setModel(defaultTableModel);
	}

	public void showGoods2(String[][] str){
		String[] s={"���","����","���","״̬","������"};

		DefaultTableModel defaultTableModel=new DefaultTableModel(str,s);
		jTable2.setModel(defaultTableModel);
	}
	public void showGoods3(String[][] str){
		String[] s={"���","����","���","״̬","������"};

		DefaultTableModel defaultTableModel=new DefaultTableModel(str,s);
		jTable3.setModel(defaultTableModel);
	}
	public static void main(String[] args) {
    	new AddJFame();
    }
}

