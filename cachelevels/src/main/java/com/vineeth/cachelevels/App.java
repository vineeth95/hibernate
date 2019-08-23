package com.vineeth.cachelevels;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
        accounts ac = new accounts();
        
        Configuration con = new Configuration().configure().addAnnotatedClass(accounts.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        Query q1 = session1.createQuery("from accounts where id = 2");
        q1.setCacheable(true);
        
//      ac = (accounts) session1.get(accounts.class,1); //data present in 1st level so no database connection is made
//      
//      System.out.println(ac);
        
       // ac = (accounts) session1.get(accounts.class,1); //checks for 1st level cache, if does'nt exist then hit database 
        
        ac = (accounts)q1.uniqueResult();
        System.out.println(ac); 
        
        session1.getTransaction().commit();
        session1.close();
    	
      
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        Query q2 = session2.createQuery("from accounts where id = 2");
        q2.setCacheable(true);
        
        ac = (accounts)q2.uniqueResult();
        System.out.println(ac); 
        
       // ac = (accounts) session2.get(accounts.class,1); 
        
        session2.getTransaction().commit();
        session2.close();
    }
}
