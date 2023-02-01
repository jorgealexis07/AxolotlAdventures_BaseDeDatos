package axolotl.spring.AxolotlDB.service;

import axolotl.spring.AxolotlDB.model.Actividades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadesRepository extends JpaRepository <Actividades, Long> {

}
