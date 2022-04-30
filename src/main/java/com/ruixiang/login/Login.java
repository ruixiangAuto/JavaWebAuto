package com.ruixiang.login;

import com.ruixiang.moudle.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.alibaba.fastjson.JSONObject;
import com.ruixiang.mysql.MysqlSelect;

/**
 * @Classname: ${NAME}
 * @Description: 根据不同的情况返回不同的返回值
 * @Data： 2022/1/25 14:03
 * @Created by ruixiang
 */
@WebServlet(name ="Login")
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //定义请求头
        request.setCharacterEncoding("UTF-8");

        //定义响应头
        response.setContentType("text/plain;charset=utf-8");

        //定义登录信息;


        ResultSet resultSet =new ResultSet();

        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        if (user!= null&&pwd!=null){
            boolean loginselect = MysqlSelect.loginselect("select * from userinfo where username='" +user+ "' and pwd ='"+pwd+ "'");

            //数据库有查询的返回值
            if (loginselect==true){

                resultSet.setmsg("用户名正确登录成功");
                resultSet.setstatuecode(200);
                //获取本次请求的sessionid
                HttpSession session = request.getSession();

                //记录一下登录信息
                session.setAttribute("username",user);
                session.setMaxInactiveInterval(1000);
//                创建一个cookes并返回
                Cookie cookieid = new Cookie("SESSIONID", session.getId());
                cookieid.setMaxAge(1000);
                response.addCookie(cookieid);
            }else {
                resultSet.setmsg("用户名或者密码不正确，登录失败");
                resultSet.setstatuecode(500);
            }
        }else {
            resultSet.setmsg("用户名或密码不能为空请重新输入");
            resultSet.setstatuecode(0);
        }
        //查询出的结果变成一个对象，并返回给前端
        String result = JSONObject.toJSONString(resultSet);
        response.getWriter().append(result);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
