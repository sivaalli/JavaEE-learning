package com.source.HibernateOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
    	Session session = sf.openSession();
    	
    	Student student1=new Student("super102");
    	StudentDetails studentDetails = new StudentDetails("111-111-1112", student1);
    	student1.setStudent_details(studentDetails);
        //Student std= (Student)session.get(Student.class, 2);
        //std.setStudentName("manohar");
        
        session.beginTransaction();
        
       // session.save(std);
       // session.update(std);
    	session.save(student1);
    	
        //session.delete(std);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
