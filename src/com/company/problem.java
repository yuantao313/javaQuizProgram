package com.company;

public class problem {
    private String text;//题目内容
    private String answer;//题目答案
    problem(){
        this.text=null;
        this.answer=null;
    }
    problem(String text, String answer){
        this.text=text;
        this.answer=answer;
    }
    public String get_text(){//getter
        return text;
    }
    public int point(String answer){//答案是否正确
        if(this.answer.equals(answer)){
            return 10;
        }else{
            return 0;
        }
    }
}
