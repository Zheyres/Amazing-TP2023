package tp;

import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {

	protected int codPedido;
	protected String nombre;
	protected String direccion;
	protected int dni;
	protected HashMap<Integer, Paquete> carrito;
	protected double costoTotal;
	protected boolean cerrado;
	
	
	Pedido(String nombre, String direccion, int dni) {
		//this.codPedido = codPedido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.cerrado = false;
	}

	public Paquete getPaquete(int codPaq) {
		if (!carrito.containsKey(codPaq)) {
			throw new RuntimeException("No contiene el paquete.");
		}
		return carrito.get(codPaq);
	}
	
	public void agregarProducto(int codProducto, Paquete paq) {
		if (carrito.containsKey(codProducto)) {
			throw new RuntimeException("El producto ya existe.");
		}
		else if (!cerrado) {
			throw new RuntimeException("El pedido ya esta cerrado.");
		}
		carrito.put(codProducto, paq);
		this.costoTotal += paq.precio;
	}

	public void eliminarProducto(int codProd) {
		if (carrito.containsKey(codProd)) {
			carrito.remove(codProd);
		}
		else {
			throw new RuntimeException("El producto no existe.");
		}
	}
	
	public double valorAPagar() {
		if (!cerrado) {
			throw new RuntimeException("El pedido todavia no esta cerrado.");
		}
		return this.costoTotal;
	}
	
	public ArrayList<Paquete> devolverCarrito() {
		ArrayList<Paquete> copiaCarrito = new ArrayList<Paquete>();
		for (int cod:carrito.keySet()) {
			copiaCarrito.add(getPaquete(cod));
		}
		return copiaCarrito;
	}
	
	public void cerrarPedido() {
		this.cerrado = true;
	}

	/**
	 * @return Si esta o no cerrado
	 */
	public boolean isCerrado() {
		return cerrado;
	}
}

