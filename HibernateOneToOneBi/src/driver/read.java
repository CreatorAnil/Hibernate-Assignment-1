package driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Student;

public class read {
	public static void main(String[] args) {
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
			.addAnnotatedClass(Address.class).buildSessionFactory();
	
	Session session = factory.getCurrentSession();	
	
	try {
		session.beginTransaction();
		
		int tempAddressId =1;
		
		Address tempAddress = session.get(Address.class, tempAddressId);
		
		System.out.println("Address Details: "+tempAddress);
		
		System.out.println("Associated Student: "+ tempAddress.getStudent());
		
		session.getTransaction().commit();
		
	}finally{
		
		factory.close();
	}
}
}

