package axolotl.spring.AxolotlDB.service;

import axolotl.spring.AxolotlDB.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository <Compras, Long> {

}
