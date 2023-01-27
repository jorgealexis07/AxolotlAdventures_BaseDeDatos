package axolotl.spring.db_axolotl.controller.service;

import java.util.List;

import axolotl.spring.db_axolotl.controller.model.Actividades;
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
	
	
	public Actividades getActividades(Long id) {
		return actividadesRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La actividad con el id " + id +
						" no existe.")
				);
		
	}//getActividades
	public Actividades deleteActividades(Long id) {
		Actividades tmp=null;
		if(actividadesRepository.existsById(id)){
			tmp=actividadesRepository.findById(id).get();
			actividadesRepository.deleteById(id);
		}//if
		return tmp;
	}//deleteActividades
	
	public Actividades addActividades(Actividades actividades) {
		return actividadesRepository.save(actividades);
	}//addActividades
	
	public Actividades updateActividades(Long id, String nombre, String descripcion, 
			String imagen, Double precio) {
		Actividades tmp=null;
		if(actividadesRepository.existsById(id)){
			tmp=actividadesRepository.findById(id).get();
			if (nombre!=null) tmp.setNombre(nombre);
			if (descripcion!=null) tmp.setDescripcion(descripcion);
			if (imagen!=null) tmp.setImagen(imagen);
			if (precio!=null) tmp.setPrecio(precio.doubleValue());
			actividadesRepository.save(tmp);
		}else {
			System.out.println("Update - La actividad con el id " + id +
					"no existe");
		}//if
		return tmp;
	}//updateActividades
		
}//class ActividadesService