

public class PedidoEncomienda extends Pedido{

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm){
        // ahora pasamos distanciaKm al constructor padre
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        // Lógica: 20 min base + 1.5 min por kilómetro
        return (int) (20 + (1.5 * distanciaKm));
    }

    @Override
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor para encomienda");
        System.out.println(" Verificando peso y embalaje");
        System.out.println("Pedido asignado a repartidor de carga.");
    }

    public void asignarRepartidor(String nombreRepartidor){
        this.asignarRepartidor();
        System.out.println("Pedido de encomienda asignado a " + nombreRepartidor);
    }
}
