

public class PedidoComida extends Pedido{

    // El constructor ahora debe recibir e inicializar la distancia
    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm){
        super(idPedido, direccionEntrega, distanciaKm);
    }

    // Implementación obligatoria del método abstracto
    @Override
    public int calcularTiempoEntrega(){
        // Fórmula: 15 min + 2 min por cada kilómetro
        return (int)(15 + (2 * distanciaKm));
    }
    @Override
    public void asignarRepartidor(){
        System.out.println("Asignando repartidor para cada COMIDA con mochila térmica");
    }

}
