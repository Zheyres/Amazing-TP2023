package Amazing;

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
	
	Pedido(int codPedido, String nombre, String direccion, int dni) {
		this.codPedido = codPedido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.cerrado = false;
		this.costoTotal = 0;
	}
	
	public boolean devolverEstado() {
		return this.cerrado;
	}
	
	public String devolverNombre() {
		return this.nombre;
	}
	
	public double devolverCostoTotal() {
		return this.costoTotal;
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
		this.costoTotal += paq.devolverPrecio();
	}

	public boolean eliminarProducto(int codProd) {
		if (carrito.containsKey(codProd) && devolverEstado() == false) {
			carrito.remove(codProd);
			return true;
		}
		else {
			return false;
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

	public boolean tienePaquetesNoEntregados() {
		boolean acum = false;
		for (int cod:carrito.keySet()) {
			if (getPaquete(cod).devolverEstado().equals("pendiente")) {
				acum = acum || true;
			}
		}
		return acum;
	}


}
