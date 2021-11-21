package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.company.problem;

//题目读取类
public class problemReader {
    public static List<problem> Read(int type) throws IOException {
        String fileName;
        String encoding = "UTF-8";
        List<problem> prs = new ArrayList<problem>();
        //根据选项判断打开题目文件的位置
        switch (type) {
            case 1:
                fileName = "./choice.txt";
                break;
            case 2:
                fileName = "./judge.txt";
                break;
            case 3:
                fileName = "./fill.txt";
                break;
            default:
                fileName = null;
                break;
        }
        File file = new File(fileName);
        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader br = new BufferedReader(read);
            for (int i = 0; i < 10; i++) {//读10个题
                String pText = br.readLine();
                String pAnswer = br.readLine();
                prs.add(new problem(pText, pAnswer));
            }
        }
        return prs;
    }
}
