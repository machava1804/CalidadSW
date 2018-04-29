package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
	 * Interface que define los métodos permitidos para los Usuarios en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface UsuarioDAO {
	
	/**
	 * Obtiene la lista de usuarios que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return Lista de usuarios ordenada
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Usuario> get() throws MyException;
	
	/**
	 * Obtiene la información de un usuario dado su id
	 * @param id de la usuario
	 * @return objeto Usuario con la información almacenada
	 * @throws MyException ocurre cuando hay un error consultando la información
	 */
	public Usuario get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de un Usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la información a almacenar
	 * @throws MyException cuando hay un error almacenando la información
	 */
	public void insert(Usuario usuario) throws MyException;
	
	/**
	 * Modifca los datos de un Usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la información a modfiicar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Usuario usuario) throws MyException;
	
	/**
	 * Elimina los datos de un usuario en la base de datos
	 * @param usuario objeto {@link Usuario} con la información a eliminar
	 * @throws MyException cuando hay un error eliminando la información
	 */
	public void delete(Usuario usuario) throws MyException;
}
