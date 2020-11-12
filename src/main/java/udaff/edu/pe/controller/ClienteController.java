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

import udaff.edu.pe.entities.Carrito;
import udaff.edu.pe.entities.CarritoId;
import udaff.edu.pe.entities.Catalogo;
import udaff.edu.pe.entities.DetalleCarrito;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.services.ClienteService;
import udaff.edu.pe.util.EncriptarClave;

@RestController
@RequestMapping("/api/v2/private/cliente")
@CrossOrigin("*")
public class ClienteController {
	@Autowired
	private ClienteService cliService;

	@PutMapping("/updateuser")
	@ResponseBody
	public boolean updateUsuario(@RequestBody ObjectNode dataUsuario, @RequestParam int id, @RequestParam String email, @RequestParam String nombreCuenta,
			@RequestParam String nombre, @RequestParam String apellido, @RequestParam int edad,
			@RequestParam String clave) {
		Usuario usuario = cliService.getUsuarioId(dataUsuario.get("usuario_id").asInt());
		usuario.setEmail(dataUsuario.get("email").asText());
		usuario.setNombreCuenta(dataUsuario.get("nombre_cuenta").asText());
		usuario.setNombre(dataUsuario.get("nombre").asText());
		usuario.setApellido(dataUsuario.get("apellido").asText());
		usuario.setEdad(dataUsuario.get("edad").asInt());
		EncriptarClave encript = new EncriptarClave();
		usuario.setClave(encript.encode(dataUsuario.get("clave").asText()));

		return cliService.updateUsuario(usuario);
	}
	
	@GetMapping("/carrito/{usuario_id}")
	public List<DetalleCarrito> getAllCarritoUsuarioId(@PathVariable int usuario_id) {
		return cliService.getAllCarritoUsuarioId(usuario_id);
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
			System.out.println("creando item del carrito");
			catalogo.setCantidad(catalogo.getCantidad()-dataCarrito.get("cantidad").asInt());
			estado = cliService.createCarrito(carritoNew);

		} else {
			carrito.setFechaCreada(new Date());
			carrito.setCantidad(dataCarrito.get("cantidad").asInt());
			System.out.println("actualizando item del carrito");
			catalogo.setCantidad(catalogo.getCantidad()-dataCarrito.get("cantidad").asInt());
			estado = cliService.updateCarrito(carrito);
		}

		return estado;
	}

	@DeleteMapping("/carrito/delete/{catalogo_id}/{usuario_id}")
	@ResponseBody
	public boolean deleteCarrito(@PathVariable int catalogo_id, @PathVariable int usuario_id) {
		CarritoId id = new CarritoId(catalogo_id, usuario_id);
		Carrito carrito = cliService.getCarrito(id);
		System.out.println("item del carrito eliminado");
		return cliService.deleteCarrito(carrito);
	}
}
