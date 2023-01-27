package axolotl.spring.db_axolotl.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")

public class Clientes {

	//Duda... sobre numeración de Id's
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id3", unique=true, nullable=false)
	private Long id3;
	@Column(nullable=false)
	private String nombre;
	private String app;
	private String email;
	private String contr;
	public Clientes(String nombre, String app, String email, String contr) { 
      super();
      this.nombre=nombre;
      this.app=app;
      this.email=email;
      this.contr=contr;

	}//constructor
	
	public Clientes() { } //constructor	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContr() {
		return contr;
	}

	public void setContr(String contr) {
		this.contr = contr;
	}

	public Long getId() {
		return id3;
	}

	
}//class Clientes
