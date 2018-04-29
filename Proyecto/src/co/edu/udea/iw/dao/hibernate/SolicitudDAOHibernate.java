package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;
	/**
	 * Implementación de SolicitudDAO 
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public class SolicitudDAOHibernate implements SolicitudDAO {
	
	//Metodo para crear una lista de Solicitudes
	@Override
	public List<Solicitud> get() throws MyException {
		//Creacion de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Solicitud> solicitud=new ArrayList<Solicitud>();
		
		try{
			//Obtengo sesion a la base de datos
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Solicitud.class);
			solicitud = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las solicitudes",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return solicitud;
	}

	//Metodo para consultar una solicitud por medio del id
	@Override
	public Solicitud get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Solicitud solicitud = null;
		
		try{
			session = DataSource.getInstance().getSession();
			
			//Consulta a través del método load
			solicitud = (Solicitud)session.get(Solicitud.class, id);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las Solicitudes",e);
		}finally{
			//if(session != null){
			//	session.close();
			//}
		}
		
		return solicitud;
	}

	//Metodo para Insertar una nueva solicitud
	@Override
	public void insert(Solicitud solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			//Para guardar una dependencia en la base de datos
			session.save(solicitud);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando la solicitud",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
}
