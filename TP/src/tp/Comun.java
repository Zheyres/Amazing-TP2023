package tp;

public class Comun extends Transporte {

	protected int limite;
	
	Comun(String patente, double volumen, double valor, int limite) {
		super(patente, volumen, valor);
		this.limite = limite;
	}
	
	public void cargarPaquete() {
		
	}
}
