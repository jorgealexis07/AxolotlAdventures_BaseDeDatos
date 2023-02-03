package axolotl.spring.AxolotlDB.model;

public class ChangeContr_cliente {

	private String contr_cliente;
    private String newContr_cliente;
	public ChangeContr_cliente(String contr_cliente, String newContr_cliente) {
		super();
		this.contr_cliente = contr_cliente;
		this.newContr_cliente = newContr_cliente;
	}//constructor
	
	public ChangeContr_cliente() {} //constructor

	
	public String getContr_cliente() {
		return contr_cliente;
	}

	public void setContr_cliente(String contr_cliente) {
		this.contr_cliente = contr_cliente;
	}

	public String getNewContr_cliente() {
		return newContr_cliente;
	}

	public void setNewContr_cliente(String newContr_cliente) {
		this.newContr_cliente = newContr_cliente;
	}

	@Override
	public String toString() {
		return "ChangeContr_cliente [contr_cliente=" + contr_cliente + ", newContr_cliente=" + newContr_cliente + "]";
	}

	
    
    
}//classChangeContr_cliente
