import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {
    // Usamos una cola para procesar los pedidos en orden
    private Queue<Pedido> pedidos = new LinkedList<>();

    // Método sincronizado para agregar
    public synchronized void agregarPedido(Pedido p){
        pedidos.add(p);
        System.out.println("Pedido #" + p.getId() + " agregado. Destino: " + p.getDireccionEntrega());
    }

    // Método sincronizado para procesar entregas

    public synchronized Pedido retirarPedido(){
        return pedidos.poll();
    }

    public synchronized boolean estaVacia(){
        return pedidos.isEmpty();
    }
}
