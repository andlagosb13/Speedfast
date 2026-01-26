public class Main {
    public static void main(String[]args){
        // Instanciamos objetos de las clases derivadas
        PedidoComida pedidoComida = new PedidoComida("#001", "Uno Poniente 285 ",3.5);
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("#002","Cinco norte 435",7.0);
        PedidoExpress pedidoExpress = new PedidoExpress("#003","Tres sur 25",6.0);

        // Ejecución y muestra de datos
        System.out.println("---- PRUEBA DE PEDIDOS SPEEDFAST ----\n");

        // Bloque Pedido Comida
        pedidoComida.mostrarResumen(); // Método heredado
        System.out.println("Tiempo estimado de entrega: " + pedidoComida.calcularTiempoEntrega() + " minutos");
        pedidoComida.asignarRepartidor();

        System.out.println(); // Salto de linea para claridad

        // Probamos pedido de encomienda
        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        pedidoEncomienda.asignarRepartidor();
        System.out.println();

        // Probamos pedido express
       pedidoExpress.mostrarResumen();
       System.out.println("Tiempo estimado de entrega: " + pedidoExpress.calcularTiempoEntrega() + " minutos");
       pedidoExpress.asignarRepartidor();
    }
}
