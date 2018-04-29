package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.dto.Dependencia;

/**
 * Interface que define los métodos permitidos para las dependencias en el 
 * sistema
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 */

public interface DependenciaDAO {
	
	/**
	 * Obtiene la lista de dependencias que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return Lista de dependencias ordenada
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Dependencia> get() throws MyException;
	
	/**
	 * Obtiene la información de una dependencia dado su id
	 * @param id de la dependencia
	 * @return objeto Dependencia con la información almacenada
	 * @throws MyException ocurre cuando hay un error consultando la información
	 */
	public Dependencia get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de una dependencia en la base de datos
	 * @param dependencia objeto {@link Dependencia} con la información a almacenar
	 * @throws MyException cuando hay un error almacenando la información
	 */
	public void insert(Dependencia dependencia) throws MyException;
	
	/**
	 * Modifca los datos de una dependencia en la base de datos
	 * @param dependencia objeto {@link Dependencia} con la información a modfiicar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Dependencia dependencia) throws MyException;
	
	/**
	 * Elimina los datos de una dependencia en la base de datos
	 * @param dependencia objeto {@link Dependencia} con la información a eliminar
	 * @throws MyException cuando hay un error eliminando la información
	 */
	
	public void delete(Dependencia dependencia) throws MyException;
}
