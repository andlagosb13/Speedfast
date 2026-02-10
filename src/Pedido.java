

public class Pedido {

    // Atributos protegidos para que las subclases puedan acceder a ellos
    private int id;
    private String direccionEntrega;
    private EstadoPedido estado;

    public Pedido(int id, String direccionEntrega){
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = EstadoPedido.PENDIENTE; // Estado inicial
    }

    // Gettesr y setters
    public int getId() {return id;}
    public String getDireccionEntrega() { return direccionEntrega;}
    public EstadoPedido getEstado(){return estado;}

    public void setEstado(EstadoPedido nuevoEstado){
        this.estado = nuevoEstado;
    }

    @Override
    public String toString(){
        return "Pedido #" + id + " [Destino: " + direccionEntrega + ", Estado: " + estado + "]";
    }
}