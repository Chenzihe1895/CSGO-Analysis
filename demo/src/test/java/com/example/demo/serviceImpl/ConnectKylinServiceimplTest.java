package com.example.demo.serviceImpl;

import com.example.demo.service.ConnectKylinService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ConnectKylinServiceimplTest {
    public static String host="localhost";
    public static String port="7070";
    public static String userName="admin";
    public static String password="kylin";

    @Autowired
    private ConnectKylinService connectKylinService;

    @Test
    public ResultSet queryKylin(String sql, String projectName) throws Exception {
        // 加载Kylin的JDBC驱动程序
        Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();
        // 配置登录Kylin的用户名和密码
        Properties info= new Properties();
        info.put("user",userName);
        info.put("password",password);
        // 连接Kylin服务
        String connectStr="jdbc:kylin://"+host+":"+port+"/"+projectName;
        Connection conn= driver.connect(connectStr, info);
        Statement state= conn.createStatement();
        System.out.println(projectName+"===="+sql);
        ResultSet resultSet =state.executeQuery(sql);
        while(resultSet.next()) {
            String i=resultSet.getString(1);
            System.out.println(i);
        }
        return  resultSet;
    }
}