package udaff.edu.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.PuestoDao;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.TipoVenta;

@Service
@Transactional
public class PuestoServiceImpl implements PuestoService {
	@Autowired
	private PuestoDao ppDao;

	@Override
	public Puesto getIdPuesto(int puesto_id) {
		// TODO Auto-generated method stub
		return ppDao.getIdPuesto(puesto_id);
	}

	@Override
	public boolean updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		return ppDao.updatePuesto(puesto);
	}

	@Override
	public boolean deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		return ppDao.deletePuesto(puesto);
	}

	@Override
	public boolean setCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		return ppDao.setCatalogo(catalogo);
	}

	@Override
	public Catalogo getCatalogoId(int catalogo_id) {
		// TODO Auto-generated method stub
		return ppDao.getCatalogoId(catalogo_id);
	}

	@Override
	public boolean updateCatalogo(Catalogo catalogo) {
		// TODO Auto-generated method stub
		return ppDao.updateCatalogo(catalogo);
	}

	@Override
	public boolean deleteCatalogo(Catalogo catalago) {
		// TODO Auto-generated method stub
		return ppDao.deleteCatalogo(catalago);
	}

	@Override
	public List<TipoProducto> getTipoProductoPorRubro(int rubro_id) {
		// TODO Auto-generated method stub
		return ppDao.getTipoProductoPorRubro(rubro_id);
	}

	@Override
	public TipoProducto getTipoProductoId(int tipoProducto_Id) {
		// TODO Auto-generated method stub
		return ppDao.getTipoProductoId(tipoProducto_Id);
	}

	@Override
	public List<TipoVenta> getAllTipoVenta() {
		// TODO Auto-generated method stub
		return ppDao.getAllTipoVenta();
	}

	@Override
	public TipoVenta getTipoVenta(int tipoVenta_id) {
		// TODO Auto-generated method stub
		return ppDao.getTipoVenta(tipoVenta_id);
	}

}
