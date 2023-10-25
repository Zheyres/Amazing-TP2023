package tp;

public class Camion extends Transporte {

	protected double valorAdicional;
	
	Camion(String patente, double volumen, double valor, double valorAdicional) {
		super(patente, volumen, valor);
		this.valorAdicional = valorAdicional;
	}

	public void calcularAdicional() {
		if (!cargado) {
			throw new RuntimeException("El vehiculo no esta cargado, no se puede calcular hasta que se cargue.");
		}
		this.valor += valorAdicional * carga.size();
	}
	
	public void cargarPaquete() {
		
	}
}
