

public class PedidoEncomienda extends Pedido{

    public PedidoEncomienda(int idPedido, String direccionEntrega){
        super(idPedido, direccionEntrega, "Encomienda");
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor para Encomienda..");
        System.out.println(" Verificando peso y embalaje");
        System.out.println("Pedido asignado a repartidor de carga.");
    }

    // Método sobrecargado para encomienda
    public void asignarRepartidor(String nombreRepartidor){
        asignarRepartidor(); // llamamos al método original
        System.out.println(" Pedido de encomienda asignado a " + nombreRepartidor);
    }
}
