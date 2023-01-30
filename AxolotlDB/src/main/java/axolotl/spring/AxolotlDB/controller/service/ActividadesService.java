package axolotl.spring.AxolotlDB.controller.service;

import java.util.List;

import axolotl.spring.AxolotlDB.controller.model.Actividades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ActividadesService {

	private final ActividadesRepository actividadesRepository;
	@Autowired
	public ActividadesService(ActividadesRepository actividadesRepository) {
		this.actividadesRepository = actividadesRepository;
	}//Constructor
	public List<Actividades> getAllActividades(){
      return actividadesRepository.findAll();
	}//getAllActividades
	
	
	public Actividades getActividades(Long id_Actividades) {
		return actividadesRepository.findById(id_Actividades).orElseThrow(
				()-> new IllegalArgumentException("La actividad con el id " + id_Actividades +
						" no existe.")
				);
		
	}//getActividades
	public Actividades deleteActividades(Long id_Actividades) {
		Actividades tmp=null;
		if(actividadesRepository.existsById(id_Actividades)){
			tmp=actividadesRepository.findById(id_Actividades).get();
			actividadesRepository.deleteById(id_Actividades);
		}//if
		return tmp;
	}//deleteActividades
	
	public Actividades addActividades(Actividades actividades) {
		return actividadesRepository.save(actividades);
	}//addActividades
	
	public Actividades updateActividades(Long id_Actividades, String nom_actv, String descrip_actv, 
			String img_actv, int precio_actv) {
		Actividades tmp=null;
		if(actividadesRepository.existsById(id_Actividades)){
			tmp=actividadesRepository.findById(id_Actividades).get();
			if (nom_actv!=null) tmp.setNom_actv(nom_actv);
			if (descrip_actv!=null) tmp.setDescrip_actv(descrip_actv);
			if (img_actv!=null) tmp.setImg_actv(img_actv);
			if (precio_actv!=0) tmp.setPrecio_actv(precio_actv);
			actividadesRepository.save(tmp);
		}else {
			System.out.println("Update - La actividad con el id " + id_Actividades +
					"no existe");
		}//if
		return tmp;
	}//updateActividades
		
}//class ActividadesService
