package com.ruixiang.moudle;

/**
 * @Classname: ResultSet
 * @Description: 对于接口返回值的定义
 * @Data： 2022/1/25 18:22
 * @Created by ruixiang
 */
public class ResultSet {
    private String msg;
    private int statuecode;

    public String getmsg(){
        return msg;
    }

    public void setmsg(String msg){
        this.msg=msg;
    }

    public int getstatuecode(){
        return statuecode;
    }

    public void setstatuecode(int statuecode){
        this.statuecode=statuecode;
    }

}
