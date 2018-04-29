package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.UsuarioDAO;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
	/**
	 * Implementación de UsuarioDAO 
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public class UsuarioDAOHibernate implements UsuarioDAO {
	
	//Metodo para crear una lista de Usuarios
	@Override
	public List<Usuario> get() throws MyException {
		
		//Creación de sesion a la base de datos
		Session session = null;
		Criteria criteria = null;
		List<Usuario> usuario=new ArrayList<Usuario>();
		
		try{
			//Obtengo sesion a la base de datos
			session = DataSource.getInstance().getSession();
			criteria = session.createCriteria(Usuario.class);
			usuario = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los usuarios",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
		return usuario;
	}

	//Metodo para consultar un usuario por medio del id
	@Override
	public Usuario get(Long id) throws MyException {
		Session session = null;
		Criteria criteria = null;
		Usuario usuario = null;
		
		try{
			session = DataSource.getInstance().getSession();
			
			//Consulta a través del método load
			usuario = (Usuario)session.get(Usuario.class, id);
			
		}catch(HibernateException e){
			throw new MyException("Se encontraron errores consultando los Usuario",e);
		}finally{
			//if(session != null){
			//	session.close();
			//}
		}
		
		return usuario;
	}

	//Metodo para Ingresar un nuevo usuario
	@Override
	public void insert(Usuario usuario) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			//Para guardar un usuario en la base de datos
			session.save(usuario);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error almacenando el usuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para modificar un usuario
	@Override
	public void update(Usuario usuario) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.update(usuario);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error modificando el usuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}

	//Metodo para borrar un usuario de la base de datos
	@Override
	public void delete(Usuario usuario) throws MyException {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = DataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.delete(usuario);
			tx.commit();
		}catch(HibernateException e){
			throw new MyException("Ocurrio un error eliminando el usuario",e);
		}finally{
			if(session != null){
				session.close();
			}
		}
		
	}
}
