package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.MyException;

/**
	 * Interface que define los métodos permitidos para las solicitudes en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface SolicitudDAO {
	
	/**
	 * Obtiene la lista de las solicitudes de usuario que existen en el sistema 
	 * ordenadas 
	 * @return Lista de solicitudes 
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Solicitud> get() throws MyException;
	
	/**
	 * Obtiene la información de una solicitud dado su id
	 * @param id de la solicitud
	 * @return objeto Solicitud con la información almacenada
	 * @throws MyException ocurre cuando hay un error consultando la información
	 */
	public Solicitud get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de una solicitud en la base de datos
	 * @param solicitud objeto {@link Solicitud} con la información a almacenar
	 * @throws MyException cuando hay un error almacenando la información
	 */
	public void insert(Solicitud solicitud) throws MyException;

}
