package axolotl.spring.db_axolotl.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Actividades_has_Ventas")

public class Actividades_has_Ventas {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id4", unique=true, nullable=false)
	private Long id4;
	@Column(nullable=false)
	private int Actividades_id_Actividades;
	private int Ventas_id_VentasClientes;
	private int Ventas_Clientes_id_Clientes;
	public Actividades_has_Ventas(int Actividades_id_Actividades, int Ventas_id_VentasClientes, int Ventas_Clientes_id_Clientes) { 
      super();
      this.Actividades_id_Actividades=Actividades_id_Actividades;
      this.Ventas_id_VentasClientes=Ventas_id_VentasClientes;
      this.Ventas_Clientes_id_Clientes=Ventas_Clientes_id_Clientes;

	}//constructor
	
	public Actividades_has_Ventas() { } //constructor	
	
	

	public int getActividades_id_Actividades() {
		return Actividades_id_Actividades;
	}

	public void setActividades_id_Actividades(int actividades_id_Actividades) {
		Actividades_id_Actividades = actividades_id_Actividades;
	}

	public int getVentas_id_VentasClientes() {
		return Ventas_id_VentasClientes;
	}

	public void setVentas_id_VentasClientes(int ventas_id_VentasClientes) {
		Ventas_id_VentasClientes = ventas_id_VentasClientes;
	}

	public int getVentas_Clientes_id_Clientes() {
		return Ventas_Clientes_id_Clientes;
	}

	public void setVentas_Clientes_id_Clientes(int ventas_Clientes_id_Clientes) {
		Ventas_Clientes_id_Clientes = ventas_Clientes_id_Clientes;
	}

	public Long getId() {
		return id4;
	}

	
}//class Actividades_has_Ventas

