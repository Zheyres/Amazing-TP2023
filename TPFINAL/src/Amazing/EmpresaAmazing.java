package Amazing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpresaAmazing {

	protected String cuit;
	protected HashMap<Integer, Pedido> pedidos;
	protected String nombre;
	protected HashMap<String, Transporte> transportes;
	protected double costoTotalPedidos;
	
	EmpresaAmazing(String cuit) {
		this.cuit = cuit;
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
		int codPaq = (int) (Math.random() * 100) + 1;
		while(getPedido(codPedido).carrito.containsKey(codPaq)) {
			codPaq = (int) (Math.random() * 100) + 1;
		}
		Paquete paq = new Ordinario(codPaq, volumen, precio, costoEnvio);
		getPedido(codPedido).agregarProducto(codPaq, paq);
		return codPaq;
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
			if (getPedido(cod).devolverEstado() == true || getPedido(cod).eliminarProducto(codProd) == false) {
				return false;
			}
		}
		return true;
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
			if (!patente.equals(pat) && getTransporte(patente).getClass() == getTransporte(pat).getClass() && coincidenCarga(patente, pat)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean coincidenCarga(String patente1, String patente2) {
		ArrayList <Paquete> cargaT1 = getTransporte(patente1).devolverCarga();
		boolean acum = true;
		for (Paquete paqT1:cargaT1) {
			acum = acum && cargaT1.size() == getTransporte(patente2).devolverTamCarga() && getTransporte(patente2).paquetesIguales(paqT1);
		}
		return acum;
	}
	
	public double cerrarPedido(int codPedido) {
		if(getPedido(codPedido).devolverEstado() == true) {
			throw new RuntimeException("El pedido ya esta cerrado.");
		}
		getPedido(codPedido).cerrarPedido();
		actualizarPrecioTotalPedidos(getPedido(codPedido).devolverCostoTotal());
		return getPedido(codPedido).devolverCostoTotal();
	}
	
	public String cargarTransporte(String patente) {
	    StringBuilder resultado = new StringBuilder();
	    
	    Transporte transporte = getTransporte(patente);

	    if (transporte == null) {
	        
	        return "Transporte no encontrado";
	    }

	    double volumenMaximoTransporte = transporte.devolverVolumen(); 

	    double volumenTotalCargado = 0; 

	    for (HashMap.Entry<Integer, Pedido> entry : pedidos.entrySet()) {
	        Pedido pedido = entry.getValue();

	        if (pedido.devolverEstado() && pedido.devolverCarrito() != null) {
	            ArrayList<Paquete> paquetesPendientes = new ArrayList<>();
 
	            for (Paquete paquete : pedido.devolverCarrito()) {
	                if ("pendiente".equals(paquete.devolverEstado()) && transporte.coincideRequisitos(paquete)) {
	                    paquetesPendientes.add(paquete);
 
	                    volumenTotalCargado += paquete.devolverVolumen();
	                }
	            }

	            if (volumenTotalCargado > volumenMaximoTransporte) {
	                break; 
	            }

	            for (Paquete paquete : paquetesPendientes) {
	                transporte.cargarPaquete(pedido.codPedido, paquete);

	                pedido.getPaquete(paquete.devolverCodigo()).actualizarEstado();

	                resultado.append("Paquete ").append(paquete.codigo).append(" cargado en el transporte ").append(patente).append("\n");
	            }
	        }
	    }

	    return resultado.toString();
	}
	
	public Map<Integer,String> pedidosNoEntregados() {
		HashMap<Integer, String> pedNoEntregados = new HashMap<Integer, String>();
		for (int cod:pedidos.keySet()) {
			if (getPedido(cod).devolverEstado() == false) {
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
