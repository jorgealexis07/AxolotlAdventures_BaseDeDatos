package axolotl.spring.AxolotlDB.service;

import java.util.Optional;

import axolotl.spring.AxolotlDB.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientesRepository extends JpaRepository <Clientes, Long>{

	@Query("SELECT u FROM Clientes u WHERE u.email_cliente=?1") // JPQL
	Optional<Clientes> findByEmail(String email_cliente);

}
