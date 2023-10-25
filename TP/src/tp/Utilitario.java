package tp;

public class Utilitario extends Transporte {

	protected double valorExtra;
	
	Utilitario(String patente, double volumen, double valor, double valorExtra) {
		super(patente, volumen, valor);
		this.valorExtra = valorExtra;
	}
	
	public void calcularValorExtra() {
		this.valor = this.valorExtra * carga.size();
	}
	
	public void cargarPaquete() {
		
	}
}
