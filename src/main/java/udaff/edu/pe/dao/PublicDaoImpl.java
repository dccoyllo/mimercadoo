package udaff.edu.pe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import udaff.edu.pe.entities.Allcatalogos;
import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.Usuario;

@Repository()
public class PublicDaoImpl implements PublicDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Login getSession(String cuenta, String clave) {
		// TODO Auto-generated method stub
		try {
			return em.createQuery("From Login where id.userCuenta =: cuenta and id.userClave =: clave", Login.class).setParameter("cuenta", cuenta).setParameter("clave", clave).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		em.merge(usuario);
	}

	@Override
	public List<TipoNegocio> getAllRubros() {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoNegocio", TipoNegocio.class).getResultList();
	}

	@Override
	public List<TipoProducto> getAllCategorias(int rubro_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From TipoProducto where tipoNegocio.idTipoNegocio =: rubro", TipoProducto.class).setParameter("rubro", rubro_id).getResultList();
	}

	@Override
	public List<Allcatalogos> getAllCatalogosMercado(int mercado_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From Allcatalogos where id.MId =: mercado", Allcatalogos.class).setParameter("mercado", mercado_id).getResultList();
	}

	@Override
	public List<Allcatalogos> getAllCatalogosPuesto(int puesto_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From Allcatalogos where id.PId =: puesto", Allcatalogos.class).setParameter("puesto", puesto_id).getResultList();
	}

	@Override
	public Allcatalogos getCatalogo(int catalogo_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From Allcatalogos where id.CId =: catalogo", Allcatalogos.class).setParameter("catalogo", catalogo_id).getSingleResult();
	}

	@Override
	public List<Allcatalogos> getAllCatalogosRubro(int rubro_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From Allcatalogos where id.tnId =: rubro", Allcatalogos.class).setParameter("rubro", rubro_id).getResultList();
	}

	@Override
	public List<Allcatalogos> getAllCatalogosCategoria(int categoria_id) {
		// TODO Auto-generated method stub
		return em.createQuery("From Allcatalogos where id.tpId =: categoria", Allcatalogos.class).setParameter("categoria", categoria_id).getResultList();
	}

	@Override
	public List<Mercado> getAllMercados() {
		// TODO Auto-generated method stub
		return em.createQuery("From Mercado", Mercado.class).getResultList();
	}

	@Override
	public Mercado getMercadoId(int mercado_id) {
		// TODO Auto-generated method stub
		return em.find(Mercado.class, mercado_id);
	}

}
