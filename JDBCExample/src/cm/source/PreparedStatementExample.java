package cm.source;

import java.sql.*;

//In this a plan is created after prepareStatement function call. Then it executes the
//same plant when the statement isn executed everytime

public class PreparedStatementExample {
	public static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static String DB_URL="jdbc:mysql://localhost/student";
	public static String USER="root";
	public static String PASS="administrator";
	public static void main(String[] args){
		java.sql.Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			
			con	=DriverManager.getConnection(DB_URL, USER, PASS);
			String sql="SELECT * FROM student WHERE id=?";
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, 2);
			rs=stmt.executeQuery();
	
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
			
	}

}
