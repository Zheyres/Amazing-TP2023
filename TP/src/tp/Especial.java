package tp;

public class Especial extends Paquete{

	protected double porcentaje;
	protected double valor;
	
	Especial(int codigo, double volumen, double precio, double porcentaje, double valor) {
		super(codigo, volumen, precio);
		this.porcentaje = porcentaje;
		this.valor = valor;
	}
	
	public void calcularAdicional() {
		
	}
}
