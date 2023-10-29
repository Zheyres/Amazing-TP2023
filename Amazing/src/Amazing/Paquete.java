package Amazing;

public abstract class Paquete {

	protected int codigo;
	protected double volumen;
	protected double precio;
	protected String entregado;
	
	Paquete(int codigo, double volumen, double precio) {
		this.codigo = codigo;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = "pendiente";
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
	
	public String devolverEstado() {
		return this.entregado;
	}
	
	public void actualizarEstado() {
		this.entregado = "cargado";
	}
	
	//public abstract void calcularAdicional();
}