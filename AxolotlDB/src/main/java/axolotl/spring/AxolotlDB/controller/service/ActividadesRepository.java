package axolotl.spring.AxolotlDB.controller.service;

import axolotl.spring.AxolotlDB.controller.model.Actividades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadesRepository extends JpaRepository <Actividades, Long> {

}
