package driver;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Employee;
import entity.Project;

public class Insert {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {			
			session.beginTransaction();

			Employee tempEmployee1 = new Employee("Rahul", "Choudhari", "Choudhari@rp.com");
			
			Employee tempEmployee2 = new Employee("Amol", "Choudhari", "Choudhari@ap.com");
			
			Project project1 = new Project("BTG");
			Project project2 = new Project("EGG");
			
			session.save(project1);
			session.save(project2);		
			
			Set<Project> projectList1=new HashSet<>();
			projectList1.add(project1);
			projectList1.add(project2);
			
			tempEmployee1.setProject(projectList1);
			

			session.save(tempEmployee1);
			
			Set<Project> projectList2=new HashSet<>();
			projectList2.add(project1);
			
			tempEmployee2.setProject(projectList2);
			session.save(tempEmployee2);
		
			session.getTransaction().commit();
			
			System.out.println("Added employee and project");

		} finally {
			factory.close();
		}
	}
}
