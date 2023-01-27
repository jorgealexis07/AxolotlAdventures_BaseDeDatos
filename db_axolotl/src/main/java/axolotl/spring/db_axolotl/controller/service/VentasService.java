package axolotl.spring.db_axolotl.controller.service;

import java.util.List;

import axolotl.spring.db_axolotl.controller.model.Ventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VentasService {

	private final VentasRepository ventasRepository;
	@Autowired
	public VentasService(VentasRepository ventasRepository) {
		this.ventasRepository = ventasRepository;
	}//Constructor
	public List<Ventas> getAllVentas(){
      return ventasRepository.findAll();
	}//getAllVentas
	
	public Ventas getVentas(Long id2) {
		return ventasRepository.findById(id2).orElseThrow(
				()-> new IllegalArgumentException("La venta con el id " + id2 +
						" no existe.")
				);
		
	}//getVentas
	public Ventas deleteVentas(Long id2) {
		Ventas tmp=null;
		if(ventasRepository.existsById(id2)){
			tmp=ventasRepository.findById(id2).get();
			ventasRepository.deleteById(id2);
		}//if
		return tmp;
	}//deleteVentas
	
	public Ventas addVentas(Ventas ventas) {
		return ventasRepository.save(ventas);
	}//addVentas
	
	//Duda.... Double es minúscula o mayúscula?
	//Duda2... en vez de null el 0
	public Ventas updateVentas(Long id2, String date, int numpx, Double precioTotal) {
		Ventas tmp=null;
		if(ventasRepository.existsById(id2)){
			tmp=ventasRepository.findById(id2).get();
			if (date!=null) tmp.setDate(date);
			if (numpx!=0) tmp.setNumpx(numpx);
			if (precioTotal!=0) tmp.setPrecioTotal(precioTotal.doubleValue());
			ventasRepository.save(tmp);
		}else {
			System.out.println("Update - La venta con el id " + id2 +
					"no existe");
		}//if
		return tmp;
	}//updateVentas
		
}//class VentasService
