package axolotl.spring.AxolotlDB.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Compras")

public class Compras {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_ComprasClientes", unique=true, nullable=false)
	private Long id_ComprasClientes;
	@Column(nullable=false)
	private String date_Compras;
	private int numpx_actv;
	private int precio_total;
	public Compras(String date_Compras, int numpx_actv, int precio_total) { 
      super();
      this.date_Compras=date_Compras;
      this.numpx_actv=numpx_actv;
      this.precio_total=precio_total;
 
	}//constructor
	
	public Compras() { } //constructor	

	public Long getId_ComprasClientes() {
		return id_ComprasClientes;
	}

	public String getDate_Compras() {
		return date_Compras;
	}

	public void setDate_Compras(String date_Compras) {
		this.date_Compras = date_Compras;
	}

	public int getNumpx_actv() {
		return numpx_actv;
	}

	public void setNumpx_actv(int numpx_actv) {
		this.numpx_actv = numpx_actv;
	}

	public int getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}
	
	

	
}//class Compras
