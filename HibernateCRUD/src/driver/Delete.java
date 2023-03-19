package driver;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Delete {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			int teacherId = 1;

			session.beginTransaction();
			System.out.println("getting teacher with id :" + teacherId);

			Teacher tempTeacher = session.get(Teacher.class, teacherId);

			System.out.println("delete teacher--");
			session.delete(tempTeacher);

			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("delete teacher with id = 2");
			session.createQuery("delete from Teacher where id = 2 ").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
