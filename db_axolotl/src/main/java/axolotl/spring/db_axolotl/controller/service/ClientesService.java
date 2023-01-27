package axolotl.spring.db_axolotl.controller.service;

import java.util.List;

import axolotl.spring.db_axolotl.controller.model.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientesService {

	private final ClientesRepository clientesRepository;
	@Autowired
	public ClientesService(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}//Constructor
	public List<Clientes> getAllClientes(){
      return clientesRepository.findAll();
	}//getAllClientes
	
	public Clientes getClientes(Long id3) {
		return clientesRepository.findById(id3).orElseThrow(
				()-> new IllegalArgumentException("El cliente con el id " + id3 +
						" no existe.")
				);
		
	}//getClientes
	public Clientes deleteClientes(Long id3) {
		Clientes tmp=null;
		if(clientesRepository.existsById(id3)){
			tmp=clientesRepository.findById(id3).get();
			clientesRepository.deleteById(id3);
		}//if
		return tmp;
	}//deleteClientes
	
	public Clientes addClientes(Clientes clientes) {
		return clientesRepository.save(clientes);
	}//addClientes
	
	
	//Duda... lo mismo de la numeración de ID's
	public Clientes updateClientes(Long id3, String nombre, String app, String email, 
			String contr) {
		Clientes tmp=null;
		if(clientesRepository.existsById(id3)){
			tmp=clientesRepository.findById(id3).get();
			if (nombre!=null) tmp.setNombre(nombre);
			if (app!=null) tmp.setApp(app);
			if (email!=null) tmp.setEmail(email);
			if (contr!=null) tmp.setContr(contr);
			clientesRepository.save(tmp);
		}else {
			System.out.println("Update - El Cliente con el id " + id3 +
					"no existe");
		}//if
		return tmp;
	}//updateClientes
		
}//class ClientesService
