package Amazing;

public class Ordinario extends Paquete{

	protected double envio;
	
	Ordinario(int codigo, double volumen, double precio, double envio) {
		super(codigo, volumen, precio+envio);
		this.envio = envio;
	}
	
//	public void calcularAdicional(double precio, double envio) {
//		precio += envio;
//	}
}