package udaff.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.Usuario;

@Repository
public class MercadoDaoImpl implements MercadoDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Mercado getMercadoId(int mercado_id) {
		// TODO Auto-generated method stub
		return em.find(Mercado.class, mercado_id);
	}

	@Override
	public boolean setMercado(Mercado mercado) {
		// TODO Auto-generated method stub
		em.persist(mercado);
		return true;

	}

	@Override
	public boolean updateMercado(Mercado mercado) {
		// TODO Auto-generated method stub
			em.merge(mercado);
			return true;
	}

	@Override
	public boolean deleteMercado(Mercado mercado) {
		// TODO Auto-generated method stub
			em.remove(mercado);
			return true;
	}

	@Override
	public Usuario getUsuarioEmail(String cliente_email) {
		// TODO Auto-generated method stub
		return em.createQuery("From Usuario where email =: email", Usuario.class)
				.setParameter("email", cliente_email).getSingleResult();
	}

	@Override
	public boolean createPuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		em.persist(puesto);
		return true;

	}

	@Override
	public List<Puesto> getPuestos(int mercado_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From Puesto where idmercado =: mercado", Puesto.class)
				.setParameter("mercado", mercado_id).getResultList();
	}

	@Override
	public List<TipoNegocio> getAllRubro() {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoNegocio", TipoNegocio.class).getResultList();
	}

	@Override
	public TipoNegocio getRubro(int rubro_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoNegocio where idTipoNegocio =: rubro", TipoNegocio.class)
				.setParameter("rubro", rubro_id).getSingleResult();
	}

	@Override
	public Puesto getPuestoId(int puesto_id) {
		// TODO Auto-generated method stub
		return em.find(Puesto.class, puesto_id);
	}

	@Override
	public boolean deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		em.remove(puesto);
		return true;
	}

	@Override
	public boolean updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		em.merge(puesto);
		return true;
	}

}
