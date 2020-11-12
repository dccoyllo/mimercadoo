package udaff.edu.pe.dao;


import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Usuario;

public interface ClienteDao {
	//datos de la sesion del usuario
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
