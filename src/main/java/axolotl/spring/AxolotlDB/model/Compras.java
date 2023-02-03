package axolotl.spring.AxolotlDB.model;

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
	private String date_compras;
	private int numpx_actv;
	private double precio_total;
	public Compras(String date_compras, int numpx_actv, double precio_total) { 
      super();
      this.date_compras=date_compras;
      this.numpx_actv=numpx_actv;
      this.precio_total=precio_total;
 
	}//constructor
	
	public Compras() { } //constructor	

	public Long getId_ComprasClientes() {
		return id_ComprasClientes;
	}

	

	public String getDate_compras() {
		return date_compras;
	}

	public void setDate_compras(String date_compras) {
		this.date_compras = date_compras;
	}

	public int getNumpx_actv() {
		return numpx_actv;
	}

	public void setNumpx_actv(int numpx_actv) {
		this.numpx_actv = numpx_actv;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	
	

	
}//class Compras
