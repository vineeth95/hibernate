package com.vineeth.maps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	
    	//creating 2 objects 
    	Laptop laptop = new Laptop();
    	
    	
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	
    	Student s = new Student();
    	s.setMarks(50);
    	s.setName("vineeth");
    	s.setRollno(1);
    	s.getLaptop().add(laptop);
    	
    	laptop.getStudent().add(s);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class); //adding 2 class name

    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

        	SessionFactory sf = con.buildSessionFactory(reg);
        	Session session = sf.openSession();
        	
    	session.beginTransaction();    	//used without transaction object
    	
    	session.save(laptop);
    	
    	
    	session.save(s);
    	
    	session.getTransaction().commit(); //used alternative of transaction object
    	
    }
}
