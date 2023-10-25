package tp;

public class Ordinario extends Paquete{

	protected double envio;
	
	Ordinario(int codigo, double volumen, double precio, double envio) {
		super(codigo, volumen, precio);
		this.envio = envio;
	}
	
	public void calcularAdicional() {
		
	}
}
