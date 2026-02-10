import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ZonaDeCarga zona = new ZonaDeCarga();
        System.out.println("[Zona de carga inicializada]");

        // Agregar al menos 5 pedidos [cite: 106]
        zona.agregarPedido(new Pedido(1, "Santiago Centro"));
        zona.agregarPedido(new Pedido(2, "Providencia"));
        zona.agregarPedido(new Pedido(3, "Ñuñoa"));
        zona.agregarPedido(new Pedido(4, "Recoleta"));
        zona.agregarPedido(new Pedido(5, "Las Condes"));

        // Crear 3 repartidores [cite: 107]
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(new Repartidor("Juan", zona));
        executor.execute(new Repartidor("Camila", zona));
        executor.execute(new Repartidor("Pedro", zona));

        executor.shutdown();
        try {
            // Esperar a que todos terminen [cite: 109]
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("\n[Zona de carga vacía]");
                System.out.println("Todos los pedidos han sido entregados correctamente.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}