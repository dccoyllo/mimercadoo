package udaff.edu.pe.entities;
// Generated 12 nov. 2020 8:24:56 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AllpuestosId generated by hbm2java
 */
@Embeddable
public class AllpuestosId implements java.io.Serializable {

	private int MId;
	private String MNombre;
	private int PId;
	private String PImagen;
	private String PNombre;
	private String PDescripcion;
	private int tnId;
	private String tnNombre;
	private Boolean PEstado;

	public AllpuestosId() {
	}

	public AllpuestosId(int MId, int PId, int tnId, String tnNombre) {
		this.MId = MId;
		this.PId = PId;
		this.tnId = tnId;
		this.tnNombre = tnNombre;
	}

	public AllpuestosId(int MId, String MNombre, int PId, String PImagen, String PNombre, String PDescripcion, int tnId,
			String tnNombre, Boolean PEstado) {
		this.MId = MId;
		this.MNombre = MNombre;
		this.PId = PId;
		this.PImagen = PImagen;
		this.PNombre = PNombre;
		this.PDescripcion = PDescripcion;
		this.tnId = tnId;
		this.tnNombre = tnNombre;
		this.PEstado = PEstado;
	}

	@Column(name = "m_id", nullable = false)
	public int getMId() {
		return this.MId;
	}

	public void setMId(int MId) {
		this.MId = MId;
	}

	@Column(name = "m_nombre", length = 60)
	public String getMNombre() {
		return this.MNombre;
	}

	public void setMNombre(String MNombre) {
		this.MNombre = MNombre;
	}

	@Column(name = "p_id", nullable = false)
	public int getPId() {
		return this.PId;
	}

	public void setPId(int PId) {
		this.PId = PId;
	}

	@Column(name = "p_imagen", length = 100)
	public String getPImagen() {
		return this.PImagen;
	}

	public void setPImagen(String PImagen) {
		this.PImagen = PImagen;
	}

	@Column(name = "p_nombre", length = 45)
	public String getPNombre() {
		return this.PNombre;
	}

	public void setPNombre(String PNombre) {
		this.PNombre = PNombre;
	}

	@Column(name = "p_descripcion", length = 500)
	public String getPDescripcion() {
		return this.PDescripcion;
	}

	public void setPDescripcion(String PDescripcion) {
		this.PDescripcion = PDescripcion;
	}

	@Column(name = "tn_id", nullable = false)
	public int getTnId() {
		return this.tnId;
	}

	public void setTnId(int tnId) {
		this.tnId = tnId;
	}

	@Column(name = "tn_nombre", nullable = false, length = 70)
	public String getTnNombre() {
		return this.tnNombre;
	}

	public void setTnNombre(String tnNombre) {
		this.tnNombre = tnNombre;
	}

	@Column(name = "p_estado")
	public Boolean getPEstado() {
		return this.PEstado;
	}

	public void setPEstado(Boolean PEstado) {
		this.PEstado = PEstado;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AllpuestosId))
			return false;
		AllpuestosId castOther = (AllpuestosId) other;

		return (this.getMId() == castOther.getMId())
				&& ((this.getMNombre() == castOther.getMNombre()) || (this.getMNombre() != null
						&& castOther.getMNombre() != null && this.getMNombre().equals(castOther.getMNombre())))
				&& (this.getPId() == castOther.getPId())
				&& ((this.getPImagen() == castOther.getPImagen()) || (this.getPImagen() != null
						&& castOther.getPImagen() != null && this.getPImagen().equals(castOther.getPImagen())))
				&& ((this.getPNombre() == castOther.getPNombre()) || (this.getPNombre() != null
						&& castOther.getPNombre() != null && this.getPNombre().equals(castOther.getPNombre())))
				&& ((this.getPDescripcion() == castOther.getPDescripcion())
						|| (this.getPDescripcion() != null && castOther.getPDescripcion() != null
								&& this.getPDescripcion().equals(castOther.getPDescripcion())))
				&& (this.getTnId() == castOther.getTnId())
				&& ((this.getTnNombre() == castOther.getTnNombre()) || (this.getTnNombre() != null
						&& castOther.getTnNombre() != null && this.getTnNombre().equals(castOther.getTnNombre())))
				&& ((this.getPEstado() == castOther.getPEstado()) || (this.getPEstado() != null
						&& castOther.getPEstado() != null && this.getPEstado().equals(castOther.getPEstado())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMId();
		result = 37 * result + (getMNombre() == null ? 0 : this.getMNombre().hashCode());
		result = 37 * result + this.getPId();
		result = 37 * result + (getPImagen() == null ? 0 : this.getPImagen().hashCode());
		result = 37 * result + (getPNombre() == null ? 0 : this.getPNombre().hashCode());
		result = 37 * result + (getPDescripcion() == null ? 0 : this.getPDescripcion().hashCode());
		result = 37 * result + this.getTnId();
		result = 37 * result + (getTnNombre() == null ? 0 : this.getTnNombre().hashCode());
		result = 37 * result + (getPEstado() == null ? 0 : this.getPEstado().hashCode());
		return result;
	}

}
