package ETF_principales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etfsprincipales")
public class fondos {
	
	
	
	public fondos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "fondos [Id=" + Id + ", Nombre=" + Nombre + ", Geografia=" + Geografia + ", TER=" + TER + "]";
	}

	


	public fondos(String nombre, String geografia, Double tER) {
		Nombre = nombre;
		Geografia = geografia;
		TER = tER;
	}

	


	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getGeografia() {
		return Geografia;
	}



	public void setGeografia(String geografia) {
		Geografia = geografia;
	}



	public Double getTER() {
		return TER;
	}



	public void setTER(Double tER) {
		TER = tER;
	}




	@Id
	@Column(name="Id")
	private int Id;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Geografia")
	private String Geografia;
	
	@Column(name="TER")
	private Double TER;

}
