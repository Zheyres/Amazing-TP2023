package tp;

public class Especial extends Paquete{

	protected int porcentaje;
	protected int valor;
	
	Especial(int codigo, int volumen, int precio, int porcentaje, int valor) {
		super(codigo, volumen, precio);
		this.porcentaje = porcentaje;
		this.valor = valor;
	}
	
	public void calcularAdicional() {
		this.precio *= porcentaje / 100;
		if (volumen > 3000 && volumen < 5000) {
			this.precio += valor;
		}
		else if (volumen > 5000) {
			this.precio += valor*2;
		}
	}
}
