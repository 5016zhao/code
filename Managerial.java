package FruitManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Managerial extends JFrame {
    FileFruit fu=new FileFruit();
    static String []str={"水果编号","水果名称","水果价格","计价单位"};
    String[][] st= fu.ReaderFruit();
    static JLabel jl=new JLabel("水果列表");
    static JLabel jll=new JLabel("注意：添加操作必须输入所有相关信息，修改操作须输入编号以及需要修改的信息,删除操作则只需输入编号");
    //创建一个二维网格
    JTable jt=new JTable(st,str);
    //创建滚动窗口
    static JScrollPane sp =  new JScrollPane();
    //添加按钮
    static JButton add=new JButton("添加水果");
    static JButton modify=new JButton("修改水果");
    static JButton erase=new JButton("删除水果");
    //添加文本框
    static JTextField id=new JTextField(6);
    static JTextField name=new JTextField(6);
    static JTextField prices=new JTextField(6);
    static JTextField price=new JTextField(6);
    //添加文本框标题
    static JLabel lid=new JLabel("水果编号:");
    static JLabel lname=new JLabel("水果名称:");
    static JLabel lprices=new JLabel("水果价格:");
    static JLabel lprice=new JLabel("计价单位:");
    public Managerial(String s){
        super(s);
        //关闭布局方式
        this.setLayout(null);

        //设置窗口所在位置
        this.setBounds(200,90,1000,700);
        //设置标题所在位置
        jl.setBounds(450,10,50,15);
        //设置滚动窗口所在位置
        sp.setBounds(90,30,810,500);
        //设置注意颜色

        //设置组件位置
        lid.setBounds(180,540,60,30);
        id.setBounds(240,540,90,30);
        lname.setBounds(330,540,60,30);
        name.setBounds(390,540,90,30);
        lprices.setBounds(480,540,60,30);
        prices.setBounds(540,540,90,30);
        lprice.setBounds(630,540,60,30);
        price.setBounds(690,540,90,30);
        //按钮添加
        add.setBounds(300,590,90,40);
        modify.setBounds(450,590,90,40);
        erase.setBounds(600,590,90,40);
        jll.setBounds(200,630,600,20);

        sp.setViewportView(jt);
        //添加按钮动作
        add.addActionListener(new AbstractAction(){
            public void actionPerformed(ActionEvent e) {
                String sid=id.getText(),sname=name.getText(),sprices=prices.getText(),sprice=price.getText();
                if(sid.isEmpty() || sname.isEmpty() || sprices.isEmpty() || sprice.isEmpty()){//不能添加
                    JOptionPane.showMessageDialog(new JFrame(),"水果编号或水果名称或水果价格或计价单位不能为空");
                }
                else{
                    boolean ok=false;
                    for(String[] strings:st) {
                        if(ok)break;
                        if (strings[1].equals(sname)&&strings[0].equals(sid)) {
                            JOptionPane.showMessageDialog(new JFrame(),"该水果已经存在");
                            ok=true;
                        }
                        else if(strings[1].equals(sname)){
                            JOptionPane.showMessageDialog(new JFrame(),"该水果名称已经存在");
                            ok=true;
                        }
                        else if(strings[0].equals(sid)){
                            JOptionPane.showMessageDialog(new JFrame(),"该水果编号已经存在");
                            ok=true;
                        }
                    }
                    if(!ok){//如果已经存在则不能添加
                        final int t=st.length;
                        String[][] arr= Arrays.copyOf(st,t+1);
                        arr[t]=new String[]{sid,sname,sprices,sprice};
                        st=Arrays.copyOf(arr,arr.length);
                        jt = new JTable(st, str);
                        sp.setViewportView(jt);
                        fu.WriterFruit(str,st);
                    }
                }
            }
        });
        //修改按钮动作
        modify.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sid=id.getText(),sname=name.getText(),sprices=prices.getText(),sprice=price.getText();
                if(sid.isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"请输入要修改的水果编号");
                }
                else{
                    boolean ok=false;
                    for(String[] strings:st){
                        if(ok)break;
                        if(strings[0].equals(sid)){
                            ok=true;
                            if(!sname.isEmpty())strings[1]=sname;
                            if(!sprices.isEmpty())strings[2]=sprices;
                            if(!sprice.isEmpty())strings[3]=sprice;
                        }
                    }
                    if(!ok){
                        JOptionPane.showMessageDialog(new JFrame(),"您输入的水果编号不存在");
                    }
                    else{
                        jt = new JTable(st, str);
                        sp.setViewportView(jt);
                        fu.WriterFruit(str,st);
                    }
                }
            }
        });
        //删除按钮动作
        erase.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sid=id.getText();
                if(sid.isEmpty()){
                    JOptionPane.showMessageDialog(new JFrame(),"请输入要删除的水果编号");
                }
                else{
                    String[][] arr = new String[st.length][4];
                    int t=0;
                    for(String[] strings:st){
                        if(!strings[0].equals(sid)){
                            System.arraycopy(strings, 0, arr[t], 0, 4);
                            t++;
                        }
                    }
                    if(t==st.length){
                        JOptionPane.showMessageDialog(new JFrame(),"您输入的水果编号不存在");
                    }
                    else{
                        st=Arrays.copyOf(arr,arr.length-1);
                        jt = new JTable(st, str);
                        sp.setViewportView(jt);
                        fu.WriterFruit(str,st);
                    }
                }
            }
        });
        //添加组件
        this.add(jl);
        this.add(sp);
        this.add(lid);
        this.add(id);
        this.add(lname);
        this.add(name);
        this.add(lprices);
        this.add(prices);
        this.add(lprice);
        this.add(price);
        this.add(add);
        this.add(erase);
        this.add(modify);
        this.add(jll);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}