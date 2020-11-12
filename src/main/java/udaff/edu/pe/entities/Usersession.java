package udaff.edu.pe.entities;
// Generated 12 nov. 2020 0:23:06 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Usersession generated by hbm2java
 */
@Entity
@Table(name = "usersession", catalog = "bd_mimercado")
public class Usersession implements java.io.Serializable {

	private UsersessionId id;

	public Usersession() {
	}

	public Usersession(UsersessionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "cuenta", column = @Column(name = "cuenta", nullable = false, length = 25)),
			@AttributeOverride(name = "clave", column = @Column(name = "clave", nullable = false, length = 50)),
			@AttributeOverride(name = "email", column = @Column(name = "email", nullable = false, length = 45)),
			@AttributeOverride(name = "nombreCuenta", column = @Column(name = "nombre_cuenta", nullable = false, length = 25)),
			@AttributeOverride(name = "nombre", column = @Column(name = "nombre", length = 45)),
			@AttributeOverride(name = "apellido", column = @Column(name = "apellido", length = 45)),
			@AttributeOverride(name = "edad", column = @Column(name = "edad")) })
	public UsersessionId getId() {
		return this.id;
	}

	public void setId(UsersessionId id) {
		this.id = id;
	}

}
