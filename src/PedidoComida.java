

public class PedidoComida extends Pedido{

    public PedidoComida(int idPedido, String direccionEntrega){
        // llamamos al constructor padre
        super(idPedido, direccionEntrega, "Comida");
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor para COMIDA...");
        System.out.println(" Verificando mochila térmica");
        System.out.println("Asignando repartidor con equipamiento.");
    }
    // metodo sobrecargado
    public void asignarRepartidor(String nombreRepartidor){
        asignarRepartidor(); // llamamos al metodo original
        System.out.println(" Pedido asignado a " + nombreRepartidor);
    }
}
