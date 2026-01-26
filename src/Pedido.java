public abstract class Pedido {

    // Atributos protegidos para que las subclases puedan acceder a ellos

    protected String idPedido;
    protected String direccionEntrega;
    protected double distanciaKm;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm){
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    // Método implementado: común para todos los pedidos

    public void mostrarResumen(){
        System.out.println("Id Pedido: " + idPedido);
        System.out.println("Dirección de Entrega: " + direccionEntrega);
        System.out.println("Distancia (km): " + distanciaKm);
    }

    // Método abstracto: cada subclase DEBE implementar su propia logíca
    public abstract int calcularTiempoEntrega();

    public void asignarRepartidor(){
        System.out.println("buscando repartidor disponible para el pedido " + idPedido + " ...");
    }
}