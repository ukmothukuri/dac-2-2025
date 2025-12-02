package in.com.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	public static SessionFactory sfactory;
	
	static {
        try {
        	// loads hibernate.cfg.xml
            Configuration configuration = new Configuration().configure(); 
            sfactory = configuration.buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sfactory;
    }
}
