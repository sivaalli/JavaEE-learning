package com.shiva.jndi;

import java.util.*;

import javax.naming.*;

import com.shiva.jndi.Student;

public class JNDIExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties prop=new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
			//check where weblogic server is running and give the same address below
			//in this case i have created weblogic doamin called "base_domain" 
			//and in oracle folder go to users and then base_domain and start server
			//to check if server is running run admin server console
			prop.put(Context.PROVIDER_URL, "t3://Sivapraneeth:7001");
			prop.put("java.naming.security.principal", "weblogic");
			prop.put("java.naming.security.credentials", "administrator1");
			
			Context ctx=new InitialContext(prop);
			/*Student std=new Student("shiva", "S001", "A", "23 williams road,NJ", 9);
			ctx.bind("StudentObj", std);*/
			Student std=(Student) ctx.lookup("StudentObj");
			System.out.println(std.name);
			System.out.println(std.address);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
