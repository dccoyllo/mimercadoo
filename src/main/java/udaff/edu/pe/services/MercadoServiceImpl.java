package udaff.edu.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.MercadoDao;
import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.Usuario;

@Service
@Transactional
public class MercadoServiceImpl implements MercadoService {
	@Autowired
	private MercadoDao pmDao;

	@Override
	public Mercado getMercadoId(int mercado_id) {
		// TODO Auto-generated method stub
		return pmDao.getMercadoId(mercado_id);
	}

	@Override
	public boolean setMercado(Mercado mercado) {
		// TODO Auto-generated method stub
		return pmDao.setMercado(mercado);
	}

	@Override
	public boolean updateMercado(Mercado mercado) {
		// TODO Auto-generated method stub
		return pmDao.updateMercado(mercado);
	}

	@Override
	public boolean deleteMercado(Mercado mercado) {
		// TODO Auto-generated method stub
		return pmDao.deleteMercado(mercado);
	}

	@Override
	public Usuario getUsuarioEmail(String cliente_email) {
		// TODO Auto-generated method stub
		return pmDao.getUsuarioEmail(cliente_email);
	}

	@Override
	public List<TipoNegocio> getAllRubro() {
		// TODO Auto-generated method stub
		return pmDao.getAllRubro();
	}

	@Override
	public TipoNegocio getRubro(int rubro_id) {
		// TODO Auto-generated method stub
		return pmDao.getRubro(rubro_id);
	}

	@Override
	public boolean createPuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		return pmDao.createPuesto(puesto);
	}

	@Override
	public List<Puesto> getPuestos(int mercado_id) {
		// TODO Auto-generated method stub
		return pmDao.getPuestos(mercado_id);
	}

	@Override
	public Puesto getPuestoId(int puesto_id) {
		// TODO Auto-generated method stub
		return pmDao.getPuestoId(puesto_id);
	}

	@Override
	public boolean updatePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		return pmDao.updatePuesto(puesto);
	}

	@Override
	public boolean deletePuesto(Puesto puesto) {
		// TODO Auto-generated method stub
		return pmDao.deletePuesto(puesto);
	}

}
