package Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Address;
import entity.Student;

public class Delete {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(Address.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int theStudentId=1;
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, theStudentId);
			
			if(tempStudent!=null) {
				System.out.println("Deleted "+ tempStudent);
				session.delete(tempStudent);
			}
			session.getTransaction().commit();
	
		}finally {
			factory.close();
		}
	}

}
