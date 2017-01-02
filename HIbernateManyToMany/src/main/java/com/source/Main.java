package com.source;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {
	
	public static void  main(String[] args){
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
		
		Course math = new Course("math");
		Course science = new Course("science");
		
		Student s1 = new Student("shiva");
		Student s3 = new Student("praneeth");
		Student s2 = new Student("alli");
		
		math.getStudentSet().add(s1);
		math.getStudentSet().add(s2);
		science.getStudentSet().add(s3);
		
		s1.getCourseSet().add(math);
		s2.getCourseSet().add(math);
		s3.getCourseSet().add(science);
		
		session.beginTransaction();     
    	
    	session.save(s1); 
    	session.save(s2);
    	session.save(s3);
    	
    	session.getTransaction().commit();		
        session.close();
        sf.close();
	}
}
