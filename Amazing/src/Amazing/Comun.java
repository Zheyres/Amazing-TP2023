package Amazing;

public class Comun extends Transporte {

	protected int limite;
	
	Comun(String patente, double volMax, double valorViaje, int maxPaq) {
		super(patente, volMax, valorViaje);
		this.limite = maxPaq;
	}
	
	public boolean coincideRequisitos(Paquete paq) {
		if (paq.getClass().getName().equals("Ordinario") &&  paq.devolverVolumen() < 2000) {
			return true;
		}
		return false;
	}
	
	public void cargarPaquete(int cod, Paquete paq) {
		carga.put(paq.devolverCodigo(), paq);
	}
	
	public void calcularAdicional() {
	}
}