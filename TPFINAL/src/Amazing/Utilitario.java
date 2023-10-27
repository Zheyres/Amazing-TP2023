package Amazing;

public class Utilitario extends Transporte {

	protected double valorExtra;
	
	Utilitario(String patente, int volMax, int valorViaje, double valorExtra) {
		super(patente, volMax, valorViaje);
		this.valorExtra = valorExtra;
	}
	
	public void calcularValorExtra() {
		if (carga.size() > 3) {
			this.valor += this.valorExtra;
		}
	}
	
	public boolean coincideRequisitos(Paquete paq) {
		return true;
	}
	
	public void cargarPaquete(int cod, Paquete paq) {
		carga.put(paq.devolverCodigo(), paq);
	}
}
