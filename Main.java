package main;

import java.sql.*;

public class Main {
	public static void main(String args[])
	{	
		//database configuration parameters
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "mysql_test";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "backbase";
		
		try
		{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName, userName, password);
			
			//print this if connection to the database was successful;
			System.out.println("Connection was made successfully");
			
			Statement st = conn.createStatement();
			
			//insert a value here
			//values to insert
			int value_phone = 12345;
			String value_name = "Jan3";  
			try
			{
				st.executeUpdate("INSERT INTO sql_table VALUES ('" + value_phone + "','" + value_name + "');");
				
				//notify if insert was successful
				System.out.println("Value successfully inserted into table");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				//notify if not successful
				System.out.println("Could not insert value into table");
			}
			
			
			//call a value from the database
			try
			{
				ResultSet res = st.executeQuery("SELECT * FROM sql_table;");
				
				while(res.next()) {
					int phone = res.getInt("phone_number");
					
					String name = res.getString("name");
					
					//notify if successful
					System.out.println("Succesfully retrieved value from database");
					System.out.println("Phone retrieved: " + phone + " name retrieved: " + name);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				//notify if unsuccessful
				System.out.println("Could not retrieve the value from the Database");
			}
			
			//close connection here
			try
			{
				conn.close();
				
				//notify closed connection
				System.out.println("Connection to database was closed");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				//notify unable to close the connection
				System.out.println("Connection to the database was closed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			//print to the console if connection was unsuccessful
			System.out.println("Conncetion Failed...");
		}
	}
}
