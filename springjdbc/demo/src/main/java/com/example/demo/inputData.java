package com.example.demo;

import java.sql.*;

public class inputData {
 private static String id;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
	putinfo();
}

public static void putinfo()
{
	String s=id;
	Integer i =new Integer(s);
	String st="insert into user values(?)";
	String str="select * from choice where id=?";
	
	 try (
             Connection conn = DriverManager.getConnection(
           		  "jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                     "myuser", "xxxx");
             
               Statement stmt = conn.createStatement();
             ){
		 
		 PreparedStatement pre=conn.prepareStatement(str); // make it st for entry
		 pre.setInt(1, i);
		ResultSet se= pre.executeQuery();
		se.next();
		id=se.getString("name");
	/*	int d=se.getInt(1);
		Integer i1=new Integer(d);
		id=i1.toString();
		id=id+"yes it worked nigga"; */
	 }
	 catch (Exception e)
	 {
		 e.printStackTrace();
	 }
	
}
}
