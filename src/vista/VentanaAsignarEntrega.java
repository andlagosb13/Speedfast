package vista;

import dao.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaAsignarEntrega extends JFrame {
    private JComboBox<String> cbPedido;
    private JComboBox<String> cbRepartidor;
    private JButton btnAsignar;

    public VentanaAsignarEntrega() {
        setTitle("Asignar Pedido a Repartidor - SpeedFast");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(null);

        add(new JLabel("Pedido:"));
        cbPedido = new JComboBox<>();
        llenarPedido();
        add(cbPedido);

        add(new JLabel("Repartidor:"));
        cbRepartidor = new JComboBox<>();
        llenarRepartidor();
        add(cbRepartidor);

        btnAsignar = new JButton("Confirmar Entrega en DB");
        btnAsignar.addActionListener(e -> ejecutarAsignacion());
        add(btnAsignar);
    }

    private void llenarPedido() {

        cbPedido.removeAllItems();
        List<Object[]> pedido = new PedidoDAO().listarParaTabla();
        for (Object[] p : pedido) {
            cbPedido.addItem(p[0] + " - " + p[1]);
        }


    }

    private void llenarRepartidor() {
        cbRepartidor.removeAllItems();
        new RepartidorDAO().listarTodos().forEach(r -> cbRepartidor.addItem(r.getNombre()));
    }

    private void ejecutarAsignacion(){
        try{
            String itemPedido = (String) cbPedido.getSelectedItem();
            if (itemPedido == null) return;
            int idPedido = Integer.parseInt((itemPedido).split(" - ")[0]);

            int idRepartidor = 1;

            EntregaDAO entregaDAO = new EntregaDAO();
            entregaDAO.guardarEntrega(idPedido, idRepartidor);

            JOptionPane.showMessageDialog(this, "¡Exito! El pedido #" + idPedido + " ha sido asignado.");
            dispose();
        } catch (Exception ex){
           JOptionPane.showMessageDialog(this, "Error al asignar: " + ex.getMessage());
        }
    }
}