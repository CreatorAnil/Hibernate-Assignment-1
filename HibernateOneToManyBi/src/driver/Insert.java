package driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;

public class Insert {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student tempStudent = new Student("Anil","Choudhari","choudhariap@gmail.com");
			
			Course course1 = new Course("math");
			Course course2 = new Course("eng");
			
			tempStudent.add(course1);
			tempStudent.add(course2);
			
			session.save(tempStudent);
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
			System.out.println("Added student and Course");
		
		}finally {
			session.close();
		}
		
	}

}
