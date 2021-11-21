package com.company;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class resultWindow {
    public resultWindow(int point){
        JFrame frame = new JFrame("考试结果");
        Container cont = frame.getContentPane();
        JPanel panel = new JPanel();
        panel.add(new JLabel("考试成绩："+new String(String.valueOf(point))));
        cont.add(panel);
        //叉
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent obj){
                System.exit(1);
            }
        }
        );
        frame.setSize(400,100);
        frame.setVisible(true);
    }
}
