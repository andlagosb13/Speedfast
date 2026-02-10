

public class PedidoEncomienda extends Pedido implements Despachable{

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm){
        // ahora pasamos distanciaKm al constructor padre
        super(idPedido, direccionEntrega);
    }

    @Override
    public void despachar(){
        System.out.println("Pedido despachado correctamente.");
    }
}
