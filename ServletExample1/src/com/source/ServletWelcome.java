package com.source;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWelcome extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServletWelcome(){
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name = request.getParameter("name");
		String email =  request.getParameter("email");
		String message = null;
		GregorianCalendar calender=new GregorianCalendar();
		if(calender.get(Calendar.AM_PM) == Calendar.AM){
			message = "Good Morning";
		}else{
			message = "Good Evening";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> "+message+"</h1>");
		out.println("<p> Thanks for registering "+name+"with your email id:"+email+"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
