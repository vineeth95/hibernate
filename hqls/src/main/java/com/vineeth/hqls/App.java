package com.vineeth.hqls;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
    	//for JPA concepts
    	
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
    	Student s = em.find(Student.class, 1);
    	
    	System.out.println(s);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//for hql concepts
//    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); 
//    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
//       	SessionFactory sf = con.buildSessionFactory(reg);
//       	Session session = sf.openSession();
//        	
//    	session.beginTransaction();
    	

    	//For fetch single unique data
    	
		//    	Query q = session.createQuery("from Student where rollno=10");
		//    	Student stud = (Student) q.uniqueResult();
		//    	System.out.println(stud);
  	
    	
    	//for fetching group of data 
		//    	Query q = session.createQuery("from Student where marks>50");   	
		//    	List<Student> students = q.list();
		//    	
		//    	for(Student stud:students)
		//    	{
		//    		System.out.println(stud);
		//    	}

    	
    	
    	
    	
    	
    	
    	
    	
    	//These code are for inserting 50 entries in db
//  Random r = new Random();
//  
//    	for(int i = 1;i<=50;i++)
//    	{
//    		Student s = new Student();
//    		s.setRollno(i);
//    		s.setName("name"+i);
//    		s.setMarks(r.nextInt(100));
//    		session.save(s);
//    	}
    	
//    	session.getTransaction().commit();
    
    }
}
