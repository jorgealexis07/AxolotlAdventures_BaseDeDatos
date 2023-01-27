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

import axolotl.spring.db_axolotl.controller.model.Clientes;
import axolotl.spring.db_axolotl.controller.service.ClientesService;


@RestController
@RequestMapping(path="/api/clientes/")

public class ClientesController {
private final ClientesService clientesService;
    
	@Autowired
	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}//constructor
	
	@GetMapping   // http://localhost:8080/api/clientes
	public List<Clientes> getAllClientes(){
		return clientesService.getAllClientes();
	}//getAllClientes
	
	@GetMapping(path="{clId}")  // http://localhost:8080/api/clientes/1
	public Clientes getClientes(@PathVariable("clId") Long id3) {
		return clientesService.getClientes(id3);
	}//getClientes
	
	@DeleteMapping(path="{clId}")  // http://localhost:8080/api/clientes/1
	public Clientes deleteClientes(@PathVariable("clId") Long id3) {
		return clientesService.getClientes(id3);
	}//deleteClientes
	
	@PostMapping
	public Clientes addClientes(@RequestBody Clientes clientes) {
		return clientesService.addClientes(clientes);
	}//addClientes
	
	@PutMapping (path="{clId}") // http://localhost:8080/api/clientes/1
	public Clientes updateClientes(@PathVariable("clId") Long id3,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) String app,
			@RequestParam(required=false) String email,
			@RequestParam(required=false) String contr) {
		    return clientesService.updateClientes(id3, nombre, app, email, contr);
	}//updateClientes
			

}//Class ClientesController

