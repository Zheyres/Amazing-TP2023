package Amazing;

public abstract class Paquete {

	protected int codigo;
	protected double volumen;
	protected double precio;
	protected boolean entregado;
	
	Paquete(int codigo, double volumen, double precio) {
		this.codigo = codigo;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = false;
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
	
	public boolean devolverEstado() {
		return this.entregado;
	}
	
	public void actualizarEstado() {
		this.entregado = true;
	}
	
	//public abstract void calcularAdicional();
}