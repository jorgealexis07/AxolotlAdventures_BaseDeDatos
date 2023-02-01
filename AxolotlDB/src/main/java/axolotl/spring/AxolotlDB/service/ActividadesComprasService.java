package axolotl.spring.AxolotlDB.service;

import java.util.List;

import axolotl.spring.AxolotlDB.model.Actividades_has_Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadesComprasService {

	private final ActividadesComprasRepository actividadesComprasRepository;
	@Autowired
	public ActividadesComprasService(ActividadesComprasRepository actividadesComprasRepository) {
		this.actividadesComprasRepository = actividadesComprasRepository;
	}//Constructor
	public List<Actividades_has_Compras> getAllActividadesCompras(){
      return actividadesComprasRepository.findAll();
	}//getAllActividadesCompras
	
	public Actividades_has_Compras getActividadesCompras(Long Actividades_id_Actividades) {
		return actividadesComprasRepository.findById(Actividades_id_Actividades).orElseThrow(
				()-> new IllegalArgumentException("El cliente con el id " + Actividades_id_Actividades +
						" no existe.")
				);
		
	}//getActividadesCompras
	public Actividades_has_Compras deleteActividadesCompras(Long Actividades_id_Actividades) {
		Actividades_has_Compras tmp=null;
		if(actividadesComprasRepository.existsById(Actividades_id_Actividades)){
			tmp=actividadesComprasRepository.findById(Actividades_id_Actividades).get();
			actividadesComprasRepository.deleteById(Actividades_id_Actividades);
		}//if
		return tmp;
	}//deleteActividadesCompras
	
	public Actividades_has_Compras addActividadesCompras(Actividades_has_Compras actividades_has_Compras) {
		return actividadesComprasRepository.save(actividades_has_Compras);
	}//addActividadesCompras
	
	
	//no coloqué el update porque siento no se necesita pero cualquier cosa dejo este espacio
	
		
}//class ActividadesComprasService
