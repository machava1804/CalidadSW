package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link UsuarioDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class UsuarioDAOImplTest {
	//	 * Realiza prueba de la implementación
	@Test
	public void testGet() {
		UsuarioDAO usuarioDAO = null;
		List<Usuario> usuarios=null;
		
		try{
			usuarioDAO = new UsuarioDAOHibernate();
			usuarios=usuarioDAO.get();
			
			//Itero las dependencias para mostrar el contenido
			for(Usuario usuario: usuarios){
				System.out.println(usuario.getId()+":"+ usuario.getDependencia_id().getNombre()+":"+usuario.getNombre()+":"+usuario.getApellido()+":"+
			usuario.getTelefono()+":"+usuario.getDireccion()+":"+usuario.getEmail()+":"+usuario.getContraseña()+":"+usuario.getUsername());
			}
			assertTrue(usuarios.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		
		try{
			usuarioDAO = new UsuarioDAOHibernate();
			usuario = usuarioDAO.get(102l);
			
			assertNotNull(usuario);
			
			System.out.println(usuario.getId()+":"+ usuario.getDependencia_id().getNombre()+":"+usuario.getNombre()+":"+usuario.getApellido()+":"+
					usuario.getTelefono()+":"+usuario.getDireccion()+":"+usuario.getEmail()+":"+usuario.getContraseña()+":"+usuario.getUsername());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = new Usuario();
		
		try{
			usuario.setId(1049l);
			usuario.getDependencia_id().getNombre();
			usuario.setNombre("Maribel");
			usuario.setApellido("Chaverra");
			usuario.setTelefono("3137895487");
			usuario.setDireccion("Alejandria");
			usuario.setEmail("macha@gmail.com");
			usuario.setContraseña("456852");
			usuario.setUsername("machava");
			
			usuarioDAO = new UsuarioDAOHibernate();
			usuarioDAO.insert(usuario);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
