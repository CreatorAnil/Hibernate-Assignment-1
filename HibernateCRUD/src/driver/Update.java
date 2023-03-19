package driver;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;

public class Update {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int teacherId = 3;

			session.beginTransaction();
			System.out.println("getting teacher with id :" + teacherId);

			Teacher tempTeacher = session.get(Teacher.class, teacherId);
			System.out.println("updating teacher--");
			tempTeacher.setF_Name("sunil");

			session.getTransaction().commit();
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("update email for all teachers");
			session.createQuery("update Teacher set email = 'choudharisp@gmail.com' where f_Name='sunil'").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
