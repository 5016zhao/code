package FruitManagement;

import javax.swing.*;

import java.awt.event.ActionEvent;

public class Welcome extends JFrame {
    JButton b;
    JLabel l;

    public Welcome(String s) {
        super(s);
        this.setBounds(300,50,1000,700);
        this.setLayout(null);

        b=new JButton("进入系统");
        l=new JLabel(new ImageIcon("src/FruitManagement/111.png"));
        l.setBounds(0,0,1000,600);
        b.setBounds(440,600,100,40);
        this.add(l);
        this.add(b);
        JFrame win=this;
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Managerial("水果管理系统");
                Welcome.this.dispose();
            }
        });
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String []args){
        new Welcome("水果超市欢迎您！");
    }
}
