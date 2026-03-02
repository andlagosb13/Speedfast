package controlador;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class GestionPedidos {
    private List<Pedido> listaPedidos;
    private List<Repartidor> listaRepartidores;
    private ZonaDeCarga zonaDeCarga;

    public GestionPedidos() {
        this.listaPedidos = new ArrayList<>();
        this.listaRepartidores = new ArrayList<>();
        this.zonaDeCarga = new ZonaDeCarga();

        // repartidores de ejemplo
        listaRepartidores.add(new Repartidor("Juan Perez", zonaDeCarga));
        listaRepartidores.add(new Repartidor("Maria Garcia", zonaDeCarga));
    }

    public void registrarPedido(Pedido p) {
        listaPedidos.add(p);
        // zonaDeCarga.agregarPedido(p);
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    // Logica de asignacion automatica
    public String asignarProximoPedido() {
        // buscamos el primer pedido que este PENDIENTE
        for (Pedido p : listaPedidos) {
            if (p.getEstado() == EstadoPedido.PENDIENTE) {
                if (!listaRepartidores.isEmpty()) {
                    // buscamos un repartidor disponible
                    Repartidor r = listaRepartidores.get(0);

                    p.setEstado(EstadoPedido.EN_REPARTO);

                    return "Pedido #" + p.getId() + " asignado a " + r.getNombre();
                }
            }
            return " No hay pedidos pendientes para asignar.";
        }
        return "";
    }
}