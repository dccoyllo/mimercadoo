package udaff.edu.pe.entities;
// Generated 6 nov. 2020 12:04:27 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CarritoId generated by hbm2java
 */
@Embeddable
public class CarritoId implements java.io.Serializable {

	private int idCatalogo;
	private int idusuario;

	public CarritoId() {
	}

	public CarritoId(int idCatalogo, int idusuario) {
		this.idCatalogo = idCatalogo;
		this.idusuario = idusuario;
	}

	@Column(name = "id_catalogo", nullable = false)
	public int getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	@Column(name = "idusuario", nullable = false)
	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CarritoId))
			return false;
		CarritoId castOther = (CarritoId) other;

		return (this.getIdCatalogo() == castOther.getIdCatalogo()) && (this.getIdusuario() == castOther.getIdusuario());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdCatalogo();
		result = 37 * result + this.getIdusuario();
		return result;
	}

}
