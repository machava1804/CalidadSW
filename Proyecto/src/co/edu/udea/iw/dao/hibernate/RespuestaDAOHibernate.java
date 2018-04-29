package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.RespuestaDAO;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

	/**
	 * Implementación de RespuestaDAO 
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public class RespuestaDAOHibernate implements RespuestaDAO {
	
	//Metodo para crear una lista de Respuestas
	@Override
	public List<Respuesta> get() throws MyException {
		//Creacion de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Respuesta> respuesta=new ArrayList<Respuesta>();
		
		try{
			//Obtengo sesion a la base de datos
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Respuesta.class);
			respuesta = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las respuestas",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return respuesta;
	}

	//Metodo para consultar una respuesta por medio del id
	@Override
	public Respuesta get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Respuesta respuesta = null;
		
		try{
			session = DataSource.getInstance().getSession();
			
			//Consulta a través del método load
			respuesta = (Respuesta)session.get(Respuesta.class, id);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando las Respuestas",e);
		}finally{
			//if(session != null){
			//	session.close();
			//}
		}
		
		return respuesta;
	}

	//Metodo para ingresar una Respuesta
	@Override
	public void insert(Respuesta respuesta) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			//Para guardar una respuesta en la base de datos
			session.save(respuesta);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando la respuesta",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

}
