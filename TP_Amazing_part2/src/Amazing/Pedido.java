package Amazing;

import java.util.List;

public class Pedido {
    private Integer codPedido;
    private String cliente;
    private String direccion;
    private List<paquete> carrito;
    private int dni;

    public Pedido(String cliente, String direccion,int dni) {
        //this.codPedido = codPedido;
        this.cliente = cliente;
        this.direccion = direccion;
        this.setDni(dni);
    }

    public Integer getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    public String getNombre() {
        return cliente;
    }

    public void setNombre(String nombre) {
        this.cliente = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<paquete> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<paquete> carrito) {
        this.carrito = carrito;
    }
    public String  getDNI(String dni) {
    	return dni;
    }

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
}
