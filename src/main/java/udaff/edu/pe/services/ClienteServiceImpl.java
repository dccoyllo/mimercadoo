package udaff.edu.pe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import udaff.edu.pe.dao.ClienteDao;
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

}
