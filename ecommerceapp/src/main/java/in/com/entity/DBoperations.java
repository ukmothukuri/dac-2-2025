package in.com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBoperations 
{
	private SessionFactory sfactory;
	
	public void insertStudentDetails(Student student)
	{
		Transaction transcation= null;
		sfactory = HibernateUtil.getSessionFactory();
		Session session = sfactory.openSession();
		
		transcation = session.beginTransaction();
		
		session.persist(student);
		
		transcation.commit();
			
	}
	
	public void getStudentDetails(int rollnumber) {
		
	}
	
	public void getAllStudentDetails() {
		
	}

}
