package tp;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Transporte {

	protected String patente;
	protected double volumen;
	protected double valor;
	protected HashMap<Integer, Paquete> carga;
	
	Transporte(String patente, double volumen, double valor) {
		
	}
	
	public String devolverPatente() {
		return this.patente;
	}
	
	public double devolverVolumen() {
		return this.volumen;
	}
	
	public double devolverValor() {
		return this.valor;
	}
	
	public ArrayList<Paquete> devolverCarga() {
		ArrayList<Paquete> listaCarga = new ArrayList<Paquete>();
		for (int cod:this.carga.keySet()) {
			listaCarga.add(this.carga.get(cod));
		}
		return listaCarga;
	}
	
	public abstract void cargarPaquete();
}
