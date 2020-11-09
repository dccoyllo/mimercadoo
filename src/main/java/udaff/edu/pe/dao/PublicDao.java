package udaff.edu.pe.dao;

import java.util.List;

import udaff.edu.pe.entities.Allcatalogos;
import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.Usuario;

public interface PublicDao {
	
	//datos de la sesion del usuario
	public void updateUsuario(Usuario usuario);
	
	//datos de página de login
	public Login getSession(String cuenta, String clave);

	//datos de página de nueva cuenta
	public void setUsuario(Usuario usuario);
	
	public List<TipoNegocio> getAllRubros();
	
	public List<TipoProducto> getAllCategorias(int rubro_id);
	
	public List<Allcatalogos> getAllCatalogosMercado(int mercado_id);
	
	public List<Allcatalogos> getAllCatalogosPuesto(int puesto_id);

	public Allcatalogos getCatalogo(int catalogo_id);
	
	public List<Allcatalogos> getAllCatalogosRubro(int rubro_id);
	
	public List<Allcatalogos> getAllCatalogosCategoria(int categoria_id);
	
	public List<Mercado> getAllMercados();
	
	public Mercado getMercadoId(int mercado_id);


}
