package tp;

public class Camion extends Transporte {

	protected double valorAdicional;
	
	Camion(String patente, double volumen, double valor, double valorAdicional) {
		super(patente, volumen, valor);
		this.valorAdicional = valorAdicional;
	}
	
	public void cargarPaquete() {
		
	}
}
