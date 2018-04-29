package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.Tipo_solicitudDAO;
import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;
	/**
	 * Implementación de Tipo_solicitudDAO 
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public class Tipo_solicitudDAOHibernate implements Tipo_solicitudDAO {
	
	//Metodo para crear una lista de Tipo de soliciutes
	@Override
	public List<Tipo_solicitud> get() throws MyException {
		//Creacion de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Tipo_solicitud> tipo_solicitud=new ArrayList<Tipo_solicitud>();
		
		try{
			//Obtengo sesion a la base de datos
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Tipo_solicitud.class);
			tipo_solicitud = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando el tipo de solicitudes",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return tipo_solicitud;
	}
	
	//Metodo para consultar un Tipo de solicitud por medio del id
	@Override
	public Tipo_solicitud get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Tipo_solicitud tipo_solicitud = null;
		
		try{
			session = DataSource.getInstance().getSession();
			
			//Consulta a través del método load
			tipo_solicitud = (Tipo_solicitud)session.get(Tipo_solicitud.class, id);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los Tipos de solicitudes",e);
		}finally{
			//if(session != null){
			//	session.close();
			//}
		}
		
		return tipo_solicitud;
	}

	//Metodo para Insertar un nuevo Tipo de Solicitud
	@Override
	public void insert(Tipo_solicitud tipo_solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			//Para guardar un tipo_solicitud en la base de datos
			session.save(tipo_solicitud);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando un tipo de solicitud",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para modificar un tipo de solicitud
	@Override
	public void update(Tipo_solicitud tipo_solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.update(tipo_solicitud);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el tipo de solicitud",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para borrar un Tipo de Solicitud
	@Override
	public void delete(Tipo_solicitud tipo_solicitud) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.delete(tipo_solicitud);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el  tipo de solicitud",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
		
	
}
