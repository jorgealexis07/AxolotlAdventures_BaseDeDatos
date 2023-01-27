package axolotl.spring.db_axolotl.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ventas")

public class Ventas {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id2", unique=true, nullable=false)
	private Long id2;
	@Column(nullable=false)
	private String date;
	private int numpx;
	private double precioTotal;
	public Ventas(String date, int numpx, double precioTotal) { 
      super();
      this.date=date;
      this.numpx=numpx;
      this.precioTotal=precioTotal;

	}//constructor
	
	public Ventas() { } //constructor	
	
	

	public Long getId() {
		return id2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNumpx() {
		return numpx;
	}

	public void setNumpx(int numpx) {
		this.numpx = numpx;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	
}//class Ventas



