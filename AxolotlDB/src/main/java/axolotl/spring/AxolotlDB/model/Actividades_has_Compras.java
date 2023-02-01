package axolotl.spring.AxolotlDB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Actividades_has_Ventas")

public class Actividades_has_Compras {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Actividades_id_Actividades", unique=true, nullable=false)
	private Long Actividades_id_Actividades;
	@Column(nullable=false)
	private int Compras_id_ComprasClientes;
	private int Compras_Clientes_id_Clientes;
	public Actividades_has_Compras(int Compras_id_ComprasClientes, int Compras_Clientes_id_Clientes) { 
      super();
      this.Compras_id_ComprasClientes=Compras_id_ComprasClientes;
      this.Compras_Clientes_id_Clientes=Compras_Clientes_id_Clientes;

	}//constructor
	
	public Actividades_has_Compras() { } //constructor	

	public Long getActividades_id_Actividades() {
		return Actividades_id_Actividades;
	}

	public int getCompras_id_ComprasClientes() {
		return Compras_id_ComprasClientes;
	}

	public int getCompras_Clientes_id_Clientes() {
		return Compras_Clientes_id_Clientes;
	}

	
	
	
}//class Actividades_has_Compras

