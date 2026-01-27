

public class PedidoComida extends Pedido implements Despachable{

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

    @Override
    public void asignarRepartidor(String nombre) {
        System.out.println("Repartidor " + nombre + "asignado a Comida.");
    }

    @Override
    public void despachar(){
        System.out.println("El pedido de comida está en camino.");
    }
}
