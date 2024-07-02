package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.GoodsDao;
/*
 * 物品状态有多种，每次只提取出
 * 管理员
 * 1.审核和管理用户上传的物品
 * 2.对违规上传物品的用户进行封号处理
 */
public class ManagerJFrema extends JFrame{
	GoodsDao goodsDao=new GoodsDao();
	JTextField tip;
	//共享，发布，归还，个人中心，退出
	JLabel mainPic,welcome,id,name,publisher,descriptions,kind;
	JButton btnShare,btnPost,btnRevert,btnOneself,btnExit,btnTt,btnadd,btnRr;
	JButton btnsure,btnreturn;
	
	JButton btnUpdata,btnRemove,btnLogout;
	
	JTextField tid,tname,tpublisher;
	JTextArea tdescriptions;
	JTable jTable1;
	JScrollPane jScrollPane;
	JLabel lname,tel,ltip,note;
	JTextField fieldName,fieldTel,fieldtip,lpass;
	JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel0,jPanel5;
	Font f2=new Font("宋体", Font.BOLD, 35);
	Font f1=new Font("宋体", Font.BOLD, 20);
	
	public ManagerJFrema() {
		this.setTitle("管理员平台");
		this.setIconImage(new ImageIcon("image\\icon.jpg").getImage());
		this.setBounds(300,200,650,500);
		this.setLayout(null);
		init();//初始化窗口组件
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init() {
		mainPic=new JLabel(new ImageIcon("image\\mainPic.jpeg"));
		welcome=new JLabel("欢迎使用共享物品管理平台");
		welcome.setBounds(50, 10, 500, 300);
		welcome.setFont(f2);
		
		jPanel0=new JPanel();
		jPanel0.setLayout(null);
		jPanel0.add(welcome);
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
		
		jScrollPane=new JScrollPane(jTable1);
		btnShare=new JButton("全部物品");//1
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				super.mouseClicked(e);
				int t=jTable1.getSelectedRow();
				String[][] s= goodsDao.getGoods();
				String[] ss=new String[7];
				System.arraycopy(s[t], 0, ss, 0, 7);
				tip.setText(ss[5]);
			}
		});
		btnShare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				jPanel0.setVisible(false);
				jPanel1.setVisible(true);
				jPanel2.setVisible(false);
				jPanel3.setVisible(false);
				jPanel4.setVisible(false);
				jPanel1.add(jScrollPane);
				showGoods(goodsDao.managerGetText(1));
			}
		});
		btnPost=new JButton("待审核");//2
		btnPost.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel3.setVisible(false);
				jPanel4.setVisible(false);
				jPanel2.setVisible(true);
				jPanel2.add(btnTt);
				jPanel2.add(btnRr);
				jPanel2.add(tip);
				btnTt.setBounds(120, 310, 100, 30);
				btnRr.setBounds(270,310,100,30);
				jPanel2.add(jScrollPane);
				showGoods(goodsDao.managerGetText(2));
			}
		});
		btnRevert=new JButton("审核通过");//3
		btnRevert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel2.setVisible(false);
				jPanel4.setVisible(false);
				jPanel3.setVisible(true);
				jPanel3.add(jScrollPane);
				jPanel3.add(tip);
				btnUpdata.setBounds(210, 310, 100, 30);
				jPanel3.add(btnUpdata);
				showGoods(goodsDao.managerGetText(3));
			}
		});
		btnOneself=new JButton("审核未通过");//4
		btnOneself.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				tip=new JTextField(500);
				tip.setBounds(50,270, 430, 25);
				tip.setEditable(false);
				jPanel0.setVisible(false);
				jPanel1.setVisible(false);
				jPanel2.setVisible(false);
				jPanel5.setVisible(false);
				jPanel3.setVisible(false);
				jPanel4.setVisible(true);
				jPanel4.add(tip);
				jPanel4.add(jScrollPane);
				btnRemove.setBounds(210, 310, 100, 30);
				jPanel4.add(btnRemove);
				showGoods(goodsDao.managerGetText(4));
			}
		});
		
		btnExit=new JButton("退出");
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				ManagerJFrema.this.setVisible(false);
				new SignInJFrame();
			}
		});
		btnTt=new JButton("通过");
		btnTt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int t=jTable1.getSelectedRow();
				String[][] s= goodsDao.managerGetText(2);
				String str=btnTt.getText();
				System.out.println(s[t][0]);
				goodsDao.audits(str,s[t][0]);
				showGoods(goodsDao.managerGetText(2));
			}
		});
		btnRr=new JButton("未通过");
		btnRr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int t=jTable1.getSelectedRow();
				String[][] s= goodsDao.managerGetText(2);
				String str=btnRr.getText();
				System.out.println(s[t][0]);
				goodsDao.audits(str,s[t][0]);
				showGoods(goodsDao.managerGetText(2));
			}
		});
		btnUpdata=new JButton("待审核");
		btnUpdata.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int t=jTable1.getSelectedRow();
				String[][] s= goodsDao.managerGetText(3);
				String str=btnUpdata.getText();
				System.out.println(s[t][0]);
				goodsDao.audits(str,s[t][0]);
				showGoods(goodsDao.managerGetText(3));
			}
		});
		btnRemove=new JButton("待审核");
		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int t=jTable1.getSelectedRow();
				String[][] s= goodsDao.managerGetText(4);
				String str=btnRemove.getText();
				System.out.println(s[t][0]);
				goodsDao.audits(str,s[t][0]);
				showGoods(goodsDao.managerGetText(4));
			}
		});
		btnLogout=new JButton("注销");
		btnsure=new JButton("确定");
		btnreturn=new JButton("返回");
		fieldName=new JTextField(150);
		lpass=new JTextField(150);
		fieldTel=new JTextField(150);
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
		jScrollPane.setBounds(50,40,430,220);
		btnadd=new JButton("添加");
		jTable1.getTableHeader().setReorderingAllowed(false);
		jTable1.getTableHeader().setResizingAllowed(false);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.add(mainPic);
		
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
		
	}
	
	public void showGoods(String[][] str){
		String[] s={"编号","名称","类别","状态","发布人"};
		DefaultTableModel defaultTableModel=new DefaultTableModel(str,s);
		jTable1.setModel(defaultTableModel);
	}
	
	public static void main(String[] args) {
		new ManagerJFrema();
	}

}
