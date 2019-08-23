// This Code contains creating and updating tables through hibernate and fetching data from DB
//Also includes Embeddable concept

package com.vineeth.hiberday1;

import java.security.Provider.Service;

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
    	Fullname fn = new Fullname();
    	fn.setFname("vineeth");
    	fn.setLname("bentley");
    	
    	//these are for insert data in Database
    	
       useraccounts obj = new useraccounts(); //works even if we specify obj = null 
       obj.setUserid(1);
       obj.setUsername(fn); //using the full name object
       obj.setPassword("vb123");
       
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(useraccounts.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	 session.save(obj); //this is for storing data
   
    	 //obj = (useraccounts)session.get(useraccounts.class,2); //for fetching data
    	 tx.commit();
    	
    	//for fetching data from database
    	
    	System.out.println(obj); //print that fetched data
    }
}
