package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * DTO para la tabla Solicitud
 * @author Maribel Chaverra Valencia - maribel.chaverra@udea.edu.co
 * @since Java 1.7
 * @version 1.0
 *
 */
public class Solicitud {
	//Id de Solicitud de la base de datos
	private Long id;
	//Tipo de solicitud 
	private Tipo_solicitud Tipo_Solicitud_id;
	//Fecha en que se realiza la solicitud
	private Date fecha;
	//Contenido de la solicitud
	private String contenido;
	//Identificacion del usuario quien hace la solicitud
	private Usuario usuario_Id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tipo_solicitud getTipo_Solicitud_id() {
		return Tipo_Solicitud_id;
	}
	public void setTipo_Solicitud_id(Tipo_solicitud tipo_Solicitud_id) {
		Tipo_Solicitud_id = tipo_Solicitud_id;
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
	public Usuario getUsuario_Id() {
		return usuario_Id;
	}
	public void setUsuario_Id(Usuario usuario_Id) {
		this.usuario_Id = usuario_Id;
	}
	

	
	


}
