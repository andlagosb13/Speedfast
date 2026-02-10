

public class PedidoComida extends Pedido implements Despachable{

    // El constructor ahora debe recibir e inicializar la distancia
    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm){
        super(idPedido, direccionEntrega);
    }

    @Override
    public void despachar(){
        System.out.println("El pedido de comida está en camino.");
    }
}
