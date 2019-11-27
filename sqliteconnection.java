package login_page;
import java.sql.*;
import javax.swing.*;
public class sqliteconnection {
	Connection conn=null;
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:‪‪‪userdb.db");
	//		JOptionPane.showMessageDialog(null,"connection successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	public static void main(String[] args)throws SQLException {
		Connection connection = dbConnector();
		
		connection.close();
		
		
	}

}
