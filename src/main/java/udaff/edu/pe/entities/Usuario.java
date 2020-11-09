package udaff.edu.pe.entities;
// Generated 6 nov. 2020 12:04:27 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "bd_mimercado", uniqueConstraints = { @UniqueConstraint(columnNames = "cuenta"),
		@UniqueConstraint(columnNames = "email") })
public class Usuario implements java.io.Serializable {

	private Integer idusuario;
	private Perfil perfil;
	private String cuenta;
	private String clave;
	private String email;
	private String nombreCuenta;
	private String nombre;
	private String apellido;
	private Integer edad;
	private Date fechaCreada;
	private Set<Carrito> carritos = new HashSet<Carrito>(0);
	private Set<Compra> compras = new HashSet<Compra>(0);
	private Puesto puesto;
	private Mercado mercado;

	public Usuario() {
	}

	public Usuario(Perfil perfil, String cuenta, String clave, String email, String nombreCuenta, Date fechaCreada) {
		this.perfil = perfil;
		this.cuenta = cuenta;
		this.clave = clave;
		this.email = email;
		this.nombreCuenta = nombreCuenta;
		this.fechaCreada = fechaCreada;
	}

	public Usuario(Perfil perfil, String cuenta, String clave, String email, String nombreCuenta, String nombre,
			String apellido, Integer edad, Date fechaCreada, Set<Carrito> carritos, Set<Compra> compras, Puesto puesto,
			Mercado mercado) {
		this.perfil = perfil;
		this.cuenta = cuenta;
		this.clave = clave;
		this.email = email;
		this.nombreCuenta = nombreCuenta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaCreada = fechaCreada;
		this.carritos = carritos;
		this.compras = compras;
		this.puesto = puesto;
		this.mercado = mercado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perfil", nullable = false)
	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Column(name = "cuenta", unique = true, nullable = false, length = 25)
	public String getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@Column(name = "clave", nullable = false, length = 50)
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "nombre_cuenta", nullable = false, length = 25)
	public String getNombreCuenta() {
		return this.nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", length = 45)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "edad")
	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creada", nullable = false, length = 10)
	public Date getFechaCreada() {
		return this.fechaCreada;
	}

	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(Set<Carrito> carritos) {
		this.carritos = carritos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Puesto getPuesto() {
		return this.puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Mercado getMercado() {
		return this.mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

}
