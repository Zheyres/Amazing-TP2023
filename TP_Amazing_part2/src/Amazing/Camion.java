package Amazing;

public class Camion extends transporte {
    private int valorAdicional;

    public Camion(String patente, int volumen, int valor, int valorAdicional) {
        super(patente, volumen, valor);
        this.valorAdicional = valorAdicional;
    }

    public int getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(int valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void cargarPaquete(int idPaquete, paquete paquete) {
        // Agrega el paquete al mapa de carga utilizando el id del paquete como clave
        getCarga().put(idPaquete, paquete);
    }
}
