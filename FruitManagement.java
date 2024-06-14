package fruitwindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FruitManagement extends JFrame {
    FruitFile fruitFile=new FruitFile();
    FruitDome fruitDome=new FruitDome();
    Fruit fruit;
    String[] st={"水果编号","水果名称","水果单价","计价单位"};
    JScrollPane jScrollPane;
    JTable jtable;
    JLabel listing,lid,lname,lprice,lunit;
    JButton add,amend,erase;
    JTextField tid,tname,tprice,tunit;
    public FruitManagement() {
        this.setBounds(100,100,800,600);
        this.setLayout(null);
        this.setVisible(true);

        init();

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        listing=new JLabel("水果列表");
        lid=new JLabel("水果编号");
        lname=new JLabel("水果名称");
        lprice=new JLabel("水果单价");
        lunit=new JLabel("计价单位");
        add=new JButton("添加水果");
        amend=new JButton("修改水果");
        erase=new JButton("删除水果");
        tid=new JTextField(12);
        tname=new JTextField(12);
        tprice=new JTextField(12);
        tunit=new JTextField(12);
        jtable=new JTable();
        jScrollPane = new JScrollPane(jtable);

        jScrollPane.setBounds(100,30,600,400);
        listing.setBounds(370,10,400,10);
        jtable.setBounds(100,30,600,400);
        lid.setBounds(200,440,50,30);
        tid.setBounds(270,440,100,30);
        lname.setBounds(430,440,50,30);
        tname.setBounds(500,440,100,30);
        lprice.setBounds(200,480,50,30);
        tprice.setBounds(270,480,100,30);
        lunit.setBounds(430,480,50,30);
        tunit.setBounds(500,480,100,30);
        add.setBounds(150,515,100,35);
        amend.setBounds(350,515,100,35);
        erase.setBounds(550,515,100,35);
        jtable.getTableHeader().setReorderingAllowed(false);
        jtable.getTableHeader().setResizingAllowed(false);
        jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[][] str= FruitDome.GetFruits();
                int row=jtable.getSelectedRow();
                tid.setText(str[row][0]);
                tname.setText(str[row][1]);
                tprice.setText(str[row][2]);
                tunit.setText(str[row][3]);
            }
        });
        add.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fruit=new Fruit();
                fruit.id=tid.getText();
                fruit.name=tname.getText();
                fruit.price=tprice.getText();
                fruit.unit=tunit.getText();
                if(fruitDome.check(fruit.id)){
                    JOptionPane.showMessageDialog(new JFrame(),"编号重复");
                }
                else{
                    fruitDome.AddFrulit(fruit);
                    fruitFile.WriterFile(FruitDome.GetFruits());
                    Show();
                    JOptionPane.showMessageDialog(new JFrame(),"添加成功");
                }
            }
        });

        amend.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fruit=new Fruit();
                fruit.id=tid.getText();
                if(fruitDome.check(fruit.id)){
                    fruit=fruitDome.getfruit(fruit.id);
                    if(!tname.getText().isEmpty())fruit.name=tname.getText();
                    if(!tprice.getText().isEmpty())fruit.price=tprice.getText();
                    if(!tunit.getText().isEmpty())fruit.unit=tunit.getText();
                    fruitDome.AmendFrulit(fruit);
                    fruitFile.WriterFile(FruitDome.GetFruits());
                    Show();
                    JOptionPane.showMessageDialog(new JFrame(),"修改成功");
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(),"要修改编号不存在");
                }

            }
        });

        erase.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fruit=new Fruit();
                fruit.id=tid.getText();
                if(!fruitDome.check(fruit.id)){
                    JOptionPane.showMessageDialog(new JFrame(),"编号不存在");
                }
                else{
                    fruitDome.EraseFrulit(fruit.id);
                    fruitFile.WriterFile(FruitDome.GetFruits());
                    Show();
                    JOptionPane.showMessageDialog(new JFrame(),"删除成功");
                }
            }
        });

        this.add(listing);
        this.add(lid);
        this.add(lname);
        this.add(lprice);
        this.add(lunit);
        this.add(add);
        this.add(amend);
        this.add(erase);
        this.add(tid);
        this.add(tname);
        this.add(tprice);
        this.add(tunit);
        this.add(jScrollPane);
        Show();
    }

    public void Show(){
        String[][] str= FruitDome.GetFruits();
        DefaultTableModel defaultTableModel=new DefaultTableModel(str,st);
        jtable.setModel(defaultTableModel);
    }

}