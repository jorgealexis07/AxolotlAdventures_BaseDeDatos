package axolotl.spring.AxolotlDB.controller.service;

import axolotl.spring.AxolotlDB.controller.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository <Compras, Long> {

}
