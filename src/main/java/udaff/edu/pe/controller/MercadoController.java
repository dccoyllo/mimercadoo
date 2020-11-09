package udaff.edu.pe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.Perfil;
import udaff.edu.pe.entities.Puesto;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.services.ClienteService;
import udaff.edu.pe.services.MercadoService;

@RestController
@RequestMapping("/api/v2/private/mercado")
@CrossOrigin("*")
public class MercadoController {
	@Autowired
	private MercadoService mService;
	@Autowired
	private ClienteService cliService;

	@PostMapping("/create")
	@ResponseBody
	public boolean setMercado(@RequestBody ObjectNode data) {
		Mercado mercado = new Mercado();
		mercado.setUsuario(mService.getUsuarioEmail(data.get("user_email").asText()));
		mercado.setFechaCreada(new Date());
		System.out.println(data);
		return mService.setMercado(mercado);
	}

	@PutMapping("/update")
	@ResponseBody
	public boolean updateMercado(@RequestParam int id, @RequestParam String nombre, @RequestParam String imagen,
			@RequestParam String direccion, @RequestParam String horaInicio, @RequestParam String horaFin,
			@RequestParam String descripcion, @RequestParam String fundacion, @RequestParam String tipo,
			@RequestParam int puestos, @RequestParam String geolocalizacion) {
		Mercado mercado = mService.getMercadoId(id);
		mercado.setNombre(nombre);
		mercado.setImagen(imagen);
		mercado.setDireccion(direccion);
		mercado.setHoraInicio(horaInicio);
		mercado.setHoraFin(horaFin);
//		mercado.setHoraFin(Time.valueOf(horaFin));
		mercado.setDescripcion(descripcion);
		mercado.setFundacion(fundacion);
		mercado.setTipo(tipo);
		mercado.setPuestos(puestos);
		mercado.setGeolocalizacion(geolocalizacion);

		return mService.updateMercado(mercado);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public boolean deteleteMercado(@PathVariable int id) {
		Mercado mercado = mService.getMercadoId(id);
		return mService.deleteMercado(mercado);
	}

	@PostMapping("/create-puesto")
	@ResponseBody
	public boolean setPuesto(@RequestParam String email, @RequestParam int id, @RequestParam int idtipopuesto,
			@RequestParam Date fechaCreada) {
		Usuario usuario = mService.getUsuarioEmail(email);
		Perfil perfil = new Perfil();
		perfil.setIdPerfil(3);
		usuario.setPerfil(perfil);
		cliService.updateUsuario(usuario);
		Puesto puesto = new Puesto();
		puesto.setUsuario(usuario);
		puesto.setIdmercado(id);
		puesto.setFechaCreada(fechaCreada);
		puesto.setTipoNegocio(mService.getRubro(idtipopuesto));

		return mService.createPuesto(puesto);
	}

}
