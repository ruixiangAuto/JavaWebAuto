package com.ruixiang.mysql;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Classname: MysqlUtils
 * @Description: 驱动封装
 * @Data： 2022/1/26 11:00
 * @Created by ruixiang
 */
public class MysqlUtils {
    static Connection connection;
    public static Connection creatcon() {
        try {
            //文件创建一个流的对象
            InputStream resourceAsStream = MysqlUtils.class.getResourceAsStream("/mysql.properties");

//            创建一个文件的对象
            Properties properties = new Properties();
//            读取流文件
            properties.load(resourceAsStream);
//            查询出来结果并赋值
            String mysqlurl = properties.getProperty("mysqlurl");
            String mysqluser = properties.getProperty("mysqluser");
            String mysqlpwd = properties.getProperty("mysqlpwd");

//            创建连接驱动
            Class.forName("com.mysql.jdbc.Driver");

//            连接数据库
            connection = DriverManager.getConnection(mysqlurl, mysqluser, mysqlpwd);

            System.out.println("创建连接成功");
            return connection;
        } catch (Exception e) {
            System.out.println("创建连接失败");
            return null;
        }
    }
}
