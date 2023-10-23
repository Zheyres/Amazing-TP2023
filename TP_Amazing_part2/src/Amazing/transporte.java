package Amazing;

import java.util.HashMap;
import java.util.Map;

public class transporte {
    private String patente;
    private double volumen;
    private double valor;
    private Map<Integer, paquete> carga;

    public transporte(String patente, double volumen, double valor) {
        this.patente = patente;
        this.volumen = volumen;
        this.valor = valor;
        this.carga = new HashMap<>();
    }

    // Getter and Setter methods for patente, volumen, and valor
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
