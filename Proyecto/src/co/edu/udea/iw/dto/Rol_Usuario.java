package co.edu.udea.iw.dto;

/**
 * DTO para la tabla Rol_Usuario
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class Rol_Usuario {
	//Id del tipo de rol
	private Long id;
	//Nombre del rol
	private String tipo_Rol;
	//id de Usuario quien tiene el rol
	private Usuario usuario_Id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo_Rol() {
		return tipo_Rol;
	}
	public void setTipo_Rol(String tipo_Rol) {
		this.tipo_Rol = tipo_Rol;
	}
	public Usuario getUsuario_Id() {
		return usuario_Id;
	}
	public void setUsuario_Id(Usuario usuario_Id) {
		this.usuario_Id = usuario_Id;
	}
	

	
	
}
