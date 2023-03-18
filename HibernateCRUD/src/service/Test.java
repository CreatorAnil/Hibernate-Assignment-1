package service;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Test {
	public static void main(String[] args){
		System.out.println("connected to database");
		SessionFactory factory = null;
		Session session = null;
		
		factory = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();
	System.out.println("created");
	
	Teacher t1 = new  Teacher("rahul","abc","r@g.com");
	Teacher t2 = new  Teacher("amol","abc","am@g.com");
	Teacher t3 = new  Teacher("anil","abc","an@g.com");
	Teacher t4 = new  Teacher("sunil","abc","s@g.com");
	Transaction tx = null;
	
	try {
		session = factory.getCurrentSession();
		tx = session.beginTransaction();
		//insert
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		tx.commit();
		 
		// reading the data 
		Teacher teacher = session.get(Teacher.class, 1);
		System.out.println("teacher "+ teacher);
		
		//update
		teacher.setF_name("Ajay");
		//session.update(teacher);
		session.createQuery("update Teacher set email='aaa@g.com' where f_name='anil'")
		System.out.println("teacher"+teacher);
		tx.commit();
		
		
		//QUery object
		List<Teacher> teachers = session.createQuery("from Teacher").list();
		for(Teacher teacher1:teachers) {
			System.out.println(teacher1);
		}
		tx.commit();
		
		//delete
		Teacher teacher2 = session.get(Teacher.class, 4);
		System.out.println("deleteting.....");
		//session.delete(teacher2);
		session.createQuery("delete from Teacher where email='s@g.com'" ).executeUpdate();
		tx.commit();
		
	}catch(Exception e) {
		//
		System.out.println("error"+e.getMessage());
		
		System.out.println("error");
		e.printStackTrace();
		tx.rollback;
		
	}finally {
		session.close();
	}
		
	}
}
