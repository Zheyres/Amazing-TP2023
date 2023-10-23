package Amazing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class EmpresaAmazing {
	private String cuitAmazing;
	//atributos
	HashMap<Integer,Pedido> pedidos = new HashMap<Integer, Pedido>();
	String nombre= "Amazing";
	List<transporte> listaTransportes = new ArrayList<>(); 
public EmpresaAmazing(String cuit) {	
	setCuitAmazing(cuit);
	
	}
	// Parser , cambia el string recibido como cuit a un numero
	public int stringToIntCuit(String cuitNum) {
	 int cuit= Integer.parseInt(cuitNum);
	 return cuit;
}
	public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq) {
		Automovil automovil = new Automovil(patente, volMax, valorViaje, maxPaq);
		listaTransportes.add(automovil);
	}
	public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra) {
		Utilitario utilitario = new Utilitario(patente,volMax,valorViaje,valorExtra);
		listaTransportes.add(utilitario);
		
	}
	//getters & setters---------------------------------------
	
	public String getCuitAmazing() {
		return cuitAmazing;
	}
	public void setCuitAmazing(String cuit) {
		this.cuitAmazing = cuit;
	}
	public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq) {
		Camion camion = new Camion(patente,volMax,valorViaje,adicXPaq);
		listaTransportes.add(camion);
		
	}

}
