package com.example.demo.serviceImpl;


import com.example.demo.service.ConnectKylinService;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

@Service("ConnectKylinService")
public class ConnectKylinServiceimpl implements ConnectKylinService {

    public static String host="localhost";
    public static String port="7070";
    public static String userName="ADMIN";
    public static String password="KYLIN";

    /**
     *
     * @param sql   查询的语句
     * @param projectName   kylin内工程的名字
     * @return
     * @throws Exception
     */
    public ResultSet queryKylin(String sql,String projectName) throws Exception {
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

        return resultSet;
    }

    @Override
    public String query(String sql) throws Exception {
        System.out.println("damn");
        ResultSet resultSet = queryKylin(sql , "CSGO");
        String i = "";
        while(resultSet.next()) {
            i += resultSet.getString(1) + " ";
            System.out.println(i);
        }
        return i;
    }
}
