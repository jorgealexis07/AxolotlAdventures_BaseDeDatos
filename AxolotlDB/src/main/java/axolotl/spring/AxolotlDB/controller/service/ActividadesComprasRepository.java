package axolotl.spring.AxolotlDB.controller.service;

import org.springframework.data.jpa.repository.JpaRepository;

import axolotl.spring.AxolotlDB.controller.model.Actividades_has_Compras;

public interface ActividadesComprasRepository  extends JpaRepository <Actividades_has_Compras, Long> {

}
