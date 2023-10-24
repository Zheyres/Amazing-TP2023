package Amazing;

import java.util.HashMap;
import java.util.Map;

public class transporte {
    private String patente;
    private int volumen;
    public static int valorBase;
    private Map<Integer, paquete> carga;

    public transporte(String patente, int volumen, int valor) {
        this.patente = patente;
        this.volumen = volumen;
        this.valorBase = valor;
        this.carga = new HashMap<>();
    }

    // Getter and Setter methods for patente, volumen, and valorBase
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getValorBase() {
        return valorBase;
    }

    public void setValorBase(int valor) {
        this.valorBase = valor;
    }

    // Getter and Setter methods for carga
    public Map<Integer, paquete> getCarga() {
        return carga;
    }

    public void setCarga(Map<Integer, paquete> carga) {
        this.carga = carga;
    }

    // Method to add a paquete to the carga map
    public void agregarPaquete(int idPaquete, paquete paquete) {
        carga.put(idPaquete, paquete);
    }

    // Method to remove a paquete from the carga map
    public void removerPaquete(int idPaquete) {
        carga.remove(idPaquete);
    }

    // Other methods related to the transporte class
}
