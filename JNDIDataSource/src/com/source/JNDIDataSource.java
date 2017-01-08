package com.source;

import java.util.Properties;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*A factory for connections to the physical data source that this DataSource object represents.
An alternative to the DriverManager facility, a DataSource object is the preferred means of getting a connection.
An object that implements the DataSource interface will typically be registered with a naming service based on the JavaTM Naming and Directory (JNDI) API.*/
public class JNDIDataSource {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				
				Properties prop=new Properties();
				prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
				prop.put(Context.PROVIDER_URL, "t3://Sivapraneeth:7001");
				prop.put("java.naming.security.principal", "weblogic");
				prop.put("java.naming.security.credentials", "administrator1");
				//mapping is done between String,DataSource(MySQL connection)
				//"SQLDATASOURCE"--DataSource
				Context ctx=new InitialContext(prop);
				
				DataSource ds=(DataSource)ctx.lookup("SQLDATASOURCE");
				Connection con=ds.getConnection();
				Statement stmt=con.createStatement();
				String sql="select * from student";
				ResultSet rs=stmt.executeQuery(sql);
				
				while(rs.next()){
					System.out.print(rs.getInt(1)+ " ");
					System.out.print(rs.getString(2)+" ");
					System.out.print(rs.getString(3));
					System.out.println();
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}

}
