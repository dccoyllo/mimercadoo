package udaff.edu.pe.dao;

import java.util.List;

import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.Usuario;

public interface MercadoDao {

	public Mercado getMercadoId(int mercado_id);
	public boolean setMercado(Mercado mercado);
	public boolean updateMercado(Mercado mercado);
	public boolean deleteMercado(Mercado mercado);
	
	//creando los puestos y ver los puestos a su cargo
	public Usuario getUsuarioEmail(String cliente_email);
	public List<TipoNegocio> getAllRubro();
	public TipoNegocio getRubro(int rubro_id);
	public boolean createPuesto(Puesto puesto);
	public List<Puesto> getPuestos(int mercado_id);
	public Puesto getPuestoId(int puesto_id);
	public boolean updatePuesto(Puesto puesto);
	public boolean deletePuesto(Puesto puesto);
	
}
