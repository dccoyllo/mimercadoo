package udaff.edu.pe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.services.ClienteService;

@RestController
@RequestMapping("/api/v2/private/cliente")
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private ClienteService cliService;

	@PostMapping("/updateuser")
	@ResponseBody
	public boolean updateUsuario(@RequestParam int id, @RequestParam String email, @RequestParam String nombreCuenta,
			@RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad,
			@RequestParam String clave) {
		Usuario usuario = cliService.getUsuarioId(id);
		usuario.setEmail(email);
		usuario.setNombreCuenta(nombreCuenta);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEdad(edad);
		usuario.setClave(clave);

		return cliService.updateUsuario(usuario);
	}

	@PostMapping("/carrito/add")
	@ResponseBody
	public boolean agregandoCarrito(@RequestBody ObjectNode dataCarrito) {
		CarritoId id = new CarritoId(dataCarrito.get("catalogo_id").asInt(), dataCarrito.get("usuario_id").asInt());
		Carrito carrito = cliService.getCarrito(id);
		Catalogo catalogo = cliService.getCatalogoId(id.getIdCatalogo());
		boolean estado = false;
		
		if (carrito == null) {

			Usuario usuario = cliService.getUsuarioId(id.getIdusuario());
			Carrito carritoNew = new Carrito();
			carritoNew.setId(id);
			carritoNew.setCatalogo(catalogo);
			carritoNew.setUsuario(usuario);
			carritoNew.setFechaCreada(new Date());
			carritoNew.setCantidad(dataCarrito.get("cantidad").asInt());
			System.out.println("creando");
			catalogo.setCantidad(catalogo.getCantidad()-dataCarrito.get("cantidad").asInt());
			estado = cliService.createCarrito(carritoNew);

		} else {
			System.out.println(carrito.getUsuario().getCuenta());
			carrito.setFechaCreada(new Date());
			carrito.setCantidad(dataCarrito.get("cantidad").asInt());
			System.out.println("actualizando");
			catalogo.setCantidad(catalogo.getCantidad()-dataCarrito.get("cantidad").asInt());
			estado = cliService.updateCarrito(carrito);
		}

		return estado;
	}

	@DeleteMapping("/carrito/delete")
	@ResponseBody
	public boolean deleteCarrito(@RequestBody ObjectNode dataCarrito) {
		CarritoId id = new CarritoId(dataCarrito.get("catalogo_id").asInt(), dataCarrito.get("usuario_id").asInt());
		Carrito carrito = cliService.getCarrito(id);
		return cliService.deleteCarrito(carrito);
	}
}
