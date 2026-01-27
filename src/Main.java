import java.util.ArrayList;

public class Main implements Rastreable {
    public static ArrayList<String> historial = new ArrayList<>();

    public static void main(String[] args) {
        Main sistema = new Main();

        // Instancias de pedidos
        PedidoComida p1 = new PedidoComida("#001", "Calle cuatro 115", 3.0);
        PedidoEncomienda p2 = new PedidoEncomienda("#002", "Avenida cerroalto 2145", 7.5);
        PedidoExpress p3 = new PedidoExpress("#003", "Boulevard central 500", 2.0);

        // simulacion Pedido 1
        System.out.println("[Procesando Pedido de Comida]");
        p1.mostrarResumen();
        p1.asignarRepartidor("Alberto");
        System.out.println("Tiempo: " + p1.calcularTiempoEntrega() + " minutos");
        p1.despachar();
        historial.add("PedidoComida #001 - entregado por Alberto");

        // Simulacion pedido 2
        System.out.println("\n[Procesando Pedido de Encomienda]");
        p2.mostrarResumen();
        p2.asignarRepartidor("Beatriz");
        System.out.println("Tiempo: " + p2.calcularTiempoEntrega() + " minutos");
        p2.despachar();
        historial.add("PedidoEncomienda #002 - entregado por Beatriz");

        // Simulación cancelación
        System.out.println("\nCancelando Pedido Express " + p3.idPedido + " ....");
        p3.cancelar();

        // Mostrar historial
        sistema.verHistorial();
    }

    @Override
    public void verHistorial() {
        System.out.println("\n[Historial de Pedidos]");
        for (String registro : historial) {
            System.out.println("-  " + registro);
        }
    }
}