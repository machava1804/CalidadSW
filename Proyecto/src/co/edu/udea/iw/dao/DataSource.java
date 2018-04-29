package co.edu.udea.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import co.edu.udea.iw.exception.MyException;

/**
 * Encargada de realizar conexiones a la base de datos
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class DataSource {
	private static DataSource instance = null;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	private DataSource(){
			
		}
	
	public static DataSource getInstance(){
		if(instance == null){
			instance = new DataSource();
		}
		
		return instance;
		
	}
	
	/**
	 * Entrega una sesión activa a la base de datos basadas en la configuración de
	 * hibernate
	 * @return objeto de tipo Session
	 * @throws MyException ocurre cuando hay errores de configuración, me arroja excepciones propias
	 */
	public Session getSession() throws MyException{
		try{
			if(factory == null){
				conf.configure("co/edu/udea/iw/dao/conf.cfg.xml");
				factory = conf.buildSessionFactory();
			}
			
			return factory.openSession();
		}catch(HibernateException e){
			throw new MyException("Ha ocurrido un error estableciendo conexión a la base de datos",e);
			
		}
	}
}
