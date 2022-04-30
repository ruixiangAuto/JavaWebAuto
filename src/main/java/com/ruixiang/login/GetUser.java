package com.ruixiang.login;

import com.alibaba.fastjson.JSONObject;
import com.ruixiang.moudle.UserInfo;
import com.ruixiang.mysql.MysqlSelect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname: ${NAME}
 * @Description: 获取用户信息
 * @Data： 2022/1/26 15:06
 * @Created by ruixiang
 */
@WebServlet(name = "GetUser")
public class GetUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义请求头
        request.setCharacterEncoding("UTF-8");

        //定义响应头
        response.setContentType("text/plain;charset=utf-8");

        UserInfo userInfo = new UserInfo();

        HttpSession session = request.getSession();
        if (session.getAttribute("username")!=null){
            List<Map<String,String>> list = MysqlSelect.multipleselect("select * from userinfo where username='" + session.getAttribute("username") + "'");
            Map<String,String> map = list.get(0);
            userInfo.setUserId(map.get("id"));
            userInfo.setNickname(map.get("nickname"));
            userInfo.setDescription(map.get("describe"));
            userInfo.setStatusCode("200");
            userInfo.setMsg("用户信息查询成功");
            System.out.println("y=用户信息查询成功");
        }else {
            userInfo.setStatusCode("500");
            userInfo.setMsg("登录失效请重新登录");
        }

        String s = JSONObject.toJSONString(userInfo);
        response.getWriter().append(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //定义请求头
        request.setCharacterEncoding("UTF-8");

        //定义响应头
        response.setContentType("text/plain;charset=utf-8");

        UserInfo userInfo = new UserInfo();

        HttpSession session = request.getSession();
        if (session.getAttribute("username")!=null){
            List<Map<String,String>> list = MysqlSelect.multipleselect("select * from userinfo where username='" + session.getAttribute("username") + "'");
            Map<String,String> map = list.get(0);
            userInfo.setUserId(map.get("id"));
            userInfo.setNickname(map.get("nickname"));
            userInfo.setDescription(map.get("describe"));
            userInfo.setStatusCode("200");
            userInfo.setMsg("用户信息查询成功");
            System.out.println("y=用户信息查询成功");
        }else {
            userInfo.setStatusCode("500");
            userInfo.setMsg("登录失效请重新登录");
        }

        String s = JSONObject.toJSONString(userInfo);
        response.getWriter().append(s);

    }
}
