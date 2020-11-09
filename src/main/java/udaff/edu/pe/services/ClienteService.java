package udaff.edu.pe.services;

import udaff.edu.pe.entities.Usuario;

public interface ClienteService {
	public Usuario getUsuarioId(int usuario_id);
	public boolean updateUsuario(Usuario usuario);
	public boolean deleteUsuario(Usuario usuario);
}
