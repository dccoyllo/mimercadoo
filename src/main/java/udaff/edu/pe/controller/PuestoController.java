package udaff.edu.pe.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.TipoVenta;
import udaff.edu.pe.services.PuestoService;

@RestController
@RequestMapping("/api/v2/private/puesto")
@CrossOrigin("*")
public class PuestoController {
	@Autowired
	private PuestoService pService;

	@PutMapping("/update")
	@ResponseBody
	public boolean updatePuesto(@RequestParam int id, @RequestParam String nombre, @RequestParam String imagen,
			@RequestParam String descripcion, @RequestParam boolean estado) {
		Puesto puesto = pService.getIdPuesto(id);
		puesto.setNombre(nombre);
		puesto.setImagen(imagen);
		puesto.setDescripcion(descripcion);
		puesto.setEstado(estado);
		return pService.updatePuesto(puesto);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public boolean deletePuesto(@PathVariable int id) {
		return pService.deletePuesto(pService.getIdPuesto(id));
	}
	
	@GetMapping("/tipoventa")
	@ResponseBody
	public List<TipoVenta> getAllTipoVenta() {
		return pService.getAllTipoVenta();
	}
	
	@PostMapping("/catalogo/create")
	@ResponseBody
	public boolean createCatalogo(@RequestBody ObjectNode dataCatalogo) {
		Catalogo catalogo = new Catalogo();
		
		System.out.println(dataCatalogo);
		catalogo.setTitulo(dataCatalogo.get("titulo").asText());
		catalogo.setImagen(dataCatalogo.get("imagen").asText());
		catalogo.setIdTipoProducto(dataCatalogo.get("tipoProducto_id").asInt());
		catalogo.setTipoVenta(pService.getTipoVenta(dataCatalogo.get("tipoVenta_id").asInt()));
		catalogo.setPrecio(dataCatalogo.get("precio").asDouble());
		catalogo.setCantidad(dataCatalogo.get("cantidad").asInt());
		catalogo.setFechaCreada(new Date());
		catalogo.setPuesto(pService.getIdPuesto(dataCatalogo.get("puesto_id").asInt()));
		return pService.setCatalogo(catalogo);
	}

	@PutMapping("/catalogo/update")
	@ResponseBody
	public boolean updateCatalogo(@RequestBody ObjectNode dataCatalogo) {
		System.out.println(dataCatalogo);
		System.out.println(pService.getCatalogoId(dataCatalogo.get("catalogo_id").asInt()).getTitulo());
		Catalogo catalogo = pService.getCatalogoId(dataCatalogo.get("catalogo_id").asInt());
		catalogo.setTitulo(dataCatalogo.get("titulo").asText());
		catalogo.setImagen(dataCatalogo.get("imagen").asText());
		catalogo.setIdTipoProducto(dataCatalogo.get("tipoProducto_id").asInt());
		catalogo.setTipoVenta(pService.getTipoVenta(dataCatalogo.get("tipoVenta_id").asInt()));
		catalogo.setPrecio(dataCatalogo.get("precio").asDouble());
		catalogo.setCantidad(dataCatalogo.get("cantidad").asInt());
		catalogo.setFechaCreada(new Date());
		return pService.updateCatalogo(catalogo);
	}

	@DeleteMapping("/catalogo/delete/{id}")
	@ResponseBody
	public boolean deleteCatalogo(@PathVariable int id) {
		return pService.deleteCatalogo(pService.getCatalogoId(id));
	}
}
