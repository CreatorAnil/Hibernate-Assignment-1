package driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import entity.Employee;
import entity.Project;

public class Read {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int theProjectId=1;
			session.beginTransaction();

			Project tempProject = session.get(Project.class,theProjectId);
			
			System.out.println("Project is: "+tempProject);
			System.out.println("Assigned Employee are: "+tempProject.getEmployees());
			
			System.out.println();
			
			int theEmployeeId=3;
			Employee tempEmployee=session.get(Employee.class,theEmployeeId);
			System.out.println("Employee is: "+tempEmployee);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}
