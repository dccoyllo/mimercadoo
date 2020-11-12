package udaff.edu.pe.entities;
// Generated 12 nov. 2020 8:24:56 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Carrito generated by hbm2java
 */
@Entity
@Table(name = "carrito", catalog = "bd_mimercado")
public class Carrito implements java.io.Serializable {

	private CarritoId id;
	private Catalogo catalogo;
	private Usuario usuario;
	private int cantidad;
	private Date fechaCreada;

	public Carrito() {
	}

	public Carrito(CarritoId id, Catalogo catalogo, Usuario usuario, int cantidad, Date fechaCreada) {
		this.id = id;
		this.catalogo = catalogo;
		this.usuario = usuario;
		this.cantidad = cantidad;
		this.fechaCreada = fechaCreada;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idCatalogo", column = @Column(name = "id_catalogo", nullable = false)),
			@AttributeOverride(name = "idusuario", column = @Column(name = "idusuario", nullable = false)) })
	public CarritoId getId() {
		return this.id;
	}

	public void setId(CarritoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_catalogo", nullable = false, insertable = false, updatable = false)
	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
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

}
