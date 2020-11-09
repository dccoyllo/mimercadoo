package udaff.edu.pe.entities;
// Generated 6 nov. 2020 12:04:27 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Mercado generated by hbm2java
 */
@Entity
@Table(name = "mercado", catalog = "bd_mimercado")
public class Mercado implements java.io.Serializable {

	private int idmercado;
	@JsonIgnore
	private Usuario usuario;
	private String nombre;
	private String descripcion;
	private String fundacion;
	private String tipo;
	private Integer puestos;
	private String imagen;
	private String direccion;
	private String horaInicio;
	private String horaFin;
	private String geolocalizacion;
	private Date fechaCreada;

	public Mercado() {
	}

	public Mercado(Usuario usuario, Date fechaCreada) {
		this.usuario = usuario;
		this.fechaCreada = fechaCreada;
	}

	public Mercado(Usuario usuario, String nombre, String descripcion, String fundacion, String tipo, Integer puestos,
			String imagen, String direccion, String horaInicio, String horaFin, String geolocalizacion,
			Date fechaCreada) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fundacion = fundacion;
		this.tipo = tipo;
		this.puestos = puestos;
		this.imagen = imagen;
		this.direccion = direccion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.geolocalizacion = geolocalizacion;
		this.fechaCreada = fechaCreada;
	}

	@GenericGenerator(name = "udaff.edu.pe.entities.MercadoIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "usuario"))
	@Id
	@GeneratedValue(generator = "udaff.edu.pe.entities.MercadoIdGenerator")

	@Column(name = "idmercado", unique = true, nullable = false)
	public int getIdmercado() {
		return this.idmercado;
	}

	public void setIdmercado(int idmercado) {
		this.idmercado = idmercado;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nombre", length = 60)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "fundacion", length = 15)
	public String getFundacion() {
		return this.fundacion;
	}

	public void setFundacion(String fundacion) {
		this.fundacion = fundacion;
	}

	@Column(name = "tipo", length = 15)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "puestos")
	public Integer getPuestos() {
		return this.puestos;
	}

	public void setPuestos(Integer puestos) {
		this.puestos = puestos;
	}

	@Column(name = "imagen", length = 200)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "direccion", length = 60)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "hora_inicio", length = 15)
	public String getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Column(name = "hora_fin", length = 15)
	public String getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	@Column(name = "geolocalizacion", length = 200)
	public String getGeolocalizacion() {
		return this.geolocalizacion;
	}

	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creada", nullable = false, length = 10)
	public Date getFechaCreada() {
		return this.fechaCreada;
	}

	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

}
