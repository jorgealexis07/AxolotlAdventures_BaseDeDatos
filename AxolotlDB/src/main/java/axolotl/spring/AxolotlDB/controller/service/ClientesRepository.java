package axolotl.spring.AxolotlDB.controller.service;

import java.util.Optional;

import axolotl.spring.AxolotlDB.controller.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientesRepository extends JpaRepository <Clientes, Long>{

	@Query("SELECT u From Usuario u WHERE u.email=?1") // JPQL
	Optional<Clientes> findByEmail(String email_cliente);

}
