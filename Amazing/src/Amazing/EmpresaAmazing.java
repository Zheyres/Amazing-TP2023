package Amazing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpresaAmazing implements IEmpresa {

	protected String cuit;
	protected HashMap<Integer, Pedido> pedidos;
	protected String nombre;
	protected HashMap<String, Transporte> transportes;
	protected double costoTotalPedidos;
	StringBuilder resultado = new StringBuilder();
	
	EmpresaAmazing(String cuit) {
		this.cuit = cuit;
		this.pedidos = new HashMap<Integer, Pedido>();
		this.transportes = new HashMap<String, Transporte>();
		this.costoTotalPedidos = 0;
	}
	
	public String toString() {
		return "[Empresa " + nombre + ", " + cuit + "]";
	}
	
	public boolean contienePed(int codPedido) {
		if (!pedidos.containsKey(codPedido)) {
			throw new RuntimeException("No existe un pedido con ese codigo.");
		}
		return true;
	}
	
	public void actualizarPrecioTotalPedidos(double valor) {
		this.costoTotalPedidos += valor;
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
	
	public int registrarPedido(String nombre, String direccion, int dni) {
		int codPedido = (int) (Math.random() * 100) + 1;
		while (pedidos.containsKey(codPedido)) {
			codPedido = (int) (Math.random() * 100) + 1;
		}
		Pedido nuevo = new Pedido(codPedido, nombre, direccion, dni);
		pedidos.put(codPedido, nuevo);
		this.costoTotalPedidos += nuevo.costoTotal;
		return codPedido;
	}
	
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {
		if (getPedido(codPedido).devolverEstado() == true) {
			throw new RuntimeException("El pedido ya esta cerrado");
		}
		else {
		int codPaq = (int) (Math.random() * 100) + 1;
		while(getPedido(codPedido).carrito.containsKey(codPaq)) {
			codPaq = (int) (Math.random() * 100) + 1;
		}
		Paquete paq = new Ordinario(codPaq, volumen, precio, costoEnvio);
		getPedido(codPedido).agregarProducto(codPaq, paq);
		return codPaq;
		}
	}
	
	public int agregarPaquete(int codPedido,  int volumen, int precio, int porcentaje, int adicional) {
		int codPaq = (int) (Math.random() * 100) + 1;
		while(getPedido(codPedido).carrito.containsKey(codPaq)) {
			codPaq = (int) (Math.random() * 100) + 1;
		}
		Paquete paq = new Especial(codPaq, volumen, precio, porcentaje, adicional);
		getPedido(codPedido).agregarProducto(codPaq, paq);
		return codPaq;
	}
	
	public boolean quitarPaquete(int codProd) {
		for (int cod:pedidos.keySet()) {
			if (getPedido(cod).devolverCarrito().containsKey(codProd) && !getPedido(cod).devolverEstado()) {
				getPedido(cod).eliminarProducto(codProd);
				return true;
			}
		}
		throw new RuntimeException("No se pudo eliminar.");
	}
	
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya existe ese transporte.");
		}
		else {
			Transporte vehiculo = new Comun(patente, volMax, valorViaje,maxPaq);
			transportes.put(patente, vehiculo);
		}
	}
	
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya existe ese transporte.");
		}
		else {
			Transporte vehiculo = new Utilitario(patente, volMax, valorViaje, valorExtra);
			transportes.put(patente, vehiculo);
		}
	}
	
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		if (transportes.containsKey(patente)) {
			throw new RuntimeException("Ya existe ese transporte.");
		}
		else {
			Transporte vehiculo = new Camion(patente, volMax, valorViaje, adicXPaq);
			transportes.put(patente, vehiculo);
		}
	}
	
	public ArrayList<Paquete> devolverListadoDePaquetes(String patente) {
		if (!transportes.containsKey(patente)) {
			throw new RuntimeException("No existe ese transporte.");
		}
		return getTransporte(patente).devolverCarga();
	}
	
	public double costoEntrega(String patente) {
		if (!transportes.containsKey(patente)) {
			throw new RuntimeException("No existe ese transporte.");
		}		
		if (getTransporte(patente).devolverTamCarga() == 0) {
			throw new RuntimeException("El transporte no tiene carga.");
		}
		return getTransporte(patente).devolverValor();
	}
	
	public boolean hayTransportesIdenticos() {
		boolean acum = false;
		for (String patente:transportes.keySet()) {
			acum = acum || algunTransporteIdentico(patente);
		}
		return acum;
	}
	
	public boolean algunTransporteIdentico(String pat) {
		for (String patente:transportes.keySet()) {
			if (!patente.equals(pat) && getTransporte(patente).getClass().getName().equals(getTransporte(pat).getClass().getName()) && coincidenCarga(patente, pat)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean coincidenCarga(String patente1, String patente2) {
		ArrayList <Paquete> cargaT1 = getTransporte(patente1).devolverCarga();
		boolean acum = true;
		for (Paquete paqT1:cargaT1) {
			acum = acum && (getTransporte(patente1).devolverCantPaquetes() == getTransporte(patente2).devolverCantPaquetes() && getTransporte(patente2).paquetesIguales(paqT1));
		}
		return acum;
	}
	
	public double cerrarPedido(int codPedido) {
		if(getPedido(codPedido).devolverEstado() == true) {
			throw new RuntimeException("El pedido ya esta cerrado.");
		} 
		else {
			getPedido(codPedido).cerrarPedido();
			actualizarPrecioTotalPedidos(getPedido(codPedido).valorAPagar());
			return getPedido(codPedido).valorAPagar();
		}
	}
	
	public String cargarTransporte(String patente) {
	    StringBuilder resultado = new StringBuilder();
	    
	    Transporte transporte = getTransporte(patente);

	    if (getTransporte(patente).devolverTamCarga() >= getTransporte(patente).devolverVolumen()) { 
	        return "Transporte ya cargado";
	    }
	    else {
			double volumenMaximoTransporte = transporte.devolverVolumen(); 
			double volumenTotalCargado = 0; 
			for (Integer cod:pedidos.keySet()) {
			     Pedido pedido = getPedido(cod);
		
			     if (pedido.devolverEstado() && pedido.devolverCarrito() != null) {
		 
			    	 for (int codPaq : pedido.devolverCarrito().keySet()) {
			        	 if (pedido.getPaquete(codPaq).devolverEstado() == false && transporte.coincideRequisitos(pedido.getPaquete(codPaq)) && volumenTotalCargado < volumenMaximoTransporte) {
			        		 transporte.cargarPaquete(pedido.getPaquete(codPaq).devolverCodigo(), pedido.getPaquete(codPaq));
			                 pedido.getPaquete(pedido.getPaquete(codPaq).devolverCodigo()).actualizarEstado();
			                 volumenTotalCargado += pedido.getPaquete(codPaq).devolverVolumen();
			            
		//	                 resultado.append("Paquete ").append(pedido.getPaquete(codPaq).codigo).append(" cargado en el transporte ").append(patente).append("\n");
			                 resultado.append(registrarPaqueteEnListado(cod, codPaq, pedido.devolverDireccion()));
			        	 }
			    	 }
			     }
			 }
			transporte.calcularAdicional();
	    }
	    return resultado.toString();
	}
	
	private String registrarPaqueteEnListado(int codPed, int codPaq, String direccion) {
		return String.format(" + [ %d - %d ] %s\n" , codPed , codPaq, direccion);	
	}
	
	public Map<Integer,String> pedidosNoEntregados() {
		HashMap<Integer, String> pedNoEntregados = new HashMap<Integer, String>();
		for (int cod:pedidos.keySet()) {
			if (getPedido(cod).devolverEstado() == true) {
				if (getPedido(cod).tienePaquetesNoEntregados()) {
					pedNoEntregados.put(cod, getPedido(cod).devolverNombre());
				}
			}
		}
		return pedNoEntregados;
	}
	
	public double facturacionTotalPedidosCerrados() {
		return this.costoTotalPedidos;
	}
}