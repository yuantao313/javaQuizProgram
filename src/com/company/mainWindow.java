package com.company;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import com.company.window.*;

public class mainWindow implements ItemListener {
    //创建及设置窗口
    private JFrame frame = new JFrame("答题系统");
    private JPanel panel = new JPanel();

    private JRadioButton m = new JRadioButton("选择题");
    private JRadioButton j = new JRadioButton("判断题");
    private JRadioButton f = new JRadioButton("填空题");

    private JButton startBtn=new JButton("开始做题");
    private JTextField userName_f = new JTextField();
    private JTextField userId_f = new JTextField();

    private String choice = new String();
    private Container cont = frame.getContentPane();
    public mainWindow(){
        this.panel.setBorder(BorderFactory.createTitledBorder("输入你的信息"));
        this.panel.setLayout(new GridLayout(6,3));

        this.panel.add(new JLabel());
        this.panel.add(new JLabel("欢迎使用答题系统"));
        this.panel.add(new JLabel());

        this.panel.add(new JLabel("姓名",SwingConstants.RIGHT));
        this.panel.add(userName_f);
        this.panel.add(new JLabel());

        this.panel.add(new JLabel("学号",SwingConstants.RIGHT));
        this.panel.add(userId_f);
        this.panel.add(new JLabel());

        this.panel.add(this.m);
        this.panel.add(this.j);
        this.panel.add(this.f);

        this.panel.add(new JLabel());
        this.panel.add(this.startBtn);
        this.panel.add(new JLabel());

        this.panel.add(new JLabel());
        this.panel.add(new JLabel("秦浚贺制作",SwingConstants.CENTER));
        this.panel.add(new JLabel());
        //单选组
        ButtonGroup rGroup = new ButtonGroup();
        rGroup.add(this.m);
        rGroup.add(this.j);
        rGroup.add(this.f);

        this.cont.add(panel);

        m.addItemListener(this);
        j.addItemListener(this);
        f.addItemListener(this);

        frame.setResizable(false);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    switch(choice){
                        case "m":
                            new multipleChoiceWindow(userName_f.getText(),userId_f.getText());
                            break;
                        case "j":
                            new judgementWindow(userName_f.getText(),userId_f.getText());
                            break;
                        case "f":
                            new fillWindow(userName_f.getText(),userId_f.getText());
                            break;

                    }
                }catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                startBtn.setEnabled(false);
            }
        });
        this.frame.setSize(400,200);
        this.frame.setVisible(true);
        this.frame.addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent obj){
               System.exit(1);
           }
        }
        );

    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == m){
            this.choice="m";
        }else if(e.getSource() == j){
            this.choice="j";
        }else if (e.getSource()==f){
            this.choice="f";
        }
    }
    public void restartBtn(){
        this.startBtn.setEnabled(true);
    }

}
