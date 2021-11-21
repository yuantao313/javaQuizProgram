package com.company.window;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import com.company.resultWindow;

//类 选择题窗口 继承自 窗口
public class multipleChoiceWindow extends window {
    private JRadioButton a = new JRadioButton("A");
    private JRadioButton b = new JRadioButton("B");
    private JRadioButton c = new JRadioButton("C");
    private JRadioButton d = new JRadioButton("D");
    private ButtonGroup bg = new ButtonGroup();

    public multipleChoiceWindow(String name, String id) throws IOException {
        super(1, id, name);

        //四个选项的设置

        bg.add(a);
        bg.add(b);
        bg.add(c);
        bg.add(d);
        this.panel.add(this.a);
        this.panel.add(this.b);
        this.panel.add(this.c);
        this.panel.add(this.d);
        a.setBounds(20, 220, 50, 20);
        b.setBounds(90, 220, 50, 20);
        c.setBounds(160, 220, 50, 20);
        d.setBounds(230, 220, 50, 20);


    }

    @Override
    public void nextQuestion() {
        /** 1. 判题加分
         *  2. 清空选项 & 更新题号
         */
        String ans = null;
        if (bg.isSelected(a.getModel())) {
            ans = "A";
        } else if (bg.isSelected(b.getModel())) {
            ans = "B";
        } else if (bg.isSelected(c.getModel())) {
            ans = "C";
        } else if (bg.isSelected(d.getModel())) {
            ans = "D";
        } else {
            return;
        }
        //加分
        point = point + prs.get(pNumber - 1).point(ans);

        bg.clearSelection();

        //切换题目

        if (pNumber == 10) {
            new resultWindow(point);
            return;
        } else {
            pNumber++;//更新题号
            pNumberLabel.setText(String.valueOf(pNumber));
            // 更新题目内容
            pText.setText(prs.get(pNumber - 1).get_text());
            if(pNumber==10){
                pNextQuestion.setText("交卷");
            }
        }

    }
}
