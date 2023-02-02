package axolotl.spring.AxolotlDB.service;

import java.util.List;

import axolotl.spring.AxolotlDB.model.Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class ComprasService {

	private final ComprasRepository comprasRepository;
	@Autowired
	public ComprasService(ComprasRepository comprasRepository) {
		this.comprasRepository = comprasRepository;
	}//Constructor
	public List<Compras> getAllCompras(){
      return comprasRepository.findAll();
	}//getAllCompras
	
	public Compras getCompras(Long id_ComprasClientes) {
		return comprasRepository.findById(id_ComprasClientes).orElseThrow(
				()-> new IllegalArgumentException("La compra con el id " + id_ComprasClientes +
						" no existe.")
				);
		
	}//getCompras
	public Compras deleteCompras(Long id_ComprasClientes) {
		Compras tmp=null;
		if(comprasRepository.existsById(id_ComprasClientes)){
			tmp=comprasRepository.findById(id_ComprasClientes).get();
			comprasRepository.deleteById(id_ComprasClientes);
		}//if
		return tmp;
	}//deleteCompras
	
	public Compras addCompras(Compras compras) {
		return comprasRepository.save(compras);
	}//addCompras
	
	//Duda.... Double es minúscula o mayúscula?
	//Duda2... en vez de null el 0
	public Compras updateCompras(Long id_ComprasClientes, String date_compras, int numpx_actv, Double precio_total) {
		Compras tmp=null;
		if(comprasRepository.existsById(id_ComprasClientes)){
			tmp=comprasRepository.findById(id_ComprasClientes).get();
			if (date_compras!=null) tmp.setDate_compras(date_compras);
			if (numpx_actv!=0) tmp.setNumpx_actv(numpx_actv);
			if (precio_total!=null) tmp.setPrecio_total(precio_total.doubleValue());
			comprasRepository.save(tmp);
		}else {
			System.out.println("Update - La compra con el id " + id_ComprasClientes +
					"no existe");
		}//if
		return tmp;
	}//updateCompras

}//class ComprasService
