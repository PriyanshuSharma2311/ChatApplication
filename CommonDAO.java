import java.sql.*;

public class CommonDAO {
	private static CommonDAO commonDAO; // null
	private CommonDAO() {
		
	}
	public static CommonDAO getInstance() {
		if(commonDAO == null) {
			commonDAO= new CommonDAO();
		}
		return commonDAO; 
	}
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		// Step -1 Load the Driver (Class) / Class Loading
		// com.mysql.jdbc.Driver
		//oracle.jdbc.driver.OracleDriver
		// jdbc:oracle:thin:@localhost:1521:orcl - Oracle Connection URL
		Class.forName("com.mysql.cj.jdbc.Driver"); // Driver Class Path
		// Step-2 Connection Create
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/chatapp","root","Prince@2311");
		return con;
	}

}
