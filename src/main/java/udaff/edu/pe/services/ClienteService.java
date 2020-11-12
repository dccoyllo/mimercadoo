package udaff.edu.pe.services;

import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Usuario;

public interface ClienteService {
	public Usuario getUsuarioId(int usuario_id);
	public boolean updateUsuario(Usuario usuario);
	public boolean deleteUsuario(Usuario usuario);
	
	public Carrito getCarrito(CarritoId user_catalogo_id);
	public Catalogo getCatalogoId(int catalogo_id);
	public boolean updateCatalogoCantidad(Catalogo catalogo);
	public boolean createCarrito(Carrito carrito);
	public boolean updateCarrito(Carrito carrito);
	public boolean deleteCarrito(Carrito carrito);
}
