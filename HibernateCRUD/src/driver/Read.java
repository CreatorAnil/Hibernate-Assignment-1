package driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;


public class Read {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Teacher.class)
				                     .buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating new teacher object...");
			Teacher teacher = new Teacher("Anil", "Choudhari", "choudhariap@gmail.com");

			session.beginTransaction();

			System.out.println("saving the teacher ..."); 
			session.save(teacher);

			session.getTransaction().commit();
			
			System.out.println("Done!");

			System.out.println("saved student" + teacher.getId());		

			session=factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Getting student with id"+ teacher.getId());
			
			Teacher tempTeacher = session.get(Teacher.class, teacher.getId());
			
			System.out.println(tempTeacher);
			
			session.getTransaction().commit();
			
			System.out.println("Done ");
		}
		finally {
			factory.close();
		}
	}
}
