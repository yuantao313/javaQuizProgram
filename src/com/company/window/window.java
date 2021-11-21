package com.company.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.company.problem;
import com.company.problemReader;

//这个类是三种题目的父类

abstract class window {
    protected JFrame frame = new JFrame();//frame
    protected JPanel panel = new JPanel();//panel
    protected Container cont = new Container();//container

    protected JLabel pId = new JLabel();
    protected JLabel pName = new JLabel();
    protected JTextArea pText = new JTextArea();
    protected JButton pNextQuestion = new JButton();//下一题按钮
    protected JLabel pNumberLabel = new JLabel();
    protected int pNumber = 1;
    protected int point = 0;

    protected List<problem> prs = new ArrayList<problem>();

    window(int type, String uId, String uName) throws IOException {
        this.cont = this.frame.getContentPane();
        String title;
        switch (type) {
            case 1:
                title = "选择题";
                break;
            case 2:
                title = "判断题";
                break;
            case 3:
                title = "填空题";
                break;
            default:
                title = "默认标题";
                break;
        }

        //1. 赋值
        this.frame.setTitle(title);
        this.pId.setText("学号： " + uId);
        this.pName.setText("姓名： " + uName);
        this.pNextQuestion.setText("下一题");
        this.pText.setLineWrap(true);

        //2. 设定位置
        this.pId.setBounds(20, 20, 80, 20);
        this.pName.setBounds(200, 20, 80, 20);
        this.pNextQuestion.setBounds(20, 260, 360, 50);
        this.pText.setBounds(20, 100, 360, 100);
        this.pNumberLabel.setBounds(20,60,80,20);

        //3. 添加到布局
        this.panel.setLayout(null);
        this.panel.add(pId);
        this.panel.add(pName);
        this.panel.add(pNextQuestion);
        this.panel.add(pText);
        this.panel.add(pNumberLabel);

        //4. 显示
        this.frame.setSize(400, 350);
        this.cont.add(this.panel);
        this.frame.setResizable(false);
        this.frame.setVisible(true);

        //5. 读取题目
        this.prs = problemReader.Read(type);

        //6. 加载第一题
        this.pNumberLabel.setText(String.valueOf(this.pNumber));
        this.pText.setText(this.prs.get(0).get_text());

        //关闭窗口
        this.frame.addWindowListener(new WindowAdapter() {
                                         public void windowClosing(WindowEvent obj) {
                                             System.exit(1);
                                         }
                                     }
        );

        //下一题按钮的监听器
        this.pNextQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
            }
        });

    }

    abstract void nextQuestion();

}
