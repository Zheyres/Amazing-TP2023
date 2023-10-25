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
	
	public Paquete getPaquete(int codPaq) {
		if (!carga.containsKey(codPaq)) {
			throw new RuntimeException("No contiene el paquete.");
		}
		return carga.get(codPaq);
	}
	
	public int devolverTamCarga() {
		return carga.size();
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
		for (int cod:carga.keySet()) {
			listaCarga.add(getPaquete(cod));
		}
		return listaCarga;
	}
	
	public boolean paquetesIguales(Paquete paq) {
		for (int cod:carga.keySet()) {
			if (getPaquete(cod).getClass() == paq.getClass() && getPaquete(cod).devolverVolumen() == paq.devolverVolumen() && getPaquete(cod).devolverPrecio() == paq.devolverPrecio()) {
				return true;
			}
		}
		return false;
	}
	
	public abstract void cargarPaquete();
}
