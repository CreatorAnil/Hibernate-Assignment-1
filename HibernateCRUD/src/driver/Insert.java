package driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Insert {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Teacher.class)
				                     .buildSessionFactory();

		Session session = factory.getCurrentSession();		
		try {

			System.out.println("Creating new teacher object...");
			Teacher teacher1 = new Teacher("Rahul", "Choudhari", "choudharirp@gmail.com");
			Teacher teacher2 = new Teacher("Amol", "choudhari", "choudhariap@gmail.com");

			session.beginTransaction();

			System.out.println("saving the teacher ..."); 
			session.save(teacher1);
			session.save(teacher2);

			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
