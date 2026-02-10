public class PedidoExpress extends Pedido implements Despachable, Cancelable {

    public PedidoExpress(int id, String direccionEntrega, double distanciaKm){
        super(id, direccionEntrega);
    }

    @Override
    public void despachar(){
        System.out.println("El pedido express está en camino con máxima prioridad.");
    }

    @Override
    public void cancelar(){
        System.out.println(" Pedido cancelado exitosamente.");
    }
}
