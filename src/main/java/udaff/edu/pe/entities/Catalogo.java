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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Catalogo generated by hbm2java
 */
@Entity
@Table(name = "catalogo", catalog = "bd_mimercado")
public class Catalogo implements java.io.Serializable {

	private Integer idCatalogo;
	private Puesto puesto;
	private TipoVenta tipoVenta;
	private String titulo;
	private String imagen;
	private int idTipoProducto;
	private Double precio;
	private Integer cantidad;
	private Date fechaCreada;
	private Set<Carrito> carritos = new HashSet<Carrito>(0);

	public Catalogo() {
	}

	public Catalogo(Puesto puesto, TipoVenta tipoVenta, String titulo, int idTipoProducto, Date fechaCreada) {
		this.puesto = puesto;
		this.tipoVenta = tipoVenta;
		this.titulo = titulo;
		this.idTipoProducto = idTipoProducto;
		this.fechaCreada = fechaCreada;
	}

	public Catalogo(Puesto puesto, TipoVenta tipoVenta, String titulo, String imagen, int idTipoProducto, Double precio,
			Integer cantidad, Date fechaCreada, Set<Carrito> carritos) {
		this.puesto = puesto;
		this.tipoVenta = tipoVenta;
		this.titulo = titulo;
		this.imagen = imagen;
		this.idTipoProducto = idTipoProducto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaCreada = fechaCreada;
		this.carritos = carritos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_catalogo", unique = true, nullable = false)
	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpuesto", nullable = false)
	public Puesto getPuesto() {
		return this.puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_venta", nullable = false)
	public TipoVenta getTipoVenta() {
		return this.tipoVenta;
	}

	public void setTipoVenta(TipoVenta tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	@Column(name = "titulo", nullable = false, length = 45)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "imagen", length = 100)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "id_tipo_producto", nullable = false)
	public int getIdTipoProducto() {
		return this.idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	@Column(name = "precio", precision = 22, scale = 0)
	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "cantidad")
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creada", nullable = false, length = 10)
	public Date getFechaCreada() {
		return this.fechaCreada;
	}

	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogo")
	public Set<Carrito> getCarritos() {
		return this.carritos;
	}

	public void setCarritos(Set<Carrito> carritos) {
		this.carritos = carritos;
	}

}
