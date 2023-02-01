package axolotl.spring.AxolotlDB.controller;

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


import axolotl.spring.AxolotlDB.model.Actividades;
import axolotl.spring.AxolotlDB.service.ActividadesService;

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
	
	@GetMapping(path="{Id_actividades}")  // http://localhost:8080/api/actividades/1
	public Actividades getActividades(@PathVariable("id_actividades") Long id_actividades) {
		return actividadesService.getActividades(id_actividades);
	}//getActividades
	
	@DeleteMapping(path="{Id_actividades}")  // http://localhost:8080/api/actividades/1
	public Actividades deleteActividades(@PathVariable("id_actividades") Long id_actividades) {
		return actividadesService.getActividades(id_actividades);
	}//deleteActividades
	
	@PostMapping
	public Actividades addActividades(@RequestBody Actividades actividades) {
		return actividadesService.addActividades(actividades);
	}//addActividades
	
	@PutMapping (path="{Id_actividades}") // http://localhost:8080/api/productos/1
	public Actividades updateActividades(@PathVariable("Id_actividades") Long id_actividades,
			@RequestParam(required=false) String nom_actv,
			@RequestParam(required=false) String descrip_actv,
			@RequestParam(required=false) String img_actv,
			@RequestParam(required=false) int precio_actv) {
		    return actividadesService.updateActividades(id_actividades, nom_actv, descrip_actv, img_actv, precio_actv);
	}//updateActividades
			

}//Class ActividadesController
