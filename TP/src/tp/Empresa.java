package tp;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {

	protected String cuit;
	protected HashMap<Integer, Pedido> pedidos;
	protected String nombre;
	protected HashMap<String, Transporte> transportes;
	
	Empresa(String cuit) {
		this.cuit = cuit;
	}
	
	public boolean contienePed(int codPedido) {
		if (!pedidos.containsKey(codPedido)) {
			throw new RuntimeException("No existe un pedido con ese codigo.");
		}
		return true;
	}
	
	public Pedido getPedido(int codPedido) {
		contienePed(codPedido);
		return pedidos.get(codPedido);
	}
	
	public Transporte getTransporte(String patente) {
		if (transportes.containsKey(patente)) {
			return transportes.get(patente);
		}
		throw new RuntimeException("No existe ese transporte.");
	}
	
	public void registrarPedido(int codPedido, String nombre, String direccion, String dni) {
		if (pedidos.containsKey(codPedido)) {
			throw new RuntimeException("Ya esta registrado un pedido con ese codigo.");
		}
		else {
			Pedido nuevo = new Pedido(codPedido, nombre, direccion, dni);
			pedidos.put(codPedido, nuevo);
		}
	}
	
	public void agregarACarrito(int codPedido, int codProd, Paquete paq) {
		contienePed(codPedido);
		getPedido(codPedido).agregarProducto(codProd, paq);
		
	}
	
	public void eliminarProducto(int codPedido, int codProd) {
		contienePed(codPedido);
		getPedido(codPedido).eliminarProducto(codProd);
	}
	

	public void agregarTransporte(String patente, Transporte vehiculo) {
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya existe ese transporte.");
		}
		else {
			transportes.put(patente, vehiculo);
		}
	}
	
	public void cargarTransporte(String patente) {
		
	}
	
	public ArrayList<Paquete> devolverListadoDePaquetes(String patente) {
		if (!transportes.containsKey(patente)) {
			throw new RuntimeException("No existe ese transporte.");
		}
		return getTransporte(patente).devolverCarga();
	}

	public double costoAPagarViaje(String patente) {
		if (!transportes.containsKey(patente)) {
			throw new RuntimeException("No existe ese transporte.");
		}
		return getTransporte(patente).devolverValor();
	}	
}
