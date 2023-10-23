package Amazing;

public class paquete {
    private Integer codigo;
    private double volumen;
    private double precio;
    private String entregado;

    public paquete(Integer codigo, double volumen, double precio, String entregado) {
        this.codigo = codigo;
        this.volumen = volumen;
        this.precio = precio;
        this.entregado = entregado;
    }

    public Integer devolverCodigo() {
        return codigo;
    }

    public double devolverVolumen() {
        return volumen;
    }

    public double devolverPrecio() {
        return precio;
    }

    public String getEntregado() {
        return entregado;
    }

    public void setEntregado(String entregado) {
        this.entregado = entregado;
    }

    public  double calcularAdicional() {
    	return 0;
    }
}
