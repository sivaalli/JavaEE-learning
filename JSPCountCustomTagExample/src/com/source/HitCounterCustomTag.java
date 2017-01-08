package com.source;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.glass.ui.GestureSupport;

public class HitCounterCustomTag extends SimpleTagSupport{

	public void doTag() throws IOException{
		JspContext context = getJspContext();
		Integer count = (Integer)context.findAttribute("counter");
		
		if(count==null || count==0){
			count=1;
			context.setAttribute("counter", count, PageContext.APPLICATION_SCOPE);
		}
		else{
			count=(Integer)context.findAttribute("counter");
			count++;			
		}
		context.setAttribute("counter", count, PageContext.APPLICATION_SCOPE);
		System.out.println(count);
	
	}
		
}
