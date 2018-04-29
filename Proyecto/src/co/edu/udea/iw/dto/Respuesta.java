package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * DTO para la tabla Respuesta
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class Respuesta {
	//id de la Respuesta de la base de datos
	private Long id;
	//Id de la solicitud a quien se le envia la respuesta
	private Solicitud solicitud_Id;
	//Id del usuario quien da la respuesta
	private Usuario usuario_Id;
	//Fecha de la respuesta
	private Date fecha;
	//Contenido de la respuesta
	private String contenido;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Solicitud getSolicitud_Id() {
		return solicitud_Id;
	}
	public void setSolicitud_Id(Solicitud solicitud_Id) {
		this.solicitud_Id = solicitud_Id;
	}
	public Usuario getUsuario_Id() {
		return usuario_Id;
	}
	public void setUsuario_Id(Usuario usuario_Id) {
		this.usuario_Id = usuario_Id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	

	

}
