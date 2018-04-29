package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;


import co.edu.udea.iw.dao.Tipo_solicitudDAO;
import co.edu.udea.iw.dto.Tipo_solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link Tipo_SolicitudDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class Tipo_SolicitudDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Test
	public void testGet() {
		Tipo_solicitudDAO tipo_SolicitudDAO = null;
		List<Tipo_solicitud> Tipo_solicitudes=null;
		
		try{
			tipo_SolicitudDAO = new Tipo_solicitudDAOHibernate();
			Tipo_solicitudes=tipo_SolicitudDAO.get();
			
			//Itero los tipos de solicitudes  para mostrar el contenido
			for(Tipo_solicitud tipo_solicitud: Tipo_solicitudes){
				System.out.println(tipo_solicitud.getId()+":"+ tipo_solicitud.getNombre());
			}
			assertTrue(Tipo_solicitudes.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		Tipo_solicitudDAO tipo_SolicitudDAO = null;
		Tipo_solicitud tipo_Solicitud = null;
		
		try{
			tipo_SolicitudDAO = new Tipo_solicitudDAOHibernate();
			tipo_Solicitud = tipo_SolicitudDAO.get(100l);
			
			assertNotNull(tipo_Solicitud);
			
			System.out.println(tipo_Solicitud.getId() + ": " +  tipo_Solicitud.getNombre());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		Tipo_solicitudDAO tipo_SolicitudDAO = null;
		Tipo_solicitud tipo_Solicitud = new Tipo_solicitud();
		
		try{
			tipo_Solicitud.setId(5l);
			tipo_Solicitud.setNombre("Otros");
			
			tipo_SolicitudDAO = new Tipo_solicitudDAOHibernate();
			tipo_SolicitudDAO.insert(tipo_Solicitud);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
