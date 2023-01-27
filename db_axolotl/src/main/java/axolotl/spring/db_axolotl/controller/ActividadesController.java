package axolotl.spring.db_axolotl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import axolotl.spring.db_axolotl.controller.model.Actividades;
import axolotl.spring.db_axolotl.controller.service.ActividadesService;

@RestController
@RequestMapping(path="/api/actividades/")

public class ActividadesController {
private final ActividadesService actividadesService;
    
	@Autowired
	public ActividadesController(ActividadesService actividadesService) {
		this.actividadesService = actividadesService;
	}//constructor
	
	@GetMapping   // http://localhost:8080/api/actividades
	public List<Actividades> getAllActividades(){
		return actividadesService.getAllActividades();
	}//getAllActividades
	
	@GetMapping(path="{actId}")  // http://localhost:8080/api/actividades/1
	public Actividades getActividades(@PathVariable("actId") Long id) {
		return actividadesService.getActividades(id);
	}//getActividades
	
	@DeleteMapping(path="{actId}")  // http://localhost:8080/api/actividades/1
	public Actividades deleteActividades(@PathVariable("actId") Long id) {
		return actividadesService.getActividades(id);
	}//deleteActividades
	
	@PostMapping
	public Actividades addActividades(@RequestBody Actividades actividades) {
		return actividadesService.addActividades(actividades);
	}//addActividades
	
	@PutMapping (path="{actId}") // http://localhost:8080/api/productos/1
	public Actividades updateActividades(@PathVariable("actId") Long id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String descripcion,
			@RequestParam(required=false) String imagen,
			@RequestParam(required=false) Double precio) {
		    return actividadesService.updateActividades(id, nombre, descripcion, imagen, precio);
	}//updateActividades
			

}//Class ActividadesController
