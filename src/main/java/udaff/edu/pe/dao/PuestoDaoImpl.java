package udaff.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.TipoVenta;

@Repository
public class PuestoDaoImpl implements PuestoDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Puesto getIdPuesto(int puesto_id) {
		// TODO Auto-generated method stub
		return em.find(Puesto.class, puesto_id);
	}

	@Override
	public boolean updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		try {
			em.merge(puesto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		try {
			em.remove(puesto);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean setCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		em.persist(catalogo);
		return true;
	}

	@Override
	public Catalogo getCatalogoId(int catalogo_id) {
		// TODO Auto-generated method stub
		return em.find(Catalogo.class, catalogo_id);
	}

	@Override
	public boolean updateCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		em.merge(catalogo);
		return true;
	}

	@Override
	public boolean deleteCatalogo(Catalogo catalago) {
		// TODO Auto-generated method stub
		em.remove(catalago);
		return true;
	}

	@Override
	public List<TipoProducto> getTipoProductoPorRubro(int rubro_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoProducto where tipoNegocio.idTipoNegocio =: rubro", TipoProducto.class).setParameter("rubro", rubro_id).getResultList();
	}

	@Override
	public TipoProducto getTipoProductoId(int tipoProducto_Id) {
		// TODO Auto-generated method stub
		return em.find(TipoProducto.class, tipoProducto_Id);
	}

	@Override
	public List<TipoVenta> getAllTipoVenta() {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoVenta", TipoVenta.class).getResultList();
	}

	@Override
	public TipoVenta getTipoVenta(int tipoVenta_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoVenta where id.idTipoVenta =: tipoVenta", TipoVenta.class).setParameter("tipoVenta", tipoVenta_id).getSingleResult();
	}

}
