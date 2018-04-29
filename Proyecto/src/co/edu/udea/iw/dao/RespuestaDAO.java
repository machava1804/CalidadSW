package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Respuesta;
import co.edu.udea.iw.exception.MyException;

	 /**
	 * Interface que define los métodos permitidos para las respuestas en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface RespuestaDAO {
	/**
	 * Obtiene la lista de Respuestas que existen en el sistema 
	 * @return Lista de Respuestas 
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Respuesta> get() throws MyException;
	
	/**
	 * Obtiene la información de una Respuesta dado su id
	 * @param id de la respuesta
	 * @return objeto Respuesta con la información almacenada
	 * @throws MyException ocurre cuando hay un error consultando la información
	 */
	public Respuesta get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de una respuesta en la base de datos
	 * @param respuesta objeto {@link Respuesta} con la información a almacenar
	 * @throws MyException cuando hay un error almacenando la información
	 */
	public void insert(Respuesta respuesta) throws MyException;

}
