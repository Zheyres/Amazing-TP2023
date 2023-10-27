package Amazing;

public class Especial extends Paquete{

	protected double porcentaje;
	protected double valor;
	
	Especial(int codigo, double volumen, double precio, double porcentaje, double valor) {
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
