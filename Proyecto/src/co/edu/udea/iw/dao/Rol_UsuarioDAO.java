package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Rol_Usuario;
import co.edu.udea.iw.exception.MyException;

	 /**
	 * Interface que define los métodos permitidos para los roles de usuario en el 
	 * sistema
	 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
	 * @since Java 1.7
	 * @version 1.0
	 */
public interface Rol_UsuarioDAO {
	
	/**
	 * Obtiene la lista de los roles de usuario que existen en el sistema 
	 * ordenadas alfabeticamente por el nombre
	 * @return Lista de roles de usuario ordenada
	 * @throws MyException ocurre cuando hay un problema con la conexión a la BD
	 */
	public List<Rol_Usuario> get() throws MyException;
	
	/**
	 * Obtiene la información de un Rol de Usuario dado su id
	 * @param id del Rol_Usuario
	 * @return objeto Rol_Usuario con la información almacenada
	 * @throws MyException ocurre cuando hay un error consultando la información
	 */
	public Rol_Usuario get(Long id) throws MyException;
	
	/**
	 * Almacena los datos de un Rol de Usuario en la base de datos
	 * @param rol_Usuario objeto {@link Rol_Usuario} con la información a almacenar
	 * @throws MyException cuando hay un error almacenando la información
	 */
	public void insert(Rol_Usuario rol_Usuario) throws MyException;
	
	/**
	 * Modifca los datos de un Rol_Usuario en la base de datos
	 * @param rol_Usuario objeto {@link Rol_Usuario} con la información a modfiicar
	 * @throws MyException cuando hay un error modificando la información
	 */
	public void update(Rol_Usuario rol_Usuario) throws MyException;
	
	/**
	 * Elimina los datos de un rol_Usuario en la base de datos
	 * @param rol_Usuario objeto {@link Rol_Usuario} con la información a eliminar
	 * @throws MyException cuando hay un error eliminando la información
	 */
	
	public void delete(Rol_Usuario rol_Usuario) throws MyException;
}
