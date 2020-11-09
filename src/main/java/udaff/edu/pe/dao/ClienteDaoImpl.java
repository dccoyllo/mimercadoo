package udaff.edu.pe.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Usuario;

@Repository
public class ClienteDaoImpl implements ClienteDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Usuario getUsuarioId(int usuario_id) {
		// TODO Auto-generated method stub
		return em.find(Usuario.class, usuario_id);
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.merge(usuario);
		return true;
	}

	@Override
	public boolean deleteUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.remove(usuario);
		return true;
	}

	@Override
	public CarritoId getCarrito(int catalogo_id, int usuario_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return false;
	}

}
