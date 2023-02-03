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

import axolotl.spring.AxolotlDB.model.Compras;
import axolotl.spring.AxolotlDB.service.ComprasService;

@RestController
@RequestMapping(path="/api/compras/")


public class ComprasController {

private final ComprasService comprasService;
    
	@Autowired
	public ComprasController(ComprasService comprasService) {
		this.comprasService = comprasService;
	}//constructor
	
	@GetMapping   // http://localhost:8080/api/compras
	public List<Compras> getAllCompras(){
		return comprasService.getAllCompras();
	}//getAllCompras
	
	@GetMapping(path="{Id_ComprasClientes}")  // http://localhost:8080/api/compras/1
	public Compras getCompras(@PathVariable("Id_ComprasClientes") Long id_ComprasClientes) {
		return comprasService.getCompras(id_ComprasClientes);
	}//getCompras
	
	@DeleteMapping(path="{Id_ComprasClientes}")  // http://localhost:8080/api/compras/1
	public Compras deleteCompras(@PathVariable("Id_ComprasClientes") Long id_ComprasClientes) {
		return comprasService.deleteCompras(id_ComprasClientes);
	}//deleteCompras
	
	@PostMapping
	public Compras addCompras(@RequestBody Compras compras) {
		return comprasService.addCompras(compras);
	}//addCompras
	
	@PutMapping (path="{Id_ComprasClientes}") // http://localhost:8080/api/compras/1
	public Compras updateCompras(@PathVariable("Id_ComprasClientes") Long id_ComprasClientes,
			@RequestParam(required=false) String date_compras,
			@RequestParam(required=false) int numpx_actv,
			@RequestParam(required=false) Double precio_total) {
		    return comprasService.updateCompras(id_ComprasClientes, date_compras, numpx_actv, precio_total);
	}//updateCompras
			

}//Class ComprasController
