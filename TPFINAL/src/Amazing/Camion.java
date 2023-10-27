package Amazing;

public class Camion extends Transporte {

	protected double valorAdicional;
	
	Camion(String patente, int volMax, int valorViaje, double valorAdicional) {
		super(patente, volMax, valorViaje);
		this.valorAdicional = valorAdicional;
	}
	
	public void calcularAdicional() {
		if (!cargado) {
			throw new RuntimeException("El vehiculo no esta cargado, no se puede calcular hasta que se cargue.");
		}
		this.valor += valorAdicional * carga.size();
	}
	
	public boolean coincideRequisitos(Paquete paq) {
		if (paq.getClass().equals("Especial") && paq.devolverVolumen() > 2000) {
			return true;
		}
		return false;
	}
	
	public void cargarPaquete(int cod, Paquete paq) {
		carga.put(paq.devolverCodigo(), paq);
	}
}
