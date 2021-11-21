package com.company.window;

import com.company.resultWindow;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

//类 填空题窗口 继承自 窗口
public class fillWindow extends window {
    private JTextField pFill = new JTextField();

    public fillWindow(String id, String name) throws IOException {
        super(3, id, name);
        JLabel bFill = new JLabel("答案：");
        bFill.setBounds(20, 220, 50, 20);
        pFill.setBounds(70, 220, 290, 20);
        this.panel.add(bFill);
        this.panel.add(pFill);


    }

    @Override
    public void nextQuestion() {
        /** 1. 判题加分
         *  2. 清空选项 & 更新题号
         */

        this.point += this.prs.get(this.pNumber - 1).point(this.pFill.getText());

        this.pFill.setText("");


        if (pNumber == 10) {
            new resultWindow(this.point);
            return;
        } else {
            pNumber++;
            this.pNumberLabel.setText(String.valueOf(this.pNumber));
            // 更新题目内容
            this.pText.setText(this.prs.get(pNumber - 1).get_text());
            if(pNumber==10){
                pNextQuestion.setText("交卷");
            }
        }
    }
}
