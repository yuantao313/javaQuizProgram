package com.company.window;

import com.company.resultWindow;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

//类 判断题窗口 继承自 窗口
public class judgementWindow extends window {
    private JRadioButton t = new JRadioButton("T 正确");
    private JRadioButton f = new JRadioButton("F 错误");
    private ButtonGroup bg = new ButtonGroup();

    public judgementWindow(String id, String name) throws IOException {
        super(2, id, name);

        //四个选项的设置

        bg.add(t);
        bg.add(f);

        panel.add(t);
        panel.add(f);
        t.setBounds(20, 220, 100, 20);
        f.setBounds(160, 220, 100, 20);


    }

    @Override
    public void nextQuestion() {
        /** 1. 判题加分
         *  2. 清空选项 & 更新题号
         */
        String ans = null;
        if (bg.isSelected(t.getModel())) {
            ans = "T";
        } else if (bg.isSelected(f.getModel())) {
            ans = "F";
        } else {
            return;
        }
        point = point + prs.get(pNumber - 1).point(ans);

        bg.clearSelection();


        if (pNumber == 10) {
            new resultWindow(point);
            return;
        } else {
            pNumber++;
            pNumberLabel.setText(String.valueOf(pNumber));
            // 更新题目内容
            pText.setText(prs.get(pNumber - 1).get_text());
            if(pNumber==10){
                pNextQuestion.setText("交卷");
            }
        }
    }

}
