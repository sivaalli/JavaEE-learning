package cm.source;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CallableStatementExample {
	public static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	public static String DB_URL="jdbc:mysql://localhost/student";
	public static String USER="root";
	public static String PASS="administrator";
	public static void main(String[] args){
		java.sql.Connection con = null;
		CallableStatement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			
			con	=DriverManager.getConnection(DB_URL, USER, PASS);
			String sql="Call getEmpName(?,?)";
			stmt=con.prepareCall(sql);
			stmt.setInt(1, 3);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);		
			stmt.execute();
			String empName=stmt.getString(2);
			System.out.println(empName);
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
			
	}
}
