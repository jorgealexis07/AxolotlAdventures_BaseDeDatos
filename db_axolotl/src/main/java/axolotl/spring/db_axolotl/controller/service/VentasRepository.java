package axolotl.spring.db_axolotl.controller.service;

import axolotl.spring.db_axolotl.controller.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Ventas, Long>{

}//Interface VentasRepository