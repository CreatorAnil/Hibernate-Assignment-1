package driver;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;


public class Delete {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int theCourseId=1;
			session.beginTransaction();
			Course tempCourse = session.get(Course.class,theCourseId);
			if(tempCourse!=null) {
				System.out.println("Deleting : "+ tempCourse);
				session.delete(tempCourse);
			}
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}

