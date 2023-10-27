package tp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class EmpresaAmazing {

	protected String cuit;
	protected HashMap<Integer, Pedido> pedidos;
	protected String nombre;
	protected HashMap<String, Transporte> transportes;
	
	EmpresaAmazing(String cuit) {
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
	
	public String cargarTransporte(String patente) {
	    StringBuilder resultado = new StringBuilder();
	    
	    Transporte transporte = getTransporte(patente);

	    if (transporte == null) {
	        
	        return "Transporte no encontrado";
	    }

	    double volumenMaximoTransporte = transporte.devolverVolumen(); 

	    double volumenTotalCargado = 0; 

	    for (Map.Entry<Integer, Pedido> entry : pedidos.entrySet()) {
	        Pedido pedido = entry.getValue();

	        if (pedido.isCerrado() && pedido.devolverCarrito() != null) {
	            List<Paquete> paquetesPendientes = new ArrayList<>();
 
	            for (Paquete paquete : pedido.devolverCarrito()) {
	                if ("pendiente".equals(paquete.getEntregado()) && coincideRequisitos(paquete)) {
	                    paquetesPendientes.add(paquete);
 
	                    volumenTotalCargado += paquete.devolverVolumen();
	                }
	            }

	            if (volumenTotalCargado > volumenMaximoTransporte) {
	                break; 
	            }

	            for (Paquete paquete : paquetesPendientes) {
	                transporte.agregarPaquete(pedido.codPedido, paquete);

	                pedido.getPaquete(paquete.getCodigo()).setEntregado("cargado");

	                resultado.append("Paquete ").append(paquete.codigo).append(" cargado en el transporte ").append(patente).append("\n");
	            }
	        }
	    }

	    return resultado.toString();
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

	public boolean algunTransporteIdentico() {
		boolean acum = false;
		for (String patente:transportes.keySet()) {
			acum = acum || transportesIdenticos(patente);
		}
		return acum;
	}
	
	public boolean transportesIdenticos(String pat) {
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

	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		if(!transportesIdenticos(patente)) {
			Comun automovil = new Comun(patente,volMax,valorViaje,maxPaq);
			transportes.put(patente,automovil);
		}
	}

	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		if(!transportesIdenticos(patente)) {
			Utilitario utilitario = new Utilitario(patente,volMax,valorViaje,valorExtra);
			transportes.put(patente, utilitario);
		}
	}

	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		if(!transportesIdenticos(patente)) {
			Camion camion = new Camion(patente,volMax,valorViaje,adicXPaq);
			transportes.put(patente, camion);
		}
	}

	public int registrarPedido(String cliente, String direccion, int dni) {	
				Pedido pedido = new Pedido(cliente,direccion,dni);
				pedido.codPedido=pedido.hashCode();
			if(!pedidos.containsKey(pedido.codPedido)) {
					pedidos.put(pedido.codPedido,pedido);
					return pedido.codPedido;
				}
			else {
				throw new RuntimeException("Este pedido ya se encuentra registrado");
			}
	}

	public void cerrarPedido(int codPedido) {
		getPedido(codPedido).cerrarPedido();
	}

	
	public int agregarPaquete(int codPedido, int volumen, int precio, int costoEnvio) {
		if(getPedido(codPedido)!=null){
			Ordinario paquete = new Ordinario(1,volumen,precio,costoEnvio);
			paquete.codigo=paquete.hashCode();
			return paquete.codigo;
		}
		else {throw new RuntimeException("no se puedo agregar el paquete");}
		
	}
	public int agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
		if(getPedido(codPedido)!=null){
			Especial paquete = new Especial(0,volumen,precio,porcentaje,adicional);
			paquete.codigo=paquete.hashCode();
			return paquete.codigo;
		}
		else {
			throw new RuntimeException("no se puedo agregar el paquete");
		}
	}

	public void quitarPaquete(int codPaquete) {
	    for (Map.Entry<Integer, Pedido> entry : pedidos.entrySet()) {
	        Pedido pedido = entry.getValue();
	        List<Paquete> carrito = pedido.devolverCarrito();

	        if (carrito != null) {
	            for (Paquete paquete : carrito) {
	                if (paquete.devolverCodigo() == codPaquete) {
	                    carrito.remove(paquete);
	                }
	            }
	        }
	    }
	}


	
	
	
}
