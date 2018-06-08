package sample.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
	public static Connection getConnection(){
		Connection connection= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:8889/gemo","root","root");
			
		}catch (Exception e){
			e.printStackTrace();
		}
		return connection;
	}
}
