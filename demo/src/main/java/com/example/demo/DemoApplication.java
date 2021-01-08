package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {

	public static String host="localhost";
	public static String port="7070";
	public static String userName="ADMIN";
	public static String password="KYLIN";

	public static ResultSet queryKylin1(String sql, String projectName) throws Exception {
		// 加载Kylin的JDBC驱动程序
		Driver driver = (Driver) Class.forName("org.apache.kylin.jdbc.Driver").newInstance();
		// 配置登录Kylin的用户名和密码
//		Properties info= new Properties();
//		info.put("user",userName);
//		info.put("password",password);
//		// 连接Kylin服务
		String connectStr="jdbc:kylin://"+host+":"+port+"/"+projectName;
//		Connection conn= driver.connect(connectStr, info);
//		Statement state= conn.createStatement();
//		System.out.println(projectName+"===="+sql);
//		ResultSet resultSet =state.executeQuery(sql);
//		while(resultSet.next()) {
//			String i=resultSet.getString(1);
//			System.out.println(i);
//		}
//		return  resultSet;
		Connection connection = DriverManager.getConnection(connectStr, userName, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
//		while(resultSet.next()) {
//			String i=resultSet.getString(2);
//			System.out.println(i);
//		}
		return resultSet;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);

//		queryKylin1("select * from lvl_base inner join lvl_base_hits on steam=steamID;", "CSGO");
	}

}
