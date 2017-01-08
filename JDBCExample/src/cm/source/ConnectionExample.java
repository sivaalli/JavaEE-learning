package cm.source;

import java.sql.*;
// we can use DataSource instead of using DriverManager and we can avoid passing all below strings
public class ConnectionExample {
	public static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static String DB_URL="jdbc:mysql://localhost:3306/student";
	public static String USER="root";
	public static String PASS="administrator";
	public static void main(String[] args){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
			
			con	=DriverManager.getConnection(DB_URL, USER, PASS);
			stmt=con.createStatement();
			String sql="SELECT * FROM student_details";
			rs=stmt.executeQuery(sql);
			
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
