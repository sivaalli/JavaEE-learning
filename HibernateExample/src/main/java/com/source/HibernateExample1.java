package com.source;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class HibernateExample1 {

public static void main(String[] args) {
	
	SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
	Session session = sf.openSession();
	
    Student std = new Student(8,"praneeth", new Date() , "2501 lake road huntsville tx");
    //Student std= (Student)session.get(Student.class, 2);
    //std.setStudentName("manohar");
    
    session.beginTransaction();
    session.save(std);
   // session.update(std);
    //session.delete(std);
    session.getTransaction().commit();
    session.close();
    sf.close();

}
}
