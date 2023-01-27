package axolotl.spring.db_axolotl.controller.service;

import axolotl.spring.db_axolotl.controller.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}


