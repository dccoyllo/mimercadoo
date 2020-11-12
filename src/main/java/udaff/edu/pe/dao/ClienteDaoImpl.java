package udaff.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.DetalleCarrito;
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
	public Carrito getCarrito(CarritoId user_catalogo_id) {
		// TODO Auto-generated method stub
		return em.find(Carrito.class, user_catalogo_id);
	}

	@Override
	public boolean createCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		em.persist(carrito);
		return true;
	}

	@Override
	public boolean updateCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		em.merge(carrito);
		return true;
	}

	@Override
	public boolean deleteCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		em.remove(carrito);
		return true;
	}

	@Override
	public Catalogo getCatalogoId(int catalogo_id) {
		// TODO Auto-generated method stub
		return em.find(Catalogo.class, catalogo_id);
	}

	@Override
	public boolean updateCatalogoCantidad(Catalogo catalogo) {
		// TODO Auto-generated method stub
		em.merge(catalogo);
		return true;
	}

	@Override
	public List<DetalleCarrito> getAllCarritoUsuarioId(int usuario_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From DetalleCarrito where id.usuarioId =: usuario", DetalleCarrito.class).setParameter("usuario", usuario_id).getResultList();
	}

}
