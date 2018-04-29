package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import co.edu.udea.iw.dao.Rol_UsuarioDAO;
import co.edu.udea.iw.dto.Rol_Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link Rol_UsuarioDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class Rol_UsuarioDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Test
	public void testGet() {
		Rol_UsuarioDAO rol_UsuarioDAO = null;
		List<Rol_Usuario> rol_Usuarios=null;
		
		try{
			rol_UsuarioDAO = new Rol_UsuarioDAOHibernate();
			rol_Usuarios=rol_UsuarioDAO.get();
			
			//Itero los Roles de Usuario para mostrar el contenido
			for(Rol_Usuario rol_Usuario: rol_Usuarios){
				System.out.println(rol_Usuario.getId()+":"+ rol_Usuario.getTipo_Rol()+":"+ rol_Usuario.getUsuario_Id().getId());
			}
			assertTrue(rol_Usuarios.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		Rol_UsuarioDAO rol_UsuarioDAO = null;
		Rol_Usuario rol_Usuario = null;
		
		try{
			rol_UsuarioDAO = new Rol_UsuarioDAOHibernate();
			rol_Usuario = rol_UsuarioDAO.get(502l);
			
			assertNotNull(rol_Usuario);
			
			System.out.println(rol_Usuario.getId()+":"+ rol_Usuario.getTipo_Rol()+":"+ rol_Usuario.getUsuario_Id().getId());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		Rol_UsuarioDAO rol_UsuarioDAO = null;
		Rol_Usuario rol_Usuario = new Rol_Usuario();
		
		try{
			rol_Usuario.setId(3l);
			rol_Usuario.setTipo_Rol("Proveedor");
			rol_Usuario.getUsuario_Id().getId();
			
			rol_UsuarioDAO = new Rol_UsuarioDAOHibernate();
			rol_UsuarioDAO.insert(rol_Usuario);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
