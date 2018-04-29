package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link SolicitudDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class SolicitudDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Test
	public void testGet() {
		SolicitudDAO solicitudDAO = null;
		List<Solicitud> solicitudes=null;
		
		try{
			solicitudDAO = new SolicitudDAOHibernate();
			solicitudes=solicitudDAO.get();
			
			//Itero las solicitudes para mostrar el contenido
			for(Solicitud solicitud: solicitudes){
				System.out.println(solicitud.getId()+":"+ solicitud.getTipo_Solicitud_id().getNombre()+":"+ solicitud.getFecha()+
						":"+solicitud.getContenido()+":"+solicitud.getUsuario_Id().getId());
			}
			assertTrue(solicitudes.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		SolicitudDAO solicitudDAO = null;
		Solicitud solicitud = null;
		
		try{
			solicitudDAO = new SolicitudDAOHibernate();
			solicitud = solicitudDAO.get(100l);
			
			assertNotNull(solicitud);
			
			System.out.println(solicitud.getId()+":"+ solicitud.getTipo_Solicitud_id().getNombre()+":"+ solicitud.getFecha()+
					":"+solicitud.getContenido()+":"+solicitud.getUsuario_Id().getId());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		SolicitudDAO solicitudDAO = null;
		Solicitud solicitud = new Solicitud();
		
		try{
			solicitud.setId(7l);
			solicitud.getTipo_Solicitud_id().getNombre();
			solicitud.setFecha(new Date());
			solicitud.setContenido("Nevera en mal estado");
			solicitud.getUsuario_Id().getId();
			
			solicitudDAO = new SolicitudDAOHibernate();
			solicitudDAO.insert(solicitud);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
