package com.ruixiang.login;

import com.alibaba.fastjson.JSONObject;
import com.ruixiang.moudle.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname: ${NAME}
 * @Description: 类型说明
 * @Data： 2022/1/26 14:54
 * @Created by ruixiang
 */
@WebServlet(name = "Servlet")
public class LoginOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");
        ResultSet resultSet = new ResultSet();

        if (request.getSession().getAttribute("username")!=null){
            String user = request.getSession().getAttribute("username").toString();
            System.out.println("用户"+user+"注销成功");
            resultSet.setstatuecode(200);
            resultSet.setmsg("用户注销成功");
            //清理用户
            request.getSession().invalidate();
        }else {
            resultSet.setstatuecode(500);
            resultSet.setmsg("用户失效，请重新登录");
        }

        String s = JSONObject.toJSONString(resultSet);
        System.out.println(s);
        response.getWriter().append(s);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
