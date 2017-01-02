package com.source;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {

    	SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
    	Session session = sf.openSession();
    	
    	
    	//for updating an employee who belongs to edison
    	//city with name edison is already in DB
    	//if we use new City("Edison") then it creates a new city with name edison
    	/* City city_edison = (City)session.get(City.class, 1); 
    	Employee e1= new Employee("praneeth", city_edison);
    	city_edison.getEmployeeSet().add(e1);    	   
        session.beginTransaction();        
    	session.save(e1);  	
        session.getTransaction().commit();*/
    	
    	//for adding new employees in new city
    	
    	City city_edison = new City("edison");
    	City city_houston = new City("houston");
    	
    	Employee e1= new Employee("test1", city_edison);
    	Employee e2= new Employee("test2", city_houston);
    	
    	city_edison.getEmployeeSet().add(e1);
    	city_houston.getEmployeeSet().add(e2);
    			
    	session.beginTransaction();     
    	
    	session.save(e1); 
    	session.save(e2); 
    	 session.getTransaction().commit();		
        session.close();
        sf.close();
    }
}
