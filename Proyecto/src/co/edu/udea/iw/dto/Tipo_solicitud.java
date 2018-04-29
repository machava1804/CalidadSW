package co.edu.udea.iw.dto;

/**
 * DTO para la tabla Tipo_solicitud
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class Tipo_solicitud {
	//Id del tipo de solicitud
	private Long id;
	//Nombre de la solicitud
	private String nombre;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
