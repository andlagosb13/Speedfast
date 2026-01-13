public class PedidoExpress extends Pedido{

    public PedidoExpress(int idPedido, String direccionEntrega){
        super(idPedido, direccionEntrega, "Express");
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor para Pedido Express...");
        System.out.println(" Verificando ruta más rápida");
        System.out.println("Pedido asignado a repartidor prioritario.");
    }

    // metodo sobrecargado
    public void asignarRepartidor(String nombreRepartidor){
        // llamamos al método original
        this.asignarRepartidor();
        // agregamos la asignación específica
        System.out.println("Pedido asignado a " + nombreRepartidor);
    }
}
