package udaff.edu.pe.entities;
// Generated 12 nov. 2020 8:24:56 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DetalleCarritoId generated by hbm2java
 */
@Embeddable
public class DetalleCarritoId implements java.io.Serializable {

	private int catalogoId;
	private int usuarioId;
	private Date fechaCreada;
	private String titulo;
	private String imagen;
	private Double precio;
	private int cantidad;
	private Double total;
	private String tipoVenta;

	public DetalleCarritoId() {
	}

	public DetalleCarritoId(int catalogoId, int usuarioId, Date fechaCreada, String titulo, int cantidad,
			String tipoVenta) {
		this.catalogoId = catalogoId;
		this.usuarioId = usuarioId;
		this.fechaCreada = fechaCreada;
		this.titulo = titulo;
		this.cantidad = cantidad;
		this.tipoVenta = tipoVenta;
	}

	public DetalleCarritoId(int catalogoId, int usuarioId, Date fechaCreada, String titulo, String imagen,
			Double precio, int cantidad, Double total, String tipoVenta) {
		this.catalogoId = catalogoId;
		this.usuarioId = usuarioId;
		this.fechaCreada = fechaCreada;
		this.titulo = titulo;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
		this.tipoVenta = tipoVenta;
	}

	@Column(name = "catalogo_id", nullable = false)
	public int getCatalogoId() {
		return this.catalogoId;
	}

	public void setCatalogoId(int catalogoId) {
		this.catalogoId = catalogoId;
	}

	@Column(name = "usuario_id", nullable = false)
	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Column(name = "fecha_creada", nullable = false, length = 10)
	public Date getFechaCreada() {
		return this.fechaCreada;
	}

	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

	@Column(name = "titulo", nullable = false, length = 45)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "imagen", length = 200)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "precio", precision = 22, scale = 0)
	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "cantidad", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "total", precision = 22, scale = 0)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Column(name = "tipo_venta", nullable = false, length = 45)
	public String getTipoVenta() {
		return this.tipoVenta;
	}

	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DetalleCarritoId))
			return false;
		DetalleCarritoId castOther = (DetalleCarritoId) other;

		return (this.getCatalogoId() == castOther.getCatalogoId()) && (this.getUsuarioId() == castOther.getUsuarioId())
				&& ((this.getFechaCreada() == castOther.getFechaCreada())
						|| (this.getFechaCreada() != null && castOther.getFechaCreada() != null
								&& this.getFechaCreada().equals(castOther.getFechaCreada())))
				&& ((this.getTitulo() == castOther.getTitulo()) || (this.getTitulo() != null
						&& castOther.getTitulo() != null && this.getTitulo().equals(castOther.getTitulo())))
				&& ((this.getImagen() == castOther.getImagen()) || (this.getImagen() != null
						&& castOther.getImagen() != null && this.getImagen().equals(castOther.getImagen())))
				&& ((this.getPrecio() == castOther.getPrecio()) || (this.getPrecio() != null
						&& castOther.getPrecio() != null && this.getPrecio().equals(castOther.getPrecio())))
				&& (this.getCantidad() == castOther.getCantidad())
				&& ((this.getTotal() == castOther.getTotal()) || (this.getTotal() != null
						&& castOther.getTotal() != null && this.getTotal().equals(castOther.getTotal())))
				&& ((this.getTipoVenta() == castOther.getTipoVenta()) || (this.getTipoVenta() != null
						&& castOther.getTipoVenta() != null && this.getTipoVenta().equals(castOther.getTipoVenta())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCatalogoId();
		result = 37 * result + this.getUsuarioId();
		result = 37 * result + (getFechaCreada() == null ? 0 : this.getFechaCreada().hashCode());
		result = 37 * result + (getTitulo() == null ? 0 : this.getTitulo().hashCode());
		result = 37 * result + (getImagen() == null ? 0 : this.getImagen().hashCode());
		result = 37 * result + (getPrecio() == null ? 0 : this.getPrecio().hashCode());
		result = 37 * result + this.getCantidad();
		result = 37 * result + (getTotal() == null ? 0 : this.getTotal().hashCode());
		result = 37 * result + (getTipoVenta() == null ? 0 : this.getTipoVenta().hashCode());
		return result;
	}

}
