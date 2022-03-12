import java.sql.*;
public class UserDAO {
	CommonDAO commonDAO = CommonDAO.getInstance();
	public String doLogin(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = commonDAO.createConnection();
			//stmt = con.createStatement();
			pstmt = con.prepareStatement("select userid from users where userid=? and password=? and pincode=?");
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, new String(userDTO.getPassword()));
			pstmt.setInt(3, Integer.parseInt(userDTO.getPincode()));
			rs = pstmt.executeQuery();
//			 rs = stmt.executeQuery("select userid from users where"
//					+ " userid ='"+userDTO.getUserid()+"' and password ='"
//					 +new String(userDTO.getPassword())+"'"+" and pincode="+userDTO.getPincode());
		
			if(rs.next()) {
				return "Welcome "+rs.getString("userid");
		}
		else {
			return "Invalid Userid or Password";
		}
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
//			if(stmt!=null) {
//				stmt.close();
//			}
			if(con!=null) {
			con.close();
			}
		}
		
	}
	
	public String register(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
		 con = commonDAO.createConnection();
		 stmt = con.createStatement(); // Query
		// insert into users (userid, password) values ('amit','amit12',111);
		int count = stmt.executeUpdate("insert into users (userid, password,pincode) "
				+ "values('"+userDTO.getUserid()+"','"+new String(userDTO.getPassword())+"',"+
				userDTO.getPincode()+")");
		if(count>0) {
			return "Record Added ";
		}
		else {
			return "Record Not Added ";
		}
		}
		finally {
		if(stmt!=null) {	
		stmt.close();
		}
		if(con!=null) {
		con.close();
		}
		}
	}
}
