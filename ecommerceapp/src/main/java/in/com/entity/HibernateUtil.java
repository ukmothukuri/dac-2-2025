package in.com.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sfactory;
	
	public static SessionFactory getSessionFactory() 
	{
		try {
			sfactory = new Configuration().buildSessionFactory();
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return sfactory;
	}
}
