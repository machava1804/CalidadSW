package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

import co.edu.udea.iw.dao.DependenciaDAO;
import co.edu.udea.iw.dao.hibernate.DependenciaDAOHibernate;
import co.edu.udea.iw.dto.Dependencia;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link DependenciaDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class DependenciaDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Test
	public void testGet() {
		DependenciaDAO dependenciaDAO = null;
		List<Dependencia> dependencias=null;
		
		try{
			dependenciaDAO = new DependenciaDAOHibernate();
			dependencias=dependenciaDAO.get();
			
			//Itero las dependencias para mostrar el contenido
			for(Dependencia dependencia: dependencias){
				System.out.println(dependencia.getId()+":"+ dependencia.getNombre());
			}
			//Valida que el objeto no sea nulo
			assertTrue(dependencias.size()>0);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//Consulta
	@Test
	public void testGetUno(){
		DependenciaDAO dependenciaDAO = null;
		Dependencia dependencia = null;
		
		try{
			dependenciaDAO = new DependenciaDAOHibernate();
			dependencia = dependenciaDAO.get(3l);
			
			assertNotNull(dependencia);
			
			System.out.println(dependencia.getId() + ": " +  dependencia.getNombre());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//Creación de nueva dependencia
	@Test
	public void testInsert(){
		DependenciaDAO dependenciaDAO = null;
		Dependencia dependencia = new Dependencia();
		
		try{
			dependencia.setId(7l);
			dependencia.setNombre("Finanzas");
			
			dependenciaDAO = new DependenciaDAOHibernate();
			dependenciaDAO.insert(dependencia);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
