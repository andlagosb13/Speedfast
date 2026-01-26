public class PedidoExpress extends Pedido{

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm){
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega(){
        // Lógica: 10 min base + 5 min extra si > 5 km
        int tiempo = 10;
        if (distanciaKm > 5){
            tiempo += 5;
        }
        return tiempo;
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor para Pedido Express...");
        System.out.println(" Verificando ruta más rápida");
        System.out.println("Pedido asignado a repartidor prioritario.");
    }

    // metodo sobrecargado
    public void asignarRepartidor(String nombreRepartidor){
        this.asignarRepartidor();
        // agregamos la asignación específica
        System.out.println("Pedido asignado a " + nombreRepartidor);
    }
}
