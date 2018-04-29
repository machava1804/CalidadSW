package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.Rol_UsuarioDAO;
import co.edu.udea.iw.dto.Rol_Usuario;
import co.edu.udea.iw.exception.MyException;
	/**
	 * Implementación de Rol_UsuarioDAO 
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public class Rol_UsuarioDAOHibernate implements Rol_UsuarioDAO {
	
	//Metodo para crear una lista de Roles de usuario
	@Override
	public List<Rol_Usuario> get() throws MyException {
		
		//Creacion de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Rol_Usuario> rol_Usuario=new ArrayList<Rol_Usuario>();
		
		try{
			//Obtengo sesion a la base de datos
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Rol_Usuario.class);
			rol_Usuario = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los roles de usuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return rol_Usuario;
	}
	
	//Metodo para consultar un Rol de usuario por medio del id
	@Override
	public Rol_Usuario get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Rol_Usuario rol_Usuario = null;
		
		try{
			session = DataSource.getInstance().getSession();
			
			//Consulta a través del método load
			rol_Usuario = (Rol_Usuario)session.get(Rol_Usuario.class, id);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los Roles de Usuario",e);
		}finally{
			//if(session != null){
			//	session.close();
			//}
		}
		
		return rol_Usuario;
	}

	//Metodo para Insertar una nuevo Rol de Usuario
	@Override
	public void insert(Rol_Usuario rol_Usuario) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			//Para guardar un Rol de Usuario en la base de datos
			session.save(rol_Usuario);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando el Rol deUsuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para modificar una Rol de usuario
	@Override
	public void update(Rol_Usuario rol_Usuario) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.update(rol_Usuario);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el Rol de usuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para borrar una rol de usuario existente
	@Override
	public void delete(Rol_Usuario rol_Usuario) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.delete(rol_Usuario);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el rol de usuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
}
