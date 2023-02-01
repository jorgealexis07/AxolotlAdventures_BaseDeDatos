package axolotl.spring.AxolotlDB.model;

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
		@Column(name="id_Clientes", unique=true, nullable=false)
		private Long id_Clientes;
		@Column(nullable=false)
		private String nom_cliente;
		private String app_cliente;
		private String email_cliente;
		@Column(nullable=false)
		private String cel_cliente;
		private String contr_cliente;
		public Clientes(String nom_cliente, String app_cliente, String email_cliente, String cel_cliente, String contr_cliente) { 
	      super();
	      this.nom_cliente=nom_cliente;
	      this.app_cliente=app_cliente;
	      this.email_cliente=email_cliente;
	      this.cel_cliente=cel_cliente;
	      this.contr_cliente=contr_cliente;

		}//constructor
		
		public Clientes() { } //constructor	

		public Long getId_Clientes() {
			return id_Clientes;
		}


		public String getNom_cliente() {
			return nom_cliente;
		}

		public void setNom_cliente(String nom_cliente) {
			this.nom_cliente = nom_cliente;
		}

		public String getApp_cliente() {
			return app_cliente;
		}

		public void setApp_cliente(String app_cliente) {
			this.app_cliente = app_cliente;
		}

		public String getEmail_cliente() {
			return email_cliente;
		}

		public void setEmail_cliente(String email_cliente) {
			this.email_cliente = email_cliente;
		}

		public String getCel_cliente() {
			return cel_cliente;
		}

		public void setCel_cliente(String cel_cliente) {
			this.cel_cliente = cel_cliente;
		}

		public String getContr_cliente() {
			return contr_cliente;
		}

		public void setContr_cliente(String contr_cliente) {
			this.contr_cliente = contr_cliente;
		}

		@Override
		public String toString() {
			return "Clientes [id_Clientes=" + id_Clientes + ", nom_cliente=" + nom_cliente + ", app_cliente=" + app_cliente
					+ ", email_cliente=" + email_cliente + ", cel_cliente=" + cel_cliente + ", contr_cliente="
					+ contr_cliente + "]";
		}//toString
		
		
	}//class Clientes

