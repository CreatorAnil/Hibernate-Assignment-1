package driver;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Query {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Teacher> theTeachers = session.createQuery("from Teacher").list();

			displayTeachers(theTeachers);

			System.out.println("Teachers with lastName choudhari");
			theTeachers = session.createQuery("from Teacher t where t.l_Name='choudhari'").list();

			displayTeachers(theTeachers);
			
			System.out.println("Teachers with gmail.com in their email ");

			theTeachers = session.createQuery("from Teacher t where t.email like '%gmail.com'").list();
			displayTeachers(theTeachers);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayTeachers(List<Teacher> theTeachers) {
		for (Teacher tempTeacher : theTeachers) {
			System.out.println(tempTeacher);
		}
	}
}
