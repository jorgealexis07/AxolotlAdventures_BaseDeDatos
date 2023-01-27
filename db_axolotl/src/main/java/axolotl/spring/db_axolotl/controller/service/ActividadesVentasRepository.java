package axolotl.spring.db_axolotl.controller.service;

import org.springframework.data.jpa.repository.JpaRepository;

import axolotl.spring.db_axolotl.controller.model.Actividades_has_Ventas;

public interface ActividadesVentasRepository extends JpaRepository<Actividades_has_Ventas, Long> {

}
