package listadodeobjetos;

public class Coches {
	private String matricula;
	private String marca;
	private String modelo;
	private String gama;
	private double precio;
	
	Coches(){}
	
	Coches(String matricula, String marca, String modelo, String gama, double precio){
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.gama = gama;
		this.precio = precio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getGama() {
		return gama;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setGama(String gama) {
		this.gama = gama;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	//pasa por encima do metodo toString() que devolve o nombre da clase + o hashcode
	  public String toString() {
	        return "Matricula " + this.matricula + ", Marca : " + marca +", Modelo " + this.modelo + ", Gama : " + gama + ", Precio : " + precio;
	    }
}
