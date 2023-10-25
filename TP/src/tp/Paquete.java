package tp;

public abstract class Paquete {

	protected int codigo;
	protected double volumen;
	protected double precio;
	protected String entregado;
	
	Paquete(int codigo, double volumen, double precio) {
		
	}
	
	public int devolverCodigo() {
		return this.codigo;
	}
	
	public double devolverVolumen() {
		return this.volumen;
	}
	
	public double devolverPrecio() {
		return this.precio;
	}
	
	public abstract void calcularAdicional();
}
