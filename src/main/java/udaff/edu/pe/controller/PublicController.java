package udaff.edu.pe.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import udaff.edu.pe.entities.Allcatalogos;
import udaff.edu.pe.entities.Login;
import udaff.edu.pe.entities.Mercado;
import udaff.edu.pe.entities.Perfil;
import udaff.edu.pe.entities.TipoNegocio;
import udaff.edu.pe.entities.TipoProducto;
import udaff.edu.pe.entities.Usuario;
import udaff.edu.pe.services.PublicService;
import udaff.edu.pe.util.EncriptarClave;
import udaff.edu.pe.util.UploadFileService;

@RestController
@RequestMapping("/api/v2/public")
@CrossOrigin("*")
public class PublicController {
	@Autowired
	private PublicService publicService;

	@Autowired
	private UploadFileService ufService;

	@GetMapping("/rubros")
	@ResponseBody
	public List<TipoNegocio> getAllRubros() {
		return publicService.getAllRubros();
	}

	@GetMapping("/categoria/{rubro_id}")
	@ResponseBody
	public List<TipoProducto> getAllCategorias(@PathVariable int rubro_id) {
		return publicService.getAllCategorias(rubro_id);
	}

	@GetMapping("/mercado")
	@ResponseBody
	public List<Mercado> getAllMercados() {
		return publicService.getAllMercados();
	}

	@GetMapping("/mercado/{mercado_id}")
	@ResponseBody
	public Mercado getMercadoId(@PathVariable int mercado_id) {
		return publicService.getMercadoId(mercado_id);
	}

	@GetMapping("/catalogo/m/{mercado_id}")
	@ResponseBody
	public List<Allcatalogos> getAllCatalogosMercado(@PathVariable int mercado_id) {
		return publicService.getAllCatalogosMercado(mercado_id);
	}

	@GetMapping("/catalogo/p/{puesto_id}")
	@ResponseBody
	public List<Allcatalogos> getAllCatalogosPuesto(@PathVariable int puesto_id) {
		return publicService.getAllCatalogosPuesto(puesto_id);
	}

	@GetMapping("/catalogo/{catalogo_id}")
	@ResponseBody
	public Allcatalogos getCatalogo(@PathVariable int catalogo_id) {
		return publicService.getCatalogo(catalogo_id);
	}

	@GetMapping("/catalogo/r/{rubro_id}")
	@ResponseBody
	public List<Allcatalogos> getAllCatalogosRubro(@PathVariable int rubro_id) {
		return publicService.getAllCatalogosRubro(rubro_id);
	}

	@GetMapping("/catalogo/c/{categoria_id}")
	@ResponseBody
	public List<Allcatalogos> getAllCatalogosCategoria(@PathVariable int categoria_id) {
		return publicService.getAllCatalogosCategoria(categoria_id);
	}

	@PostMapping("/login")
	@ResponseBody
	public Login getLogin(@RequestParam String cuenta, @RequestParam String clave) {
		// @RequestBody ObjectNode objeto
		EncriptarClave encript = new EncriptarClave();
		return publicService.getSession(cuenta, encript.encode(clave));
	}

	@PostMapping("/newlogin")
	@ResponseBody
	public boolean setUsuario(@RequestParam String cuenta, @RequestParam String email, @RequestParam String clave) {
		EncriptarClave encript = new EncriptarClave();
		Usuario usuario = new Usuario();
		Perfil perfil = new Perfil();
		perfil.setIdPerfil(1);

		// convirtiendo la primera letra a mayuscula
		String nombreCuenta = Character.toUpperCase(cuenta.charAt(0)) + cuenta.substring(1, cuenta.length());

		usuario.setCuenta(cuenta);
		usuario.setEmail(email);
		usuario.setClave(encript.encode(clave));
		usuario.setPerfil(perfil);
		usuario.setNombre("");
		usuario.setApellido("");
		usuario.setEdad(0);
		usuario.setNombreCuenta(nombreCuenta);
		usuario.setFechaCreada(new Date());

		try {
			publicService.setUsuario(usuario);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			return false;
		}

	}

	@PostMapping("/img/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getResource().getFilename());
		if (file.isEmpty()) {
			return new ResponseEntity<>("Seleccionar un archivo", HttpStatus.OK);
		}

		try {
			ufService.saveFileCatalogo(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
	}

}
