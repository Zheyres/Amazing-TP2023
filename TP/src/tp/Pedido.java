package tp;

import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {

	protected int codPedido;
	protected String nombre;
	protected String direccion;
	protected String dni;
	protected HashMap<Integer, Paquete> carrito;
	
	Pedido(int codPedido, String nombre, String direccion, String dni) {
		
	}
	
	public void agregarProducto(int codProducto, Paquete paq) {
		
	}
	
	public void eliminarProducto(int codProd) {
		
	}
	
	public double valorAPagar() {
		return 0;
	}
	
	public ArrayList<Paquete> devolverCarrito() {
		ArrayList<Paquete> copiaCarrito = new ArrayList<Paquete>();
		return copiaCarrito;
	}
}
