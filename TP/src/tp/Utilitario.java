package tp;

public class Utilitario extends Transporte {

	protected double valorExtra;
	
	Utilitario(String patente, int volumen, int valor, int valorExtra) {
		super(patente, volumen, valor);
		this.valorExtra = valorExtra;
	}
	
	public void calcularValorExtra() {
		if (carga.size() > 3) {
			this.valor += this.valorExtra;
		}
	}
	
	public void cargarPaquete() {
		
	}
}
