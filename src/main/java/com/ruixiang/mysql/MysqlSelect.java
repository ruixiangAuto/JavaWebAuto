package com.ruixiang.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname: MysqlSelect
 * @Description: 连接数据库进行查询
 * @Data： 2022/1/25 19:25
 * @Created by ruixiang
 */
public class MysqlSelect {
    public static void main(String[] args) {
    }


    public static boolean singleselect(String user, String password) {
        Connection creatcon = MysqlUtils.creatcon();

        try {
            //建立一个查询的对象,使用存储过程进行查询
            CallableStatement callableStatement = creatcon.prepareCall("");
            //对存储过程进行赋值
            callableStatement.setString(0,user);
            callableStatement.setString("pwd",password);
            //指向性查询
            ResultSet resultSet = callableStatement.executeQuery();

            //获取表头行的信息
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取行数
            int columnCount = metaData.getColumnCount();
            Map<String,String> map =new HashMap<>();
            while (resultSet!=null &&resultSet.next()){
                for (int i = 1; i < columnCount; i++) {
                    map.put(metaData.getColumnName(i),resultSet.getString(i));

                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Map<String ,String>> multipleselect(String sql) {
        Connection creatcon = MysqlUtils.creatcon();

        try {
//            创建一个查询的对象
            Statement statement = creatcon.createStatement();
            //执行查询语句
            ResultSet resultSet = statement.executeQuery(sql);

            //5、处理结果集，拿出查询的结果来。
            //获取表头行的信息
            ResultSetMetaData metaData = resultSet.getMetaData();

            //获取行数
            int columnCount = metaData.getColumnCount();
            Map<String,String> map =new HashMap<>();
            List<Map<String,String>> list = new ArrayList<>();
            while (resultSet!=null &&resultSet.next()){
                for (int i = 1; i < columnCount; i++) {
                    map.put(metaData.getColumnName(i),resultSet.getString(i));
                }
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static boolean resultselect(String sql) {
        Connection creatcon = MysqlUtils.creatcon();

        try {

//            创建一个查询的对象
            Statement statement = creatcon.createStatement();
            //执行查询语句
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet!=null &&resultSet.next()){
                    return true;
                }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean loginselect(String sql) {
        Connection creatcon = MysqlUtils.creatcon();

        try {

//            创建一个查询的对象
            Statement statement = creatcon.createStatement();
            //执行查询语句
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet!=null &&resultSet.next()){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
