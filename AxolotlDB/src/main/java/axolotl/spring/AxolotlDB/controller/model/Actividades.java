package axolotl.spring.AxolotlDB.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Actividades")

public class Actividades {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id_Actividades", unique=true, nullable=false)
	private Long id_Actividades;
	@Column(nullable=false)
	private String nom_actv;
	private String descrip_actv;
	private String img_actv;
	private int precio_actv;
	public Actividades(String nom_actv, String descrip_actv, String img_actv, int precio_actv) { 
      super();
      this.nom_actv=nom_actv;
      this.descrip_actv=descrip_actv;
      this.img_actv=img_actv;
      this.precio_actv=precio_actv;

	}//constructor
	
	public Actividades() { } //constructor	

	public Long getId_actividades() {
		return id_Actividades;
	}


	public String getNom_actv() {
		return nom_actv;
	}

	public void setNom_actv(String nom_actv) {
		this.nom_actv = nom_actv;
	}

	public String getDescrip_actv() {
		return descrip_actv;
	}

	public void setDescrip_actv(String descrip_actv) {
		this.descrip_actv = descrip_actv;
	}

	public String getImg_actv() {
		return img_actv;
	}

	public void setImg_actv(String img_actv) {
		this.img_actv = img_actv;
	}

	public int getPrecio_actv() {
		return precio_actv;
	}

	public void setPrecio_actv(int precio_actv) {
		this.precio_actv = precio_actv;
	}
	
	
	
}//class Actividades
