package udaff.edu.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.ClienteDao;
import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Usuario;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteDao cliDao;
	
	@Override
	public Usuario getUsuarioId(int usuario_id) {
		// TODO Auto-generated method stub
		return cliDao.getUsuarioId(usuario_id);
	}

	@Override
	public boolean updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return cliDao.updateUsuario(usuario);
	}

	@Override
	public boolean deleteUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return cliDao.deleteUsuario(usuario);
	}

	@Override
	public Carrito getCarrito(CarritoId user_catalogo_id) {
		// TODO Auto-generated method stub
		return cliDao.getCarrito(user_catalogo_id);
	}

	@Override
	public boolean createCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return cliDao.createCarrito(carrito);
	}

	@Override
	public boolean updateCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return cliDao.updateCarrito(carrito);
	}

	@Override
	public boolean deleteCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return cliDao.deleteCarrito(carrito);
	}

	@Override
	public Catalogo getCatalogoId(int catalogo_id) {
		// TODO Auto-generated method stub
		return cliDao.getCatalogoId(catalogo_id);
	}

	@Override
	public boolean updateCatalogoCantidad(Catalogo catalogo) {
		// TODO Auto-generated method stub
		cliDao.updateCatalogoCantidad(catalogo);
		return true;
	}

}
