package com.source;

import java.io.*;
import java.util.Properties;

public class CarFactoryGenerator {
	public static CarFactoryGenerator cfg=null;
	public static CarFactoryGenerator getCarFactoryGenerator(){
		if(cfg==null){
			 cfg=new CarFactoryGenerator();
		}
		return cfg;
	}
	public CarFactory getCarFactory(){
		CarFactory cf=null;
		try {
			String filePath="config.txt";
			FileInputStream inputStream=new FileInputStream(filePath);
			Properties prop=new Properties();			
			prop.load(inputStream);
			String factory=prop.getProperty("carFactory");		
			Class c=Class.forName(factory); 
			cf=(CarFactory)c.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cf;
	}
}
