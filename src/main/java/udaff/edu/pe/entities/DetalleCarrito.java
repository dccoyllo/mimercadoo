package udaff.edu.pe.entities;
// Generated 12 nov. 2020 8:24:56 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DetalleCarrito generated by hbm2java
 */
@Entity
@Table(name = "detalle_carrito", catalog = "bd_mimercado")
public class DetalleCarrito implements java.io.Serializable {

	private DetalleCarritoId id;

	public DetalleCarrito() {
	}

	public DetalleCarrito(DetalleCarritoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "catalogoId", column = @Column(name = "catalogo_id", nullable = false)),
			@AttributeOverride(name = "usuarioId", column = @Column(name = "usuario_id", nullable = false)),
			@AttributeOverride(name = "fechaCreada", column = @Column(name = "fecha_creada", nullable = false, length = 10)),
			@AttributeOverride(name = "titulo", column = @Column(name = "titulo", nullable = false, length = 45)),
			@AttributeOverride(name = "imagen", column = @Column(name = "imagen", length = 200)),
			@AttributeOverride(name = "precio", column = @Column(name = "precio", precision = 22, scale = 0)),
			@AttributeOverride(name = "cantidad", column = @Column(name = "cantidad", nullable = false)),
			@AttributeOverride(name = "total", column = @Column(name = "total", precision = 22, scale = 0)),
			@AttributeOverride(name = "tipoVenta", column = @Column(name = "tipo_venta", nullable = false, length = 45)) })
	public DetalleCarritoId getId() {
		return this.id;
	}

	public void setId(DetalleCarritoId id) {
		this.id = id;
	}

}
