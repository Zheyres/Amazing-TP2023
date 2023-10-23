package Amazing;

public class Utilitario extends transporte {
    private double valorExtra;

    public Utilitario(String patente, int volumen, int valor, int valorExtra) {
        super(patente, volumen, valor);
        this.valorExtra = valorExtra;
    }

    public double getValorExtra() {
        return valorExtra;
    }

    public void setValorExtra(double valorExtra) {
        this.valorExtra = valorExtra;
    }

    public void calcularValorExtra() {
        // Implementa el cálculo del valor extra según tus necesidades
        // Puedes proporcionar la lógica para calcular el valor extra aquí.
    }

    public void cargarPaquete(int idPaquete, paquete paquete) {
        // Agrega el paquete al mapa de carga utilizando el id del paquete como clave
        getCarga().put(idPaquete, paquete);
    }
}
