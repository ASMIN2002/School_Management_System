package com.asmin;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	Connection connection;
	public Conn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?allowPublicKeyRetrieval=true&useSSL=false","root","Asmin@2002");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
