package udaff.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
