package driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Student;

public class Insert {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent = new Student("amol","choudhari","choudariap@gmail.com");
			Address tempAddress = new Address("Maharashtra","Omerga");
			
			tempStudent.setAddress(tempAddress);
			
			session.beginTransaction();
			session.save(tempStudent);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
