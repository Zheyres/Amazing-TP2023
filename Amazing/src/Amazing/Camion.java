package Amazing;

public class Camion extends Transporte {

	protected double valorAdicional;
	
	Camion(String patente, double volMax, double valorViaje, double valorAdicional) {
		super(patente, volMax, valorViaje);
		this.valorAdicional = valorAdicional;
	}
	
	public void calcularAdicional() {
		this.valor += (valorAdicional * carga.size());
	}
	
	public boolean coincideRequisitos(Paquete paq) {
		if (paq.getClass().getName().equals("Especial") && paq.devolverVolumen() > 2000) {
			return true;
		}
		return false;
	}
	
	public void cargarPaquete(int cod, Paquete paq) {
		carga.put(paq.devolverCodigo(), paq);
	}
}
