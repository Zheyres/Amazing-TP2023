package Amazing;

import java.util.HashMap;

public class Automovil extends transporte {
    private int cargaMaxima;

    public Automovil(String patente, int volumen, int valor, int cargaMaxima) {
        super(patente, volumen, valor); // Llama al constructor de la clase base (transporte)
        this.cargaMaxima = cargaMaxima;
    }

    // Getter and Setter methods for cargaMaxima
    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    // Other methods related to the Automovil class
}