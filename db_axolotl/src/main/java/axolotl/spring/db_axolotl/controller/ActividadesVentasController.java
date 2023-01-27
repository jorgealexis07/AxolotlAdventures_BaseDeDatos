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

import axolotl.spring.db_axolotl.controller.model.Acitivades_has_Ventas;
import axolotl.spring.db_axolotl.controller.model.Ventas;
import axolotl.spring.db_axolotl.controller.service.ActividadesVentasService;
import axolotl.spring.db_axolotl.controller.service.VentasService;

@RestController
@RequestMapping(path="/api/actividadesVentas/")

public class ActividadesVentasController {
private final ActividadesVentasService actividadesVentasService;
    
	@Autowired
	public ActividadesVentasController(ActividadesVentasService actividadesVentasService) {
		this.actividadesVentasService = actividadesVentasService;
	}//constructor
	
	@GetMapping   // http://localhost:8080/api/actividadesVentas
	public List<ActividadesVentas> getAllActividadesVentas(){
		return actividadesVentasService.getAllActividadesVentas();
	}//getAllVentas
	
	@GetMapping(path="{avId}")  // http://localhost:8080/api/actividadesVentas/1
	public ActividadesVentas getActividadesVentas(@PathVariable("avId") Long id4) {
		return actividadesVentasService.getActividadesVentas(id4);
	}//getActividadesVentas
	
	@DeleteMapping(path="{avId}")  // http://localhost:8080/api/actividadesVentas/1
	public ActividadesVentas deleteActividadesVentas(@PathVariable("avId") Long id4) {
		return actividadesVentasService.getActividadesVentas(id4);
	}//deleteActividadesVentas
	
	@PostMapping
	public ActividadesVentas addActividadesVentas(@RequestBody ActividadesVentas actividadesVentas) {
		return actividadesVentasService.addVentas(actividadesVentas);
	}//addActividadesVentas
	
	@PutMapping (path="{avId}") // http://localhost:8080/api/actividadesVentas/1
	public Ventas updateActividadesVentas(@PathVariable("avtId") Long id4,
			@RequestParam(required=false) int Actividades_id_Actividades,
			@RequestParam(required=false) int Ventas_id_VentasClientes,
			@RequestParam(required=false) int Ventas_Clientes_id_Clientes) {
		    return actividadesVentasService.updateVentas(id4, Actividades_id_Actividades, Ventas_id_VentasClientes, Ventas_Clientes_id_Clientes);
	}//updateActividadesVentas
			

}//Class ActividadesVentas
