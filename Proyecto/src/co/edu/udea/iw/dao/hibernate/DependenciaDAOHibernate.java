package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.DependenciaDAO;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;
	/**
	 * Implementación de DependenciaDAO 
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public class DependenciaDAOHibernate implements DependenciaDAO {
	
	//Metodo para crear una lista de Dependencias
	@Override
	public List<Dependencia> get() throws MyException {
		
		//Creación de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Dependencia> dependencia=new ArrayList<Dependencia>();
		
		try{
			//Obtengo sesion a la base de datos
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Dependencia.class);
			
			//Para ver la lista por orden de nombre
			criteria.addOrder(Order.asc("id"));
			
			dependencia = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las dependencias",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return dependencia;
	}

	//Metodo para consultar una dependencia por medio del id
	@Override
	public Dependencia get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Dependencia dependencia = null;
		
		try{
			session = DataSource.getInstance().getSession();
			
			//Consulta a través del método load
			dependencia = (Dependencia)session.get(Dependencia.class, id);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las Dependencias",e);
		}finally{
			//if(session != null){
			//	session.close();
			//}
		}
		
		return dependencia;
	}

	//Metodo para Insertar una Dependencia
	@Override
	public void insert(Dependencia dependencia) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			
			//Guardar una dependencia en la base de datos
			session.save(dependencia);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando la dependencia",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para modificar una dependencia
	@Override
	public void update(Dependencia dependencia) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.update(dependencia);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando la dependencia",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
	
	//Metodo para borrar una dependencia
	@Override
	public void delete(Dependencia dependencia) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.delete(dependencia);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando la dependencia",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

}
