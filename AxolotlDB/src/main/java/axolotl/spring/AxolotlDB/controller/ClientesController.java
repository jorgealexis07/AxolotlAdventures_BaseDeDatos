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

import axolotl.spring.AxolotlDB.controller.model.ChangeContr_cliente;
import axolotl.spring.AxolotlDB.controller.model.Clientes;
import axolotl.spring.AxolotlDB.controller.service.ClientesService;


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
	
	@GetMapping(path="{Id_Clientes}")  // http://localhost:8080/api/clientes/1
	public Clientes getClientes(@PathVariable("id_Clientes") Long id_Clientes) {
		return clientesService.getClientes(id_Clientes);
	}//getClientes
	
	@DeleteMapping(path="{Id_Clientes}")  // http://localhost:8080/api/clientes/1
	public Clientes deleteClientes(@PathVariable("id_Clientes") Long id_Clientes) {
		return clientesService.getClientes(id_Clientes);
	}//deleteClientes
	
	@PostMapping
	public Clientes addClientes(@RequestBody Clientes clientes) {
		return clientesService.addClientes(clientes);
	}//addClientes
	
	 @PutMapping (path="{Id_Clientes}") // http://localhost:8080/api/clientes/1
	 public Clientes updateClientes(@PathVariable("Id_Clientes") Long id_Clientes,
			@RequestParam(required=false) String nom_cliente,
			@RequestParam(required=false) String app_cliente,
			@RequestParam(required=false) String email_cliente,
			@RequestParam(required=false) String cel_cliente,
			@RequestParam(required=false) String contr_cliente,
			@RequestBody ChangeContr_cliente changeContr_cliente) {
		   return clientesService.updateClientes(id_Clientes, nom_cliente, app_cliente, email_cliente, cel_cliente, contr_cliente, changeContr_cliente.getContr_cliente());
	 }//updateClientes
	
	//@PutMapping (path= "{Id_Clientes}") // http://localhost:8080/api/clientes/1
	//public Clientes updateClientes(@PathVariable("Id_Clientes") Long id_Clientes,
		//	@RequestBody ChangeContr_cliente changeContr_cliente) {
		//return clientesService.updateClientes(id_Clientes, changeContr_cliente.getContr_cliente(),
			//	changeContr_cliente.getNewContr_cliente());
	//}

 }//UsuarioController
			

