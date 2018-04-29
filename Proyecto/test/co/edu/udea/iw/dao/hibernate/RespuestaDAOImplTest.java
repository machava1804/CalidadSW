package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import co.edu.udea.iw.dao.RespuestaDAO;
import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

/**
 * Implementación de la interface {@link RespuestaDAO}
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public class RespuestaDAOImplTest {
	/**
	 * Realiza prueba de la implementación
	 */
	@Test
	public void testGet() {
		RespuestaDAO respuestaDAO = null;
		List<Respuesta> respuestas=null;
		
		try{
			respuestaDAO = new RespuestaDAOHibernate();
			respuestas=respuestaDAO.get();
			
			//Itero las respuestas para mostrar el contenido
			for(Respuesta respuesta: respuestas){
				System.out.println(respuesta.getId()+":"+ respuesta.getSolicitud_Id().getTipo_Solicitud_id()+":"+ respuesta.getUsuario_Id().getId()+":"+
				respuesta.getFecha()+":"+respuesta.getContenido());
			}
			assertTrue(respuestas.size()>0);
			
		}catch(MyException e){
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUno(){
		RespuestaDAO respuestaDao = null;
		Respuesta respuesta = null;
		
		try{
			respuestaDao = new RespuestaDAOHibernate();
			respuesta = respuestaDao.get(2l);
			
			assertNotNull(respuesta);
			
			System.out.println(respuesta.getId()+":"+ respuesta.getSolicitud_Id().getTipo_Solicitud_id()+":"+ respuesta.getUsuario_Id().getId()+":"+
					respuesta.getFecha()+":"+respuesta.getContenido());
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsert(){
		RespuestaDAO respuestaDao = null;
		Respuesta respuesta = new Respuesta();
		
		try{
			respuesta.setId(102l);
			respuesta.getSolicitud_Id().getTipo_Solicitud_id();
			respuesta.getUsuario_Id().getId();
			respuesta.setFecha(new Date());
			respuesta.setContenido("Rectificar factura F-4875");
			
			
			respuestaDao = new RespuestaDAOHibernate();
			respuestaDao.insert(respuesta);
			
			
		}catch(MyException e){
			e.printStackTrace();
		}
	}
}
