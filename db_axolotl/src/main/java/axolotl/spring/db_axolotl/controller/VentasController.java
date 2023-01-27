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

import axolotl.spring.db_axolotl.controller.model.Ventas;
import axolotl.spring.db_axolotl.controller.service.VentasService;

@RestController
@RequestMapping(path="/api/ventas/")

public class VentasController {
private final VentasService ventasService;
    
	@Autowired
	public VentasController(VentasService ventasService) {
		this.ventasService = ventasService;
	}//constructor
	
	@GetMapping   // http://localhost:8080/api/ventas
	public List<Ventas> getAllVentas(){
		return ventasService.getAllVentas();
	}//getAllVentas
	
	@GetMapping(path="{ventId}")  // http://localhost:8080/api/ventas/1
	public Ventas getActividades(@PathVariable("ventId") Long id2) {
		return ventasService.getVentas(id2);
	}//getActividades
	
	@DeleteMapping(path="{ventId}")  // http://localhost:8080/api/ventas/1
	public Ventas deleteVentas(@PathVariable("ventId") Long id2) {
		return ventasService.getVentas(id2);
	}//deleteActividades
	
	@PostMapping
	public Ventas addVentas(@RequestBody Ventas ventas) {
		return ventasService.addVentas(ventas);
	}//addActividades
	
	@PutMapping (path="{ventId}") // http://localhost:8080/api/ventas/1
	public Ventas updateVentas(@PathVariable("ventId") Long id2,
			@RequestParam(required=false) String date,
			@RequestParam(required=false) int numpx,
			@RequestParam(required=false) Double precioTotal) {
		    return ventasService.updateVentas(id2, date, numpx, precioTotal);
	}//updateVentas
			

}//Class VentasController
