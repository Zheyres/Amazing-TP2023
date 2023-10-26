package tp;

public class Ordinario extends Paquete{

	protected int envio;
	
	Ordinario(int codigo, int volumen, int precio, int envio) {
		super(codigo, volumen, precio);
		this.envio = envio;
	}
	
	public void calcularAdicional() {
		this.precio += envio;
	}
}
