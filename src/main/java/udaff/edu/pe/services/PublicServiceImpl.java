package udaff.edu.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.PublicDao;
import udaff.edu.pe.entities.Allcatalogos;
import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.Usuario;
@Service
@Transactional
public class PublicServiceImpl implements PublicService {
	@Autowired
	private PublicDao publicDao;

	@Override
	public void updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		publicDao.updateUsuario(usuario);
	}

	@Override
	public Login getSession(String cuenta, String clave) {
		// TODO Auto-generated method stub
		return publicDao.getSession(cuenta, clave);
	}

	@Override
	public void setUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		publicDao.setUsuario(usuario);
	}

	@Override
	public List<TipoNegocio> getAllRubros() {
		// TODO Auto-generated method stub
		return publicDao.getAllRubros();
	}

	@Override
	public List<TipoProducto> getAllCategorias(int rubro_id) {
		// TODO Auto-generated method stub
		return publicDao.getAllCategorias(rubro_id);
	}

	@Override
	public List<Allcatalogos> getAllCatalogosMercado(int mercado_id) {
		// TODO Auto-generated method stub
		return publicDao.getAllCatalogosMercado(mercado_id);
	}

	@Override
	public List<Allcatalogos> getAllCatalogosPuesto(int puesto_id) {
		// TODO Auto-generated method stub
		return publicDao.getAllCatalogosPuesto(puesto_id);
	}

	@Override
	public Allcatalogos getCatalogo(int catalogo_id) {
		// TODO Auto-generated method stub
		return publicDao.getCatalogo(catalogo_id);
	}

	@Override
	public List<Allcatalogos> getAllCatalogosRubro(int rubro_id) {
		// TODO Auto-generated method stub
		return publicDao.getAllCatalogosRubro(rubro_id);
	}

	@Override
	public List<Allcatalogos> getAllCatalogosCategoria(int categoria_id) {
		// TODO Auto-generated method stub
		return publicDao.getAllCatalogosCategoria(categoria_id);
	}

	@Override
	public List<Mercado> getAllMercados() {
		// TODO Auto-generated method stub
		return publicDao.getAllMercados();
	}

	@Override
	public Mercado getMercadoId(int mercado_id) {
		// TODO Auto-generated method stub
		return publicDao.getMercadoId(mercado_id);
	}

	
}
