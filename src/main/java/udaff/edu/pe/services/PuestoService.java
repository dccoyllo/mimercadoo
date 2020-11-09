package udaff.edu.pe.services;

import java.util.List;

import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.TipoVenta;

public interface PuestoService {
	
	public Puesto getIdPuesto(int puesto_id);
	
	public boolean updatePuesto(Puesto puesto);
	public boolean deletePuesto(Puesto puesto);
	
	public List<TipoProducto> getTipoProductoPorRubro(int rubro_id);
	public TipoProducto getTipoProductoId(int tipoProducto_Id);
	
	public List<TipoVenta> getAllTipoVenta();
	public TipoVenta getTipoVenta(int tipoVenta_id);
	
	public boolean setCatalogo(Catalogo catalogo);
	public Catalogo getCatalogoId(int catalogo_id);
	public boolean updateCatalogo(Catalogo catalogo);
	public boolean deleteCatalogo(Catalogo catalago);
}
