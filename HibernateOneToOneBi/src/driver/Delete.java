package driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Student;

public class Delete {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int theAddressId=1;
			
			session.beginTransaction();
			
			Address tempAddress = session.get(Address.class, theAddressId);
			
			if(tempAddress!=null) {
				System.out.println("Deleting: "+tempAddress);
				
				session.delete(tempAddress);
				
				session.getTransaction().commit();
			}
		}finally {
			session.close();
		}
	}

}
