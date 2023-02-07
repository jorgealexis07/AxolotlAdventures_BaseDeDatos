package axolotl.spring.AxolotlDB.service;

import java.util.List;
import java.util.Optional;

import axolotl.spring.AxolotlDB.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ClientesService {

	private final ClientesRepository clientesRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	public ClientesService(ClientesRepository clientesRepository) {
		this.clientesRepository = clientesRepository;
	}//Constructor
	public List<Clientes> getAllClientes(){
      return clientesRepository.findAll();
	}//getAllClientes
	
	public Clientes getClientes(Long id_Clientes) {
		return clientesRepository.findById(id_Clientes).orElseThrow(
				()-> new IllegalArgumentException("El cliente con el id " + id_Clientes +
						" no existe.")
				);
		
	}//getClientes
	
	public Clientes deleteClientes(Long id_Clientes) {
		Clientes tmp=null;
		if(clientesRepository.existsById(id_Clientes)){
			tmp=clientesRepository.findById(id_Clientes).get();
			clientesRepository.deleteById(id_Clientes);
		}//if
		return tmp;
	}//deleteClientes
	
	public Clientes addClientes(Clientes clientes) {
		clientes.setPassword(passwordEncoder.encode(clientes.getPassword()));
		return clientesRepository.save(clientes);
	}//addClientes
	
	

	//Duda... lo mismo de la numeración de ID's
	public Clientes updateClientes(Long id_Clientes, String nom_cliente, String app_cliente, String email_cliente, 
		   String cel_cliente, String contr_cliente) {
		Clientes tmp=null;
		if(clientesRepository.existsById(id_Clientes)){
			tmp=clientesRepository.findById(id_Clientes).get();
			if (nom_cliente!=null) tmp.setNom_cliente(nom_cliente);
			if (app_cliente!=null) tmp.setApp_cliente(app_cliente);
			if (email_cliente!=null) tmp.setEmail_cliente(email_cliente);
			if (cel_cliente!=null) tmp.setCel_cliente(cel_cliente);
			if (contr_cliente!=null) tmp.setContr_cliente(contr_cliente);
			
			clientesRepository.save(tmp);
		}else {
			System.out.println("Update - El Cliente con el id " + id_Clientes +
					"no existe");
		}//if
		return tmp;
	}//updateClientes
	
	public boolean validaClientes(Clientes clientes) {
        Optional<Clientes> userByEmail= clientesRepository.findByEmail(clientes.getEmail_cliente());
		if(userByEmail.isPresent()) {
			Clientes c = userByEmail.get();
			if(c.getContr_cliente().equals(clientes.getContr_cliente())){
				return true;
			}//if equals
		}//if isPresent
        		return false;
	}//validaUsuario
		
}//class ClientesService
