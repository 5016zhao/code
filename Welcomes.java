package fruitwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Welcomes extends JFrame {

    JButton GoInto;
    JLabel Contexts;

    public Welcomes() {
        this.setBounds(100,100,600,400);
        this.setLayout(new FlowLayout());
        init();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        GoInto=new JButton("进入系统");
        Contexts=new JLabel(new ImageIcon("src/fruitwindow/FruitStore.jpg"));
        Welcomes win=this;
        GoInto.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FruitManagement();
                win.setVisible(false);
            }
        });
        this.add(Contexts);
        this.add(GoInto);
    }

    public static void main(String[]args){
        new Welcomes();
    }

}