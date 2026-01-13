public class Main {
    public static void main(String[]args){
        // Instanciamos objetos de las clases derivadas
        PedidoComida pedidoComida = new PedidoComida(1199, "1 Poniente");
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(2220,"5 norte");
        PedidoExpress pedidoExpress = new PedidoExpress(1547,"3 sur");

        // Probando la version sobrescrita
        System.out.println("[Pedido Comida]");
        pedidoComida.asignarRepartidor(); // Version sobreescrita
        pedidoComida.asignarRepartidor("Carlos");

        System.out.println(); // Salto de linea para claridad

        // Probamos pedido de encomienda
        System.out.println("[Pedido Encomienda]");
        pedidoEncomienda.asignarRepartidor(); // Version sobreescrita
        pedidoEncomienda.asignarRepartidor("Ana");

        System.out.println();

        // Probamos pedido express
        System.out.println("[Pedido Express]");
        pedidoExpress.asignarRepartidor(); // Version sobreescrita
        pedidoExpress.asignarRepartidor("Luis");
    }
}
