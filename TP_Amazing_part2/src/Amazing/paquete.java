package Amazing;

public class paquete {
    private Integer codigo;
    private int volumen;
    private int precio;
    private String estado;

    public paquete(Integer codigo, int volumen, int precio, String estado) {
        this.codigo = codigo;
        this.volumen = volumen;
        this.precio = precio;
        this.setEstado("pendiente");
    }

    public Integer devolverCodigo() {
        return codigo;
    }

    public int devolverVolumen() {
        return volumen;
    }

    public int devolverPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public  int calcularAdicional(paquete p) {
    	int base = transporte.valorBase;
    	//return base + precio+ this..getClass().getadicional();
    	return 0;
    }
}
