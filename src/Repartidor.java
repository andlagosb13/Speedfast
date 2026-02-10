
public class Repartidor implements Runnable{

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga){
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run(){
        while(true){
            Pedido pedido = zonaDeCarga.retirarPedido();

            if(pedido == null) break; // si no hay mas pedidos, el hilo termina

            try{
                // Cambio de estado a EN_REPARTO
                pedido.setEstado(EstadoPedido.EN_REPARTO);
                System.out.println("[Repartidor: " + nombre + "] Retirando pedido#" + pedido.getId() + "...");
                System.out.println("[Repartidor: " + nombre + "] Estado: " + pedido.getEstado());

                // Simular entrega
                Thread.sleep(2000);

                // Cambio de estado a ENTREGADO
                pedido.setEstado(EstadoPedido.ENTREGADO);
                System.out.println("[Repartidor - " + nombre + "] Entregando pedido#" + pedido.getId() + "...");
                System.out.println("[Repartidor: " + nombre + "] Estado: " + pedido.getEstado());

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
