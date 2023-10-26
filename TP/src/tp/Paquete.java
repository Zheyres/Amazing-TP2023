package tp;

public abstract class Paquete {

	/**
	 *  codigo de identificacion del paquete
	 */
	protected int codigo; 
	/**
	 * Volumen que ocupa el paquete en la carga
	 */
	protected int volumen; 
	/**
	 * Precio del producto dentro del paquete
	 */
	protected int precio; 
	/**
	 * Estatuds del paquete
	 */
	protected String entregado;
	/**
	 * Costo base del envio del paquete
	 */
	protected int costoDeEnvioBase; 
	
	Paquete(int codigo, int volumen, int precio) {
		this.codigo = codigo;
		this.volumen = volumen;
		this.precio = precio;
		this.entregado = "pendiente";
	}
	
	public int devolverCodigo() {
		return this.codigo;
	}
	
	public int devolverVolumen() {
		return this.volumen;
	}
	
	public int devolverPrecio() {
		return this.precio;
	}
	public int devolverCostoEnvio() {
		return this.costoDeEnvioBase;
	}
	
	public abstract void calcularAdicional();

	/**
	 * @return the entregado
	 */
	public String getEntregado() {
		return entregado;
	}

	/**
	 * @param entregado the entregado to set
	 */
	public void setEntregado(String entregado) {
		this.entregado = entregado;
	}
}
